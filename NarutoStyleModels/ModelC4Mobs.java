package NarutoStyleModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelC4Mobs extends ModelBase{

	//fields
    ModelRenderer head;
    ModelRenderer Leg7;
    ModelRenderer Leg5;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg1;
    ModelRenderer Leg4;
  
  public ModelC4Mobs()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3F, -3F, -3F, 4, 4, 4);
      head.setRotationPoint(0F, 21F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      Leg7 = new ModelRenderer(this, 18, 0);
      Leg7.addBox(0F, 0F, 1F, 5, 1, 0);
      Leg7.setRotationPoint(-1F, 20F, -3F);
      Leg7.setTextureSize(64, 32);
      Leg7.mirror = true;
      setRotation(Leg7, -0.0371786F, 0.2906128F, 0.1487144F);
      Leg5 = new ModelRenderer(this, 18, 0);
      Leg5.addBox(0F, 0F, 0F, 5, 1, 0);
      Leg5.setRotationPoint(0F, 20F, -1F);
      Leg5.setTextureSize(64, 32);
      Leg5.mirror = true;
      setRotation(Leg5, 0F, 0.0546319F, 0.1487144F);
      Leg2 = new ModelRenderer(this, 18, 0);
      Leg2.addBox(-2F, 0F, -2F, 5, 1, 0);
      Leg2.setRotationPoint(1F, 20F, 2F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0.179077F, -0.2951569F, 0.2625223F);
      Leg3 = new ModelRenderer(this, 18, 0);
      Leg3.addBox(0F, 1F, 0F, 5, 1, 0);
      Leg3.setRotationPoint(-2F, 19F, -1.5F);
      Leg3.setTextureSize(64, 32);
      Leg3.mirror = true;
      setRotation(Leg3, 0.179077F, 2.924717F, 0.2056184F);
      Leg1 = new ModelRenderer(this, 18, 0);
      Leg1.addBox(2F, 0F, 0F, 5, 1, 0);
      Leg1.setRotationPoint(0F, 20F, -1F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, -0.0068161F, 3.11061F, 0.2056184F);
      Leg4 = new ModelRenderer(this, 18, 0);
      Leg4.addBox(0F, 0F, 0F, 4, 1, 0);
      Leg4.setRotationPoint(-3F, 20F, 0.5F);
      Leg4.setTextureSize(64, 32);
      Leg4.mirror = true;
      setRotation(Leg4, -0.0068161F, 3.141593F, 0.2056184F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    head.render(f5);
    Leg7.render(f5);
    Leg5.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg1.render(f5);
    Leg4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }
}
