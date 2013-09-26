package NarutoStyleEntitys;

import java.util.List;

import NarutoStyle.NarutoStyle_main;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySharinganUser extends EntityMob {
Boolean time = true;
	public EntitySharinganUser(World par1World) {
		super(par1World);
		//this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 4, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.38D, false));
	}
	public boolean isAIEnabled()
    {
        return true;
    }
	protected void func_110147_ax()
	{
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(50.0D);
        // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(0.0D);
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.38D);
        // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(15.0D);
	}
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	 protected void dropFewItems(boolean par1, int par2)
	    {
	       this.dropItem(NarutoStyle_main.Sharingan.itemID, 1);
	       
	    }
	 public void onLivingUpdate()
	    {
	        super.onLivingUpdate();
	        
	       
             }
	 public EnumCreatureAttribute getCreatureAttribute(){
			return EnumCreatureAttribute.UNDEAD;
		}
	  @Override
	  public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
		  if (damageSource.getEntity()instanceof EntityPlayer)
              this.Sharingan();
	  
	 
	  
	
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }
	 public double getYOffset()
	    {
	        return super.getYOffset() - 0.5D;
	    }
	 public void func_70844_e(boolean par1)
	    {
	        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

	        if (par1)
	        {
	            b0 = (byte)(b0 | 1);
	        }
	        else
	        {
	            b0 &= -2;
	        }

	        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
	    }
	  public boolean func_70845_n()
	    {
	        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
	    }
	 public void Sharingan (){
		 
		 List<EntityPlayer> entl = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(15,15,15));
         if (entl != null && entl.size() > 0) {
          for (EntityPlayer el : entl) {
           if (el != null && el instanceof EntityPlayer){
                                  el.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,50,2));
                                 
           }}}
	 }
}
