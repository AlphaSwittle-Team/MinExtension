package mcmod.nxs.minextension.lib;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHelper extends Block {
	public BlockHelper(Material material)
	{
		super(material);
	}

	public Block setBlockParameters(String name, float hardness, float resistance, SoundType sound, CreativeTabs tab)
	{
		this.setBlockName(name);
		this.setBlockTextureName(ResourcePathHelper.getResourcesPath() + name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setStepSound(sound);
		this.setCreativeTab(tab);
		return this;
	}
}
