package mcmod.nxs.minextension.block;

import java.util.Random;

import mcmod.nxs.minextension.lib.BlockHelper;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class FossilOre extends BlockHelper {
	public FossilOre(Material material)
	{
		super(material);
	}

	public int quantityDropped(Random rand)
	{
		return 3 + rand.nextInt(5);
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Items.bone;
	}
}
