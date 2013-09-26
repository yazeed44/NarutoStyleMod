package NarutoStyle;


import cpw.mods.fml.common.event.FMLInitializationEvent;


public class CommonProxy  {

	/** Used to store IExtendedEntityProperties data temporarily between player death and respawn or dimension change */
	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void registerRenderers() {}
	
	// This should be done in the main mod as well
	public void registerEvents()
	 
	public int addArmor(String string) {
		 return 0;
	}
	
	// What's this doing here? These kinds of methods belong in the main class with @EventHandler notation
	public void onInit(FMLInitializationEvent evt) {}
	
	/**
	 * Adds an entity's custom data to the map for temporary storage
	 */
	public static void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
	}

	/**
	 * Removes the compound from the map and returns the NBT tag stored for name or null if none exists
	 */
	public static NBTTagCompound getEntityData(String name) {
		return extendedEntityData.remove(name);
	}
}
