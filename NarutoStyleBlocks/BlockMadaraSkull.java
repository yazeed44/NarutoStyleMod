package NarutoStyleBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMadaraSkull extends Block {
	@SideOnly(Side.CLIENT)
    private Icon field_94393_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94392_b;

	public BlockMadaraSkull(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);

	}

	
	
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 0 ? this.field_94392_b : (par1 == 1 ? this.field_94393_a : this.blockIcon);
    }
	

	    /**
	     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	     */
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    /**
	     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	     */
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	    {
	        int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 7;

	        switch (l)
	        {
	            case 1:
	            default:
	                this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
	                break;
	            case 2:
	                this.setBlockBounds(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
	                break;
	            case 3:
	                this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
	                break;
	            case 4:
	                this.setBlockBounds(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
	                break;
	            case 5:
	                this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
	        }
	    }
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    {
	        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
	        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	    }
	    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	    {
	        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
	        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
	    }

	    /**
	     * Returns a new instance of a block's tile entity class. Called on placing the block.
	     */
	    public TileEntity createNewTileEntity(World par1World)
	    {
	        return new TileEntitySkull();
	    }
	    /**
	     * This method attempts to create a wither at the given location and skull
	     */
	    public void makeWither(World par1World, int par2, int par3, int par4, TileEntitySkull par5TileEntitySkull)
	    {
	        if (par5TileEntitySkull.getSkullType() == 1 && par3 >= 2 && par1World.difficultySetting > 0 && !par1World.isRemote)
	        {
	            int l = Block.slowSand.blockID;
	            int i1;
	            EntityWither entitywither;
	            int j1;

	            for (i1 = -2; i1 <= 0; ++i1)
	            {
	                if (par1World.getBlockId(par2, par3 - 1, par4 + i1) == l && par1World.getBlockId(par2, par3 - 1, par4 + i1 + 1) == l && par1World.getBlockId(par2, par3 - 2, par4 + i1 + 1) == l && par1World.getBlockId(par2, par3 - 1, par4 + i1 + 2) == l && this.func_82528_d(par1World, par2, par3, par4 + i1, 1) && this.func_82528_d(par1World, par2, par3, par4 + i1 + 1, 1) && this.func_82528_d(par1World, par2, par3, par4 + i1 + 2, 1))
	                {
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4 + i1, 8, 2);
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4 + i1 + 1, 8, 2);
	                    par1World.setBlockMetadataWithNotify(par2, par3, par4 + i1 + 2, 8, 2);
	                    par1World.setBlock(par2, par3, par4 + i1, 0, 0, 2);
	                    par1World.setBlock(par2, par3, par4 + i1 + 1, 0, 0, 2);
	                    par1World.setBlock(par2, par3, par4 + i1 + 2, 0, 0, 2);
	                    par1World.setBlock(par2, par3 - 1, par4 + i1, 0, 0, 2);
	                    par1World.setBlock(par2, par3 - 1, par4 + i1 + 1, 0, 0, 2);
	                    par1World.setBlock(par2, par3 - 1, par4 + i1 + 2, 0, 0, 2);
	                    par1World.setBlock(par2, par3 - 2, par4 + i1 + 1, 0, 0, 2);

	                    if (!par1World.isRemote)
	                    {
	                        entitywither = new EntityWither(par1World);
	                        entitywither.setLocationAndAngles((double)par2 + 0.5D, (double)par3 - 1.45D, (double)(par4 + i1) + 1.5D, 90.0F, 0.0F);
	                        entitywither.renderYawOffset = 90.0F;
	                        entitywither.func_82206_m();
	                        par1World.spawnEntityInWorld(entitywither);
	                    }

	                    for (j1 = 0; j1 < 120; ++j1)
	                    {
	                        par1World.spawnParticle("snowballpoof", (double)par2 + par1World.rand.nextDouble(), (double)(par3 - 2) + par1World.rand.nextDouble() * 3.9D, (double)(par4 + i1 + 1) + par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
	                    }

	                    par1World.notifyBlockChange(par2, par3, par4 + i1, 0);
	                    par1World.notifyBlockChange(par2, par3, par4 + i1 + 1, 0);
	                    par1World.notifyBlockChange(par2, par3, par4 + i1 + 2, 0);
	                    par1World.notifyBlockChange(par2, par3 - 1, par4 + i1, 0);
	                    par1World.notifyBlockChange(par2, par3 - 1, par4 + i1 + 1, 0);
	                    par1World.notifyBlockChange(par2, par3 - 1, par4 + i1 + 2, 0);
	                    par1World.notifyBlockChange(par2, par3 - 2, par4 + i1 + 1, 0);
	                    return;
	                }
	            }

	            for (i1 = -2; i1 <= 0; ++i1)
	            {
	                if (par1World.getBlockId(par2 + i1, par3 - 1, par4) == l && par1World.getBlockId(par2 + i1 + 1, par3 - 1, par4) == l && par1World.getBlockId(par2 + i1 + 1, par3 - 2, par4) == l && par1World.getBlockId(par2 + i1 + 2, par3 - 1, par4) == l && this.func_82528_d(par1World, par2 + i1, par3, par4, 1) && this.func_82528_d(par1World, par2 + i1 + 1, par3, par4, 1) && this.func_82528_d(par1World, par2 + i1 + 2, par3, par4, 1))
	                {
	                    par1World.setBlockMetadataWithNotify(par2 + i1, par3, par4, 8, 2);
	                    par1World.setBlockMetadataWithNotify(par2 + i1 + 1, par3, par4, 8, 2);
	                    par1World.setBlockMetadataWithNotify(par2 + i1 + 2, par3, par4, 8, 2);
	                    par1World.setBlock(par2 + i1, par3, par4, 0, 0, 2);
	                    par1World.setBlock(par2 + i1 + 1, par3, par4, 0, 0, 2);
	                    par1World.setBlock(par2 + i1 + 2, par3, par4, 0, 0, 2);
	                    par1World.setBlock(par2 + i1, par3 - 1, par4, 0, 0, 2);
	                    par1World.setBlock(par2 + i1 + 1, par3 - 1, par4, 0, 0, 2);
	                    par1World.setBlock(par2 + i1 + 2, par3 - 1, par4, 0, 0, 2);
	                    par1World.setBlock(par2 + i1 + 1, par3 - 2, par4, 0, 0, 2);

	                    if (!par1World.isRemote)
	                    {
	                        entitywither = new EntityWither(par1World);
	                        entitywither.setLocationAndAngles((double)(par2 + i1) + 1.5D, (double)par3 - 1.45D, (double)par4 + 0.5D, 0.0F, 0.0F);
	                        entitywither.func_82206_m();
	                        par1World.spawnEntityInWorld(entitywither);
	                    }

	                    for (j1 = 0; j1 < 120; ++j1)
	                    {
	                        par1World.spawnParticle("snowballpoof", (double)(par2 + i1 + 1) + par1World.rand.nextDouble(), (double)(par3 - 2) + par1World.rand.nextDouble() * 3.9D, (double)par4 + par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
	                    }

	                    par1World.notifyBlockChange(par2 + i1, par3, par4, 0);
	                    par1World.notifyBlockChange(par2 + i1 + 1, par3, par4, 0);
	                    par1World.notifyBlockChange(par2 + i1 + 2, par3, par4, 0);
	                    par1World.notifyBlockChange(par2 + i1, par3 - 1, par4, 0);
	                    par1World.notifyBlockChange(par2 + i1 + 1, par3 - 1, par4, 0);
	                    par1World.notifyBlockChange(par2 + i1 + 2, par3 - 1, par4, 0);
	                    par1World.notifyBlockChange(par2 + i1 + 1, par3 - 2, par4, 0);
	                    return;
	                }
	            }
	        }
	    }

	    private boolean func_82528_d(World par1World, int par2, int par3, int par4, int par5)
	    {
	        if (par1World.getBlockId(par2, par3, par4) != this.blockID)
	        {
	            return false;
	        }
	        else
	        {
	            TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
	            return tileentity != null && tileentity instanceof TileEntitySkull ? ((TileEntitySkull)tileentity).getSkullType() == par5 : false;
	        }
	    }

		/**
	     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	     * is the only chance you get to register icons.
	     */
	    

	    
			
		
	  

	    /**
	     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	     */
	    
	    /*public Icon getIcon(int par1, int par2)
	    {
	        return NarutoStyle.BlockMadaraSkull.getBlockTextureFromSide(par1);
	        

	    }
	   
*/
	    
	    public void registerIcons(IconRegister par1IconRegister) {
			this.blockIcon = par1IconRegister.registerIcon("NarutoStyle:BlockMadaraSkull");
	   
	        this.blockIcon = par1IconRegister.registerIcon("NarutoStyle:BlockMadaraSkull_sides");
	        this.field_94393_a = par1IconRegister.registerIcon("NarutoStyle:BlockMadaraSkull_top");
	        this.field_94392_b = par1IconRegister.registerIcon("NarutoStyle:BlockMadaraSkull_bottom");}
	    
	    
	

	

	

	

	
	
}
