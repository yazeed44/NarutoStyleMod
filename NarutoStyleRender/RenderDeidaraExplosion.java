package NarutoStyleRender;

import NarutoStyleEntitys.EntityDeidara;
import NarutoStyleEntitys.EntityDeidaraExplosion;

import NarutoStyleModels.ModelNarutoStyle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDeidaraExplosion extends RenderLiving {

	protected ModelNarutoStyle model;
	private static final ResourceLocation textureLocation = new ResourceLocation("narutostyle:textures/models/mobs/DeidaraExplosion.png");
	
	   public RenderDeidaraExplosion(ModelBase par1ModelBase,float par2)
	   {
		   super(par1ModelBase,par2);
		   model = ((ModelNarutoStyle)mainModel);
		   
	   }
	   
	   public void renderDeidaraExplosion(EntityDeidaraExplosion entity , double par2 , double par4,double par6 , float par8,float par9){
		   super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	   }
	   
	   public void doRenderLiving(EntityLiving par1EntityLiving,double par2,double par4,double par6,float par8,float par9)
	   {
		   renderDeidaraExplosion((EntityDeidaraExplosion)par1EntityLiving,par2,par4,par6,par8,par9);
	   }
	   @Override
	   public void doRender(Entity entity,double d0,double d1,double d2,float f,float f1)
	   {
		   renderDeidaraExplosion((EntityDeidaraExplosion)entity,d0,d1,d2,f,f1);
	   }
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {

	return textureLocation;
	}
}
