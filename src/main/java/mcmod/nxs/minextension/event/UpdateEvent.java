package mcmod.nxs.minextension.event;

import mcmod.nxs.minextension.core.ToolHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class UpdateEvent {
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			ItemStack heldItem = event.entityLiving.getHeldItem();
			if (heldItem != null && heldItem.getItem() == ToolHandler.staff_sword)
			{
				event.entityLiving.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20, 1));
			}
		}
	}
}
