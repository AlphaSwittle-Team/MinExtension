package mcmod.nxs.minextension.entity.passive;

import java.util.Calendar;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityArcher extends EntityMob implements IRangedAttackMob {
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);

	public EntityArcher(World par1World)
	{
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

		if (par1World != null && !par1World.isRemote)
		{
			this.setCombatTask();
		}
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.24999D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
	}

	protected void entityInit()
	{
		super.entityInit();
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	public void updateRidden()
	{
		super.updateRidden();
	}

	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
	}

	protected Item getDropItem()
	{
		return Items.arrow;
	}

	protected void addRandomArmor()
	{
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		par1EntityLivingData = super.onSpawnWithEgg(par1EntityLivingData);

		this.tasks.addTask(4, this.aiArrowAttack);
		this.addRandomArmor();
		this.enchantEquipment();

		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * this.worldObj.func_147462_b(this.posX, this.posY, this.posZ));

		if (this.getEquipmentInSlot(4) == null)
		{
			Calendar calendar = this.worldObj.getCurrentDate();

			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.lit_pumpkin : Blocks.pumpkin));
				this.equipmentDropChances[4] = 0.0F;
			}
		}

		return par1EntityLivingData;
	}

	public void setCombatTask()
	{
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();

		if (itemstack != null && itemstack.getItem() == Items.bow)
		{
			this.tasks.addTask(4, this.aiArrowAttack);
		} else
		{
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	{
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, (float) (14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		entityarrow.setDamage((double) (par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double) ((float) this.worldObj.difficultySetting.getDifficultyId() * 0.11F));

		if (i > 0)
		{
			entityarrow.setDamage(entityarrow.getDamage() + (double) i * 0.5D + 0.5D);
		}

		if (j > 0)
		{
			entityarrow.setKnockbackStrength(j);
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0)
		{
			entityarrow.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setCombatTask();
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
	{
		super.setCurrentItemOrArmor(par1, par2ItemStack);

		if (!this.worldObj.isRemote && par1 == 0)
		{
			this.setCombatTask();
		}
	}

	public double getYOffset()
	{
		return super.getYOffset() - 0.5D;
	}
}