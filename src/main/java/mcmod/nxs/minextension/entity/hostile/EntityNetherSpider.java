package mcmod.nxs.minextension.entity.hostile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityNetherSpider extends EntitySpider {

	public EntityNetherSpider(World par1World)
	{
		super(par1World);
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(32.0D);
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
		{
			if (par1Entity instanceof EntityLivingBase)
			{
				byte b0 = 0;

				if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL)
				{
					b0 = 7;
				} else if (this.worldObj.difficultySetting == EnumDifficulty.HARD)
				{
					b0 = 15;
				}

				if (b0 > 0)
				{
					((EntityLivingBase) par1Entity).setFire(20 * b0);
				}
			}

			return true;
		} else
		{
			return false;
		}
	}

	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1EntityLivingData)
	{
		return par1EntityLivingData;
	}
}