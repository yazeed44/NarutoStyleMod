package NarutoStyleModels;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class DeidaraHandTest extends ModelBase
{
	  //fields
    ModelRenderer يد;
    ModelRenderer Shape1;
  
  public DeidaraHandTest()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      يد = new ModelRenderer(this, 0, 0);
      يد.addBox(0F, 0F, 0F, 4, 4, 12);
      يد.setRotationPoint(-4F, 0F, -4F);
      يد.setTextureSize(64, 32);
      يد.mirror = true;
      setRotation(يد, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 32, 0);
      Shape1.addBox(0F, 0F, 0F, 2, 3, 1);
      Shape1.setRotationPoint(-3F, 1F, -4F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -1.03119F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    يد.render(f5);
    Shape1.render(f5);
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


