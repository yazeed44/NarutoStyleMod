package NarutoStyleItems;

import NarutoStyleEntitys.EntityNarutoStylePainting;
import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class NarutoStylePainting extends Item {

	public NarutoStylePainting(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	 public void registerIcons(IconRegister IR)
		{
			this.itemIcon = IR.registerIcon("NarutoStyle:NarutoStylePainting");
		}
	 
	 

	 @Override
	 public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, 
			 float par8, float par9, float par10)
			     {
			         if (par7 == 0)
			         {
			             return false;
			         }
			         else if (par7 == 1)
			         {
			             return false;
			         }
			         else
			         {
			             int i1 = Direction.facingToDirection[par7];
			             EntityNarutoStylePainting hangingentity = new EntityNarutoStylePainting(par3World, par4, par5, par6, i1); 

			             if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			             {
			                 return false;
			             }
			             else
			             {
			                 if (hangingentity != null && hangingentity.onValidSurface())
			                 {
			                     if (!par3World.isRemote)
			                     {
			                         par3World.spawnEntityInWorld(hangingentity);
			                         FMLLog.getLogger().info(hangingentity + " was spawned at location "+par4+" "+par5+" "+par6);
			                     }

			                     --par1ItemStack.stackSize;
			                 }

			                 return true;
			             }
			         }
			     }}