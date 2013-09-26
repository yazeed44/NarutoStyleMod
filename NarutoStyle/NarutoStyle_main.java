package NarutoStyle;


import java.util.logging.Logger;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import NarutoStyleBlocks.TileEntityDeidaraClay;
import NarutoStyleEntitys.EntityC3;
import NarutoStyleEntitys.EntityC4Mob;
import NarutoStyleEntitys.EntityC4Mobs;
import NarutoStyleEntitys.EntityClayBird;
import NarutoStyleEntitys.EntityClaySpider;
import NarutoStyleEntitys.EntityClaySpiderDeidara;
import NarutoStyleEntitys.EntityClaySpiderMob;
import NarutoStyleEntitys.EntityClaySpiderMobDeidara;
import NarutoStyleEntitys.EntityDeidara;
import NarutoStyleEntitys.EntityDeidaraClone;
import NarutoStyleEntitys.EntityDeidaraExplosion;
import NarutoStyleEntitys.EntityFourthHokage;
import NarutoStyleEntitys.EntityFourthHokageKunai;
import NarutoStyleEntitys.EntitySharinganUser;
import NarutoStyleEntitys.EntitySmokeBomb;
import NarutoStyleEyeInventory.GuiHandler;
import NarutoStyleItems.C3;
import NarutoStyleItems.ClayBird;
import NarutoStyleItems.ClaySpider;
import NarutoStyleItems.MadaraArmor;
import NarutoStyleItems.gunbai;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = NarutoStyle_main.modid ,name="NarutoStyle",version = "Second Release")
@NetworkMod(clientSideRequired=true, serverSideRequired=false,
channels={"NarutoStyle"}, packetHandler = PacketHandler.class)

public class NarutoStyle_main {

	public static final Logger L = Logger.getLogger("NarutoStyle");
	public static Item gunbai;
	public static Item ClaySpider;
	public static Item MadaraHelmet;
	public static Item MadaraChestPlate;
	public static Item MadaraLegging;
	public static Item MadaraBoots;
	public static Item MadaraSkull;
	public static Block BlockMadaraSkull;
	public static Item ClayBird;
	public static Item C3;
	public static Item NarutoStylePainting;
	public static Item FourthHokageKunai;
	public static Item DeidaraHand;
	public static Item SmokeBomb;
	public static Item Sharingan;
	private static int modGuiIndex = 0;
	public static Item AkatsukiScroll;
	public static KonohaGen konohaGen = new KonohaGen(); 
	public static Item DeidaraHair;
	public static BiomeGenBase DeidaraArena;
	public static Block DeidaraClay;

	static KeyBinding[] key = {new KeyBinding("Eyes", Keyboard.KEY_M)};
    static boolean[] repeat = {false};
	

	// GUI indices:
	public static final int eyeGuiId = modGuiIndex++;

	
	
	
	@SidedProxy(clientSide="NarutoStyle.ClientProxy", serverSide="NarutoStyle.CommonProxy")
	public static CommonProxy Proxy;
	
	@Instance("NarutoStyle")
	public static NarutoStyle_main Instance = new NarutoStyle_main();
	public static final String modid = "NarutoStyle";
	static int startEntityId = 6001;
	public static CreativeTabs NarutoStyle = new CreativeTabs("NarutoStyle"){
		public ItemStack getIconItemStack(){
			return new ItemStack(ClaySpider);
		}
	};
	
	
	 
	@EventHandler
	public void load(FMLInitializationEvent event)
	{		
		
        L.setParent(FMLLog.getLogger());
		//introduction a new Enum
		EnumToolMaterial GunbaiTool = EnumHelper.addToolMaterial("Gunbai Tool", 0, 2000, 0, 4, 10);
		EnumArmorMaterial MadaraArmor = EnumHelper.addArmorMaterial("MadaraArmor", 20, new int []{2, 5, 3, 1}, 17);
		//EnumArt EnumNarutoStylePainting = EnumHelper.addArt("NarutoStylePainting", "UchihaMadara", 32, 32, 128, 128);
		
		//Key Binding and Registry
		
        
		
		
		// Introduction Items and armors
		gunbai = new gunbai(4001,GunbaiTool).setUnlocalizedName("gunbai").setCreativeTab(NarutoStyle);
		ClaySpider = new ClaySpider(4002).setUnlocalizedName("ClaySpider").setCreativeTab(NarutoStyle);
		MadaraHelmet = new MadaraArmor(4003,MadaraArmor,Proxy.addArmor("MadaraArmor"), 0).setUnlocalizedName("MadaraHelmet").setCreativeTab(NarutoStyle);
		MadaraChestPlate = new MadaraArmor(4004,MadaraArmor,Proxy.addArmor("MadaraArmor"),1).setUnlocalizedName("MadaraChestPlate").setCreativeTab(NarutoStyle);
		MadaraLegging = new MadaraArmor(4005,MadaraArmor,Proxy.addArmor("MadaraArmor"),2).setUnlocalizedName("MadaraLegs").setCreativeTab(NarutoStyle);
		MadaraBoots = new MadaraArmor(4006,MadaraArmor,Proxy.addArmor("MadaraArmor"),3).setUnlocalizedName("MadaraBoots").setCreativeTab(NarutoStyle);
		//MadaraSkull = new MadaraSkull(4007).setUnlocalizedName("MadaraSkull");
		//BlockMadaraSkull = new BlockMadaraSkull(4008,Material.cake).setUnlocalizedName("BlockMadaraSkull");
		ClayBird = new ClayBird(4009).setUnlocalizedName("ClayBird").setCreativeTab(NarutoStyle);
		C3 = new C3(4010).setUnlocalizedName("C3").setCreativeTab(NarutoStyle);
		//NarutoStylePainting = new NarutoStylePainting(4011).setUnlocalizedName("NarutoStylePainting");	
		FourthHokageKunai = new NarutoStyleItems.FourthHokageKunai(4012).setUnlocalizedName("FourthHokageKunai").setCreativeTab(NarutoStyle);
		DeidaraHand = new NarutoStyleItems.DeidaraHand(4013).setUnlocalizedName("DeidaraHand").setCreativeTab(NarutoStyle);
		//SmokeBomb = new NarutoStyleItems.SmokeBomb(4014).setUnlocalizedName("SmokeBomb").setCreativeTab(NarutoStyle);
		Sharingan = new NarutoStyleItems.Sharingan(4015).setUnlocalizedName("Sharingan").setCreativeTab(NarutoStyle);
		AkatsukiScroll = new NarutoStyleItems.AkatsukiScroll(4016).setUnlocalizedName("AkatsukiScroll").setCreativeTab(NarutoStyle);
		DeidaraHair = new NarutoStyleItems.DeidaraHair(4017).setUnlocalizedName("DeidaraHair").setCreativeTab(NarutoStyle);
		//DeidaraArena = new NarutoStyleBiomes.DeidaraArena(55).setColor(34234432).setBiomeName("Deidara Arena ").setDisableRain().setMinMaxHeight(0.2F, 1.0F);		
		DeidaraClay = new NarutoStyleBlocks.DeidaraClay(4018, Material.grass).setUnlocalizedName("DeidaraClay").setCreativeTab(NarutoStyle).setHardness(100.0F).setResistance(100.0F);
		
		//Game Registry
		//GameRegistry.registerBlock(BlockMadaraSkull, "BlackMadaraSkull");
		GameRegistry.registerBlock(DeidaraClay, "DeidaraClay");
		GameRegistry.registerTileEntity(TileEntityDeidaraClay.class, "Spawnning Deidara");
		//Language Registrys
		LanguageRegistry.addName(gunbai, "Gunbai");
		LanguageRegistry.addName(ClaySpider, "Clay Spider");
		LanguageRegistry.addName(MadaraHelmet, "Madara Helmet");
		LanguageRegistry.addName(MadaraChestPlate, "Madara ChestPlate");
		LanguageRegistry.addName(MadaraLegging, "Madara Legging");
		LanguageRegistry.addName(MadaraBoots, "Madara Boots");
		//LanguageRegistry.addName(MadaraSkull,"Madara Skull");
		//LanguageRegistry.addName(BlockMadaraSkull, "Block Madara Skull");
		LanguageRegistry.addName(ClayBird, "Clay Bird");
		LanguageRegistry.addName(C3, "C3");
	    //LanguageRegistry.addName(NarutoStylePainting, "Naruto Painting");
		LanguageRegistry.addName(FourthHokageKunai, "Fourth Hokage Kunai");
		LanguageRegistry.instance().addStringLocalization("Deidara","Deidara");
		LanguageRegistry.addName(DeidaraHand, "Deidara Hand");
		LanguageRegistry.instance().addStringLocalization("itemGroup.NarutoStyle", "Naruto Style");
		
		//LanguageRegistry.addName(SmokeBomb, "Smoke Bomb");
		LanguageRegistry.addName(Sharingan, "Sharingan");
		LanguageRegistry.addName(AkatsukiScroll, "Akatsuki Scroll");
		LanguageRegistry.addName(DeidaraHair, "Deidara Hair");
		LanguageRegistry.addName(DeidaraClay, "Deidara Clay");
		
		
		
		
		
		// LanguageRegistry for mobs
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.Deidara.name", "Deidara");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.DeidaraExplosion.name", "DeidaraExplosion");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.SharinganUser.name", "Sharingan User");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.C4.name", "C4");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.C4Mobs.name", "C4 Mobs");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.ClaySpiderMobDeidara.name", "Clay Spider");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.FourthHokage.name", "Fourth Hokage"); 
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.DeidaraClone.name", "Deidara Clone");
		LanguageRegistry.instance().addStringLocalization("entity.NarutoStyle.ClaySpiderMobDeidara.name", "Clay Spider");
		
		//EntityRegistry
		EntityRegistry.registerModEntity(EntityClaySpider.class, "BoomBoom", 5001, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityClayBird.class, "Boom", 5002, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityC3.class, "BOOOOMBOOOOM", 5003, this, 40, 3, true);
		//EntityRegistry.registerGlobalEntityID(EntityNarutoStylePainting.class, "Painting", EntityRegistry.findGlobalUniqueEntityId());
	    //EntityRegistry.registerModEntity(EntityNarutoStylePainting.class, "Painting", EntityRegistry.findGlobalUniqueEntityId(), this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFourthHokageKunai.class, "Teleport", 5005, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityDeidara.class, "Deidara", 5006, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityDeidaraClone.class, "DeidaraClone", 5007, this, 40, 3, true);
		//EntityRegistry.addSpawn(EntityDeidara.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert,BiomeGenBase.forest,BiomeGenBase.plains,BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityFourthHokage.class,1, 0, 1, EnumCreatureType.monster, BiomeGenBase.plains);
		
		//EntityRegistry.registerModEntity(EntitySmokeBomb.class, "Smooooke", 5008, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityDeidaraExplosion.class, "DeidaraExplosion", 5009, this, 40, 3, true);
		
		
		
		EntityRegistry.registerModEntity(EntityClaySpiderMob.class, "ClaySpiderMob", 5011, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityClaySpiderDeidara.class, "ClaySpiderDeidara", 5012, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityClaySpiderMobDeidara.class, "ClaySpiderMobDeidara", 5013, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntitySharinganUser.class, "SharinganUser", 5014, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityC4Mob.class, "C4", 5015, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityC4Mobs.class, "C4Mobs", 5016, this, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFourthHokage.class, "FourthHokage", 5017, this, 40, 3, true);
        //Egg  Registry
		registerEntityEgg(EntitySharinganUser.class, 0x240000, 0xD41919);
		registerEntityEgg(EntityDeidara.class, 0x240000, 0xD41919);		
		registerEntityEgg(EntityDeidaraExplosion.class, 0x240000, 0xD41919);
		registerEntityEgg(EntityC4Mob.class, 0x240000, 0xD41919);
		registerEntityEgg(EntityC4Mobs.class, 0x240000, 0xD41919);
		registerEntityEgg(EntityClaySpiderMobDeidara.class, 0x240000, 0xD41919);
		registerEntityEgg(EntityFourthHokage.class, 0x240000, 0xD41919);
		registerEntityEgg(EntityDeidaraClone.class, 0x240000, 0xD41919);
		// Misc
		

		NarutoStyleCrafting.addRecipes();

        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
        TickRegistry.registerTickHandler(new NarutoTickHandler(), Side.SERVER);
        Proxy.registerRenderers();
		Proxy.registerEvents();
		//GameRegistry.addBiome(DeidaraArena);
		KeyBindingRegistry.registerKeyBinding(new EyesKey(key, repeat));
		 GameRegistry.registerWorldGenerator(konohaGen);
		
	    
		
		//Villager Registry
		 
		
	


}
	
	
	public static int getUniqueEntityId() 
	{
	do 
	{
	startEntityId++;
	} 
	while (EntityList.getStringFromID(startEntityId) != null);

	return startEntityId;
	}
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	{
	int id = getUniqueEntityId();
	EntityList.IDtoClassMapping.put(id, entity);
	EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
