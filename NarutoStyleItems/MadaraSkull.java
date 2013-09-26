package NarutoStyleItems;

import java.util.List;

import NarutoStyle.NarutoStyle_main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class MadaraSkull extends Item {

	
	
	private Icon sides, bottom, top;
	private static final String[] skullTypes = new String[] {"skeleton", "wither", "zombie", "char", "creeper"};
    public static final String[] field_94587_a = new String[] {"skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper","MadaraSkull"};
    @SideOnly(Side.CLIENT)
    private Icon[] field_94586_c;
	

    public MadaraSkull(int par1)
    {
        super(par1);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("narutostyle:MadaraSkull");
    }


   
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par7 == 0)
        {
            return false;
        }
        else if (!par3World.getBlockMaterial(par4, par5, par6).isSolid())
        {
            return false;
        }
        else
        {
            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }

            if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
            {
                return false;
            }
            else if (!NarutoStyle_main.BlockMadaraSkull.canPlaceBlockAt(par3World, par4, par5, par6))
            {
                return false;
            }
            else
            {
                par3World.setBlock(par4, par5, par6, NarutoStyle_main.BlockMadaraSkull.blockID, par7, 2);
                int i1 = 0;

                if (par7 == 1)
                {
                    i1 = MathHelper.floor_double((double)(par2EntityPlayer.rotationYaw * 16.0F / 360.0F) + 0.5D) & 15;
                }

                TileEntity tileentity = par3World.getBlockTileEntity(par4, par5, par6);

                if (tileentity != null && tileentity instanceof TileEntitySkull)
                {
                    String s = "";

                    if (par1ItemStack.hasTagCompound() && par1ItemStack.getTagCompound().hasKey("SkullOwner"))
                    {
                        s = par1ItemStack.getTagCompound().getString("SkullOwner");
                    }

                    ((TileEntitySkull)tileentity).setSkullType(par1ItemStack.getItemDamage(), s);
                    ((TileEntitySkull)tileentity).setSkullRotation(i1);
                    ((BlockSkull)NarutoStyle_main.BlockMadaraSkull).makeWither(par3World, par4, par5, par6, (TileEntitySkull)tileentity);
                }

                --par1ItemStack.stackSize;
                return true;
            }
        }
        
        

    
    }

   
		

    

}
