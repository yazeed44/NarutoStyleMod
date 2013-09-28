package NarutoStyleItems;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Sharingan extends Item
{
	/** For ease of reference; needs to match order of SHARINGAN_NAMES strings. */
	public static final int SHARINGAN = 0, TSUKUYOMI = 1, AMATERASU = 2; // SUSANOO = 3, KAMUI = 4, NEW_TYPE = 5, etc.;
	
	/** Used to localized names as well as store number of sharingan types (i.e. String.length). */
	public static final String[] SHARINGAN_NAMES = new String[] {"Sharingan","Tsukuyomi"}; // ,"Amaterasu"};
	
	/** Identifier to store/retrieve cooldown from NBT Tag */
	public static final String COOLDOWN = "Cooldown";
	
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;
	
	public Sharingan(int par1) {
		super(par1);
		this.maxStackSize = 1;
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean i)
	{
		// Can add general information here, but it gets crowded
		list.add(EnumChatFormatting.ITALIC + "Grants users unique abilities");
		
		// Add specific information based on type of Sharingan here
		switch(stack.getItemDamage()) {
		case SHARINGAN: list.add(EnumChatFormatting.ITALIC + "Acute perception makes others seem slow"); break;
		case TSUKUYOMI: list.add(EnumChatFormatting.ITALIC + "Traps target in genjutsu."); list.add(EnumChatFormatting.ITALIC + "Requires line of sight."); break;
		default: list.add("Why haven't you defined this type yet?"); break;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1)
	{
		int j = MathHelper.clamp_int(par1, 0, SHARINGAN_NAMES.length - 1);
		return this.iconArray[j];
	}

	/**
	 * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
	 * different names based on their damage or NBT.
	 */
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		int i = MathHelper.clamp_int(itemstack.getItemDamage(), 0, SHARINGAN_NAMES.length - 1);
		return SHARINGAN_NAMES[i];
	}

	/**
	 * Returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List list)
	{
		for (int i = 0; i < SHARINGAN_NAMES.length; ++i) {
			list.add(new ItemStack(itemID, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		iconArray = new Icon[SHARINGAN_NAMES.length];

		for (int i = 0; i < SHARINGAN_NAMES.length; ++i) {
			this.iconArray[i] = iconRegister.registerIcon(NarutoStyle_main.modid + ":" + SHARINGAN_NAMES[i].toLowerCase());
		}
	}
	
	/**
	 * A method to manually update, since onUpdate is not called from custom inventory slots
	 */
	public static void onUpdateTick(ItemStack stack, World world)
	{
		if (!world.isRemote) {
			decrementCooldown(stack);
		}
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
		if (stack != null && stack.getItem() instanceof Sharingan && !player.worldObj.isRemote)
		{
			if (isCooling(stack)) {
				player.addChatMessage("Can't use " + stack.getItem().getUnlocalizedName(stack) + " for " + getCooldown(stack) + " more ticks.");
				return false;
			}
			
			player.addChatMessage("Sharingan was used!");

			switch(stack.getItemDamage()) {
			case SHARINGAN: return useGenericSharingan(stack, player);
			case TSUKUYOMI: return useTsukuyomi(stack, player);
			default: player.addChatMessage("No effect has been defined yet for this type of Sharingan. Sorry!"); break;
			}
		}

		return false;
	}
	
	/**
	 * Returns true if Sharingan stack is cooling down from use
	 */
	public static final boolean isCooling(ItemStack stack) {
		return stack.hasTagCompound() && stack.getTagCompound().hasKey(COOLDOWN) && stack.getTagCompound().getInteger(COOLDOWN) > 0;
	}
	
	/**
	 * Decrements cooldown timer for stack by 1
	 */
	public static final void decrementCooldown(ItemStack stack) {
		if (isCooling(stack)) stack.getTagCompound().setInteger(COOLDOWN, getCooldown(stack) - 1);
	}
	
	/**
	 * Returns time left for cooldown or 0 if not cooling down
	 */
	public static final int getCooldown(ItemStack stack) {
		return (isCooling(stack) ? stack.getTagCompound().getInteger(COOLDOWN) : 0);
	}
	
	/**
	 * Sets cooldown timer for stack
	 */
	public static final void setCooldown(ItemStack stack, int time)
	{
		if (stack.getTagCompound() == null) { stack.stackTagCompound = new NBTTagCompound(); }
		stack.getTagCompound().setInteger(COOLDOWN, time);
		System.out.println("[SHARINGAN] Cooldown set to " + getCooldown(stack));
	}
	
	/**
	 * Performs effects of generic Sharingan, i.e. slowing down entities around player
	 */
	private static final boolean useGenericSharingan(ItemStack stack, EntityPlayer player)
	{
		setCooldown(stack, 200); // 10 seconds
		
		List<EntityLivingBase> list = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, player.boundingBox.expand(10, 10, 10));
		
		if (!list.isEmpty()) {
			for (EntityLivingBase target : list) {
				if (target != player) {
					target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,100,0));
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Performs effects of Tsukuyomi on target that can see player and that player is looking at
	 */
	private static final boolean useTsukuyomi(ItemStack stack, EntityPlayer player)
	{
		float range = 32.0F;
		Vec3 vec3 = player.getLookVec().normalize();
		
		double targetX = player.posX;
		double targetY = player.posY + player.getEyeHeight() - 0.10000000149011612D;
		double targetZ = player.posZ;
		
		while (Math.abs(targetX) < (Math.abs(player.posX) + Math.abs(vec3.xCoord * range)))
		{
			targetX += vec3.xCoord;
			targetY += vec3.yCoord;
			targetZ += vec3.zCoord;
			
			List<EntityLivingBase> list = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(targetX-0.5F, targetY-0.5F, targetZ-0.5F, targetX+0.5F, targetY+0.5F, targetZ+0.5F));
			
			if (!list.isEmpty()) {
				for (EntityLivingBase target : list) {
					if (target != player && target.canEntityBeSeen(player)) {
						target.addPotionEffect(new PotionEffect(Potion.blindness.id,100,0));
						target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,100,3));
						setCooldown(stack, 1200); // one minute
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
