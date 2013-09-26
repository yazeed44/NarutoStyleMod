package NarutoStyleItems;

import java.util.List;

import NarutoStyle.NarutoStyle_main;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Sharingan extends Item
{
	public Sharingan(int par1) {
		super(par1);
		this.maxStackSize = 1;
	}
	
	/**
	 * A method to call when active Sharingan is used with a key press
	 * @param stack
	 * @param player
	 * @return true if Sharingan was activated successfully
	 */
	public static boolean useSharingan(ItemStack stack, EntityPlayer player)
	{
		// Double-check whether this method was called with correct Item type
		if (stack != null && stack.getItem() instanceof Sharingan)
		{
			if (!player.worldObj.isRemote) {
				player.addChatMessage("Sharingan was used!");

				List<EntityLivingBase> entl = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, player.boundingBox.expand(10, 10, 10));
				if (!entl.isEmpty()) {
					for (EntityLivingBase el : entl) {
						if (el != player) {
							el.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,100,2));
						}
					}
				}
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
		list.add("Radius of 10 Blocks");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(NarutoStyle_main.modid + ":" + getUnlocalizedName().substring(5).toLowerCase());
	}
}
