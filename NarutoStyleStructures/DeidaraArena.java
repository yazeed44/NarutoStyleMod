package NarutoStyleStructures;

import java.util.Random;

import NarutoStyle.NarutoStyle_main;
import NarutoStyleEntitys.EntityDeidara;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeidaraArena extends WorldGenerator
{
	
	public DeidaraArena() { 
		
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		

		world.setBlock(i + 5, j + 0, k + 5, NarutoStyle_main.DeidaraClay.blockID);
		//world.setBlock(i + 0, j + 0, k + 2, Block.obsidian.blockID);
		world.setBlock(i + 0, j + 0, k + 3, Block.obsidian.blockID);
		world.setBlock(i + 0, j + 0, k + 4, Block.obsidian.blockID);
		world.setBlock(i + 0, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 0, j + 0, k + 6, Block.obsidian.blockID);
		world.setBlock(i + 0, j + 0, k + 7, Block.obsidian.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.obsidian.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.cloth.blockID,14,0 );
		world.setBlock(i + 1, j + 0, k + 4, Block.cloth.blockID,14,0);
		world.setBlock(i + 1, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.cloth.blockID);
		world.setBlock(i + 1, j + 0, k + 7, Block.cloth.blockID);
		world.setBlock(i + 1, j + 0, k + 8, Block.obsidian.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.obsidian.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.cloth.blockID,14,0);
		world.setBlock(i + 2, j + 0, k + 3, Block.cloth.blockID,14,0);
		world.setBlock(i + 2, j + 0, k + 4, Block.cloth.blockID,14,0);
		world.setBlock(i + 2, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.cloth.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Block.cloth.blockID);
		world.setBlock(i + 2, j + 0, k + 8, Block.cloth.blockID);
		world.setBlock(i + 2, j + 0, k + 9, Block.obsidian.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Block.obsidian.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Block.cloth.blockID,14,0);
		world.setBlock(i + 3, j + 0, k + 2, Block.cloth.blockID,14,0);
		world.setBlock(i + 3, j + 0, k + 3, Block.cloth.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.cloth.blockID,14,0);
		world.setBlock(i + 3, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.cloth.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.cloth.blockID, 14,0);
		world.setBlock(i + 3, j + 0, k + 8, Block.cloth.blockID);
		world.setBlock(i + 3, j + 0, k + 9, Block.cloth.blockID);
		world.setBlock(i + 3, j + 0, k + 10, Block.obsidian.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Block.obsidian.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Block.cloth.blockID,14,0);
		world.setBlock(i + 4, j + 0, k + 2, Block.cloth.blockID,14,0);
		world.setBlock(i + 4, j + 0, k + 3, Block.cloth.blockID,14,0);
		world.setBlock(i + 4, j + 0, k + 4, Block.cloth.blockID,14,0);
		world.setBlock(i + 4, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.cloth.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Block.cloth.blockID);
		world.setBlock(i + 4, j + 0, k + 8, Block.cloth.blockID);
		world.setBlock(i + 4, j + 0, k + 9, Block.cloth.blockID);
		world.setBlock(i + 4, j + 0, k + 10, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 0, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 1, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 7, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 8, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 9, Block.obsidian.blockID);
		world.setBlock(i + 5, j + 0, k + 10, Block.obsidian.blockID);
		world.setBlock(i + 6, j + 0, k + 0, Block.obsidian.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Block.cloth.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Block.cloth.blockID);
		world.setBlock(i + 6, j + 0, k + 3, Block.cloth.blockID);
		world.setBlock(i + 6, j + 0, k + 4, Block.cloth.blockID);
		world.setBlock(i + 6, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Block.cloth.blockID,14,0);
		world.setBlock(i + 6, j + 0, k + 7, Block.cloth.blockID,14,0);
		world.setBlock(i + 6, j + 0, k + 8, Block.cloth.blockID,14,0);
		world.setBlock(i + 6, j + 0, k + 9, Block.cloth.blockID,14,0);
		world.setBlock(i + 6, j + 0, k + 10, Block.obsidian.blockID);
		world.setBlock(i + 7, j + 0, k + 0, Block.obsidian.blockID);
		world.setBlock(i + 7, j + 0, k + 1, Block.cloth.blockID);
		world.setBlock(i + 7, j + 0, k + 2, Block.cloth.blockID);
		world.setBlock(i + 7, j + 0, k + 3, Block.cloth.blockID,14,0);
		world.setBlock(i + 7, j + 0, k + 4, Block.cloth.blockID);
		world.setBlock(i + 7, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 7, j + 0, k + 6, Block.cloth.blockID,14,0);
		world.setBlock(i + 7, j + 0, k + 7, Block.cloth.blockID);
		world.setBlock(i + 7, j + 0, k + 8, Block.cloth.blockID,14,0);
		world.setBlock(i + 7, j + 0, k + 9, Block.cloth.blockID,14,0);
		world.setBlock(i + 7, j + 0, k + 10, Block.obsidian.blockID);
		world.setBlock(i + 8, j + 0, k + 1, Block.obsidian.blockID);
		world.setBlock(i + 8, j + 0, k + 2, Block.cloth.blockID);
		world.setBlock(i + 8, j + 0, k + 3, Block.cloth.blockID);
		world.setBlock(i + 8, j + 0, k + 4, Block.cloth.blockID);
		world.setBlock(i + 8, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 8, j + 0, k + 6, Block.cloth.blockID,14,0);
		world.setBlock(i + 8, j + 0, k + 7, Block.cloth.blockID,14,0);
		world.setBlock(i + 8, j + 0, k + 8, Block.cloth.blockID,14,0);
		world.setBlock(i + 8, j + 0, k + 9, Block.obsidian.blockID);
		world.setBlock(i + 9, j + 0, k + 2, Block.obsidian.blockID);
		world.setBlock(i + 9, j + 0, k + 3, Block.cloth.blockID);
		world.setBlock(i + 9, j + 0, k + 4, Block.cloth.blockID);
		world.setBlock(i + 9, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 9, j + 0, k + 6, Block.cloth.blockID,14,0);
		world.setBlock(i + 9, j + 0, k + 7, Block.cloth.blockID,14,0);
		world.setBlock(i + 9, j + 0, k + 8, Block.obsidian.blockID);
		world.setBlock(i + 10, j + 0, k + 3, Block.obsidian.blockID);
		world.setBlock(i + 10, j + 0, k + 4, Block.obsidian.blockID);
		world.setBlock(i + 10, j + 0, k + 5, Block.obsidian.blockID);
		world.setBlock(i + 10, j + 0, k + 6, Block.obsidian.blockID);
		world.setBlock(i + 10, j + 0, k + 7, Block.obsidian.blockID);

		
		return true;
	}
}