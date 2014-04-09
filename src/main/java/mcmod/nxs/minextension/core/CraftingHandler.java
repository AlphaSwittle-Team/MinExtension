package mcmod.nxs.minextension.core;

import cpw.mods.fml.common.registry.GameRegistry;
import mcmod.nxs.minextension.lib.EnumToolHelper;
import mcmod.nxs.minextension.lib.RegistryHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingHandler {

	public static CraftingHandler instance()
	{
		return new CraftingHandler();
	}

	public void load()
	{
		addRecipes();
		addSmeltings();
	}

	public void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(BlockHandler.golem_head), new Object[] { "XXX", "XXX", "XXX", 'X', Blocks.pumpkin });
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.copper_ingot), EnumToolHelper.AXE, new ItemStack(ToolHandler.copper_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.copper_ingot), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.copper_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.copper_ingot), EnumToolHelper.SPADE, new ItemStack(ToolHandler.copper_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.copper_ingot), EnumToolHelper.HOE, new ItemStack(ToolHandler.copper_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.copper_ingot), EnumToolHelper.SWORD, new ItemStack(ToolHandler.copper_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.platinum_ingot), EnumToolHelper.AXE, new ItemStack(ToolHandler.platinum_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.platinum_ingot), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.platinum_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.platinum_ingot), EnumToolHelper.SPADE, new ItemStack(ToolHandler.platinum_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.platinum_ingot), EnumToolHelper.HOE, new ItemStack(ToolHandler.platinum_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.platinum_ingot), EnumToolHelper.SWORD, new ItemStack(ToolHandler.platinum_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.ruby_gem), EnumToolHelper.AXE, new ItemStack(ToolHandler.ruby_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.ruby_gem), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.ruby_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.ruby_gem), EnumToolHelper.SPADE, new ItemStack(ToolHandler.ruby_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.ruby_gem), EnumToolHelper.HOE, new ItemStack(ToolHandler.ruby_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.ruby_gem), EnumToolHelper.SWORD, new ItemStack(ToolHandler.ruby_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.sapphire_nugget), EnumToolHelper.AXE, new ItemStack(ToolHandler.sapphire_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.sapphire_nugget), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.sapphire_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.sapphire_nugget), EnumToolHelper.SPADE, new ItemStack(ToolHandler.sapphire_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.sapphire_nugget), EnumToolHelper.HOE, new ItemStack(ToolHandler.sapphire_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.sapphire_nugget), EnumToolHelper.SWORD, new ItemStack(ToolHandler.sapphire_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.topaze_gem), EnumToolHelper.AXE, new ItemStack(ToolHandler.topaze_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.topaze_gem), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.topaze_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.topaze_gem), EnumToolHelper.SPADE, new ItemStack(ToolHandler.topaze_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.topaze_gem), EnumToolHelper.HOE, new ItemStack(ToolHandler.topaze_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.topaze_gem), EnumToolHelper.SWORD, new ItemStack(ToolHandler.topaze_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.onyx_ingot), EnumToolHelper.AXE, new ItemStack(ToolHandler.onyx_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.onyx_ingot), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.onyx_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.onyx_ingot), EnumToolHelper.SPADE, new ItemStack(ToolHandler.onyx_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.onyx_ingot), EnumToolHelper.HOE, new ItemStack(ToolHandler.onyx_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.onyx_ingot), EnumToolHelper.SWORD, new ItemStack(ToolHandler.onyx_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.mythril_piece), EnumToolHelper.AXE, new ItemStack(ToolHandler.mythril_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.mythril_piece), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.mythril_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.mythril_piece), EnumToolHelper.SPADE, new ItemStack(ToolHandler.mythril_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.mythril_piece), EnumToolHelper.HOE, new ItemStack(ToolHandler.mythril_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.mythril_piece), EnumToolHelper.SWORD, new ItemStack(ToolHandler.mythril_sword), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.amethyst_piece), EnumToolHelper.AXE, new ItemStack(ToolHandler.amethyst_axe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.amethyst_piece), EnumToolHelper.PICKAXE, new ItemStack(ToolHandler.amethyst_pickaxe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.amethyst_piece), EnumToolHelper.SPADE, new ItemStack(ToolHandler.amethyst_spade), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.amethyst_piece), EnumToolHelper.HOE, new ItemStack(ToolHandler.amethyst_hoe), new ItemStack(Items.stick));
		RegistryHelper.addToolsCrafting(new ItemStack(ItemHandler.amethyst_piece), EnumToolHelper.SWORD, new ItemStack(ToolHandler.amethyst_sword), new ItemStack(Items.stick));
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.copper_block), ItemHandler.copper_ingot);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.platinum_block), ItemHandler.platinum_ingot);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.ruby_block), ItemHandler.ruby_gem);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.sapphire_block), ItemHandler.sapphire_nugget);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.topaze_block), ItemHandler.topaze_gem);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.onyx_block), ItemHandler.onyx_ingot);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.mythril_block), ItemHandler.mythril_piece);
		RegistryHelper.addBlockOfMaterial(new ItemStack(BlockHandler.amethyst_block), ItemHandler.amethyst_piece);
		RegistryHelper.addAllArmorCrafting(new ItemStack(ItemHandler.copper_ingot), new ItemStack(ArmorHandler.copper_helmet), new ItemStack(ArmorHandler.copper_chestplate), new ItemStack(ArmorHandler.copper_leggings), new ItemStack(ArmorHandler.copper_boots));
		RegistryHelper.addAllArmorCrafting(new ItemStack(ItemHandler.platinum_ingot), new ItemStack(ArmorHandler.platinum_helmet), new ItemStack(ArmorHandler.platinum_chestplate), new ItemStack(ArmorHandler.platinum_leggings), new ItemStack(ArmorHandler.platinum_boots));
		RegistryHelper.addAllArmorCrafting(new ItemStack(ItemHandler.ruby_gem), new ItemStack(ArmorHandler.ruby_helmet), new ItemStack(ArmorHandler.ruby_chestplate), new ItemStack(ArmorHandler.ruby_leggings), new ItemStack(ArmorHandler.ruby_boots));
		RegistryHelper.addAllArmorCrafting(new ItemStack(ItemHandler.sapphire_nugget), new ItemStack(ArmorHandler.sapphire_helmet), new ItemStack(ArmorHandler.sapphire_chestplate), new ItemStack(ArmorHandler.sapphire_leggings), new ItemStack(ArmorHandler.sapphire_boots));
		RegistryHelper.addAllArmorCrafting(new ItemStack(ItemHandler.onyx_ingot), new ItemStack(ArmorHandler.onyx_helmet), new ItemStack(ArmorHandler.onyx_chestplate), new ItemStack(ArmorHandler.onyx_leggings), new ItemStack(ArmorHandler.onyx_boots));
		RegistryHelper.addAllArmorCrafting(new ItemStack(ItemHandler.amethyst_piece), new ItemStack(ArmorHandler.amethyst_helmet), new ItemStack(ArmorHandler.amethyst_chestplate), new ItemStack(ArmorHandler.amethyst_leggings), new ItemStack(ArmorHandler.amethyst_boots));
		RegistryHelper.addExplosiveBlockRecipe(new ItemStack(BlockHandler.tnt_stone), Blocks.stone);
		RegistryHelper.addExplosiveBlockRecipe(new ItemStack(BlockHandler.tnt_netherrack), Blocks.netherrack);
		RegistryHelper.addExplosiveBlockRecipe(new ItemStack(BlockHandler.tnt_endstone), Blocks.end_stone);
	}

	public void addSmeltings()
	{
		RegistryHelper.addSmeltingRecipe(BlockHandler.copper_ore, new ItemStack(ItemHandler.copper_ingot), 1f);
		RegistryHelper.addSmeltingRecipe(BlockHandler.platinum_ore, new ItemStack(ItemHandler.platinum_ingot), 1f);
		RegistryHelper.addSmeltingRecipe(BlockHandler.onyx_ore, new ItemStack(ItemHandler.onyx_ingot), 1f);
	}
}