package NarutoStyleEntitys;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import NarutoStyle.NarutoStyle_main;

public class EntityFourthHokage extends EntityMob  implements IMerchant     {

	



	Village villageObj;
	 private int homeCheckTimer;
	 /** This villager's current customer. */
	    private EntityPlayer buyingPlayer;

	    private EntityPlayer player;
	    /** Initialises the MerchantRecipeList.java */
	    private MerchantRecipeList buyingList;
	    private int timeUntilReset;

	    /** addDefaultEquipmentAndRecipies is called if this is true */
	    private boolean needsInitilization;
	    private int wealth;

	    /** Last player to trade with this villager, used for aggressivity. */
	    private String lastBuyingPlayer;
	    private boolean field_82190_bM;
	    private float field_82191_bN;
	    Class c = EntityRenderer.class;
	    Object o = Minecraft.getMinecraft().entityRenderer;

	public EntityFourthHokage(World par1World) {
		super(par1World);
		this.tasks.addTask(7, new EntityAILookIdle(this));
		//this.tasks.addTask(6, new EntityAIWander(this, 1.1D));
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this,1.35D, true));
		this.tasks.addTask(5, new EntityAISwimming(this));
		//this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.4D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.1D));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        //this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySpider.class, 20, true, true));
		
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 20, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 20, true));
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 20, true));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySpider.class, 20, true));
        this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 20, true));
        
	   
	

	}
	public boolean isAIEnabled()
    {
        return true;
    }
	protected void func_110147_ax()
	{
		
        super.func_110147_ax();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200D);
        // Follow Range - default 32.0D - min 0.0D - max 2048.0D
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(128.0D);
        // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0D);
        // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35D);
        // Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(20D);
	}
	
	protected boolean canDespawn()
    {
        return false;
    }

	/*protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }*/

	 /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
    	this.player = par1EntityPlayer;
        ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
        boolean flag = itemstack != null && itemstack.itemID == Item.monsterPlacer.itemID;

        if (!flag && this.isEntityAlive() && !this.isTrading() && !this.isChild())
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(par1EntityPlayer);
                par1EntityPlayer.displayGUIMerchant(this, "Fourth Hokage");
                
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }
   

	@Override
	public void setCustomer(EntityPlayer entityplayer) {
		
		this.buyingPlayer = entityplayer;
	}



	@Override
	public EntityPlayer getCustomer() {
		
		return this.buyingPlayer;
	}

	public void onLivingUpdate()
    {
        super.onLivingUpdate();
        
       
         }

	@Override
	public MerchantRecipeList getRecipes(EntityPlayer entityplayer) {
		
		MerchantRecipeList merchantrecipelist;
        merchantrecipelist = new MerchantRecipeList();
        merchantrecipelist.add(new MerchantRecipe(new ItemStack(Item.ingotGold, 16, 8229), new ItemStack(NarutoStyle_main.FourthHokageKunai, 2, 7)));
		return merchantrecipelist;
        
	}



	@Override
	public void setRecipes(MerchantRecipeList merchantrecipelist) {
		
		merchantrecipelist.add(new MerchantRecipe(new ItemStack(NarutoStyle_main.FourthHokageKunai, 1, 7), new ItemStack(Item.potion, 1, 8229)));
	}



	@Override
	public void useRecipe(MerchantRecipe merchantrecipe) {

       /* if (merchantrecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1)))
        {
            this.timeUntilReset = 40;
            this.needsInitilization = true;

            if (this.buyingPlayer != null)
            {
                this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
            }
            else
            {
                this.lastBuyingPlayer = null;
            }
        }*/

		
	}


	 /*/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        
        par1NBTTagCompound.setInteger("Riches", this.wealth);

        if (this.buyingList != null)
        {
            par1NBTTagCompound.setCompoundTag("Offers", this.buyingList.getRecipiesAsTags());
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        
        this.wealth = par1NBTTagCompound.getInteger("Riches");

        if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound nbttagcompound1 = par1NBTTagCompound.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(nbttagcompound1);
        }
    }*/
    public boolean attackEntityFrom(DamageSource damageSource, float damageAmount)
	  {
    	EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		  if (damageSource.getEntity() instanceof EntityPlayer){
			  damageAmount = 0;
			  player.setPositionAndUpdate(player.posX + 60, player.posY+5,player.posZ + 60);
			  this.setDead();
			  

      // ReflectionHelper.setPrivateValue(c, o, 5D, 36);

		  }
	  
	
	  super.attackEntityFrom(damageSource, damageAmount);
	  return false;
	  }
	@Override
	public void func_110297_a_(ItemStack itemstack) {
		
		
	}
	public boolean isTrading()
    {
        return this.buyingPlayer != null;
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
	  @Override
	  public boolean getCanSpawnHere()
	    {
		 if (this.rand.nextFloat() < 0.009){
			 return true;
		 }
		 else return false;
	        		
	    }

	    /**
	     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
	     */
	  @Override
	    protected void attackEntity(Entity par1Entity, float par2)
	    {
	        if (this.attackTime <= 0 )
	        {
	            this.attackTime = 5;
	            this.attackEntityAsMob(par1Entity);
	        }
	    }

}
