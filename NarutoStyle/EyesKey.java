package NarutoStyle;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import NarutoStyleEyeInventory.ExtendedPlayerProperties;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class EyesKey extends KeyHandler {
	 public EnumSet<TickType> tickTypes = EnumSet.of(TickType.CLIENT);
	 public static KeyBinding login = new KeyBinding("Login", Keyboard.KEY_M);
	 public static KeyBinding[] arrayOfKeys = new KeyBinding[] {login};
	 public static boolean[] areRepeating = new boolean[] {false};
	 public EntityPlayer player;
	 public static boolean keyPressed = false;
     
     public KeyBinding key;
     public boolean[] repeatings;
	private boolean keyHasBeenPressed;
     public EyesKey(KeyBinding[] key, boolean[] repeatings)
     {
             super(key, repeatings);
     }
     
	

	

	




	@Override
     public String getLabel()
     {
             return "EyesKey";
     }
     
     @Override
     public EnumSet<TickType> ticks()
     {
             return tickTypes;
     }
	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,
			boolean tickEnd, boolean isRepeat) {
		keyPressed = true;
		}
	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		
		
		if (keyHasBeenPressed) {
            keyHasBeenPressed = false;
            keyPressed = true; }
	}

}
