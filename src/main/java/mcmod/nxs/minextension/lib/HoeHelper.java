package mcmod.nxs.minextension.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class HoeHelper extends ItemHoe {
	private Item material;

	public HoeHelper(ToolMaterial p_i45356_1_)
	{
		super(p_i45356_1_);
	}

	public ItemHoe setNameAndTab(String name, CreativeTabs tab, Item material)
	{
		this.setTextureName(ResourcePathHelper.getResourcesPath() + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
		this.material = material;
		return this;
	}

	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem() == material)
		{
			return true;
		}
		return false;
	}
}