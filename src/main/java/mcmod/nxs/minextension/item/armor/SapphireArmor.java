package mcmod.nxs.minextension.item.armor;

import mcmod.nxs.minextension.MainClass;
import mcmod.nxs.minextension.core.ArmorHandler;
import mcmod.nxs.minextension.core.ItemHandler;
import mcmod.nxs.minextension.lib.ArmorHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class SapphireArmor extends ArmorHelper {
	public SapphireArmor(ArmorMaterial material, int type, int layer)
	{
		super(material, type, layer);
	}

	public boolean getIsRepairable(ItemStack input, ItemStack repair)
	{
		if (repair.getItem() == ItemHandler.sapphire_nugget)
		{
			return true;
		}
		return false;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ArmorHandler.sapphire_leggings)
		{
			return MainClass.TEXTURES_PATH + "textures/models/armors/sapphire_2.png";
		} else
		{
			return MainClass.TEXTURES_PATH + "textures/models/armors/sapphire_1.png";
		}
	}
}
