package mcmod.nxs.minextension.event;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SpawnEvent {
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entityLiving instanceof EntityChicken)
		{
			event.entityLiving.setDead();
		}
	}
}
