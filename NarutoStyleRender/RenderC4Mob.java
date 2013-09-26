package NarutoStyleRender;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import NarutoStyleEntitys.EntityC4Mob;
import NarutoStyleModels.ModelNarutoStyle;

public class RenderC4Mob extends RenderLiving {

	private ModelNarutoStyle model;
    private static final ResourceLocation field_110871_a = new ResourceLocation("narutostyle:textures/models/mobs/Deidara.png");

    /** Scale of the model to use */
    private float scale;

    public RenderC4Mob(ModelBase par1ModelBase, float par2, float par3)
    {
        super(par1ModelBase, par2 * par3);
        this.scale = par3;
    }

    /*public RenderC4Mob(ModelBase par1ModelBase,float par2)
	   {
		   super(par1ModelBase,par2);
		   model = ((ModelNarutoStyle)mainModel);
	   }*/

	/**
     * Applies the scale to the transform matrix
     */
    protected void preRenderScale(EntityC4Mob par1EntityGiantZombie, float par2)
    {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected ResourceLocation func_110870_a(EntityC4Mob par1EntityGiantZombie)
    {
        return field_110871_a;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderScale((EntityC4Mob)par1EntityLivingBase, par2);
    }

    protected ResourceLocation func_110775_a(Entity par1Entity)
    {
        return this.func_110870_a((EntityC4Mob)par1Entity);
    }
}
