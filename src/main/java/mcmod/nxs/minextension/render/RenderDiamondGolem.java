package mcmod.nxs.minextension.render;

import mcmod.nxs.minextension.entity.passive.EntityDiamondGolem;
import mcmod.nxs.minextension.lib.ResourcePathHelper;
import mcmod.nxs.minextension.model.ModelDiamondGolem;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDiamondGolem extends RenderLiving {
	private static final ResourceLocation ironGolemTextures = new ResourceLocation(ResourcePathHelper.getResourcesPath() + "textures/entity/diamond_golem.png");
	/**
	 * Iron Golem's Model.
	 */
	private final ModelDiamondGolem ironGolemModel;
	private static final String __OBFID = "CL_00001031";

	public RenderDiamondGolem()
	{
		super(new ModelDiamondGolem(), 0.5F);
		this.ironGolemModel = (ModelDiamondGolem) this.mainModel;
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityDiamondGolem par1EntityDiamondGolem, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender((EntityLiving) par1EntityDiamondGolem, par2, par4, par6, par8, par9);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityDiamondGolem par1EntityDiamondGolem)
	{
		return ironGolemTextures;
	}

	protected void rotateCorpse(EntityDiamondGolem par1EntityDiamondGolem, float par2, float par3, float par4)
	{
		super.rotateCorpse(par1EntityDiamondGolem, par2, par3, par4);

		if ((double) par1EntityDiamondGolem.limbSwingAmount >= 0.01D)
		{
			float f3 = 13.0F;
			float f4 = par1EntityDiamondGolem.limbSwing - par1EntityDiamondGolem.limbSwingAmount * (1.0F - par4) + 6.0F;
			float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
			GL11.glRotatef(6.5F * f5, 0.0F, 0.0F, 1.0F);
		}
	}

	protected void renderEquippedItems(EntityDiamondGolem par1EntityDiamondGolem, float par2)
	{
		super.renderEquippedItems(par1EntityDiamondGolem, par2);

		if (par1EntityDiamondGolem.getHoldRoseTick() != 0)
		{
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glPushMatrix();
			GL11.glRotatef(5.0F + 180.0F * this.ironGolemModel.ironGolemRightArm.rotateAngleX / (float) Math.PI, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(-0.6875F, 1.25F, -0.9375F);
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			float f1 = 0.8F;
			GL11.glScalef(f1, -f1, f1);
			int i = par1EntityDiamondGolem.getBrightnessForRender(par2);
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.bindTexture(TextureMap.locationBlocksTexture);
			this.field_147909_c.renderBlockAsItem(Blocks.red_flower, 0, 1.0F);
			GL11.glPopMatrix();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((EntityDiamondGolem) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.renderEquippedItems((EntityDiamondGolem) par1EntityLivingBase, par2);
	}

	protected void rotateCorpse(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
	{
		this.rotateCorpse((EntityDiamondGolem) par1EntityLivingBase, par2, par3, par4);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityLivingBase par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((EntityDiamondGolem) par1Entity, par2, par4, par6, par8, par9);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityDiamondGolem) par1Entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((EntityDiamondGolem) par1Entity, par2, par4, par6, par8, par9);
	}
}