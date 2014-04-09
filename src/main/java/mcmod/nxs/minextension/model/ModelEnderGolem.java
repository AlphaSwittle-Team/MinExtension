package mcmod.nxs.minextension.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnderGolem extends ModelBase {
	// fields
	ModelRenderer HeadF3;
	ModelRenderer Forehead;
	ModelRenderer HeadF1;
	ModelRenderer Jaw;
	ModelRenderer Crown_1;
	ModelRenderer Crown_2;
	ModelRenderer HeadB;
	ModelRenderer Body;
	ModelRenderer LShoulder;
	ModelRenderer LArm_1;
	ModelRenderer LArm_2;
	ModelRenderer RShoulder;
	ModelRenderer RArm_1;
	ModelRenderer RArm_2;
	ModelRenderer RBodyR;
	ModelRenderer LBodyL;
	ModelRenderer Crystal;
	ModelRenderer Ring_1;
	ModelRenderer Ring_2;
	ModelRenderer Ring_3;
	ModelRenderer HeadF4;
	ModelRenderer HeadF2;

	public ModelEnderGolem()
	{
		textureWidth = 512;
		textureHeight = 512;

		HeadF3 = new ModelRenderer(this, 50, 50);
		HeadF3.addBox(-4F, -8F, -4F, 4, 2, 1);
		HeadF3.setRotationPoint(2F, -30F, -1F);
		HeadF3.setTextureSize(512, 512);
		HeadF3.mirror = true;
		setRotation(HeadF3, 0F, 0F, 0F);
		Forehead = new ModelRenderer(this, 50, 100);
		Forehead.addBox(-4F, -8F, -4F, 10, 2, 10);
		Forehead.setRotationPoint(-1F, -32F, -1F);
		Forehead.setTextureSize(512, 512);
		Forehead.mirror = true;
		setRotation(Forehead, 0F, 0F, 0F);
		HeadF1 = new ModelRenderer(this, 50, 150);
		HeadF1.addBox(-4F, -8F, -4F, 10, 6, 1);
		HeadF1.setRotationPoint(-1F, -28F, -1F);
		HeadF1.setTextureSize(512, 512);
		HeadF1.mirror = true;
		setRotation(HeadF1, 0F, 0F, 0F);
		Jaw = new ModelRenderer(this, 50, 200);
		Jaw.addBox(-4F, -8F, -4F, 11, 4, 11);
		Jaw.setRotationPoint(-1.5F, -26F, -2F);
		Jaw.setTextureSize(512, 512);
		Jaw.mirror = true;
		setRotation(Jaw, 0F, 0F, 0F);
		Crown_1 = new ModelRenderer(this, 50, 250);
		Crown_1.addBox(-4F, -8F, -4F, 10, 4, 7);
		Crown_1.setRotationPoint(-1F, -34.5F, 2.1F);
		Crown_1.setTextureSize(512, 512);
		Crown_1.mirror = true;
		setRotation(Crown_1, 0.454F, 0F, 0F);
		Crown_2 = new ModelRenderer(this, 50, 300);
		Crown_2.addBox(-4F, -8F, -4F, 10, 4, 4);
		Crown_2.setRotationPoint(-1F, -35F, 5F);
		Crown_2.setTextureSize(512, 512);
		Crown_2.mirror = true;
		setRotation(Crown_2, 0F, 0F, 0F);
		HeadB = new ModelRenderer(this, 50, 350);
		HeadB.addBox(-4F, -8F, -4F, 10, 8, 9);
		HeadB.setRotationPoint(-1F, -30F, 0F);
		HeadB.setTextureSize(512, 512);
		HeadB.mirror = true;
		setRotation(HeadB, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 50, 400);
		Body.addBox(-4F, 0F, -2F, 28, 13, 13);
		Body.setRotationPoint(-10F, -30F, -5F);
		Body.setTextureSize(512, 512);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		LShoulder = new ModelRenderer(this, 100, 50);
		LShoulder.addBox(-1F, -2F, -2F, 12, 12, 14);
		LShoulder.setRotationPoint(13F, -30F, -5.5F);
		LShoulder.setTextureSize(512, 512);
		LShoulder.mirror = true;
		setRotation(LShoulder, 0F, 0F, 0F);
		LArm_1 = new ModelRenderer(this, 100, 100);
		LArm_1.addBox(-1F, -2F, -2F, 8, 13, 8);
		LArm_1.setRotationPoint(16F, -19F, -2.5F);
		LArm_1.setTextureSize(512, 512);
		LArm_1.mirror = true;
		setRotation(LArm_1, 0F, 0F, 0F);
		LArm_2 = new ModelRenderer(this, 100, 150);
		LArm_2.addBox(-1F, -2F, -2F, 8, 13, 8);
		LArm_2.setRotationPoint(16F, -6F, -2.5F);
		LArm_2.setTextureSize(512, 512);
		LArm_2.mirror = true;
		setRotation(LArm_2, 0F, 0F, 0F);
		RShoulder = new ModelRenderer(this, 100, 250);
		RShoulder.addBox(-1F, -2F, -2F, 12, 12, 14);
		RShoulder.setRotationPoint(-23F, -30F, -5.5F);
		RShoulder.setTextureSize(512, 512);
		RShoulder.mirror = true;
		setRotation(RShoulder, 0F, 0F, 0F);
		RArm_1 = new ModelRenderer(this, 100, 300);
		RArm_1.addBox(-1F, -2F, -2F, 8, 13, 8);
		RArm_1.setRotationPoint(-22F, -19F, -2.5F);
		RArm_1.setTextureSize(512, 512);
		RArm_1.mirror = true;
		setRotation(RArm_1, 0F, 0F, 0F);
		RArm_2 = new ModelRenderer(this, 100, 350);
		RArm_2.addBox(-1F, -12F, -2F, 8, 13, 8);
		RArm_2.setRotationPoint(-22F, 4F, -2.5F);
		RArm_2.setTextureSize(512, 512);
		RArm_2.mirror = true;
		setRotation(RArm_2, 0F, 0F, 0F);
		RBodyR = new ModelRenderer(this, 100, 20);
		RBodyR.addBox(-2F, 0F, -2F, 11, 11, 11);
		RBodyR.setRotationPoint(-4F, -23.5F, -4F);
		RBodyR.setTextureSize(512, 512);
		RBodyR.mirror = true;
		setRotation(RBodyR, 0F, 0F, 0.785F);
		LBodyL = new ModelRenderer(this, 150, 200);
		LBodyL.addBox(-2F, 0F, -2F, 11, 11, 11);
		LBodyL.setRotationPoint(7F, -23.5F, -4F);
		LBodyL.setTextureSize(512, 512);
		LBodyL.mirror = true;
		setRotation(LBodyL, 0F, 0F, 0.785F);
		Crystal = new ModelRenderer(this, 150, 150);
		Crystal.addBox(0F, 0F, 0F, 5, 5, 5);
		Crystal.setRotationPoint(-3F, -10F, -3F);
		Crystal.setTextureSize(512, 512);
		Crystal.mirror = true;
		setRotation(Crystal, 0.785F, 0.436F, 0.611F);
		Ring_1 = new ModelRenderer(this, 150, 300);
		Ring_1.addBox(0F, 0F, 0F, 13, 0, 13);
		Ring_1.setRotationPoint(-5.5F, -2F, -7F);
		Ring_1.setTextureSize(512, 512);
		Ring_1.mirror = true;
		setRotation(Ring_1, 0F, 0F, 0F);
		Ring_2 = new ModelRenderer(this, 150, 350);
		Ring_2.addBox(0F, 0F, 0F, 10, 0, 10);
		Ring_2.setRotationPoint(-4F, 2F, -5F);
		Ring_2.setTextureSize(512, 512);
		Ring_2.mirror = true;
		setRotation(Ring_2, 0F, 0F, 0F);
		Ring_3 = new ModelRenderer(this, 50, 20);
		Ring_3.addBox(0F, 0F, 0F, 7, 0, 7);
		Ring_3.setRotationPoint(-2.5F, 6F, -3F);
		Ring_3.setTextureSize(512, 512);
		Ring_3.mirror = true;
		setRotation(Ring_3, 0F, 0F, 0F);
		HeadF4 = new ModelRenderer(this, 170, 50);
		HeadF4.addBox(-4F, -8F, -4F, 1, 2, 1);
		HeadF4.setRotationPoint(8F, -30F, -1F);
		HeadF4.setTextureSize(512, 512);
		HeadF4.mirror = true;
		setRotation(HeadF4, 0F, 0F, 0F);
		HeadF2 = new ModelRenderer(this, 165, 70);
		HeadF2.addBox(-4F, -8F, -5F, 1, 2, 1);
		HeadF2.setRotationPoint(-1F, -30F, 0F);
		HeadF2.setTextureSize(512, 512);
		HeadF2.mirror = true;
		setRotation(HeadF2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		HeadF3.render(f5);
		Forehead.render(f5);
		HeadF1.render(f5);
		Jaw.render(f5);
		Crown_1.render(f5);
		Crown_2.render(f5);
		HeadB.render(f5);
		Body.render(f5);
		LShoulder.render(f5);
		LArm_1.render(f5);
		LArm_2.render(f5);
		RShoulder.render(f5);
		RArm_1.render(f5);
		RArm_2.render(f5);
		RBodyR.render(f5);
		LBodyL.render(f5);
		Crystal.render(f5);
		Ring_1.render(f5);
		Ring_2.render(f5);
		Ring_3.render(f5);
		HeadF4.render(f5);
		HeadF2.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
