package mcmod.nxs.minextension.core;

import mcmod.nxs.minextension.block.AmethystOre;
import mcmod.nxs.minextension.block.FossilOre;
import mcmod.nxs.minextension.block.GolemSummoner;
import mcmod.nxs.minextension.block.MythrilOre;
import mcmod.nxs.minextension.block.RubyOre;
import mcmod.nxs.minextension.block.SapphireOre;
import mcmod.nxs.minextension.block.TopazeOre;
import mcmod.nxs.minextension.lib.BlockHelper;
import mcmod.nxs.minextension.lib.ExplosiveBlockHelper;
import mcmod.nxs.minextension.lib.ResourcePathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHandler {

	public static Block fossil_ore;
	public static Block copper_ore;
	public static Block platinum_ore;
	public static Block ruby_ore;
	public static Block sapphire_ore;
	public static Block onyx_ore;
	public static Block topaze_ore;
	public static Block mythril_ore;
	public static Block amethyst_ore;

	public static Block copper_block;
	public static Block platinum_block;
	public static Block ruby_block;
	public static Block sapphire_block;
	public static Block onyx_block;
	public static Block topaze_block;
	public static Block mythril_block;
	public static Block amethyst_block;

	public static Block golem_head;

	public static Block tnt_stone, tnt_netherrack, tnt_endstone;

	public static BlockHandler instance()
	{
		return new BlockHandler();
	}

	public void load()
	{
		addBlocks();
		registerBlocks();
	}

	public void addBlocks()
	{
		fossil_ore = new FossilOre(Material.rock).setBlockParameters("fossilOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		copper_ore = new BlockHelper(Material.rock).setBlockParameters("copperOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		platinum_ore = new BlockHelper(Material.rock).setBlockParameters("platinumOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		sapphire_ore = new SapphireOre(Material.rock).setBlockParameters("sapphireOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		ruby_ore = new RubyOre(Material.rock).setBlockParameters("rubyOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		onyx_ore = new BlockHelper(Material.rock).setBlockParameters("onyxOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		topaze_ore = new TopazeOre(Material.rock).setBlockParameters("topazeOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		mythril_ore = new MythrilOre(Material.rock).setBlockParameters("mythrilOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);
		amethyst_ore = new AmethystOre(Material.rock).setBlockParameters("amethystOre", 5, 5, Block.soundTypeStone, TabHandler.nxsTab);

		copper_block = new BlockHelper(Material.iron).setBlockParameters("copperBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		platinum_block = new BlockHelper(Material.iron).setBlockParameters("platinumBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		sapphire_block = new BlockHelper(Material.iron).setBlockParameters("sapphireBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		ruby_block = new BlockHelper(Material.iron).setBlockParameters("rubyBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		onyx_block = new BlockHelper(Material.iron).setBlockParameters("onyxBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		topaze_block = new BlockHelper(Material.iron).setBlockParameters("topazeBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		mythril_block = new BlockHelper(Material.iron).setBlockParameters("mythrilBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);
		amethyst_block = new BlockHelper(Material.iron).setBlockParameters("amethystBlock", 5, 5, Block.soundTypeMetal, TabHandler.nxsTab);

		golem_head = new GolemSummoner(false).setBlockName("golemHead").setBlockTextureName(ResourcePathHelper.getResourcesPath() + "golemHead").setCreativeTab(TabHandler.nxsTab).setHardness(3);

		tnt_stone = new ExplosiveBlockHelper(Material.rock).setBlockParameters("tntStone", 5, 5, Block.soundTypeStone, TabHandler.nxsTab, 5);
		tnt_netherrack = new ExplosiveBlockHelper(Material.rock).setBlockParameters("tntNetherrack", 5, 5, Block.soundTypeStone, TabHandler.nxsTab, 10);
		tnt_endstone = new ExplosiveBlockHelper(Material.rock).setBlockParameters("tntEndstone", 5, 5, Block.soundTypeStone, TabHandler.nxsTab, 15);
	}

	public void registerBlocks()
	{
		GameRegistry.registerBlock(fossil_ore, "fossilOre");
		GameRegistry.registerBlock(copper_ore, "copperOre");
		GameRegistry.registerBlock(platinum_ore, "platinumOre");
		GameRegistry.registerBlock(sapphire_ore, "sapphireOre");
		GameRegistry.registerBlock(ruby_ore, "rubyOre");
		GameRegistry.registerBlock(onyx_ore, "onyxOre");
		GameRegistry.registerBlock(topaze_ore, "topazeOre");
		GameRegistry.registerBlock(mythril_ore, "mythrilOre");
		GameRegistry.registerBlock(amethyst_ore, "amethystOre");

		GameRegistry.registerBlock(copper_block, "copperBlock");
		GameRegistry.registerBlock(platinum_block, "platinumBlock");
		GameRegistry.registerBlock(sapphire_block, "sapphireBlock");
		GameRegistry.registerBlock(ruby_block, "rubyBlock");
		GameRegistry.registerBlock(onyx_block, "onyxBlock");
		GameRegistry.registerBlock(topaze_block, "topazeBlock");
		GameRegistry.registerBlock(mythril_block, "mythrilBlock");
		GameRegistry.registerBlock(amethyst_block, "amethystBlock");

		GameRegistry.registerBlock(golem_head, "golemHead");

		GameRegistry.registerBlock(tnt_stone, "tntStone");
		GameRegistry.registerBlock(tnt_netherrack, "tntNetherrack");
		GameRegistry.registerBlock(tnt_endstone, "tntEndstone");
	}
}
