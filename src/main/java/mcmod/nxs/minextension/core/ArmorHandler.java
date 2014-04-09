package mcmod.nxs.minextension.core;

import mcmod.nxs.minextension.item.armor.AmethystArmor;
import mcmod.nxs.minextension.item.armor.CopperArmor;
import mcmod.nxs.minextension.item.armor.OnyxArmor;
import mcmod.nxs.minextension.item.armor.PlatinumArmor;
import mcmod.nxs.minextension.item.armor.RubyArmor;
import mcmod.nxs.minextension.item.armor.SapphireArmor;
import mcmod.nxs.minextension.item.armor.StaffArmor;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ArmorHandler {

	public static ArmorMaterial copper = EnumHelper.addArmorMaterial("copper", 55, new int[] { 3, 5, 4, 3 }, 20);
	public static ArmorMaterial platinum = EnumHelper.addArmorMaterial("platinum", 85, new int[] { 4, 5, 4, 3 }, 30);
	public static ArmorMaterial ruby = EnumHelper.addArmorMaterial("ruby", 250, new int[] { 5, 6, 5, 4 }, 35);
	public static ArmorMaterial sapphire = EnumHelper.addArmorMaterial("sapphire", 400, new int[] { 6, 7, 6, 5 }, 40);
	public static ArmorMaterial onyx = EnumHelper.addArmorMaterial("onyx", 1200, new int[] { 7, 8, 7, 6 }, 50);
	public static ArmorMaterial mythril = EnumHelper.addArmorMaterial("mythril", 600, new int[] { 8, 9, 8, 7 }, 55);
	public static ArmorMaterial amethyst = EnumHelper.addArmorMaterial("amethyst", 1000, new int[] { 10, 11, 10, 9 }, 64);
	public static ArmorMaterial staff = EnumHelper.addArmorMaterial("staff", 2400, new int[] { 13, 15, 14, 12 }, 64);

	public static ItemArmor copper_helmet, copper_chestplate, copper_leggings, copper_boots;
	public static ItemArmor platinum_helmet, platinum_chestplate, platinum_leggings, platinum_boots;
	public static ItemArmor ruby_helmet, ruby_chestplate, ruby_leggings, ruby_boots;
	public static ItemArmor sapphire_helmet, sapphire_chestplate, sapphire_leggings, sapphire_boots;
	public static ItemArmor onyx_helmet, onyx_chestplate, onyx_leggings, onyx_boots;
	public static ItemArmor amethyst_helmet, amethyst_chestplate, amethyst_leggings, amethyst_boots;
	public static ItemArmor staff_helmet, staff_chestplate, staff_leggings, staff_boots;

	public static ArmorHandler instance()
	{
		return new ArmorHandler();
	}

	public void load()
	{
		addArmors();
		registerArmors();
	}

	public void addArmors()
	{
		copper_helmet = new CopperArmor(copper, 0, 0).setNameAndTab("copperHelmet", TabHandler.nxsTab);
		copper_chestplate = new CopperArmor(copper, 1, 1).setNameAndTab("copperChestplate", TabHandler.nxsTab);
		copper_leggings = new CopperArmor(copper, 2, 2).setNameAndTab("copperLeggings", TabHandler.nxsTab);
		copper_boots = new CopperArmor(copper, 3, 3).setNameAndTab("copperBoots", TabHandler.nxsTab);
		platinum_helmet = new PlatinumArmor(platinum, 0, 0).setNameAndTab("platinumHelmet", TabHandler.nxsTab);
		platinum_chestplate = new PlatinumArmor(platinum, 1, 1).setNameAndTab("platinumChestplate", TabHandler.nxsTab);
		platinum_leggings = new PlatinumArmor(platinum, 2, 2).setNameAndTab("platinumLeggings", TabHandler.nxsTab);
		platinum_boots = new PlatinumArmor(platinum, 3, 3).setNameAndTab("platinumBoots", TabHandler.nxsTab);
		ruby_helmet = new RubyArmor(ruby, 0, 0).setNameAndTab("rubyHelmet", TabHandler.nxsTab);
		ruby_chestplate = new RubyArmor(ruby, 1, 1).setNameAndTab("rubyChestplate", TabHandler.nxsTab);
		ruby_leggings = new RubyArmor(ruby, 2, 2).setNameAndTab("rubyLeggings", TabHandler.nxsTab);
		ruby_boots = new RubyArmor(ruby, 3, 3).setNameAndTab("rubyBoots", TabHandler.nxsTab);
		sapphire_helmet = new SapphireArmor(sapphire, 0, 0).setNameAndTab("sapphireHelmet", TabHandler.nxsTab);
		sapphire_chestplate = new SapphireArmor(sapphire, 1, 1).setNameAndTab("sapphireChestplate", TabHandler.nxsTab);
		sapphire_leggings = new SapphireArmor(sapphire, 2, 2).setNameAndTab("sapphireLeggings", TabHandler.nxsTab);
		sapphire_boots = new SapphireArmor(sapphire, 3, 3).setNameAndTab("sapphireBoots", TabHandler.nxsTab);
		onyx_helmet = new OnyxArmor(onyx, 0, 0).setNameAndTab("onyxHelmet", TabHandler.nxsTab);
		onyx_chestplate = new OnyxArmor(onyx, 1, 1).setNameAndTab("onyxChestplate", TabHandler.nxsTab);
		onyx_leggings = new OnyxArmor(onyx, 2, 2).setNameAndTab("onyxLeggings", TabHandler.nxsTab);
		onyx_boots = new OnyxArmor(onyx, 3, 3).setNameAndTab("onyxBoots", TabHandler.nxsTab);
		amethyst_helmet = new AmethystArmor(amethyst, 0, 0).setNameAndTab("amethystHelmet", TabHandler.nxsTab);
		amethyst_chestplate = new AmethystArmor(amethyst, 1, 1).setNameAndTab("amethystChestplate", TabHandler.nxsTab);
		amethyst_leggings = new AmethystArmor(amethyst, 2, 2).setNameAndTab("amethystLeggings", TabHandler.nxsTab);
		amethyst_boots = new AmethystArmor(amethyst, 3, 3).setNameAndTab("amethystBoots", TabHandler.nxsTab);
		staff_helmet = new StaffArmor(staff, 0, 0).setNameAndTab("staffHelmet", TabHandler.nxsTab);
		staff_chestplate = new StaffArmor(staff, 1, 1).setNameAndTab("staffChestplate", TabHandler.nxsTab);
		staff_leggings = new StaffArmor(staff, 2, 2).setNameAndTab("staffLeggings", TabHandler.nxsTab);
		staff_boots = new StaffArmor(staff, 3, 3).setNameAndTab("staffBoots", TabHandler.nxsTab);
	}

	public void registerArmors()
	{
		GameRegistry.registerItem(copper_helmet, "copperHelmet");
		GameRegistry.registerItem(copper_chestplate, "copperChestplate");
		GameRegistry.registerItem(copper_leggings, "copperLeggings");
		GameRegistry.registerItem(copper_boots, "copperBoots");
		GameRegistry.registerItem(platinum_helmet, "platinumHelmet");
		GameRegistry.registerItem(platinum_chestplate, "platinumChestplate");
		GameRegistry.registerItem(platinum_leggings, "platinumLeggings");
		GameRegistry.registerItem(platinum_boots, "platinumBoots");
		GameRegistry.registerItem(ruby_helmet, "rubyHelmet");
		GameRegistry.registerItem(ruby_chestplate, "rubyChestplate");
		GameRegistry.registerItem(ruby_leggings, "rubyLeggings");
		GameRegistry.registerItem(ruby_boots, "rubyBoots");
		GameRegistry.registerItem(sapphire_helmet, "sapphireHelmet");
		GameRegistry.registerItem(sapphire_chestplate, "sapphireChestplate");
		GameRegistry.registerItem(sapphire_leggings, "sapphireLeggings");
		GameRegistry.registerItem(sapphire_boots, "sapphireBoots");
		GameRegistry.registerItem(onyx_helmet, "onyxHelmet");
		GameRegistry.registerItem(onyx_chestplate, "onyxChestplate");
		GameRegistry.registerItem(onyx_leggings, "onyxLeggings");
		GameRegistry.registerItem(onyx_boots, "onyxBoots");
		GameRegistry.registerItem(amethyst_helmet, "amethystHelmet");
		GameRegistry.registerItem(amethyst_chestplate, "amethystChestplate");
		GameRegistry.registerItem(amethyst_leggings, "amethystLeggings");
		GameRegistry.registerItem(amethyst_boots, "amethystBoots");
		GameRegistry.registerItem(staff_helmet, "staffHelmet");
		GameRegistry.registerItem(staff_chestplate, "staffChestplate");
		GameRegistry.registerItem(staff_leggings, "staffLeggings");
		GameRegistry.registerItem(staff_boots, "staffBoots");
	}
}
