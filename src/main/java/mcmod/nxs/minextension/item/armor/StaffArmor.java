package mcmod.nxs.minextension.item.armor;

import mcmod.nxs.minextension.MainClass;
import mcmod.nxs.minextension.core.ArmorHandler;
import mcmod.nxs.minextension.lib.ArmorHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class StaffArmor extends ArmorHelper {
	public StaffArmor(ArmorMaterial material, int type, int layer)
	{
		super(material, type, layer);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ArmorHandler.staff_leggings)
		{
			return MainClass.TEXTURES_PATH + "textures/models/armors/staff_2.png";
		} else
		{
			return MainClass.TEXTURES_PATH + "textures/models/armors/staff_1.png";
		}
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (!player.capabilities.isCreativeMode)
		{
			if (this.armorType == 0)
			{
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 1));
			} else if (this.armorType == 1)
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 20, 1));
			} else if (this.armorType == 2)
			{
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 1));
			} else if (this.armorType == 3)
			{
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 20, 1));
			}
		}
	}
}
