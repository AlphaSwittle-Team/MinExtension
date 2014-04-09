package mcmod.nxs.minextension.render;

import mcmod.nxs.minextension.MainClass;
import mcmod.nxs.minextension.entity.hostile.EntityEnderGolem;
import mcmod.nxs.minextension.model.ModelEnderGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEnderGolem extends RenderLiving {

	private static final ResourceLocation textures = new ResourceLocation(MainClass.TEXTURES_PATH + "textures/entity/ender_golem.png");

	public RenderEnderGolem()
	{
		super(new ModelEnderGolem(), 0.5F);
	}

	protected ResourceLocation getEnderGuardianTexture(EntityEnderGolem anizob)
	{
		return textures;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEnderGuardianTexture((EntityEnderGolem) par1Entity);
	}
}