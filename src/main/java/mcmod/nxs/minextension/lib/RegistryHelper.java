package mcmod.nxs.minextension.lib;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegistryHelper {
	protected static Random rand = new Random();

	public static RegistryHelper instance = new RegistryHelper();

	public static void addExplosiveBlockRecipe(ItemStack block, Block centerBlock)
	{
		GameRegistry.addRecipe(block, new Object[] { "XXX", "XYX", "XXX", 'X', Blocks.tnt, 'Y', centerBlock });
	}

	public static void addBlockOfMaterial(ItemStack block, Item material)
	{
		GameRegistry.addRecipe(block, new Object[] { "XXX", "XXX", "XXX", 'X', material });
		GameRegistry.addShapelessRecipe(new ItemStack(material, 9), new Object[] { block });
	}

	public static void addToolsCrafting(ItemStack toolMaterial, EnumToolHelper toolType, ItemStack toolOutput, ItemStack toolStick)
	{
		try
		{
			if (toolType == EnumToolHelper.AXE)
			{
				GameRegistry.addRecipe(toolOutput, new Object[] { "XX", "XS", " S", 'X', toolMaterial, 'S', toolStick });
				GameRegistry.addRecipe(toolOutput, new Object[] { "XX", "SX", "S ", 'X', toolMaterial, 'S', toolStick });
			} else if (toolType == EnumToolHelper.PICKAXE)
			{
				GameRegistry.addRecipe(toolOutput, new Object[] { "XXX", " S ", " S ", 'X', toolMaterial, 'S', toolStick });
			} else if (toolType == EnumToolHelper.SPADE)
			{
				GameRegistry.addRecipe(toolOutput, new Object[] { "X", "S", "S", 'X', toolMaterial, 'S', toolStick });
			} else if (toolType == EnumToolHelper.HOE)
			{
				GameRegistry.addRecipe(toolOutput, new Object[] { "XX", " S", " S", 'X', toolMaterial, 'S', toolStick });
				GameRegistry.addRecipe(toolOutput, new Object[] { "XX", "S ", "S ", 'X', toolMaterial, 'S', toolStick });
			} else if (toolType == EnumToolHelper.SWORD)
			{
				GameRegistry.addRecipe(toolOutput, new Object[] { "X", "X", "S", 'X', toolMaterial, 'S', toolStick });
			} else
			{
				System.out.println("Failed to register tool recipe for " + toolType + " !");
			}
		} catch (Exception e)
		{
			System.out.println("Failed to register tool recipe !");
		}
	}

	public static void addAllToolsCrafting(ItemStack toolMaterial, ItemStack outputAxe, ItemStack outputShovel, ItemStack outputHoe, ItemStack outputPickaxe, ItemStack outputSword, ItemStack toolStick)
	{
		try
		{
			GameRegistry.addRecipe(outputAxe, new Object[] { "XX", "XS", " S", 'X', toolMaterial, 'S', toolStick });
			GameRegistry.addRecipe(outputAxe, new Object[] { "XX", "SX", "S ", 'X', toolMaterial, 'S', toolStick });
			GameRegistry.addRecipe(outputShovel, new Object[] { "X", "S", "S", 'X', toolMaterial, 'S', toolStick });
			GameRegistry.addRecipe(outputHoe, new Object[] { "XX", " S", " S", 'X', toolMaterial, 'S', toolStick });
			GameRegistry.addRecipe(outputHoe, new Object[] { "XX", "S ", "S ", 'X', toolMaterial, 'S', toolStick });
			GameRegistry.addRecipe(outputPickaxe, new Object[] { "XXX", " S ", " S ", 'X', toolMaterial, 'S', toolStick });
			GameRegistry.addRecipe(outputSword, new Object[] { "X", "X", "S", 'X', toolMaterial, 'S', toolStick });
		} catch (Exception e)
		{
			System.out.println("Failed to register tools crafting");
		}
	}

	public static void addArmorCrafting(ItemStack armorMaterial, EnumArmorHelper armorType, ItemStack output)
	{
		try
		{
			if (armorType == EnumArmorHelper.HELMET)
			{
				GameRegistry.addRecipe(output, new Object[] { "XXX", "X X", 'X', armorMaterial });
			} else if (armorType == EnumArmorHelper.CHESTPLATE)
			{
				GameRegistry.addRecipe(output, new Object[] { "X X", "XXX", "XXX", 'X', armorMaterial });
			} else if (armorType == EnumArmorHelper.LEGGINGS)
			{
				GameRegistry.addRecipe(output, new Object[] { "XXX", "X X", "X X", 'X', armorMaterial });
			} else if (armorType == EnumArmorHelper.BOOTS)
			{
				GameRegistry.addRecipe(output, new Object[] { "X X", "X X", 'X', armorMaterial });
			} else
			{
				System.out.println("Failed to register armor crafting, couldn't handle type " + armorType);
			}
		} catch (Exception e)
		{
			System.out.println("Failed to register armor crafting");
		}
	}

	public static void addAllArmorCrafting(ItemStack armorMaterial, ItemStack outputHelmet, ItemStack outputChestPlate, ItemStack outputLeggings, ItemStack outputBoots)
	{
		try
		{
			GameRegistry.addRecipe(outputHelmet, new Object[] { "XXX", "X X", 'X', armorMaterial });
			GameRegistry.addRecipe(outputChestPlate, new Object[] { "X X", "XXX", "XXX", 'X', armorMaterial });
			GameRegistry.addRecipe(outputLeggings, new Object[] { "XXX", "X X", "X X", 'X', armorMaterial });
			GameRegistry.addRecipe(outputBoots, new Object[] { "X X", "X X", 'X', armorMaterial });
		} catch (Exception e)
		{
			System.out.println("Failed to register armor crafting !");
		}
	}

	public static void addSmeltingRecipe(Block input, ItemStack output, float xp)
	{
		GameRegistry.addSmelting(input, output, xp);
	}

	public static void addOtherEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

	public static void addMob(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int backGroundEggColour, int foreGroundEggColour, int weightedProb, int minSpawn, int maxSpawn, EnumCreatureType creatureType)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), backGroundEggColour, foreGroundEggColour);
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.addSpawn(entityName, weightedProb, minSpawn, maxSpawn, creatureType);
	}

	public static void addMob(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int backGroundEggColour, int foreGroundEggColour, int weightedProb, int minSpawn, int maxSpawn, EnumCreatureType creatureType, BiomeGenBase... biome)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), backGroundEggColour, foreGroundEggColour);
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.addSpawn(entityName, weightedProb, minSpawn, maxSpawn, creatureType, biome);
	}

	public static void targetEntity(World world, EntityCreature entityHostAttack, Class<? extends EntityLivingBase> classToAttack)
	{
		List list = world.getEntitiesWithinAABB(classToAttack, entityHostAttack.boundingBox.getBoundingBox(entityHostAttack.posX, entityHostAttack.posY, entityHostAttack.posZ, entityHostAttack.posX + 1, entityHostAttack.posY + 1, entityHostAttack.posZ + 1).expand(16D, 4D, 16D));
		Entity entityToAttack = (Entity) list.get(rand.nextInt(list.size()));
		if (!list.isEmpty())
		{
			entityHostAttack.setTarget(entityToAttack);
		}
	}

	public static boolean entityOnGround(Entity entity)
	{
		return entity.onGround;
	}

	public void removeLoadedEntityList(World world, Entity entityToRemove)
	{
		List list = world.getLoadedEntityList();
		if (!list.isEmpty())
		{
			list.remove(entityToRemove);
		}
	}

	public static void setInfiniteHealthToEntity(EntityLivingBase entity)
	{
		entity.setHealth(Float.MAX_VALUE);
	}
}