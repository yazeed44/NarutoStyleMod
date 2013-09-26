package NarutoStyle;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class NarutoStyleCrafting {

	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.C3,2), new Object []{
			"aTa",
			"TCT",
			"TTT",
			'T',Block.tnt,'C',Block.blockClay
			
		});
		
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.ClaySpider), new Object[]{
            "aSa",
			"CZC",
            "CZC",
             'S',Item.spiderEye,'C',Item.gunpowder,'Z',Item.clay});
		
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.ClayBird,2), new Object[]{
            
			"CZC",
            "GaG",
             'G',Item.gunpowder,'C',Item.feather,'Z',Item.clay});
		
		
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.MadaraHelmet), new Object[]{
            "CCC",
            "CaC",
             'C', Item.netherrackBrick});
		
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.MadaraChestPlate), new Object[]{
			"CaC",
			"CCC",
			"CCC",
			'C',Item.netherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.MadaraLegging), new Object[]{
			"CCC",
			"CaC",
			"CaC",
			'C',Item.netherrackBrick});
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.MadaraBoots), new Object[]{
			"CaC",
			"CaC",
			'C',Item.netherrackBrick});
		
		GameRegistry.addRecipe(new ItemStack(NarutoStyle_main.gunbai,1), new Object[]{
            "CZC",
            "CZC",
            "aXa",
            'X', Item.stick, 'C', Item.diamond, 'Z', Block.blockIron});
		
	}
}
