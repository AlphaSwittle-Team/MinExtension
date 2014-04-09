package mcmod.nxs.minextension.item.armor;

import mcmod.nxs.minextension.MainClass;
import mcmod.nxs.minextension.core.ArmorHandler;
import mcmod.nxs.minextension.core.ItemHandler;
import mcmod.nxs.minextension.lib.ArmorHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class AmethystArmor extends ArmorHelper {

	public AmethystArmor(ArmorMaterial material, int type, int layer)
	{
		super(material, type, layer);
	}

	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem() == ItemHandler.amethyst_piece)
		{
			return true;
		}
		return false;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ArmorHandler.amethyst_leggings)
		{
			return MainClass.TEXTURES_PATH + "textures/models/armors/amethyst_2.png";
		} else
		{
			return MainClass.TEXTURES_PATH + "textures/models/armors/amethyst_1.png";
		}
	}
}
