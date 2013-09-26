package NarutoStyleBlocks;

import java.util.Random;

import NarutoStyle.NarutoStyle_main;
import NarutoStyleEntitys.EntityDeidara;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityDeidaraClay extends TileEntity {
int time = 0;
	
	
	/**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
	@Override
    public void updateEntity()
    {
		
		Random random = new Random();
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		/*if (this.worldObj != null)
        {
            this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
            this.func_98267_a(10);
        }*/
		if (worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 6) != null)
			time++;
		EntityDeidara deidara = new EntityDeidara(worldObj);
			if (time >= 80){
				if (!worldObj.isRemote)
				deidara.setLocationAndAngles(this.xCoord,player.posY,this.zCoord , 0F, 0F);
			worldObj.spawnEntityInWorld(deidara);
			//worldObj.setBlockToAir(xCoord, yCoord, zCoord);
			worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Block.obsidian.blockID);
			}
        super.updateEntity();}
    
	/**
     * Reads a tile entity from NBT.
     */
	@Override
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        //this.func_98267_a.readFromNBT(par1NBTTagCompound);
    }

    /**
     * Writes a tile entity to NBT.
     */
	@Override
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        //this.func_98267_a.writeToNBT(par1NBTTagCompound);
    }
    /**
     * Called when a client event is received with the event number and argument, see World.sendClientEvent
     */
    @Override
    public boolean receiveClientEvent(int par1, int par2)
    {
    	super.receiveClientEvent(par1, par2);
        return true;
        
    }
    public void func_98267_a(int par1)
    {
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, NarutoStyle_main.DeidaraClay.blockID, par1, 10);
    }
}
