package NarutoStyle;

import java.util.Random;



import NarutoStyleStructures.DeidaraArena;

import net.minecraft.world.World;

import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class KonohaGen  implements IWorldGenerator  {
	DeidaraArena arena = new DeidaraArena();
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		 
		
		 switch (world.provider.dimensionId)
		 {
		 case -1: //generateNether(world, random, chunkX*16, chunkZ*16);
		 case 0:generateSurface(world, random, chunkX*16, chunkZ*16);
		 }
		 }
	 private void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	 {
		 //System.out.println("Generating Leaf in overworld");
		 /*int posX = world.getSpawnPoint().posX;
			int posZ = world.getSpawnPoint().posZ;
			int posY = world.getSpawnPoint().posY;*/
		 //for(int x = 0;x<2;x++){
		 int i = chunkX + random.nextInt(16);
		 int k = chunkZ + random.nextInt(16);
		 int j = world.getHeightValue(i, k);
		// BiomeGenBase base = new BiomeGenBase();
		 if (random.nextFloat() < 0.0033f) 
			 if (world.getBiomeGenForCoords(i, k) instanceof BiomeGenPlains){
				 arena.generate(world, random,i, j+1, k);
				 
				 }
		 
		 
			
			
		 //System.out.println("Z = " +k + " X = " +  i + " Y = " + j );
		 
			
			
			//world.setBlock(posX, posY+2,posZ , Block.blockDiamond.blockID);
			//world.setBlock(posX, posY+4,posZ, Block.blockDiamond.blockID);
			//world.setBlock(posX, posY+6,posZ, Block.blockDiamond.blockID);
				 //(new A_()).generate(world, random, posX, posY+10, posZ);
				
			
		


        
         //System.out.println("Z = " +posZ + " X = " +  posX + " Y = " + posY );
		
		 ;
	 
	}}


