package NarutoStyleEntitys;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityC4Mobs extends EntityCreature {

	int time = 0;
	public EntityC4Mobs(World par1World) {
		super(par1World);
		this.setSize(0.3F, 0.3F);
		this.tasks.addTask(4, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false));
		
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 1.35D, false));
		this.targetTasks.addTask(5, new EntityAIHurtByTarget(this, false));
	}

	public boolean isAIEnabled()
    {
        return true;
    }
	protected void func_110147_ax()
	{
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1.0D);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(60.0D);
     // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0D);
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35D);
        
	}
	
	public void onLivingUpdate()
    {
		time++;
        super.onLivingUpdate();
        if (this.worldObj.getClosestPlayerToEntity(this, 0.5D) != null){
        this.explode();
        
        }
        
        
        
    }
	@Override
	  public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
		  if (damageSource.isExplosion()){
	  damageAmount = 0;}
	 
	  
	
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }
	private  void explode()
    {

			if (!worldObj.isRemote){
				
			this.worldObj.createExplosion((Entity)this, this.posX, this.posY+2, this.posZ, 1.7F, false);
			
			this.setDead();
			}
    
    }
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	 
}
