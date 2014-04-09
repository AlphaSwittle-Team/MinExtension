package mcmod.nxs.minextension.core;

import mcmod.nxs.minextension.lib.ItemHelper;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHandler {

	public static Item copper_ingot;
	public static Item platinum_ingot;
	public static Item ruby_gem;
	public static Item sapphire_nugget;
	public static Item onyx_ingot;
	public static Item topaze_gem;
	public static Item mythril_piece;
	public static Item amethyst_piece;

	public static ItemHandler instance()
	{
		return new ItemHandler();
	}

	public void load()
	{
		addItems();
		registerItems();
	}

	public void addItems()
	{
		copper_ingot = new ItemHelper().setNameAndTab("copperIngot", TabHandler.nxsTab);
		platinum_ingot = new ItemHelper().setNameAndTab("platinumIngot", TabHandler.nxsTab);
		ruby_gem = new ItemHelper().setNameAndTab("rubyGem", TabHandler.nxsTab);
		sapphire_nugget = new ItemHelper().setNameAndTab("sapphireNugget", TabHandler.nxsTab);
		onyx_ingot = new ItemHelper().setNameAndTab("onyxIngot", TabHandler.nxsTab);
		topaze_gem = new ItemHelper().setNameAndTab("topazeGem", TabHandler.nxsTab);
		mythril_piece = new ItemHelper().setNameAndTab("mythrilPiece", TabHandler.nxsTab);
		amethyst_piece = new ItemHelper().setNameAndTab("amethystPiece", TabHandler.nxsTab);
	}

	public void registerItems()
	{
		GameRegistry.registerItem(copper_ingot, "copperIngot");
		GameRegistry.registerItem(platinum_ingot, "platinumIngot");
		GameRegistry.registerItem(ruby_gem, "rubyGem");
		GameRegistry.registerItem(sapphire_nugget, "sapphireNugget");
		GameRegistry.registerItem(onyx_ingot, "onyxIngot");
		GameRegistry.registerItem(topaze_gem, "topazeGem");
		GameRegistry.registerItem(mythril_piece, "mythrilPiece");
		GameRegistry.registerItem(amethyst_piece, "amethystPiece");
	}
}
