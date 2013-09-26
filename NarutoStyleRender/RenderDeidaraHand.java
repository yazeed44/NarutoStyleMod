package NarutoStyleRender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import NarutoStyle.NarutoStyle_main;
import NarutoStyleItems.DeidaraHand;
import NarutoStyleModels.DeidaraHandTest;

public class RenderDeidaraHand   implements IItemRenderer {
	private DeidaraHandTest modelDeidara;
	 public RenderDeidaraHand(){
		 modelDeidara = new DeidaraHandTest();
	}
	
	 /**
     * Forge checks this to see if our custom renderer will handle a certain type of rendering.
     * <p/>
     * type can be:
     * <p/>
     * ENTITY - When the item is floating in the world, e.g. after being tossed or dropped by a mob.
     * <p/>
     * INVENTORY - Drawing it on an inventory slot.
     * <p/>
     * EQUIPPED - Rendering the item in an entity's hand e.g. endermen.
     * <p/>
     * FIRST_PERSON_MAP - Drawing it in the viewing player's hand
     */
	 @Override
	 public boolean handleRenderType(ItemStack item, ItemRenderType type) {
	  switch(type)
	  {
	  case  EQUIPPED: 
	   if(item.getItem().equals(Item.dyePowder) && item.getItemDamage() != 4)
	    return false;
	   else
	    return true;
	  case  EQUIPPED_FIRST_PERSON: 
	   if(item.getItem().equals(Item.dyePowder) && item.getItemDamage() != 4)
	    return false;
	   else
	    return true;
	  case ENTITY:
	   if(item.getItem().equals(Item.dyePowder) && item.getItemDamage() != 4)
	    return true;
	   else
	    return true;
	  default: 
	   return false;}
    }

    
	 @Override
	    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
	        return type == ItemRenderType.ENTITY;
	    }
    /**
     * Called to actually render the item. type is as above, item is the item to render, and data is some extra data depending on the type.
     */
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

    	switch (type) {
        case ENTITY:
            RenderBlocks renderEntity = (RenderBlocks) data[0];
            EntityItem entityEntity = (EntityItem) data[1];
           

            
            break;}
        /*case INVENTORY:
            RenderBlocks renderInventory = (RenderBlocks) data[0];
            MuseRenderer.drawIconAt(0, 0, ModularPowersuits.powerTool.getIconIndex(itemStack), colour);
            break;
        case EQUIPPED:
            RenderBlocks renderEquipped = (RenderBlocks) data[0];
            EntityLivingBase entityEquipped = (EntityLivingBase) data[1];

            if (entityEquipped instanceof EntityPlayer) {
                model.setPoseForPlayer((EntityPlayer) entityEquipped, itemStack);
            } else {
                model.setNeutralPose();
            }

            model.render(entityEquipped, 1, false, colour, glow);
            break;
        case FIRST_PERSON_MAP:
            EntityPlayer playerFirstPerson = (EntityPlayer) data[0];
            TextureManager engineFirstPerson = (TextureManager) data[1];
            MapData mapDataFirstPerson = (MapData) data[2];
            model.setPoseForPlayer(playerFirstPerson, itemStack);

            model.render(playerFirstPerson, 1, true, colour, glow);
            break;
        case EQUIPPED_FIRST_PERSON:
            RenderBlocks renderEquFP = (RenderBlocks) data[0];
            EntityLivingBase entityEquFP = (EntityLivingBase) data[1];
            if (entityEquFP instanceof EntityPlayer) {
                model.setPoseForPlayer((EntityPlayer) entityEquFP, itemStack);
            } else {
                model.setNeutralPose();
            }

            model.render(entityEquFP, 1, true, colour, glow);
            break;
        default:
    }*/
}

    

    /**
     * Whether or not to use the RenderHelper for this item. Helper can be:
     * <p/>
     * ENTITY_ROTATION - Isometric rotation, for block items
     * <p/>
     * ENTITY_BOBBING - Up-and-down bobbing effect for EntityItem
     * <p/>
     * EQUIPPED_BLOCK - Determines if the currently equipped item should be rendered as a 3D block or as a 2D texture.
     * <p/>
     * BLOCK_3D - Determines if the item should equate to a block that has RenderBlocks.renderItemIn3d return true
     * <p/>
     * INVENTORY_BLOCK - Determines if the item should be rendered in GUI inventory slots as a 3D block or as a 2D texture.
     */
   

    /*@Override
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {

    }*/

    public void renderFirstPersonArm(EntityClientPlayerMP entityclientplayermp, float par1) {
        Minecraft mc = Minecraft.getMinecraft();
        float changeItemProgress = 0;

        GL11.glPushMatrix();
        float f4 = 0.8F;
        float swingProgress = entityclientplayermp.getSwingProgress(par1);
        float swingProgressx = MathHelper.sin(swingProgress * (float) Math.PI);
        float swingProgressy = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float) Math.PI);
        GL11.glTranslatef(-swingProgressy * 0.3F, MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float) Math.PI * 2.0F) * 0.4F, -swingProgressx * 0.4F);
        GL11.glTranslatef(0.8F * f4, -0.75F * f4 - (1.0F - changeItemProgress) * 0.6F, -0.9F * f4);
        GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        swingProgress = entityclientplayermp.getSwingProgress(par1);
        swingProgressx = MathHelper.sin(swingProgress * swingProgress * (float) Math.PI);
        swingProgressy = MathHelper.sin(MathHelper.sqrt_float(swingProgress) * (float) Math.PI);
        GL11.glRotatef(swingProgressy * 70.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-swingProgressx * 20.0F, 0.0F, 0.0F, 1.0F);
      // GL11.glBindTexture(GL11.GL_TEXTURE_2D, mc.renderEngine.getTextureForDownloadableImage(mc.thePlayer.skinUrl, mc.thePlayer.getTexture()));
      //((Object) mc.renderEngine).resetBoundTexture();
        GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
        GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(5.6F, 0.0F, 0.0F);
        Render render = RenderManager.instance.getEntityRenderObject(mc.thePlayer);
        RenderPlayer renderplayer = (RenderPlayer) render;
        renderplayer.renderFirstPersonArm(mc.thePlayer);
        GL11.glPopMatrix();
    }

	}


