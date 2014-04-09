package mcmod.nxs.minextension.core;

import mcmod.nxs.minextension.lib.AxeHelper;
import mcmod.nxs.minextension.lib.HoeHelper;
import mcmod.nxs.minextension.lib.PickaxeHelper;
import mcmod.nxs.minextension.lib.SpadeHelper;
import mcmod.nxs.minextension.lib.SwordHelper;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ToolHandler {

	public static ToolMaterial copper = EnumHelper.addToolMaterial("copper", 1, 550, 5, 2, 30);
	public static ToolMaterial platinum = EnumHelper.addToolMaterial("platinum", 2, 850, 6, 3, 50);
	public static ToolMaterial ruby = EnumHelper.addToolMaterial("ruby", 5, 2500, 9, 5, 64);
	public static ToolMaterial sapphire = EnumHelper.addToolMaterial("sapphire", 6, 4000, 12, 6, 64);
	public static ToolMaterial topaze = EnumHelper.addToolMaterial("topaze", 7, 5500, 14, 7, 64);
	public static ToolMaterial onyx = EnumHelper.addToolMaterial("onyx", 3, 12000, 4, 2, 64);
	public static ToolMaterial mythril = EnumHelper.addToolMaterial("mythril", 8, 6000, 16, 8, 64);
	public static ToolMaterial amethyst = EnumHelper.addToolMaterial("amethyst", 10, 10000, 20, 10, 64);
	public static ToolMaterial staff = EnumHelper.addToolMaterial("staff", 16, 12000, 25, 16, 64);

	public static ItemAxe copper_axe, platinum_axe, ruby_axe, sapphire_axe, topaze_axe, onyx_axe, mythril_axe, amethyst_axe, staff_axe;
	public static ItemPickaxe copper_pickaxe, platinum_pickaxe, ruby_pickaxe, sapphire_pickaxe, topaze_pickaxe, onyx_pickaxe, mythril_pickaxe, amethyst_pickaxe, staff_pickaxe;
	public static ItemSpade copper_spade, platinum_spade, ruby_spade, sapphire_spade, topaze_spade, onyx_spade, mythril_spade, amethyst_spade, staff_spade;
	public static ItemHoe copper_hoe, platinum_hoe, ruby_hoe, sapphire_hoe, topaze_hoe, onyx_hoe, mythril_hoe, amethyst_hoe, staff_hoe;
	public static ItemSword copper_sword, platinum_sword, ruby_sword, sapphire_sword, topaze_sword, onyx_sword, mythril_sword, amethyst_sword, staff_sword;

	public static ToolHandler instance()
	{
		return new ToolHandler();
	}

	public void load()
	{
		addTools();
		registerTools();
	}

	public void addTools()
	{
		copper_axe = new AxeHelper(copper).setNameAndTab("copperAxe", TabHandler.nxsTab, ItemHandler.copper_ingot);
		platinum_axe = new AxeHelper(platinum).setNameAndTab("platinumAxe", TabHandler.nxsTab, ItemHandler.platinum_ingot);
		ruby_axe = new AxeHelper(ruby).setNameAndTab("rubyAxe", TabHandler.nxsTab, ItemHandler.ruby_gem);
		sapphire_axe = new AxeHelper(sapphire).setNameAndTab("sapphireAxe", TabHandler.nxsTab, ItemHandler.sapphire_nugget);
		topaze_axe = new AxeHelper(topaze).setNameAndTab("topazeAxe", TabHandler.nxsTab, ItemHandler.topaze_gem);
		onyx_axe = new AxeHelper(onyx).setNameAndTab("onyxAxe", TabHandler.nxsTab, ItemHandler.onyx_ingot);
		mythril_axe = new AxeHelper(mythril).setNameAndTab("mythrilAxe", TabHandler.nxsTab, ItemHandler.mythril_piece);
		amethyst_axe = new AxeHelper(amethyst).setNameAndTab("amethystAxe", TabHandler.nxsTab, ItemHandler.amethyst_piece);
		staff_axe = new AxeHelper(staff).setNameAndTab("staffAxe", TabHandler.nxsTab, null);

		copper_pickaxe = new PickaxeHelper(copper).setNameAndTab("copperPickaxe", TabHandler.nxsTab, ItemHandler.copper_ingot);
		platinum_pickaxe = new PickaxeHelper(platinum).setNameAndTab("platinumPickaxe", TabHandler.nxsTab, ItemHandler.platinum_ingot);
		ruby_pickaxe = new PickaxeHelper(ruby).setNameAndTab("rubyPickaxe", TabHandler.nxsTab, ItemHandler.ruby_gem);
		sapphire_pickaxe = new PickaxeHelper(sapphire).setNameAndTab("sapphirePickaxe", TabHandler.nxsTab, ItemHandler.sapphire_nugget);
		topaze_pickaxe = new PickaxeHelper(topaze).setNameAndTab("topazePickaxe", TabHandler.nxsTab, ItemHandler.topaze_gem);
		onyx_pickaxe = new PickaxeHelper(onyx).setNameAndTab("onyxPickaxe", TabHandler.nxsTab, ItemHandler.onyx_ingot);
		mythril_pickaxe = new PickaxeHelper(mythril).setNameAndTab("mythrilPickaxe", TabHandler.nxsTab, ItemHandler.mythril_piece);
		amethyst_pickaxe = new PickaxeHelper(amethyst).setNameAndTab("amethystPickaxe", TabHandler.nxsTab, ItemHandler.amethyst_piece);
		staff_pickaxe = new PickaxeHelper(staff).setNameAndTab("staffPickaxe", TabHandler.nxsTab, null);

		copper_spade = new SpadeHelper(copper).setNameAndTab("copperSpade", TabHandler.nxsTab, ItemHandler.copper_ingot);
		platinum_spade = new SpadeHelper(platinum).setNameAndTab("platinumSpade", TabHandler.nxsTab, ItemHandler.platinum_ingot);
		ruby_spade = new SpadeHelper(ruby).setNameAndTab("rubySpade", TabHandler.nxsTab, ItemHandler.ruby_gem);
		sapphire_spade = new SpadeHelper(sapphire).setNameAndTab("sapphireSpade", TabHandler.nxsTab, ItemHandler.sapphire_nugget);
		topaze_spade = new SpadeHelper(topaze).setNameAndTab("topazeSpade", TabHandler.nxsTab, ItemHandler.topaze_gem);
		onyx_spade = new SpadeHelper(onyx).setNameAndTab("onyxSpade", TabHandler.nxsTab, ItemHandler.onyx_ingot);
		mythril_spade = new SpadeHelper(mythril).setNameAndTab("mythrilSpade", TabHandler.nxsTab, ItemHandler.mythril_piece);
		amethyst_spade = new SpadeHelper(amethyst).setNameAndTab("amethystSpade", TabHandler.nxsTab, ItemHandler.amethyst_piece);
		staff_spade = new SpadeHelper(staff).setNameAndTab("staffSpade", TabHandler.nxsTab, null);

		copper_hoe = new HoeHelper(copper).setNameAndTab("copperHoe", TabHandler.nxsTab, ItemHandler.copper_ingot);
		platinum_hoe = new HoeHelper(platinum).setNameAndTab("platinumHoe", TabHandler.nxsTab, ItemHandler.platinum_ingot);
		ruby_hoe = new HoeHelper(ruby).setNameAndTab("rubyHoe", TabHandler.nxsTab, ItemHandler.ruby_gem);
		sapphire_hoe = new HoeHelper(sapphire).setNameAndTab("sapphireHoe", TabHandler.nxsTab, ItemHandler.sapphire_nugget);
		topaze_hoe = new HoeHelper(topaze).setNameAndTab("topazeHoe", TabHandler.nxsTab, ItemHandler.topaze_gem);
		onyx_hoe = new HoeHelper(onyx).setNameAndTab("onyxHoe", TabHandler.nxsTab, ItemHandler.onyx_ingot);
		mythril_hoe = new HoeHelper(mythril).setNameAndTab("mythrilHoe", TabHandler.nxsTab, ItemHandler.mythril_piece);
		amethyst_hoe = new HoeHelper(amethyst).setNameAndTab("amethystHoe", TabHandler.nxsTab, ItemHandler.amethyst_piece);
		staff_hoe = new HoeHelper(staff).setNameAndTab("staffHoe", TabHandler.nxsTab, null);

		copper_sword = new SwordHelper(copper).setNameAndTab("copperSword", TabHandler.nxsTab, ItemHandler.copper_ingot);
		platinum_sword = new SwordHelper(platinum).setNameAndTab("platinumSword", TabHandler.nxsTab, ItemHandler.platinum_ingot);
		ruby_sword = new SwordHelper(ruby).setNameAndTab("rubySword", TabHandler.nxsTab, ItemHandler.ruby_gem);
		sapphire_sword = new SwordHelper(sapphire).setNameAndTab("sapphireSword", TabHandler.nxsTab, ItemHandler.sapphire_nugget);
		topaze_sword = new SwordHelper(topaze).setNameAndTab("topazeSword", TabHandler.nxsTab, ItemHandler.topaze_gem);
		onyx_sword = new SwordHelper(onyx).setNameAndTab("onyxSword", TabHandler.nxsTab, ItemHandler.onyx_ingot);
		mythril_sword = new SwordHelper(mythril).setNameAndTab("mythrilSword", TabHandler.nxsTab, ItemHandler.mythril_piece);
		amethyst_sword = new SwordHelper(amethyst).setNameAndTab("amethystSword", TabHandler.nxsTab, ItemHandler.amethyst_piece);
		staff_sword = new SwordHelper(staff).setNameAndTab("staffSword", TabHandler.nxsTab, null);
	}

	public void registerTools()
	{
		GameRegistry.registerItem(copper_axe, "copperAxe");
		GameRegistry.registerItem(copper_pickaxe, "copperPickaxe");
		GameRegistry.registerItem(copper_spade, "copperSpade");
		GameRegistry.registerItem(copper_hoe, "copperHoe");
		GameRegistry.registerItem(copper_sword, "copperSword");

		GameRegistry.registerItem(platinum_axe, "platinumAxe");
		GameRegistry.registerItem(platinum_pickaxe, "platinumPickaxe");
		GameRegistry.registerItem(platinum_spade, "platinumSpade");
		GameRegistry.registerItem(platinum_hoe, "platinumHoe");
		GameRegistry.registerItem(platinum_sword, "platinumSword");

		GameRegistry.registerItem(ruby_axe, "rubyAxe");
		GameRegistry.registerItem(ruby_pickaxe, "rubyPickaxe");
		GameRegistry.registerItem(ruby_spade, "rubySpade");
		GameRegistry.registerItem(ruby_hoe, "rubyHoe");
		GameRegistry.registerItem(ruby_sword, "rubySword");

		GameRegistry.registerItem(sapphire_axe, "sapphireAxe");
		GameRegistry.registerItem(sapphire_pickaxe, "sapphirePickaxe");
		GameRegistry.registerItem(sapphire_spade, "sapphireSpade");
		GameRegistry.registerItem(sapphire_hoe, "sapphireHoe");
		GameRegistry.registerItem(sapphire_sword, "sapphireSword");

		GameRegistry.registerItem(topaze_axe, "topazeAxe");
		GameRegistry.registerItem(topaze_pickaxe, "topazePickaxe");
		GameRegistry.registerItem(topaze_spade, "topazeSpade");
		GameRegistry.registerItem(topaze_hoe, "topazeHoe");
		GameRegistry.registerItem(topaze_sword, "topazeSword");

		GameRegistry.registerItem(onyx_axe, "onyxAxe");
		GameRegistry.registerItem(onyx_pickaxe, "onyxPickaxe");
		GameRegistry.registerItem(onyx_spade, "onyxSpade");
		GameRegistry.registerItem(onyx_hoe, "onyxHoe");
		GameRegistry.registerItem(onyx_sword, "onyxSword");

		GameRegistry.registerItem(mythril_axe, "mythrilAxe");
		GameRegistry.registerItem(mythril_pickaxe, "mythrilPickaxe");
		GameRegistry.registerItem(mythril_spade, "mythrilSpade");
		GameRegistry.registerItem(mythril_hoe, "mythrilHoe");
		GameRegistry.registerItem(mythril_sword, "mythrilSword");

		GameRegistry.registerItem(amethyst_axe, "amethystAxe");
		GameRegistry.registerItem(amethyst_pickaxe, "amethystPickaxe");
		GameRegistry.registerItem(amethyst_spade, "amethystSpade");
		GameRegistry.registerItem(amethyst_hoe, "amethystHoe");
		GameRegistry.registerItem(amethyst_sword, "amethystSword");

		GameRegistry.registerItem(staff_axe, "staffAxe");
		GameRegistry.registerItem(staff_pickaxe, "staffPickaxe");
		GameRegistry.registerItem(staff_spade, "staffSpade");
		GameRegistry.registerItem(staff_hoe, "staffHoe");
		GameRegistry.registerItem(staff_sword, "staffSword");
	}
}