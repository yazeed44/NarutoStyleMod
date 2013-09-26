package NarutoStyleEyeInventory;

import NarutoStyleItems.Sharingan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryEye implements IInventory
{
	public static final int INV_SIZE = 2, ACTIVE_SLOT = INV_SIZE;
	
	private final ItemStack[] items = new ItemStack[INV_SIZE];
	
	private final NBTTagCompound compound;
	
	public InventoryEye(NBTTagCompound compound) {
		this.compound = compound;
	}
	
	/**
	 * Returns index of slot that is 'active'
	 */
	public int getActiveSlot() {
		return compound.getInteger("ActiveSlot");
	}

	/**
	 * Sets the active slot index to the next index within the inventory size
	 */
	public void nextActiveSlot()
	{
		int activeSlot = getActiveSlot() + 1;
		if (activeSlot == ACTIVE_SLOT) { activeSlot = 0; }
		compound.setInteger("ActiveSlot", activeSlot);
	}
	
	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		if (slot == ACTIVE_SLOT) {
			return items[getActiveSlot()];
		} else {
			return items[slot];
		}
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		ItemStack stack = getStackInSlot(slot);
		
		if(stack != null)
		{
			if(stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);
				onInventoryChanged();
			} else {
				setInventorySlotContents(slot, null);
			}
		}
		
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		this.items[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}

		this.onInventoryChanged();
	}

	@Override
	public String getInvName() {
		return null;
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public void onInventoryChanged()
	{
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
				setInventorySlotContents(i, null);
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		/** NEVER declare a new Item outside of your main mod!!! */
		//Sharingan sharingan = new Sharingan(4015);
		return stack.getItem() instanceof Sharingan;
	}
	
	public void readFromNBT(NBTTagCompound compound)
	{
		NBTTagList items = compound.getTagList("EyeInventory");
		
		for (int i = 0; i < items.tagCount(); ++i)
		{
			NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
			byte slot = item.getByte("Slot");

			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound compound)
	{
		NBTTagList items = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); ++i)
		{
			if (getStackInSlot(i) != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}
		
		compound.setTag("EyeInventory", items);
	}
}
