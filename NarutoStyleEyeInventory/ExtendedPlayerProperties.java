package NarutoStyleEyeInventory;

import java.io.DataOutputStream;

import org.apache.commons.io.output.ByteArrayOutputStream;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties
 {
	/** The player to whom these extended properties belong. */
	private final EntityPlayer player;

	/** Stores special inventory for this player. */
	public final InventoryEye eyeInventory = new InventoryEye();

	/** The name of these extended properties */
    public final static String EXT_PROP_NAME = "ExtPlayerProps";
	public ExtendedPlayerProperties(EntityPlayer par1Player) {
	this.player = par1Player;
	}

	/**
	         * Called when the entity that this class is attached to is saved.
	         * Any custom entity data that needs saving should be saved here.
	         * @param compound The compound to save to.
	         */
	@Override
	public final void saveNBTData(NBTTagCompound compound)
	{
	         eyeInventory.writeToNBT(compound);
	}

	/**
	         * Called when the entity that this class is attached to is loaded.
	         * In order to hook into this, you will need to subscribe to the EntityConstructing event.
	         * Otherwise, you will need to initialize manually.
	         * @param compound The compound to load from.
	         */
	@Override
	public final void loadNBTData(NBTTagCompound compound)
	{
	         eyeInventory.readFromNBT(compound);
	}

	/**
	         * Used to initialize the extended properties with the entity that this is attached to, as well
	         * as the world object.
	         * Called automatically if you register with the EntityConstructing event.
	         * @param entity The entity that this extended properties is attached to
	         * @param world The world in which the entity exists
	         */
	@Override
	public final void init(Entity entity, World world)
	{
	}

	// Used to sync properties from server to client, when necessary
	public final void syncExtendedProperties()
	{
	ByteArrayOutputStream bos = new ByteArrayOutputStream(2);
	DataOutputStream outputStream = new DataOutputStream(bos);

	try {
	         // outputStream.writeInt(this.sharingan.getActiveSlot());
	} catch (Exception ex) {
	ex.printStackTrace();
	}

	Packet250CustomPayload packet = new Packet250CustomPayload();
	packet.channel = "ExtPlayerProps";
	packet.data = bos.toByteArray();
	packet.length = bos.size();

	Side side = FMLCommonHandler.instance().getEffectiveSide();

	if (side == Side.SERVER) {
	EntityPlayerMP player1 = (EntityPlayerMP) player;
	PacketDispatcher.sendPacketToPlayer(packet, (Player)player1);
	} else if (side == Side.CLIENT) {
	//EntityClientPlayerMP player1 = (EntityClientPlayerMP) player;
	//player1.sendQueue.addToSendQueue(packet);
	} else {
	// We are on the Bukkit server.
	}
	}
	
}
