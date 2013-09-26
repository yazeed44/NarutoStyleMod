package NarutoStyleItems;

import NarutoStyleEntitys.EntityClayBird;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ClayBird extends Item {

	public ClayBird(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setMaxStackSize(64);
	}
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {
	            --par1ItemStack.stackSize;
	        }

	        //par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	        if (!par2World.isRemote)
	        {
	            par2World.spawnEntityInWorld(new EntityClayBird(par2World,par3EntityPlayer));
	        }

	        return par1ItemStack;
	    }
	 public void registerIcons(IconRegister IR)
		{
			this.itemIcon = IR.registerIcon("NarutoStyle:ClayBird");
		}

}
//return 0.001F;