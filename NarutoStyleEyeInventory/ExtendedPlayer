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

public class ExtendedPlayer implements IExtendedEntityProperties
 {
	/** The player to whom these extended properties belong. */
	private final EntityPlayer player;

	/** Stores special inventory for this player. */
	public final InventoryEye sharingan = new InventoryEye();

	/** The name of these extended properties */
    	public final static String EXT_PROP_NAME = "ExtPlayerProps";
    	
	public ExtendedPlayer(EntityPlayer par1Player) {
		this.player = par1Player;
	}
	
	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player
	 */
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	/**
	 * Makes it look nicer in the methods save/loadProxyData
	 */
	private static final String getSaveKey(EntityPlayer player) {
		return player.username + ":" + EXT_PROP_NAME;
	}

	/**
	 * Does everything I did in onLivingDeathEvent and it's static,
	 * so you now only need to use the following in the above event:
	 * ExtendedPlayer.saveProxyData((EntityPlayer) event.entity));
	 */
	public static final void saveProxyData(EntityPlayer player)
	{
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}

	/**
	 * This cleans up the onEntityJoinWorld event by replacing most of the code
	 * with a single line: ExtendedPlayer.loadProxyData((EntityPlayer) event.entity));
	 */
	public static final void loadProxyData(EntityPlayer player)
	{
		ExtendedPlayer playerData = ExtendedPlayer.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) {
			playerData.loadNBTData(savedData);
		}
		// playerData.sync(); // nothing to sync
	}

	/**
	 * Called when the entity that this class is attached to is saved.
	 * Any custom entity data that needs saving should be saved here.
	 * @param compound The compound to save to.
	 */
	@Override
	public final void saveNBTData(NBTTagCompound compound)
	{
	         sharingan.writeToNBT(compound);
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
	         sharingan.readFromNBT(compound);
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
	
	public final void sync() {}
	
}
