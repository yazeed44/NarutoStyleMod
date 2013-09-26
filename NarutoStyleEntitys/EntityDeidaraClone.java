package NarutoStyleEntitys;

import NarutoStyle.NarutoStyle_main;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDeidaraClone extends EntityMob implements IRangedAttackMob {
	int time = 0;
	int time2 =0;
	
	
	public EntityDeidaraClone(World par1World) {
		super(par1World);
		
		this.setSize(0.6F, 1.8F);
		//this.setSize(this.width * 6.0F, this.height * 6.0F);
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class,0, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true, true));
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.3D, 20, 10.0F));
        
        //this.prevHealth = health;
       // this.setEntityHealth(health);
	}

	 
	public boolean isAIEnabled()
    {
        return true;
    }
	
	protected void func_110147_ax()
	{
		double health = 50D;
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(health);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(64.0D);
        // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(0.0D);
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30D);
        // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0D);
	}
	
	
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
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
		  time2++;
	        super.onLivingUpdate();

	       
           if (time2 == 1000){
        	   this.ExplodeAndKill();
           }

           super.findPlayerToAttack();
	        //}

	    }
	  
	  public void onDeath(DamageSource par1DamageSource)
	    {
		  super.onDeath(par1DamageSource);
	        
	       
	        
		       

	        
	        
	
	           }
	        
	    
	       
	      


	  private void ExplodeAndKill(){
		  if (!worldObj.isRemote){
		  worldObj.createExplosion((Entity)null, this.posX,this.posY, this.posZ, 5F, true);
   	   this.setDead();}
	  }
	  
	 
	
	
	  /**
	  * Called when the entity is attacked.
	  */
	  @Override
	  public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
		  EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		  if (damageSource.isExplosion())
	  damageAmount = 0;
		  
		  if (super.attackEntityFrom(damageSource, damageAmount))
	        {
	            Entity entity = damageSource.getEntity();

	           
	                if (entity != this)
	                {
	                    this.entityToAttack = player;
	                }

	                return true;
	            }
	  
	
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }
	  
	    

	
	

	public EnumCreatureAttribute getCreatureAttribute(){
		return EnumCreatureAttribute.UNDEAD;
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
    {
		time++;
		
		
	
    	
		while (time == 10){
			EntityClaySpiderDeidara clayspider = new EntityClaySpiderDeidara(this.worldObj,this);
        double d0 = par1EntityLivingBase.posX - this.posX;
        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - clayspider.posY;
        double d2 = par1EntityLivingBase.posZ - this.posZ;
        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
        clayspider.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        //this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(clayspider);
        time = 0;}
		
    
		
        EntityClayBird claybird = new EntityClayBird(this.worldObj, this);
        double d0 = par1EntityLivingBase.posX - this.posX;
        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - claybird.posY;
        double d2 = par1EntityLivingBase.posZ - this.posZ;
        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
        claybird.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
        //this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(claybird);
        
    }
	public double getYOffset()
    {
        return super.getYOffset() - 0.5D;
    }
}
