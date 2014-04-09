package mcmod.nxs.minextension.render;

import mcmod.nxs.minextension.entity.passive.EntityShield;
import mcmod.nxs.minextension.lib.ResourcePathHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShield extends RenderBiped {
	private static final ResourceLocation warriorTextures = new ResourceLocation(ResourcePathHelper.getResourcesPath() + "textures/entity/warrior_shield.png");

	public RenderShield()
	{
		super(new ModelBiped(), 0.5F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityShield warrior)
	{
		return warriorTextures;
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityShield) par1Entity);
	}
}