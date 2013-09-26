package NarutoStyleEyeInventory;



import NarutoStyle.NarutoStyle_main;
import cpw.mods.fml.common.network.IGuiHandler;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler   {
    public GuiHandler() {}

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                    int x, int y, int z)
    {
            ExtendedPlayerProperties props = ((ExtendedPlayerProperties) player.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME));
            
     if (ID == NarutoStyle_main.eyeGuiId)
            {
                    return new ContainerEye(player, player.inventory, props.eyeInventory);
            }
            return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                    int x, int y, int z)
    {
            ExtendedPlayerProperties extendedProps = ((ExtendedPlayerProperties) player.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME));
            
     if (ID == NarutoStyle_main.eyeGuiId)
            {
                    return new GuiEye(player, player.inventory, extendedProps.eyeInventory);
            }

            return null;
    }

 
}
