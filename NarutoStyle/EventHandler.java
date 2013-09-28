package NarutoStyle;


import NarutoStyleEyeInventory.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EventHandler
{
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null)
				ExtendedPlayer.register((EntityPlayer) event.entity);
		}
	}


	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			ExtendedPlayer.loadProxyData((EntityPlayer) event.entity);
		}
	}
	
	@ForgeSubscribe
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			ExtendedPlayer.saveProxyData((EntityPlayer) event.entity);
		}
	}
	
	@ForgeSubscribe
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ExtendedPlayer.get(player).sharingan.onUpdateTick(player.worldObj);
		}
	}
}
		
		
	

		
	 
		 
	
