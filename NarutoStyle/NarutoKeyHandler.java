package NarutoStyle;

import java.util.EnumSet;

import NarutoStyleEyeInventory.ExtendedPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NarutoKeyHandler extends KeyHandler
{
	/** Not really important. I use it to store/find keys in the config file */
	public static final String label = "Naruto Style Keys";

	public NarutoKeyHandler(KeyBinding[] keyBindings, boolean[] repeatings) {
		super(keyBindings, repeatings);
	}

	@Override
	public String getLabel() {
		return this.label;
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		if (tickEnd && RegisterKeyBindings.keyMap.containsKey(kb.keyCode))
		{
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;

			switch(RegisterKeyBindings.keyMap.get(kb.keyCode)) {
			case RegisterKeyBindings.SHARINGAN_INV:
				if (player.openContainer != null && player.openContainer instanceof ContainerEye)
					player.closeScreen();
				else if (FMLClientHandler.instance().getClient().inGameHasFocus)
					PacketHandler.sendOpenGuiPacket(NarutoStyle_main.eyeGuiId);
				break;
			case RegisterKeyBindings.SHARINGAN_NEXT:
				if (player.openContainer != null && player.openContainer instanceof ContainerEye) {
					PacketHandler.sendNextActiveEyePacket();
					((ContainerEye) player.openContainer).nextActiveSlot();
				} else if (FMLClientHandler.instance().getClient().inGameHasFocus) {
					PacketHandler.sendNextActiveEyePacket();
					ExtendedPlayer.get(player).sharingan.nextActiveSlot();
				}
				break;
			}
			case RegisterKeyBindings.SHARINGAN_USE:
				PacketHandler.sendUseEyePacket();
				break;
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		// Don't need to do anything here!
	}

	@Override
	public EnumSet<TickType> ticks() {
		// We're only interested in player ticks, as that's when the keyboard will fire
		return EnumSet.of(TickType.PLAYER);
	}
}
