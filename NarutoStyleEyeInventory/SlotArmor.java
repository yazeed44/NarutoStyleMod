package NarutoStyleEyeInventory;

import javax.swing.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SlotArmor extends Slot {

    /**
    * The armor type that can be placed on that slot, it uses the same values of armorType field on ItemArmor.
    */
   final int armorType;

   /**
    * The parent class of this clot, ContainerPlayer, SlotArmor is a Anon inner class.
    */
   final EntityPlayer player;

   SlotArmor(EntityPlayer par1Player, IInventory par2IInventory, int par3, int par4, int par5, int par6)
   {
           super(par2IInventory, par3, par4, par5);
           this.player = par1Player;
           this.armorType = par6;
   }

   /**
    * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
    * of armor slots)
    */
   public int getSlotStackLimit()
   {
           return 1;
   }

   /**
    * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
    */
   public boolean isItemValid(ItemStack par1ItemStack)
   {
           Item item = (par1ItemStack == null ? null : par1ItemStack.getItem());
           return item != null && item.isValidArmor(par1ItemStack, armorType, player);
   }

   @SideOnly(Side.CLIENT)

   /**
    * Returns the icon index on items.png that is used as background image of the slot.
    */
   public net.minecraft.util.Icon getBackgroundIconIndex()
   {
           return ItemArmor.func_94602_b(this.armorType);
   }

}
