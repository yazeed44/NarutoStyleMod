package NarutoStyleItems;

import NarutoStyle.NarutoStyle_main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;


public class MadaraArmor extends ItemArmor    {

	private String type;

	public MadaraArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3,
			int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(itemID == NarutoStyle_main.MadaraHelmet.itemID || itemID == NarutoStyle_main.MadaraChestPlate.itemID || itemID == NarutoStyle_main.MadaraBoots.itemID) {
			return "narutostyle:textures/models/armor/diamond_1_madara.png";
		}
		if(itemID == NarutoStyle_main.MadaraLegging.itemID) {
			return "narutostyle:textures/models/armor/diamond_2madra.png";
		}
		return null;
	}
	
	
	@Override
	   public void registerIcons(IconRegister iconRegister)
	   {
	      if(itemID == NarutoStyle_main.MadaraHelmet.itemID)
	      {
	         itemIcon = iconRegister.registerIcon("narutostyle:MadaraHelmet");
	      }
	      if(itemID == NarutoStyle_main.MadaraChestPlate.itemID)
	      {
	         itemIcon = iconRegister.registerIcon("narutostyle:MadaraChestPlate");
	      }
	      if(itemID == NarutoStyle_main.MadaraLegging.itemID)
	      {
	         itemIcon = iconRegister.registerIcon("narutostyle:MadaraLegging");
	      }
	      if(itemID == NarutoStyle_main.MadaraBoots.itemID)
	      {
	         itemIcon = iconRegister.registerIcon("narutostyle:MadaraBoots");
	      }

	

	
	   }
}
