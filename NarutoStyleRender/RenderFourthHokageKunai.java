package NarutoStyleRender;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import NarutoStyle.NarutoStyle_main;
import NarutoStyleEntitys.EntityFourthHokageKunai;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderFourthHokageKunai extends Render {
	private static final ResourceLocation field_110780_a = new ResourceLocation("narutostyle:textures/items/FourthHokageKunai.png");
	private Item field_94151_a;
	private int field_94150_f;
	private World worldObj;
	public RenderFourthHokageKunai(Item par1, int par2)
	{
	this.field_94151_a = par1;
	this.field_94150_f = par2;
	}
	public RenderFourthHokageKunai(Item par1)
	{
	this(par1, 0);
	}
	/**
	* Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	* handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	* (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	* double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	*/
	public void doRender(EntityFourthHokageKunai par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		 this.func_110777_b(par1Entity);
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
	        GL11.glRotatef(par1Entity.prevRotationYaw + (par1Entity.rotationYaw - par1Entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glRotatef(par1Entity.prevRotationPitch + (par1Entity.rotationPitch - par1Entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
	        Tessellator tessellator = Tessellator.instance;
	        byte b0 = 0;
	        float f2 = 0.0F;
	        float f3 = 0.5F;
	        float f4 = (float)(0 + b0 * 10) / 32.0F;
	        float f5 = (float)(5 + b0 * 10) / 32.0F;
	        float f6 = 0.0F;
	        float f7 = 0.15625F;
	        float f8 = (float)(5 + b0 * 10) / 32.0F;
	        float f9 = (float)(10 + b0 * 10) / 32.0F;
	        float f10 = 0.05625F;
	        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
	        

	        

	        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
	        GL11.glScalef(f10, f10, f10);
	        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
	        GL11.glNormal3f(f10, 0.0F, 0.0F);
	        tessellator.startDrawingQuads();
	        tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)f6, (double)f8);
	        tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)f7, (double)f8);
	        tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)f7, (double)f9);
	        tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)f6, (double)f9);
	        tessellator.draw();
	        GL11.glNormal3f(-f10, 0.0F, 0.0F);
	        tessellator.startDrawingQuads();
	        tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)f6, (double)f8);
	        tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)f7, (double)f8);
	        tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)f7, (double)f9);
	        tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)f6, (double)f9);
	        tessellator.draw();

	        for (int i = 0; i < 4; ++i)
	        {
	            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
	            GL11.glNormal3f(0.0F, 0.0F, f10);
	            tessellator.startDrawingQuads();
	            tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)f2, (double)f4);
	            tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)f3, (double)f4);
	            tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)f3, (double)f5);
	            tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)f2, (double)f5);
	            tessellator.draw();
	        }

	        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	        GL11.glPopMatrix();
	    }
	
	
	/*if (icon == ItemPotion.func_94589_d("potion_splash"))
	{
	int i = PotionHelper.func_77915_a(((EntityPotion)par1Entity).getPotionDamage(), false);
	float f2 = (float)(i >> 16 & 255) / 255.0F;
	float f3 = (float)(i >> 8 & 255) / 255.0F;
	float f4 = (float)(i & 255) / 255.0F;
	GL11.glColor3f(f2, f3, f4);
	GL11.glPushMatrix();
	this.func_77026_a(tessellator, ItemPotion.func_94589_d("potion_contents"));
	GL11.glPopMatrix();
	GL11.glColor3f(1.0F, 1.0F, 1.0F);
	}
	this.func_77026_a(tessellator, icon);
	GL11.glDisable(GL12.GL_RESCALE_NORMAL);
	GL11.glPopMatrix();
	}
	}*/

	
	/*private void func_77026_a(Tessellator par1Tessellator, Icon par2Icon)
	{
		
	float f = par2Icon.getMinU();
	float f1 = par2Icon.getMaxU();
	float f2 = par2Icon.getMinV();
	float f3 = par2Icon.getMaxV();
	float f4 = 1.0F;
	float f5 = 0.5F;
	float f6 = 0.25F;
	GL11.glRotatef(120.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	//GL11.glRotatef(kunai.prevRotationYaw + (kunai.rotationYaw - kunai.prevRotationYaw) - 90.0F, 0.0F, 1.0F, 0.0F);
	GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	par1Tessellator.startDrawingQuads();
	par1Tessellator.setNormal(0.0F, 1.0F, 0.0F);
	par1Tessellator.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f, (double)f3);
	par1Tessellator.addVertexWithUV((double)(f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
	par1Tessellator.addVertexWithUV((double)(f4 - f5), (double)(f4 - f6), 0.0D, (double)f1, (double)f2);
	par1Tessellator.addVertexWithUV((double)(0.0F - f5), (double)(f4 - f6), 0.0D, (double)f, (double)f2);
	par1Tessellator.draw();
	//float f9 = (float)(10 + 0 * 10) / 32.0F;
	}*/
	protected ResourceLocation func_110775_a(EntityFourthHokageKunai par1Entity)
    {
        return field_110780_a;
    }
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,
			float f, float f1) {
		this.doRender((EntityFourthHokageKunai)entity, d0, d1, d2, f, f1);
		
	}
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		
		return this.func_110775_a((EntityFourthHokageKunai)entity);
	}
}
