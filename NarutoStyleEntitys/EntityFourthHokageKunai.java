package NarutoStyleEntitys;

import NarutoStyle.NarutoStyle_main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityFourthHokageKunai extends EntityThrowable {
	public boolean f = true;
	
	public EntityFourthHokageKunai(World par1World)
    {
        super(par1World);
        
        
        
    }

    public EntityFourthHokageKunai(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    @SideOnly(Side.CLIENT)
    public EntityFourthHokageKunai(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

	
	public void onUpdate()
{
   super.onUpdate();
   

   
       }
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 5.5F);
        }

        /*for (int i = 0; i < 32; ++i)
        {
        	double f3 = 0.25;
			this.worldObj.spawnParticle("reddust",
        			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
        			   this.posY - this.motionY * (double)f3 - 0.5D,
        			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
        			   1, 1, 0);*/
        for (int i = 0; i < 32; ++i)
        {
    	double f3 = 0.25;
			this.worldObj.spawnParticle("reddust",
    			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
    			   this.posY - this.motionY * (double)f3 - 0.5D + 1,
    			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
    			   1, 1, 0);
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D + 1,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   1, 1, 0);
    	
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D + 0.5,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   1, 1, 0);
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D - 1,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   1, 1, 0);
 	
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D - 0.5,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   1, 1, 0);
       
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D + 1 ,
	      			   1, 1, 0);
 	
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D + 0.5,
	      			   1, 1, 0);
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D - 1,
	      			   1, 1, 0);
	
			this.worldObj.spawnParticle("reddust",
	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D ,
	      			   this.posY - this.motionY * (double)f3 - 0.5D ,
	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D -0.5 ,
	      			   1, 1, 0);
	
        	
     
        }

        
        if (!this.worldObj.isRemote)
        {
        	
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.getThrower();

                if (!entityplayermp.playerNetServerHandler.connectionClosed && entityplayermp.worldObj == this.worldObj)
                {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!MinecraftForge.EVENT_BUS.post(event))
                    {
                        if (this.getThrower().isRiding())
                        {
                            this.getThrower().mountEntity((Entity)null);
                        }
    
                        this.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                        this.getThrower().fallDistance = 0.0F;
                        this.entityDropItem(new ItemStack(NarutoStyle_main.FourthHokageKunai), 1);
                        //this.getThrower().attackEntityFrom(DamageSource.fall, event.attackDamage);
                    }
                }
            }

            this.setDead();
        }
    }
    
    @Override
	   protected float getGravityVelocity() 
	   {
		   return 0.01F;
	   }
    
    @Override
	   protected float func_70182_d()
	   {
	   // It's now faster:
	   return 4F;
	   }
}
