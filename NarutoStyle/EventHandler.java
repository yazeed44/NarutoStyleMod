package NarutoStyle;

import java.util.List;

import org.lwjgl.input.Keyboard;

import NarutoStyleEntitys.EntityDeidara;
import NarutoStyleEyeInventory.ExtendedPlayerProperties;
import NarutoStyleItems.Sharingan;
import NarutoStyleRender.RenderC4Mobs;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class EventHandler {
	
	public Entity entity;
	public  World world;
	
	

    
	
	/** Register extended properties when entity is constructed. */
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
	if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME) == null)
	{        event.entity.registerExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME, new ExtendedPlayerProperties((EntityPlayer) event.entity));
	}}


	/** Sync properties from server to client when entity joins world */
	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
	if (event.entity instanceof EntityPlayer) {
	((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).syncExtendedProperties();
	
	}}
	
	@ForgeSubscribe
	public  void onLivingUpdateEvent(LivingUpdateEvent event ){
		
		if (event.entity instanceof EntityPlayer)
		  {
		   EntityPlayer player = (EntityPlayer)event.entity;
		   ExtendedPlayerProperties props = (ExtendedPlayerProperties)player.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME);
		           ItemStack eye = props.eyeInventory.getStackInSlot(props.eyeInventory.getActiveSlot());
		 
		   if (FMLClientHandler.instance().getClient().inGameHasFocus && Keyboard.isKeyDown(Keyboard.KEY_M) && props != null) {
	
		                        player.openGui(NarutoStyle_main.Instance, NarutoStyle_main.eyeGuiId, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		                         if (Keyboard.isKeyDown(Keyboard.KEY_N) && props != null)
		                  {
		                   props.eyeInventory.nextActiveSlot();
		                  }}
		 
		  
		  if (eye != null )
		  {
		   List<EntityLiving> entl = player.worldObj.getEntitiesWithinAABB(EntityLiving.class, player.boundingBox.expand(10, 10, 10));
		                 if (entl != null && entl.size() > 0) {
		                  for (EntityLiving el : entl) {
		                   if (el != null && el instanceof EntityLiving){
		                                          el.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,20,2));
		                                        
		                                         
		                   }
		                  }
		  }
		           
		                 
		                 
		   }}}
	
	
	
	}
		
		
	

		
	 
		 
	