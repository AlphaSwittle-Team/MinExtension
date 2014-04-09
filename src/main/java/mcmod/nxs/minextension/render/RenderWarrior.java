package mcmod.nxs.minextension.render;

import mcmod.nxs.minextension.entity.passive.EntityWarrior;
import mcmod.nxs.minextension.lib.ResourcePathHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWarrior extends RenderBiped {

	public RenderWarrior()
	{
		super(new ModelBiped(), 0.5F);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityWarrior warrior)
	{
		return new ResourceLocation(ResourcePathHelper.getResourcesPath() + "textures/entity/warrior_" + warrior.texture + ".png");
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityWarrior) par1Entity);
	}
}