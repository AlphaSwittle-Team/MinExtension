package mcmod.nxs.minextension.entity.hostile;

import java.util.UUID;

import mcmod.nxs.minextension.entity.ai.EntityAIEnderCreeperSwell;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityEnderCreeper extends EntityMob {
	/**
	 * Time when this creeper was last in an active state (Messed up code here,
	 * probably causes creeper animation to go weird)
	 */
	private int lastActiveTime;
	/**
	 * The amount of time since the creeper was close enough to the player to
	 * ignite
	 */
	private int timeSinceIgnited;
	private int fuseTime = 30;
	/**
	 * Explosion radius for this creeper.
	 */
	private int explosionRadius = 6;
	private static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.199999809265137D, 0)).setSaved(false);
	@Deprecated
	// DO NOT TOUCH THIS EVER
	private static boolean[] carriableBlocks = new boolean[256];
	/**
	 * Counter to delay the teleportation of an enderman towards the currently
	 * attacked target
	 */
	private int teleportDelay;
	/**
	 * A player must stare at an enderman for 5 ticks before it becomes
	 * aggressive. This field counts those ticks.
	 */
	private int stareTimer;
	private Entity lastEntityToAttack;
	private boolean isAggressive;
	private static final String __OBFID = "CL_00001685";

	public EntityEnderCreeper(World par1World)
	{
		super(par1World);
		this.isImmuneToFire = true;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIEnderCreeperSwell(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * The number of iterations PathFinder.getSafePoint will execute before
	 * giving up.
	 */
	public int getMaxSafePointTries()
	{
		return this.getAttackTarget() == null ? 3 : 3 + (int) (this.getHealth() - 1.0F);
	}

	/**
	 * Called when the mob is falling. Calculates and applies fall damage.
	 */
	protected void fall(float par1)
	{
		super.fall(par1);
		this.timeSinceIgnited = (int) ((float) this.timeSinceIgnited + par1 * 1.5F);

		if (this.timeSinceIgnited > this.fuseTime - 5)
		{
			this.timeSinceIgnited = this.fuseTime - 5;
		}
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) -1));
		this.dataWatcher.addObject(17, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(18, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(19, new Byte((byte) 0));
		this.dataWatcher.addObject(20, new Byte((byte) 0));
		this.dataWatcher.addObject(21, new Byte((byte) 0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		if (this.dataWatcher.getWatchableObjectByte(17) == 1)
		{
			par1NBTTagCompound.setBoolean("powered", true);
		}

		par1NBTTagCompound.setShort("Fuse", (short) this.fuseTime);
		par1NBTTagCompound.setByte("ExplosionRadius", (byte) this.explosionRadius);
		par1NBTTagCompound.setBoolean("ignited", this.func_146078_ca());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) (par1NBTTagCompound.getBoolean("powered") ? 1 : 0)));

		if (par1NBTTagCompound.hasKey("Fuse", 99))
		{
			this.fuseTime = par1NBTTagCompound.getShort("Fuse");
		}

		if (par1NBTTagCompound.hasKey("ExplosionRadius", 99))
		{
			this.explosionRadius = par1NBTTagCompound.getByte("ExplosionRadius");
		}

		if (par1NBTTagCompound.getBoolean("ignited"))
		{
			this.func_146079_cb();
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		if (this.isWet())
		{
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}

		if (this.lastEntityToAttack != this.entityToAttack)
		{
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			iattributeinstance.removeModifier(attackingSpeedBoostModifier);

			if (this.entityToAttack != null)
			{
				iattributeinstance.applyModifier(attackingSpeedBoostModifier);
			}
		}

		this.lastEntityToAttack = this.entityToAttack;
		int k;

		for (k = 0; k < 2; ++k)
		{
			this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
		}

		if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float f = this.getBrightness(1.0F);

			if (f > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
			{
				this.entityToAttack = null;
				this.setScreaming(false);
				this.isAggressive = false;
				this.teleportRandomly();
			}
		}

		if (this.isWet() || this.isBurning())
		{
			this.entityToAttack = null;
			this.setScreaming(false);
			this.isAggressive = false;
			this.teleportRandomly();
		}

		if (this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0)
		{
			this.setScreaming(false);
		}

		this.isJumping = false;

		if (this.entityToAttack != null)
		{
			this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
		}

		if (!this.worldObj.isRemote && this.isEntityAlive())
		{
			if (this.entityToAttack != null)
			{
				if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer) this.entityToAttack))
				{
					if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0D)
					{
						this.teleportRandomly();
					}

					this.teleportDelay = 0;
				} else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack))
				{
					this.teleportDelay = 0;
				}
			} else
			{
				this.setScreaming(false);
				this.teleportDelay = 0;
			}
		}
		if (this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;

			if (this.func_146078_ca())
			{
				this.setCreeperState(1);
			}

			int i = this.getCreeperState();

			if (i > 0 && this.timeSinceIgnited == 0)
			{
				this.playSound("creeper.primed", 1.0F, 0.5F);
			}

			this.timeSinceIgnited += i;

			if (this.timeSinceIgnited < 0)
			{
				this.timeSinceIgnited = 0;
			}

			if (this.timeSinceIgnited >= this.fuseTime)
			{
				this.timeSinceIgnited = this.fuseTime;
				this.func_146077_cc();
			}
		}

		super.onUpdate();
	}

	protected boolean teleportRandomly()
	{
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double) (this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}

	protected boolean teleportToEntity(Entity par1Entity)
	{
		Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - par1Entity.posX, this.boundingBox.minY + (double) (this.height / 2.0F) - par1Entity.posY + (double) par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
		double d2 = this.posY + (double) (this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}

	protected boolean teleportTo(double par1, double par3, double par5)
	{
		EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0);
		if (MinecraftForge.EVENT_BUS.post(event))
		{
			return false;
		}
		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if (this.worldObj.blockExists(i, j, k))
		{
			boolean flag1 = false;

			while (!flag1 && j > 0)
			{
				Block block = this.worldObj.getBlock(i, j - 1, k);

				if (block.getMaterial().blocksMovement())
				{
					flag1 = true;
				} else
				{
					--this.posY;
					--j;
				}
			}

			if (flag1)
			{
				this.setPosition(this.posX, this.posY, this.posZ);

				if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
				{
					flag = true;
				}
			}
		}

		if (!flag)
		{
			this.setPosition(d3, d4, d5);
			return false;
		} else
		{
			short short1 = 128;

			for (int l = 0; l < short1; ++l)
			{
				double d6 = (double) l / ((double) short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double) this.width * 2.0D;
				double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double) this.height;
				double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double) this.width * 2.0D;
				this.worldObj.spawnParticle("portal", d7, d8, d9, (double) f, (double) f1, (double) f2);
			}

			this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.creeper.say";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

		if (par1DamageSource.getEntity() instanceof EntitySkeleton)
		{
			int i = Item.getIdFromItem(Items.record_13);
			int j = Item.getIdFromItem(Items.record_wait);
			int k = i + this.rand.nextInt(j - i + 1);
			this.dropItem(Item.getItemById(k), 1);
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return true;
	}

	/**
	 * Returns true if the creeper is powered by a lightning bolt.
	 */
	public boolean getPowered()
	{
		return this.dataWatcher.getWatchableObjectByte(17) == 1;
	}

	/**
	 * Params: (Float)Render tick. Returns the intensity of the creeper's flash
	 * when it is ignited.
	 */
	@SideOnly(Side.CLIENT)
	public float getCreeperFlashIntensity(float par1)
	{
		return ((float) this.lastActiveTime + (float) (this.timeSinceIgnited - this.lastActiveTime) * par1) / (float) (this.fuseTime - 2);
	}

	protected Item getDropItem()
	{
		return Items.fire_charge;
	}

	/**
	 * Returns the current state of creeper, -1 is idle, 1 is 'in fuse'
	 */
	public int getCreeperState()
	{
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	/**
	 * Sets the state of creeper, -1 to idle and 1 to be 'in fuse'
	 */
	public void setCreeperState(int par1)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte) par1));
	}

	/**
	 * Called when a lightning bolt hits the entity.
	 */
	public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
	{
		super.onStruckByLightning(par1EntityLightningBolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) 1));
	}

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow,
	 * gets into the saddle on a pig.
	 */
	protected boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.flint_and_steel)
		{
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.ignite", 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
			par1EntityPlayer.swingItem();

			if (!this.worldObj.isRemote)
			{
				this.func_146079_cb();
				itemstack.damageItem(1, par1EntityPlayer);
				return true;
			}
		}

		return super.interact(par1EntityPlayer);
	}

	private void func_146077_cc()
	{
		if (!this.worldObj.isRemote)
		{
			boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

			if (this.getPowered())
			{
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) (this.explosionRadius * 2), flag);
			} else
			{
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius, flag);
			}

			this.setDead();
		}
	}

	public boolean func_146078_ca()
	{
		return this.dataWatcher.getWatchableObjectByte(18) != 0;
	}

	public void func_146079_cb()
	{
		this.dataWatcher.updateObject(18, Byte.valueOf((byte) 1));
	}

	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

		if (entityplayer != null)
		{
			if (this.shouldAttackPlayer(entityplayer))
			{
				this.isAggressive = true;

				if (this.stareTimer == 0)
				{
					this.worldObj.playSoundEffect(entityplayer.posX, entityplayer.posY, entityplayer.posZ, "mob.endermen.stare", 1.0F, 1.0F);
				}

				if (this.stareTimer++ == 5)
				{
					this.stareTimer = 0;
					this.setScreaming(true);
					return entityplayer;
				}
			} else
			{
				this.stareTimer = 0;
			}
		}

		return null;
	}

	private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.armorInventory[3];

		if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin))
		{
			return false;
		} else
		{
			Vec3 vec3 = par1EntityPlayer.getLook(1.0F).normalize();
			Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - par1EntityPlayer.posX, this.boundingBox.minY + (double) (this.height / 2.0F) - (par1EntityPlayer.posY + (double) par1EntityPlayer.getEyeHeight()), this.posZ - par1EntityPlayer.posZ);
			double d0 = vec31.lengthVector();
			vec31 = vec31.normalize();
			double d1 = vec3.dotProduct(vec31);
			return d1 > 1.0D - 0.025D / d0 ? par1EntityPlayer.canEntityBeSeen(this) : false;
		}
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		} else
		{
			this.setScreaming(true);

			if (par1DamageSource instanceof EntityDamageSource && par1DamageSource.getEntity() instanceof EntityPlayer)
			{
				this.isAggressive = true;
			}

			if (par1DamageSource instanceof EntityDamageSourceIndirect)
			{
				this.isAggressive = false;

				for (int i = 0; i < 64; ++i)
				{
					if (this.teleportRandomly())
					{
						return true;
					}
				}

				return super.attackEntityFrom(par1DamageSource, par2);
			} else
			{
				return super.attackEntityFrom(par1DamageSource, par2);
			}
		}
	}

	public boolean isScreaming()
	{
		return this.dataWatcher.getWatchableObjectByte(21) > 0;
	}

	public void setScreaming(boolean par1)
	{
		this.dataWatcher.updateObject(21, Byte.valueOf((byte) (par1 ? 1 : 0)));
	}
}