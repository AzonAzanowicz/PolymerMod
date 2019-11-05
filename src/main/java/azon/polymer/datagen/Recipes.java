package azon.polymer.datagen;

import azon.polymer.blocks.BlockPolystyrene;
import azon.polymer.blocks.SlabPolystyrene;
import azon.polymer.init.ModBlocks;
import azon.polymer.init.ModTags;
import azon.polymer.utill.BlockMap;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.DyeColor;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {

    public Recipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        for(Block block : ModBlocks.getBlocksList()) {

            if(block instanceof BlockPolystyrene) {
                DyeColor color = ((BlockPolystyrene) block).getColor();

                ShapedRecipeBuilder.shapedRecipe(block, 8)
                        .patternLine("xxx")
                        .patternLine("xdx")
                        .patternLine("xxx")
                        .key('x', ModTags.Items.STORAGE_BLOCKS_POLYSTYRENE)
                        .key('d', BlockMap.getItemTag(color))
                        .setGroup("polystyrene_color_storage_blocks")
                        .addCriterion("has_polystyrene_block", InventoryChangeTrigger.Instance.forItems(ModBlocks.BLOCK_POLYSTYRENE_WHITE))
                        .build(consumer);
            }

            if(block instanceof SlabPolystyrene) {
                DyeColor color = ((SlabPolystyrene) block).getColor();

                ShapedRecipeBuilder.shapedRecipe(block, 6)
                        .patternLine("xxx")
                        .key('x', BlockMap.getPolystyreneItemBlock(color))
                        .setGroup("polystyrene_color_slabs")
                        .addCriterion("has_polystyrene_slab", InventoryChangeTrigger.Instance.forItems(ModBlocks.SLAB_POLYSTYRENE_WHITE))
                        .build(consumer);

                ShapedRecipeBuilder.shapedRecipe(block, 8)
                        .patternLine("xxx")
                        .patternLine("xdx")
                        .patternLine("xxx")
                        .key('x', ModTags.Items.SLABS_POLYSTYRENE)
                        .key('d', BlockMap.getItemTag(color))
                        .setGroup("polystyrene_color_slabs")
                        .addCriterion("has_polystyrene_slab", InventoryChangeTrigger.Instance.forItems(ModBlocks.SLAB_POLYSTYRENE_WHITE))
                        .build(consumer, "polymer:slab_polystyrene_"+color.getTranslationKey()+"_from_dye");
            }

        }
    }
}
