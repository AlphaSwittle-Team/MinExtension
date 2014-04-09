package mcmod.nxs.minextension.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;

public class DamageBoost extends Enchantment {

	private static final int[] baseEnchantability = new int[] { 1, 5, 5 };

	private static final int[] levelEnchantability = new int[] { 11, 8, 8 };

	private static final int[] thresholdEnchantability = new int[] { 20, 20, 20 };

	public final int damageType;

	public DamageBoost(int par1, int par2, int par3)
	{
		super(par1, par2, EnumEnchantmentType.weapon);
		this.damageType = par3;
	}

	public int getMinEnchantability(int par1)
	{
		return 30;
	}

	public int getMaxEnchantability(int par1)
	{
		return 30;
	}

	public int getMaxLevel()
	{
		return 5;
	}

	public String getName()
	{
		return "Damage Boost";
	}

	public boolean canApplyTogether(Enchantment par1Enchantment)
	{
		return !(par1Enchantment instanceof DamageBoost);
	}

	public float calcModifierLiving(int par1, EntityLivingBase par2EntityLivingBase)
	{
		return 3.5F;
	}

}
