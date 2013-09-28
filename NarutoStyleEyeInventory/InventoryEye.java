package NarutoStyleEyeInventory;

import NarutoStyleItems.Sharingan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class InventoryEye implements IInventory
{
	public static final int INV_SIZE = 2, ACTIVE_SLOT = INV_SIZE;
	
	private final ItemStack[] items = new ItemStack[INV_SIZE];
	
	public final NBTTagCompound compound;
	
	public InventoryEye(NBTTagCompound compound) {
		this.compound = compound;
	}
	
	/**
	 * Call this method from a TickHandler to update stored ItemStacks
	 * Item onUpdate method is not called for custom inventories
	 */
	public void onUpdateTick(World world)
	{
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null)
				Sharingan.onUpdateTick(getStackInSlot(i), world);
		}
	}
	
	/**
	 * Returns index of slot that is 'active'
	 */
	public int getActiveSlot() {
		return compound.getByte("ActiveSlot");
	}
	
	/**
	 * Sets active slot to index or 0 if index is out of bounds
	 */
	public void setActiveSlot(int index) {
		if (index >= 0 && index < ACTIVE_SLOT)
			compound.setByte("ActiveSlot", (byte) index);
		else
			compound.setByte("ActiveSlot", (byte) 0);
	}

	/**
	 * Sets the active slot index to the next index within the inventory size
	 */
	public void nextActiveSlot() {
		setActiveSlot(getActiveSlot() + 1);
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

		onInventoryChanged();
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
		
		setActiveSlot(compound.getByte("ActiveSlot"));
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
		compound.setByte("ActiveSlot", (byte) getActiveSlot());
	}
}
