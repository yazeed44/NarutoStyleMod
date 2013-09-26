package NarutoStyleEntitys;





import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDeidaraExplosion extends EntityMob {

	public int time = 0;
	
	public EntityDeidaraExplosion(World par1World) {
		super(par1World);
		
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityPlayer.class, 0F, 0D, 0));
		
	}

	public EntityDeidaraExplosion(World par1World, double x, double y, double z)
	{
		super(par1World);
	
	this.setPosition(x, y, z);
	}
	
	protected void func_110147_ax()
	{
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(Double.MAX_VALUE);}
	public boolean isAIEnabled()
    {
        return true;
    }
	 /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }

	
	 
	
	public void onLivingUpdate()
    {
		
        super.onLivingUpdate();
        this.explode();
        
        
        
    }
	 protected void entityInit()
	    {
	        super.entityInit();
	        this.dataWatcher.addObject(16, new Byte((byte)0));
	    }

	
	
	
	
	private  void explode()
    {
		time++;

		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		
        
		if (time == 10*2&&!worldObj.isRemote)
		player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 20*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 30*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 40*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 50*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 60*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 70*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 80*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 90*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 100*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 110*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 120*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 130*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 140*2&&!worldObj.isRemote)
			player.addChatMessage("\u00A76" +time/20 + "");
		
		if (time == 150*2&&!worldObj.isRemote){
			player.addChatMessage("\u00A76" + "Katsuuuuuuuuuuuu");
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX+10, this.posY, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX+20, this.posY, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ+10, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ+20, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX-10, this.posY, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX-20, this.posY, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ-10, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ-20, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY+10, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY+15, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY+20, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY+30, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY+40, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY-10, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY-20, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY-30, this.posZ, 50F, true);
			this.worldObj.createExplosion((Entity)null, this.posX, this.posY-40, this.posZ, 50F, true);
			
            this.setDead();}}

	@Override
	  public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
	  if (damageSource.getEntity() instanceof EntityPlayer){
	     damageAmount = 0;}
	  
	  
	  
		  
		  
		  
	 
	 
	  
	 
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }

	}
			
		
		   
    
	

