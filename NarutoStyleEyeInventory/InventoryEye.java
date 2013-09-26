package NarutoStyleEyeInventory;

import NarutoStyleItems.Sharingan;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryEye extends InventoryBasic {

private int activeSlot = 0;

public InventoryEye()
{
super("Eyes", true, ContainerEye.ACTIVE_SLOT + 1);
}

/** Returns index of slot that is 'active' */
public int getActiveSlot()
{
return this.activeSlot;
}

/** Sets the currently active slot index */
public void setActiveSlot(int slotIndex)
{
this.activeSlot = slotIndex;
}

/** Allows cycling of the active slot index */
public void nextActiveSlot()
{
++this.activeSlot;
if (this.activeSlot == this.getSizeInventory()) {
this.activeSlot = 0;
}
}

/**
         * Returns the stack in slot index
         */
@Override
public ItemStack getStackInSlot(int index)
{
if (index == ContainerEye.ACTIVE_SLOT) {
return super.getStackInSlot(this.activeSlot);
}
else {
return super.getStackInSlot(index);
}
}

/**
         * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
         * this more of a set than a get?*
         */
@Override
public int getInventoryStackLimit()
{
         // return NarutoStyleItems.Sharingan.getMaxStackSize();
return 1;
}

/**
         * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
         */
@Override
public boolean isItemValidForSlot(int par1, ItemStack itemstack)
{
	Sharingan sharingan = new Sharingan(4015);
          return itemstack.itemID == sharingan.itemID;
//return true;
}

public void readFromNBT(NBTTagCompound tagCompound)
{
NBTTagList nbttaglist = tagCompound.getTagList("EyeInventory");

for (int i = 0; i < nbttaglist.tagCount(); ++i)
{
NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
byte b0 = nbttagcompound1.getByte("Slot");
this.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
}
this.activeSlot = tagCompound.getShort("ActiveEye");
}

public void writeToNBT(NBTTagCompound tagCompound)
{
NBTTagList nbttaglist = new NBTTagList();

// Don't need to save ItemStack in active slot
for (int i = 0; i < ContainerEye.ACTIVE_SLOT; ++i)
{
if (this.getStackInSlot(i) != null)
{
NBTTagCompound nbttagcompound1 = new NBTTagCompound();
nbttagcompound1.setByte("Slot", (byte)i);
this.getStackInSlot(i).writeToNBT(nbttagcompound1);
nbttaglist.appendTag(nbttagcompound1);
}
}

tagCompound.setTag("EyeInventory", nbttaglist);
tagCompound.setShort("ActiveEye", (short) this.activeSlot);
}


}
