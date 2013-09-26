package NarutoStyle;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
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
import NarutoStyleModels.ModelC4Mobs;
import NarutoStyleModels.ModelClaySpiderMob;
import NarutoStyleModels.ModelNarutoStyle;
import NarutoStyleRender.RenderC3;
import NarutoStyleRender.RenderC4Mob;
import NarutoStyleRender.RenderC4Mobs;
import NarutoStyleRender.RenderClayBird;
import NarutoStyleRender.RenderClaySpider;
import NarutoStyleRender.RenderClaySpiderMob;
import NarutoStyleRender.RenderClaySpiderMobDeidara;
import NarutoStyleRender.RenderDeidara;
import NarutoStyleRender.RenderDeidaraClone;
import NarutoStyleRender.RenderDeidaraExplosion;
import NarutoStyleRender.RenderDeidaraHand;
import NarutoStyleRender.RenderFourthHokage;
import NarutoStyleRender.RenderFourthHokageKunai;
import NarutoStyleRender.RenderSharinganUser;
import NarutoStyleRender.RenderSmokeBomb;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;


public class ClientProxy extends CommonProxy   {

	public static RenderDeidaraHand RenderHand = new RenderDeidaraHand();
	
	@Override
	public  void registerRenderers()
	{
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityClaySpider.class, new RenderClaySpider(NarutoStyle_main.ClaySpider));
		RenderingRegistry.registerEntityRenderingHandler(EntityClayBird.class, new RenderClayBird(NarutoStyle_main.ClayBird));
		RenderingRegistry.registerEntityRenderingHandler(EntityC3.class, new RenderC3(NarutoStyle_main.C3));
		//RenderingRegistry.registerEntityRenderingHandler(EntityNarutoStylePainting.class, new RenderNarutoStylePainting(NarutoStyle_main.NarutoStylePainting));
		RenderingRegistry.registerEntityRenderingHandler(EntityFourthHokageKunai.class, new RenderFourthHokageKunai(NarutoStyle_main.FourthHokageKunai));
		MinecraftForgeClient.registerItemRenderer(NarutoStyle_main.DeidaraHand.itemID, RenderHand);
		RenderingRegistry.registerEntityRenderingHandler(EntitySmokeBomb.class, new RenderSmokeBomb(NarutoStyle_main.SmokeBomb));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeidara.class, new RenderDeidara(new ModelNarutoStyle(),0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeidaraExplosion.class, new RenderDeidaraExplosion(new ModelNarutoStyle(),0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityClaySpiderMob.class, new RenderClaySpiderMob(new ModelClaySpiderMob(),0.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityClaySpiderDeidara.class, new RenderClaySpider(NarutoStyle_main.ClaySpider));
		RenderingRegistry.registerEntityRenderingHandler(EntityClaySpiderMobDeidara.class, new RenderClaySpiderMobDeidara(new ModelClaySpiderMob(),0.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntityC4Mob.class, new RenderC4Mob(new ModelNarutoStyle(),0.3F, 5));
		RenderingRegistry.registerEntityRenderingHandler(EntityC4Mobs.class, new RenderC4Mobs(new ModelC4Mobs(),0.1F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySharinganUser.class, new RenderSharinganUser(new ModelNarutoStyle(),0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeidaraClone.class, new RenderDeidaraClone(new ModelNarutoStyle(),0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFourthHokage.class, new RenderFourthHokage(new ModelNarutoStyle(),0.3F));
		
	}
	
	@Override
    public void registerEvents()
    {
            MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	@Override
    public void onInit(FMLInitializationEvent evt) {
        super.onInit(evt);
        
        
        
}}
