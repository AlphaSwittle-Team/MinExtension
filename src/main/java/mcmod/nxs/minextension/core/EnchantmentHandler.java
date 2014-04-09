package mcmod.nxs.minextension.core;

import mcmod.nxs.minextension.enchantment.DamageBoost;
import net.minecraft.enchantment.Enchantment;

public class EnchantmentHandler {
	public static Enchantment damageBoost;

	public static EnchantmentHandler instance()
	{
		return new EnchantmentHandler();
	}

	public void load()
	{
		addEnchantments();
	}

	public void addEnchantments()
	{
		damageBoost = new DamageBoost(200, 10, 10);
	}
}
