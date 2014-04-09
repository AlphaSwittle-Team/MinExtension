package mcmod.nxs.minextension.block;

import mcmod.nxs.minextension.entity.passive.EntityDiamondGolem;
import mcmod.nxs.minextension.entity.passive.EntityGoldGolem;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GolemSummoner extends BlockDirectional {
	private boolean field_149985_a;
	@SideOnly(Side.CLIENT)
	private IIcon field_149984_b;
	@SideOnly(Side.CLIENT)
	private IIcon field_149986_M;
	private static final String __OBFID = "CL_00000291";

	public GolemSummoner(boolean p_i45419_1_)
	{
		super(Material.gourd);
		this.setTickRandomly(true);
		this.field_149985_a = p_i45419_1_;
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return p_149691_1_ == 1 ? this.field_149984_b : (p_149691_1_ == 0 ? this.field_149984_b : (p_149691_2_ == 2 && p_149691_1_ == 2 ? this.field_149986_M : (p_149691_2_ == 3 && p_149691_1_ == 5 ? this.field_149986_M : (p_149691_2_ == 0 && p_149691_1_ == 3 ? this.field_149986_M : (p_149691_2_ == 1 && p_149691_1_ == 4 ? this.field_149986_M : this.blockIcon)))));
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World world, int posX, int posY, int posZ)
	{
		super.onBlockAdded(world, posX, posY, posZ);
		if (world.getBlock(posX, posY - 1, posZ) == Blocks.iron_block && world.getBlock(posX, posY - 2, posZ) == Blocks.iron_block)
		{
			boolean flag = world.getBlock(posX - 1, posY - 1, posZ) == Blocks.iron_block && world.getBlock(posX + 1, posY - 1, posZ) == Blocks.iron_block;
			boolean flag1 = world.getBlock(posX, posY - 1, posZ - 1) == Blocks.iron_block && world.getBlock(posX, posY - 1, posZ + 1) == Blocks.iron_block;

			if (flag || flag1)
			{
				world.setBlock(posX, posY, posZ, getBlockById(0), 0, 2);
				world.setBlock(posX, posY - 1, posZ, getBlockById(0), 0, 2);
				world.setBlock(posX, posY - 2, posZ, getBlockById(0), 0, 2);

				if (flag)
				{
					world.setBlock(posX - 1, posY - 1, posZ, getBlockById(0), 0, 2);
					world.setBlock(posX + 1, posY - 1, posZ, getBlockById(0), 0, 2);
				} else
				{
					world.setBlock(posX, posY - 1, posZ - 1, getBlockById(0), 0, 2);
					world.setBlock(posX, posY - 1, posZ + 1, getBlockById(0), 0, 2);
				}

				EntityIronGolem entityirongolem = new EntityIronGolem(world);
				entityirongolem.setPlayerCreated(true);
				entityirongolem.setLocationAndAngles((double) posX + 0.5D, (double) posY - 1.95D, (double) posZ + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entityirongolem);

				for (int l = 0; l < 120; ++l)
				{
					world.spawnParticle("snowballpoof", (double) posX + world.rand.nextDouble(), (double) (posY - 2) + world.rand.nextDouble() * 3.9D, (double) posZ + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(posX, posY, posZ, getBlockById(0));
				world.notifyBlockChange(posX, posY - 1, posZ, getBlockById(0));
				world.notifyBlockChange(posX, posY - 2, posZ, getBlockById(0));

				if (flag)
				{
					world.notifyBlockChange(posX - 1, posY - 1, posZ, getBlockById(0));
					world.notifyBlockChange(posX + 1, posY - 1, posZ, getBlockById(0));
				} else
				{
					world.notifyBlockChange(posX, posY - 1, posZ - 1, getBlockById(0));
					world.notifyBlockChange(posX, posY - 1, posZ + 1, getBlockById(0));
				}
			}
		} else if (world.getBlock(posX, posY - 1, posZ) == Blocks.gold_block && world.getBlock(posX, posY - 2, posZ) == Blocks.gold_block)
		{
			boolean flag = world.getBlock(posX - 1, posY - 1, posZ) == Blocks.gold_block && world.getBlock(posX + 1, posY - 1, posZ) == Blocks.gold_block;
			boolean flag1 = world.getBlock(posX, posY - 1, posZ - 1) == Blocks.gold_block && world.getBlock(posX, posY - 1, posZ + 1) == Blocks.gold_block;

			if (flag || flag1)
			{
				world.setBlock(posX, posY, posZ, getBlockById(0), 0, 2);
				world.setBlock(posX, posY - 1, posZ, getBlockById(0), 0, 2);
				world.setBlock(posX, posY - 2, posZ, getBlockById(0), 0, 2);

				if (flag)
				{
					world.setBlock(posX - 1, posY - 1, posZ, getBlockById(0), 0, 2);
					world.setBlock(posX + 1, posY - 1, posZ, getBlockById(0), 0, 2);
				} else
				{
					world.setBlock(posX, posY - 1, posZ - 1, getBlockById(0), 0, 2);
					world.setBlock(posX, posY - 1, posZ + 1, getBlockById(0), 0, 2);
				}

				EntityGoldGolem entitygoldgolem = new EntityGoldGolem(world);
				entitygoldgolem.setPlayerCreated(true);
				entitygoldgolem.setLocationAndAngles((double) posX + 0.5D, (double) posY - 1.95D, (double) posZ + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entitygoldgolem);

				for (int l = 0; l < 120; ++l)
				{
					world.spawnParticle("snowballpoof", (double) posX + world.rand.nextDouble(), (double) (posY - 2) + world.rand.nextDouble() * 3.9D, (double) posZ + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(posX, posY, posZ, getBlockById(0));
				world.notifyBlockChange(posX, posY - 1, posZ, getBlockById(0));
				world.notifyBlockChange(posX, posY - 2, posZ, getBlockById(0));

				if (flag)
				{
					world.notifyBlockChange(posX - 1, posY - 1, posZ, getBlockById(0));
					world.notifyBlockChange(posX + 1, posY - 1, posZ, getBlockById(0));
				} else
				{
					world.notifyBlockChange(posX, posY - 1, posZ - 1, getBlockById(0));
					world.notifyBlockChange(posX, posY - 1, posZ + 1, getBlockById(0));
				}
			}
		} else if (world.getBlock(posX, posY - 1, posZ) == Blocks.diamond_block && world.getBlock(posX, posY - 2, posZ) == Blocks.diamond_block)
		{
			boolean flag = world.getBlock(posX - 1, posY - 1, posZ) == Blocks.diamond_block && world.getBlock(posX + 1, posY - 1, posZ) == Blocks.diamond_block;
			boolean flag1 = world.getBlock(posX, posY - 1, posZ - 1) == Blocks.diamond_block && world.getBlock(posX, posY - 1, posZ + 1) == Blocks.diamond_block;

			if (flag || flag1)
			{
				world.setBlock(posX, posY, posZ, getBlockById(0), 0, 2);
				world.setBlock(posX, posY - 1, posZ, getBlockById(0), 0, 2);
				world.setBlock(posX, posY - 2, posZ, getBlockById(0), 0, 2);

				if (flag)
				{
					world.setBlock(posX - 1, posY - 1, posZ, getBlockById(0), 0, 2);
					world.setBlock(posX + 1, posY - 1, posZ, getBlockById(0), 0, 2);
				} else
				{
					world.setBlock(posX, posY - 1, posZ - 1, getBlockById(0), 0, 2);
					world.setBlock(posX, posY - 1, posZ + 1, getBlockById(0), 0, 2);
				}

				EntityDiamondGolem entitydiamondgolem = new EntityDiamondGolem(world);
				entitydiamondgolem.setPlayerCreated(true);
				entitydiamondgolem.setLocationAndAngles((double) posX + 0.5D, (double) posY - 1.95D, (double) posZ + 0.5D, 0.0F, 0.0F);
				world.spawnEntityInWorld(entitydiamondgolem);

				for (int l = 0; l < 120; ++l)
				{
					world.spawnParticle("snowballpoof", (double) posX + world.rand.nextDouble(), (double) (posY - 2) + world.rand.nextDouble() * 3.9D, (double) posZ + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				world.notifyBlockChange(posX, posY, posZ, getBlockById(0));
				world.notifyBlockChange(posX, posY - 1, posZ, getBlockById(0));
				world.notifyBlockChange(posX, posY - 2, posZ, getBlockById(0));

				if (flag)
				{
					world.notifyBlockChange(posX - 1, posY - 1, posZ, getBlockById(0));
					world.notifyBlockChange(posX + 1, posY - 1, posZ, getBlockById(0));
				} else
				{
					world.notifyBlockChange(posX, posY - 1, posZ - 1, getBlockById(0));
					world.notifyBlockChange(posX, posY - 1, posZ + 1, getBlockById(0));
				}
			}
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
	{
		return p_149742_1_.getBlock(p_149742_2_, p_149742_3_, p_149742_4_).isReplaceable(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_);
	}

	/**
	 * Called when the block is placed in the world.
	 */
	public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
	{
		int l = MathHelper.floor_double((double) (p_149689_5_.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, l, 2);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.field_149986_M = p_149651_1_.registerIcon(this.getTextureName() + "_face_" + (this.field_149985_a ? "on" : "off"));
		this.field_149984_b = p_149651_1_.registerIcon(this.getTextureName() + "_top");
		this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
	}
}