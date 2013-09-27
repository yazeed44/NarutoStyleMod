package NarutoStyle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import NarutoStyleEyeInventory.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	/** Defining packet ids allow for subtypes of Packet250CustomPayload all on single channel */
	public static final byte OPEN_SERVER_GUI = 1, NEXT_ACTIVE_SLOT = 2, USE_SHARINGAN = 3;

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		// Adding this code will allow us to easily distinguish between various CustomPayload packets
		// The first byte of each packet is used as an id, defined above as constants
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		byte packetType;

		try {
			packetType = inputStream.readByte();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// Now we check which channel, in case you have more than one registered
		if (packet.channel.equals(NarutoStyle_main.channel))
		{
			// Handle each case appropriately:
			switch(packetType) {
			case OPEN_SERVER_GUI: handleOpenGuiPacket(packet, (EntityPlayer) player, inputStream); break;
			case NEXT_ACTIVE_SLOT: handleNextActiveSlot(packet, (EntityPlayer) player); break;
			case USE_SHARINGAN: handleUseSharingan(packet, (EntityPlayer) player); break;
			default: System.out.println("[PACKET][WARNING] Unknown packet type " + packetType);
			}
		}
	}

	/**
	 * Sends a packet to the server telling it to open gui for player
	 */
	public static final void sendOpenGuiPacket(int guiId)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try {
			outputStream.writeByte(OPEN_SERVER_GUI);
			outputStream.writeInt(guiId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(NarutoStyle_main.channel, bos.toByteArray()));
	}
	
	/**
	 * Sends a packet to change active sharingan slot
	 */
	public static final void sendNextActiveEyePacket()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try {
			outputStream.writeByte(NEXT_ACTIVE_SLOT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(NarutoStyle_main.channel, bos.toByteArray()));
	}
	
	/**
	 * Sends a packet informing server player to use power of currently active sharingan, if any
	 */
	public static final void sendUseEyePacket()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream outputStream = new DataOutputStream(bos);
		
		try {
			outputStream.writeByte(USE_SHARINGAN);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(NarutoStyle_main.channel, bos.toByteArray()));
	}

	/**
	 * This method will open the appropriate server gui element for the player
	 */
	private void handleOpenGuiPacket(Packet250CustomPayload packet, EntityPlayer player, DataInputStream inputStream)
	{
		int guiId;

		try {
			guiId = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		player.openGui(NarutoStyle_main.instance, guiId, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
	
	private void handleNextActiveSlot(Packet250CustomPayload packet, EntityPlayer player) {
		ExtendedPlayer.get(player).sharingan.nextActiveSlot();
	}
	
	private void handleUseSharingan(Packet250CustomPayload packet, EntityPlayer player)
	{
		ItemStack eye = ExtendedPlayer.get(player).sharingan.getStackInSlot(ExtendedPlayer.get(player).sharingan.getActiveSlot());
		
		if (eye != null && eye.getItem() instanceof Sharingan) {
			Sharingan.useSharingan(eye, player);
		}
	}
}
