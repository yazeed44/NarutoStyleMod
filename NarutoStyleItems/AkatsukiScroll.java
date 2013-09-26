package NarutoStyleItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class AkatsukiScroll extends Item {

	public AkatsukiScroll(int par1) {
		super(par1);
		this.setMaxStackSize(1);
	}

	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister iconRegister) {
	          this.itemIcon = iconRegister.registerIcon("narutostyle:AkatsukiScroll");
	 }
}
