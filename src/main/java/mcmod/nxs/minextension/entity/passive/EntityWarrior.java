package mcmod.nxs.minextension.entity.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityWarrior extends EntityMob {
	public int texture;

	public EntityWarrior(World par1World)
	{
		super(par1World);
		texture = this.worldObj.rand.nextInt(2);
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
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

	protected boolean isAIEnabled()
	{
		return true;
	}

	public void onLivingUpdate()
	{
		this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
		super.onLivingUpdate();
	}

	public void onUpdate()
	{
		super.onUpdate();
	}

	protected Item getDropItem()
	{
		return Items.stick;
	}

	protected void dropRareDrop(int par1)
	{
		switch (this.rand.nextInt(3)) {
		case 0:
			this.dropItem(Items.iron_ingot, 1);
			break;
		case 1:
			this.dropItem(Items.iron_sword, 1);
			break;
		case 2:
			this.dropItem(Items.iron_horse_armor, 1);
		}
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
	}
}