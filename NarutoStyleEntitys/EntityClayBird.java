package NarutoStyleEntitys;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityClayBird extends EntityThrowable {


	public EntityClayBird(World par1World)
    {
        super(par1World);
    }

    public EntityClayBird(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityClayBird(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 0;

            

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }

        /*for (int i = 0; i < 8; ++i)
        {
            this.worldObj.spawnParticle("crit", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }*/

        if (!this.worldObj.isRemote)
		{
			this.setDead();
			if (!this.worldObj.isRemote)
			{
				//for (int i = 0; i < 8; ++i){
				this.worldObj.createExplosion((Entity)null, this.posX, this.posY, this.posZ, 1.5F, true);
			}}
		}
	
	   @Override
	   protected float getGravityVelocity() 
	   {
		   return 0.01F;
	   }

	   /**
	    * Velocity of entity; default value 1.5F for ThrowableEntity
	    */
	   @Override
	   protected float func_70182_d()
	   {
	   // It's now faster:
	   return 3F;
	   }

	
}
