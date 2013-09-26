package NarutoStyleItems;

import NarutoStyleEntitys.EntityClayBird;
import NarutoStyleEntitys.EntitySmokeBomb;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SmokeBomb extends Item {

	public SmokeBomb(int par1) {
		super(par1);
		
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
            par2World.spawnEntityInWorld(new EntitySmokeBomb(par2World,par3EntityPlayer));
        }

        return par1ItemStack;
    }
	public void registerIcons(IconRegister IR)
	{
		this.itemIcon = IR.registerIcon("NarutoStyle:SmokeBomb");
	}}
