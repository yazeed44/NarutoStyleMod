package NarutoStyleItems;

import java.awt.Color;
import java.util.List;

import NarutoStyle.NarutoStyle_main;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DeidaraHand extends Item {
	
		public DeidaraHand(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		
	}

	

	@Override
    public  boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
		int id = world.getBlockId(x, y, z);

        if (id== Block.blockClay.blockID) {
        	world.destroyBlock(x, y, z, false);
        	entityPlayer.inventory.addItemStackToInventory(new ItemStack(NarutoStyle_main.ClayBird,6));
        	if (!world.isRemote)
        	entityPlayer.addChatMessage("You got 6 Clay Birds");


        	
            return true;
        }
        
        return false;
    }
		
	
	
	public Color getColorFromItemStack(ItemStack itemStack) {
		
		return null;
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
	list.add("Right click at Clay Block");
	list.add("\u00A76" +"Incomplete");
	}
	public void registerIcons(IconRegister IR)
	{
		this.itemIcon = IR.registerIcon("NarutoStyle:DeidaraHand");
	}
	
}
