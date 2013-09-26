package NarutoStyleEyeInventory;


import NarutoStyleItems.Sharingan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ContainerEye extends Container {
	public IInventory inventory;

	private final EntityPlayer player;

	public static final int ACTIVE_SLOT = 2;

	private static final int ARMOR_START = ACTIVE_SLOT+1, ARMOR_END = ARMOR_START+3, INV_START = ARMOR_END+1,
	INV_END = INV_START+26, HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;

	public ContainerEye(EntityPlayer parPlayer, InventoryPlayer inventoryPlayer, InventoryEye inventoryEye)
	{
	this.inventory = inventoryEye;

	this.player = parPlayer;

	int i;

	this.addSlotToContainer(new SlotEye(inventory, 0, 80, 8));
	this.addSlotToContainer(new SlotEye(inventory, 1, 80, 26));
	this.addSlotToContainer(new SlotEyeActive(inventory, 2, 116, 26));

	for (i = 0; i < 4; ++i)
	         {
	                 this.addSlotToContainer(new SlotArmor(this.player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18, i));
	         }

	for (i = 0; i < 3; ++i)
	         {
	                 for (int j = 0; j < 9; ++j)
	                 {
	                         this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
	                 }
	         }

	         for (i = 0; i < 9; ++i)
	         {
	                 this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
	         }
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
	return true;
	}

	/**
	         * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	         */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
	         ItemStack itemstack = null;
	         Slot slot = (Slot)this.inventorySlots.get(par2);

	         if (slot != null && slot.getHasStack())
	         {
	                 ItemStack itemstack1 = slot.getStack();
	                 itemstack = itemstack1.copy();

	                 // Either armor or sharingan eye
	                 if (par2 < ARMOR_END + 1 && par2 != ACTIVE_SLOT)
	                 {
	                 // try to place in player inventory / action bar
	                         if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
	                         {
	                                 return null;
	                         }

	                         slot.onSlotChange(itemstack1, itemstack);
	                 }
	                 // Item is in inventory / hotbar, try to place either in eye or armor slots
	                 else
	                 {
	                 // if item is a sharingan eye
	                         if (itemstack1.getItem() instanceof Sharingan)
	                         {
	                         if (!this.mergeItemStack(itemstack1, 0, ACTIVE_SLOT, false))
	                         {
	                         return null;
	                         }
	                         }
	                         // if item is armor
	                         else if (itemstack1.getItem() instanceof ItemArmor) {
	                         int type = ((ItemArmor) itemstack1.getItem()).armorType;
	                         if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
	                         {
	                         return null;
	                         }
	                         }
	                         // item in player's inventory, but not in action bar
	                         else if (par2 >= INV_START && par2 < HOTBAR_START)
	                         {
	                         // place in action bar
	                                 if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_START + 1, false))
	                                 {
	                                         return null;
	                                 }
	                         }
	                         // item in action bar - place in player inventory
	                         else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
	                         {
	                         if (!this.mergeItemStack(itemstack1, INV_START, INV_END + 1, false))
	                         {
	                         return null;
	                         }
	                         }
	                 }

	                 if (itemstack1.stackSize == 0)
	                 {
	                         slot.putStack((ItemStack)null);
	                 }
	                 else
	                 {
	                         slot.onSlotChanged();
	                 }

	                 if (itemstack1.stackSize == itemstack.stackSize)
	                 {
	                         return null;
	                 }

	                 slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	         }
	        
	         return itemstack;
	}

}
