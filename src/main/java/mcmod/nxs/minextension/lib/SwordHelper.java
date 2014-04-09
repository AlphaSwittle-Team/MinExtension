package mcmod.nxs.minextension.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class SwordHelper extends ItemSword {
	private Item material;

	public SwordHelper(ToolMaterial p_i45356_1_)
	{
		super(p_i45356_1_);
	}

	public ItemSword setNameAndTab(String name, CreativeTabs tab, Item material)
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