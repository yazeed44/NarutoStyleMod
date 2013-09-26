package NarutoStyleEntitys;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySmokeBomb extends EntityThrowable {

	public EntitySmokeBomb(World par1World)
    {
        super(par1World);
    }

    public EntitySmokeBomb(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntitySmokeBomb(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	for (int l = 0; l < 100; ++l) // where 'x' is however many you want to spawn
    	{
    	
    		/*this.worldObj.spawnParticle("largesmoke", this.posX + this.motionX * (double)l / 4.0D, 
    				this.posY + this.motionY * (double)l / 2.0D, 
    				this.posZ + this.motionZ * (double)l / 2.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);*/
    		
    		double f3 = 0.25;
  			this.worldObj.spawnParticle("largesmoke",
        			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.1D + 0.5,
        			   this.posY - this.motionY * (double)f3 - 0.5D,
        			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.1D + 0.5,
        			   1, 1, 0);
  			this.worldObj.spawnParticle("largesmoke",
  	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.1D,
  	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
  	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.1D,
  	      			   1, 1, 0);
        	
  			this.worldObj.spawnParticle("largesmoke",
  	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.1D,
  	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
  	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.1D,
  	      			   1, 1, 0);
  			
  			
  			
  			
  			
  			
  			
  			
  			
  			this.worldObj.spawnParticle("largesmoke",
     			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.1D ,
     			   this.posY - this.motionY * (double)f3 - 0.5D* 0.1,
     			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.1D ,
     			   1, 1, 0);
			this.worldObj.spawnParticle("largesmoke",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.1D ,
	      			   this.posY - this.motionY * (double)f3 - 0.5D* 0.1 ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.1D ,
	      			   1, 1, 0);
     	
			this.worldObj.spawnParticle("largesmoke",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.1D ,
	      			   this.posY - this.motionY * (double)f3 - 0.5D * 0.1 ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.1D ,
	      			   1, 1, 0);
    	}


    /*if (!this.worldObj.isRemote)
    {
    this.setDead();
    }*/
    }

        
		
	
	   

	
}
