package NarutoStyleBlocks;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DeidaraClay extends BlockContainer{
	
	public DeidaraClay(int par1, Material par2Material) {
		super(par1, par2Material);
		
	}

	@Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister iconRegister) {
	          this.blockIcon = iconRegister.registerIcon("narutostyle:DeidaraClay");
	 }
	

    
    

	
	@Override
	public TileEntity createNewTileEntity(World world) {
		
		return new TileEntityDeidaraClay();
	}
	
}
	 
	 

