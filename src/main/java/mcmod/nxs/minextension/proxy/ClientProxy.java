package mcmod.nxs.minextension.proxy;

import mcmod.nxs.minextension.entity.hostile.EntityEnderCreeper;
import mcmod.nxs.minextension.entity.hostile.EntityEnderGolem;
import mcmod.nxs.minextension.entity.hostile.EntityNetherCreeper;
import mcmod.nxs.minextension.entity.hostile.EntityNetherSpider;
import mcmod.nxs.minextension.entity.hostile.EntityNetherman;
import mcmod.nxs.minextension.entity.passive.EntityArcher;
import mcmod.nxs.minextension.entity.passive.EntityDiamondGolem;
import mcmod.nxs.minextension.entity.passive.EntityGoldGolem;
import mcmod.nxs.minextension.entity.passive.EntityShield;
import mcmod.nxs.minextension.entity.passive.EntityWarrior;
import mcmod.nxs.minextension.render.RenderArcher;
import mcmod.nxs.minextension.render.RenderDiamondGolem;
import mcmod.nxs.minextension.render.RenderEnderCreeper;
import mcmod.nxs.minextension.render.RenderEnderGolem;
import mcmod.nxs.minextension.render.RenderGoldGolem;
import mcmod.nxs.minextension.render.RenderNetherCreeper;
import mcmod.nxs.minextension.render.RenderNetherSpider;
import mcmod.nxs.minextension.render.RenderNetherman;
import mcmod.nxs.minextension.render.RenderShield;
import mcmod.nxs.minextension.render.RenderWarrior;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEntityRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityWarrior.class, new RenderWarrior());
		RenderingRegistry.registerEntityRenderingHandler(EntityShield.class, new RenderShield());
		RenderingRegistry.registerEntityRenderingHandler(EntityArcher.class, new RenderArcher());
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherSpider.class, new RenderNetherSpider());
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherCreeper.class, new RenderNetherCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityNetherman.class, new RenderNetherman());
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderCreeper.class, new RenderEnderCreeper());
		RenderingRegistry.registerEntityRenderingHandler(EntityEnderGolem.class, new RenderEnderGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldGolem.class, new RenderGoldGolem());
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondGolem.class, new RenderDiamondGolem());
	}

	@Override
	public void registerItemRender()
	{
	}
}
