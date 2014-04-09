package mcmod.nxs.minextension.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

public class ArmorHelper extends ItemArmor {
	public ArmorHelper(ArmorMaterial material, int type, int layer)
	{
		super(material, type, layer);
	}

	public ItemArmor setNameAndTab(String name, CreativeTabs tab)
	{
		this.setTextureName(ResourcePathHelper.getResourcesPath() + name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
		return this;
	}
}
