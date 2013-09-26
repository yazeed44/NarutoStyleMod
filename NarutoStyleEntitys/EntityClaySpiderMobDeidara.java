package NarutoStyleEntitys;

import NarutoStyle.NarutoStyle_main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityClaySpiderMobDeidara extends EntityCreature {

	int time = 0;
	
	
	public EntityClaySpiderMobDeidara(World par1World) {
		super(par1World);
		//this.setSize(0.3F, 0.7F);
		
		this.tasks.addTask(4, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false));
		
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.30D, false));
		this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, false));
	}
	
	
	public EntityClaySpiderMobDeidara(World par1World, double x, double y, double z)
	{
		super(par1World);
	
	this.setPosition(x, y, z);
	}
	

	protected void func_110147_ax()
	{
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3.0D);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(50.0D);
       
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30D);
        
	}
	public boolean isAIEnabled()
    {
        return true;
    }
	
	
	public void onLivingUpdate()
    {
		time++;
        super.onLivingUpdate();

        
        if (this.worldObj.getClosestPlayerToEntity(this, 1.5D) != null&&!worldObj.isRemote){
        	
        	this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 2.5F, true);
        	this.setDead();}
        
        
        
       
    }
	 @Override
	  public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
		  if (damageSource.isExplosion())
	  damageAmount = 0;
	 
	  
	
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }
	public void onDeath(DamageSource par1DamageSource)
    {
	  super.onDeath(par1DamageSource);
	  
	 
    }
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	
}
