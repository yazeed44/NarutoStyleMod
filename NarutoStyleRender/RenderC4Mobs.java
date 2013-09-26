package NarutoStyleRender;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import NarutoStyleEntitys.EntityC4Mobs;
import NarutoStyleEyeInventory.ExtendedPlayerProperties;
import NarutoStyleModels.ModelC4Mobs;

public class RenderC4Mobs extends RenderLiving {

	protected ModelC4Mobs model;
	private static final ResourceLocation textureLocation = new ResourceLocation("narutostyle:textures/models/mobs/C4Mobs.png");
	
	
	   public RenderC4Mobs(ModelBase par1ModelBase,float par2)
	   {
		   super(par1ModelBase,par2);
		   model = ((ModelC4Mobs)mainModel);
		   
	   }
	  
	   public void renderClaySpiderMob(EntityC4Mobs entity , double par2 , double par4,double par6 , float par8,float par9){
		   super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	   }
	   
	   public void doRenderLiving(EntityLiving par1EntityLiving,double par2,double par4,double par6,float par8,float par9)
	   {
		   renderClaySpiderMob((EntityC4Mobs)par1EntityLiving,par2,par4,par6,par8,par9);
	   }
	   @Override
	   public void doRender(Entity entity,double d0,double d1,double d2,float f,float f1)
	   {
		   renderClaySpiderMob((EntityC4Mobs)entity,d0,d1,d2,f,f1);
	   }
	   
	@Override
	protected ResourceLocation func_110775_a(Entity entity) {

	return textureLocation;
	}
}
