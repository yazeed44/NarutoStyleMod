package NarutoStyleEntitys;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityC4Mob extends EntityMob {
	private int countown = 5 * 20;
	
	public EntityC4Mob(World par1World) {
		super(par1World);
		this.yOffset *= 6.0F;
		
		this.setSize(this.width * 6.0F, this.height * 6.0F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 4, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.24D, false));
	}

	public boolean isAIEnabled()
    {
        return true;
    }
	protected void func_110147_ax()
	{
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(60.0D);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(60.0D);
        // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0D);
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.24D);
        // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.0D);
	}
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	public float getBlockPathWeight(int par1, int par2, int par3)
    {
        return this.worldObj.getLightBrightness(par1, par2, par3) - 0.5F;
    }
	
	public void onLivingUpdate()
    {
		countown--;
        super.onLivingUpdate();
        
        
        if (this.worldObj.getClosestPlayerToEntity(this, 6D) != null){
        	this.spawnMobs();
        }
        /*if (countown == 0){
        	
        }*/
        
        }
	@Override
	  public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
		  if (damageSource.isExplosion()){
	  damageAmount = 0;}
	 
	  
	
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }
	
       
	
	public void onDeath(DamageSource par1DamageSource)
    {
	  super.onDeath(par1DamageSource);
	  }
		
	public void spawnMobs(){
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		this.Explosion();
		  EntityC4Mobs mobs = new EntityC4Mobs(worldObj);
			mobs.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs2 = new EntityC4Mobs(worldObj);
			mobs2.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs3 = new EntityC4Mobs(worldObj);
			mobs3.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs4 = new EntityC4Mobs(worldObj);
			mobs4.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs5 = new EntityC4Mobs(worldObj);
			mobs5.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs6 = new EntityC4Mobs(worldObj);
			mobs6.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs7 = new EntityC4Mobs(worldObj);
			mobs7.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs8 = new EntityC4Mobs(worldObj);
			mobs8.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs9 = new EntityC4Mobs(worldObj);
			mobs9.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs10 = new EntityC4Mobs(worldObj);
			mobs10.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs11 = new EntityC4Mobs(worldObj);
			mobs11.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs12 = new EntityC4Mobs(worldObj);
			mobs12.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs13 = new EntityC4Mobs(worldObj);
			mobs13.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs14 = new EntityC4Mobs(worldObj);
			mobs14.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs15 = new EntityC4Mobs(worldObj);
			mobs15.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs16 = new EntityC4Mobs(worldObj);
			mobs16.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs17 = new EntityC4Mobs(worldObj);
			mobs17.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs18 = new EntityC4Mobs(worldObj);
			mobs18.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs19 = new EntityC4Mobs(worldObj);
			mobs19.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs20 = new EntityC4Mobs(worldObj);
			mobs20.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs21 = new EntityC4Mobs(worldObj);
			mobs21.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs22 = new EntityC4Mobs(worldObj);
			mobs22.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs23 = new EntityC4Mobs(worldObj);
			mobs23.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs24 = new EntityC4Mobs(worldObj);
			mobs24.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs25 = new EntityC4Mobs(worldObj);
			mobs25.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs26 = new EntityC4Mobs(worldObj);
			mobs26.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs27 = new EntityC4Mobs(worldObj);
			mobs27.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs28 = new EntityC4Mobs(worldObj);
			mobs28.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs29 = new EntityC4Mobs(worldObj);
			mobs29.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs30 = new EntityC4Mobs(worldObj);
			mobs30.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs31 = new EntityC4Mobs(worldObj);
			mobs31.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs32 = new EntityC4Mobs(worldObj);
			mobs32.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs33 = new EntityC4Mobs(worldObj);
			mobs33.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs34 = new EntityC4Mobs(worldObj);
			mobs34.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs35 = new EntityC4Mobs(worldObj);
			mobs35.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs36 = new EntityC4Mobs(worldObj);
			mobs36.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs37 = new EntityC4Mobs(worldObj);
			mobs37.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs38 = new EntityC4Mobs(worldObj);
			mobs38.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs39 = new EntityC4Mobs(worldObj);
			mobs39.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs40 = new EntityC4Mobs(worldObj);
			mobs40.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs41 = new EntityC4Mobs(worldObj);
			mobs41.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs42 = new EntityC4Mobs(worldObj);
			mobs42.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs43 = new EntityC4Mobs(worldObj);
			mobs43.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs44 = new EntityC4Mobs(worldObj);
			mobs44.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs45 = new EntityC4Mobs(worldObj);
			mobs45.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs46 = new EntityC4Mobs(worldObj);
			mobs46.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs47 = new EntityC4Mobs(worldObj);
			mobs47.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs48 = new EntityC4Mobs(worldObj);
			mobs48.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs49 = new EntityC4Mobs(worldObj);
			mobs49.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			EntityC4Mobs mobs50 = new EntityC4Mobs(worldObj);
			mobs50.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
			
			
			if (!worldObj.isRemote){
				player.addChatMessage("Beware of Micro C4 ");
				worldObj.spawnEntityInWorld(mobs);
				worldObj.spawnEntityInWorld(mobs2);
				worldObj.spawnEntityInWorld(mobs3);
				worldObj.spawnEntityInWorld(mobs4);
				worldObj.spawnEntityInWorld(mobs5);
				worldObj.spawnEntityInWorld(mobs6);
				worldObj.spawnEntityInWorld(mobs7);
				worldObj.spawnEntityInWorld(mobs8);
				worldObj.spawnEntityInWorld(mobs9);
				worldObj.spawnEntityInWorld(mobs10);
				worldObj.spawnEntityInWorld(mobs11);
				worldObj.spawnEntityInWorld(mobs12);
				worldObj.spawnEntityInWorld(mobs13);
				worldObj.spawnEntityInWorld(mobs14);
				worldObj.spawnEntityInWorld(mobs15);
				worldObj.spawnEntityInWorld(mobs16);
				worldObj.spawnEntityInWorld(mobs17);
				worldObj.spawnEntityInWorld(mobs18);
				worldObj.spawnEntityInWorld(mobs19);
				worldObj.spawnEntityInWorld(mobs20);
				worldObj.spawnEntityInWorld(mobs21);
				worldObj.spawnEntityInWorld(mobs22);
				worldObj.spawnEntityInWorld(mobs23);
				worldObj.spawnEntityInWorld(mobs24);
				worldObj.spawnEntityInWorld(mobs25);
				worldObj.spawnEntityInWorld(mobs26);
				worldObj.spawnEntityInWorld(mobs27);
				worldObj.spawnEntityInWorld(mobs28);
				worldObj.spawnEntityInWorld(mobs29);
				worldObj.spawnEntityInWorld(mobs30);
				worldObj.spawnEntityInWorld(mobs31);
				worldObj.spawnEntityInWorld(mobs32);
				worldObj.spawnEntityInWorld(mobs33);
				worldObj.spawnEntityInWorld(mobs34);
				worldObj.spawnEntityInWorld(mobs35);
				worldObj.spawnEntityInWorld(mobs36);
				worldObj.spawnEntityInWorld(mobs37);
				worldObj.spawnEntityInWorld(mobs38);
				worldObj.spawnEntityInWorld(mobs39);
				worldObj.spawnEntityInWorld(mobs40);
				worldObj.spawnEntityInWorld(mobs41);
				worldObj.spawnEntityInWorld(mobs42);
				worldObj.spawnEntityInWorld(mobs43);
				worldObj.spawnEntityInWorld(mobs44);
				worldObj.spawnEntityInWorld(mobs45);
				worldObj.spawnEntityInWorld(mobs46);
				worldObj.spawnEntityInWorld(mobs47);
				worldObj.spawnEntityInWorld(mobs48);
				worldObj.spawnEntityInWorld(mobs49);
				worldObj.spawnEntityInWorld(mobs50);
				
				this.setDead();
				
			}
	}
	  
			
			public void Explosion(){
				for (int i = 0; i < 32; ++i)
	            {
	        	double f3 = 0.25;
	  			this.worldObj.spawnParticle("hugeexplosion",
	        			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
	        			   this.posY - this.motionY * (double)f3 - 0.5D,
	        			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
	        			   1, 1, 0);
	  			this.worldObj.spawnParticle("hugeexplosion",
	  	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
	  	      			   this.posY - this.motionY * (double)f3 - 0.5D + 5,
	  	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
	  	      			   1, 1, 0);
	        	
	  			this.worldObj.spawnParticle("hugeexplosion",
	  	      			   this.posX - this.motionX * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
	  	      			   this.posY - this.motionY * (double)f3 - 0.5D + 10,
	  	      			   this.posZ - this.motionZ * (double)f3 + this.rand.nextDouble() * 0.6D - 0.3D,
	  	      			   1, 1, 0);
	            }
			}
				
				
			
   
      
    
}
