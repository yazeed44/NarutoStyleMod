package NarutoStyleEntitys;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityClaySpiderDeidara extends EntityThrowable
{
    public EntityClaySpiderDeidara(World par1World)
    {
        super(par1World);
    }

    public EntityClaySpiderDeidara(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityClaySpiderDeidara(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	
    	

        if (!worldObj.isRemote)
        {
        	EntityClaySpiderMobDeidara mob = new EntityClaySpiderMobDeidara(worldObj);
        	mob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        	worldObj.spawnEntityInWorld(mob);
            this.setDead();
		     
            
            
       }
    }
}
