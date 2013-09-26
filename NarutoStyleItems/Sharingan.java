package NarutoStyleItems;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import NarutoStyle.NarutoStyle_main;
import NarutoStyleEyeInventory.ExtendedPlayerProperties;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Sharingan extends Item {

	
	public Sharingan(int par1) {
		super(par1);
		this.maxStackSize = 1;
	}

	
	@Override
	 public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	 {
	 //EntityPlayer player = (EntityPlayer)entity;
	 //ExtendedPlayerProperties props = (ExtendedPlayerProperties)player.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME);

	 // Choose whatever key you want
	 /*if (FMLClientHandler.instance().getClient().inGameHasFocus && Keyboard.isKeyDown(Keyboard.KEY_M) && props != null) {
         player.openGui(NarutoStyle_main.Instance, NarutoStyle_main.eyeGuiId, world, (int)player.posX, (int)player.posY, (int)player.posZ);
	 }
         
         
	 
        	    
         
 
	 if (Keyboard.isKeyDown(Keyboard.KEY_N) && props != null)
     {
      props.eyeInventory.nextActiveSlot();
     }
	 
	 
	 }*/
	 }
	
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
	list.add("Radius of 10 Blocks");
	}
	
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister iconRegister) {
	          this.itemIcon = iconRegister.registerIcon("narutostyle:Sharingan");
	 }
}
