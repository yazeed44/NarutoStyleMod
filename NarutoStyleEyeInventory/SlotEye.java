package NarutoStyleEyeInventory;

import NarutoStyleItems.Sharingan;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotEye extends Slot
{
	public SlotEye(IInventory inventory, int par2, int par3, int par4) {
		super(inventory, par2, par3, par4);
	}

	/**
	 * Returns the maximum stack size for a given slot
	 */
	@Override
	public int getSlotStackLimit() {
	         return 1;
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	 */
	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return itemstack.getItem() instanceof Sharingan;
	}
}

class SlotEyeActive extends SlotEye
{
	public SlotEyeActive(IInventory inventory, int par2, int par3, int par4) {
		super(inventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return false;
	}
	
	@Override
	public boolean canTakeStack(EntityPlayer player) {
		return false;
    	}
}
