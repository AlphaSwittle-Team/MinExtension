package mcmod.nxs.minextension.lib;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class ExplosiveBlockHelper extends Block {
	private int explosionRadius;

	public ExplosiveBlockHelper(Material material)
	{
		super(material);
	}

	public Block setBlockParameters(String name, float hardness, float resistance, SoundType sound, CreativeTabs tab, int explosionRadius)
	{
		this.setBlockName(name);
		this.setBlockTextureName(ResourcePathHelper.getResourcesPath() + name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setStepSound(sound);
		this.setCreativeTab(tab);
		this.explosionRadius = explosionRadius;
		return this;
	}

	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int p_149664_5_)
	{
		if (!world.isRemote)
		{
			world.createExplosion(new EntityTNTPrimed(world), i, j, k, explosionRadius, true);
		}
		super.onBlockDestroyedByPlayer(world, i, j, k, p_149664_5_);
	}

}
