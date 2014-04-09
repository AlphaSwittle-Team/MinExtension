package mcmod.nxs.minextension.render;

import java.util.Random;

import mcmod.nxs.minextension.MainClass;
import mcmod.nxs.minextension.entity.hostile.EntityNetherman;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNetherman extends RenderLiving {
	private static final ResourceLocation endermanEyesTexture = new ResourceLocation("textures/entity/enderman/enderman_eyes.png");
	private static final ResourceLocation endermanTextures = new ResourceLocation(MainClass.TEXTURES_PATH + "textures/entity/netherman.png");
	/**
	 * The model of the enderman
	 */
	private ModelEnderman endermanModel;
	private Random rnd = new Random();
	private static final String __OBFID = "CL_00000989";

	public RenderNetherman()
	{
		super(new ModelEnderman(), 0.5F);
		this.endermanModel = (ModelEnderman) super.mainModel;
		this.setRenderPassModel(this.endermanModel);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(EntityNetherman par1EntityNetherman, double par2, double par4, double par6, float par8, float par9)
	{
		this.endermanModel.isCarrying = par1EntityNetherman.func_146080_bZ().getMaterial() != Material.air;
		this.endermanModel.isAttacking = par1EntityNetherman.isScreaming();

		if (par1EntityNetherman.isScreaming())
		{
			double d3 = 0.02D;
			par2 += this.rnd.nextGaussian() * d3;
			par6 += this.rnd.nextGaussian() * d3;
		}

		super.doRender((EntityLiving) par1EntityNetherman, par2, par4, par6, par8, par9);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityNetherman par1EntityNetherman)
	{
		return endermanTextures;
	}

	protected void renderEquippedItems(EntityNetherman par1EntityNetherman, float par2)
	{
		super.renderEquippedItems(par1EntityNetherman, par2);

		if (par1EntityNetherman.func_146080_bZ().getMaterial() != Material.air)
		{
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glPushMatrix();
			float f1 = 0.5F;
			GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
			f1 *= 1.0F;
			GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(-f1, -f1, f1);
			int i = par1EntityNetherman.getBrightnessForRender(par2);
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.bindTexture(TextureMap.locationBlocksTexture);
			this.field_147909_c.renderBlockAsItem(par1EntityNetherman.func_146080_bZ(), par1EntityNetherman.getCarryingData(), 1.0F);
			GL11.glPopMatrix();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityNetherman par1EntityNetherman, int par2, float par3)
	{
		if (par2 != 0)
		{
			return -1;
		} else
		{
			this.bindTexture(endermanEyesTexture);
			float f1 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GL11.glDisable(GL11.GL_LIGHTING);

			if (par1EntityNetherman.isInvisible())
			{
				GL11.glDepthMask(false);
			} else
			{
				GL11.glDepthMask(true);
			}

			char c0 = 61680;
			int j = c0 % 65536;
			int k = c0 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j / 1.0F, (float) k / 1.0F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
			return 1;
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
		this.doRender((EntityNetherman) par1EntityLiving, par2, par4, par6, par8, par9);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	{
		return this.shouldRenderPass((EntityNetherman) par1EntityLivingBase, par2, par3);
	}

	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.renderEquippedItems((EntityNetherman) par1EntityLivingBase, par2);
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
		this.doRender((EntityNetherman) par1Entity, par2, par4, par6, par8, par9);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called
	 * unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return this.getEntityTexture((EntityNetherman) par1Entity);
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
		this.doRender((EntityNetherman) par1Entity, par2, par4, par6, par8, par9);
	}
}