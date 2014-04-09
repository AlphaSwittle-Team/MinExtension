package mcmod.nxs.minextension.gen;

import java.util.Random;

import mcmod.nxs.minextension.core.BlockHandler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random random, int x, int z)
	{
		int xCoord = x + random.nextInt(4);
		int yCoord = random.nextInt(256);
		int zCoord = z + random.nextInt(4);
		(new WorldGenEndMinable(BlockHandler.tnt_endstone, 7 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
		(new WorldGenEndMinable(BlockHandler.mythril_ore, 5 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
		(new WorldGenEndMinable(BlockHandler.amethyst_ore, 3 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
	}

	private void generateSurface(World world, Random random, int x, int z)
	{
		for (int i = 0; i <= 15; i++)
		{
			int xCoord = x + random.nextInt(16);
			int yCoord = random.nextInt(76);
			int zCoord = z + random.nextInt(16);
			(new WorldGenMinable(BlockHandler.tnt_stone, 7 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
		}

		for (int i = 0; i <= 13; i++)
		{
			int xCoord = x + random.nextInt(16);
			int yCoord = random.nextInt(64);
			int zCoord = z + random.nextInt(16);
			(new WorldGenMinable(BlockHandler.copper_ore, 7 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
		}

		for (int i = 0; i <= 15; i++)
		{
			int xCoord = x + random.nextInt(16);
			int yCoord = random.nextInt(52);
			int zCoord = z + random.nextInt(16);
			(new WorldGenMinable(BlockHandler.platinum_ore, 5 + random.nextInt(5))).generate(world, random, xCoord, yCoord, zCoord);
		}

		for (int i = 0; i <= 15; i++)
		{
			int xCoord = x + random.nextInt(16);
			int yCoord = random.nextInt(40);
			int zCoord = z + random.nextInt(16);
			(new WorldGenMinable(BlockHandler.ruby_ore, 5 + random.nextInt(3))).generate(world, random, xCoord, yCoord, zCoord);
		}

		for (int i = 0; i <= 15; i++)
		{
			int xCoord = x + random.nextInt(16);
			int yCoord = random.nextInt(32);
			int zCoord = z + random.nextInt(16);
			(new WorldGenMinable(BlockHandler.sapphire_ore, 3 + random.nextInt(3))).generate(world, random, xCoord, yCoord, zCoord);
		}
	}

	private void generateNether(World world, Random random, int x, int z)
	{
		int xCoord = x + random.nextInt(4);
		int yCoord = random.nextInt(128);
		int zCoord = z + random.nextInt(4);
		(new WorldGenNetherMinable(BlockHandler.tnt_netherrack, 7 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
		(new WorldGenNetherMinable(BlockHandler.onyx_ore, 5 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
		(new WorldGenNetherMinable(BlockHandler.topaze_ore, 3 + random.nextInt(4))).generate(world, random, xCoord, yCoord, zCoord);
	}
}