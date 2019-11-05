package azon.polymer.utill;

import azon.polymer.blocks.BlockPolystyrene;
import azon.polymer.blocks._ModBlock;
import azon.polymer.init.ModBlocks;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.Tags;

public class BlockMap {

    public static Tag<Item> getItemTag (DyeColor color) {
        if (color == DyeColor.WHITE) return Tags.Items.DYES_WHITE;
        else if (color == DyeColor.ORANGE) return Tags.Items.DYES_ORANGE;
        else if (color == DyeColor.MAGENTA) return Tags.Items.DYES_MAGENTA;
        else if (color == DyeColor.LIGHT_BLUE) return Tags.Items.DYES_LIGHT_BLUE;
        else if (color == DyeColor.YELLOW) return Tags.Items.DYES_YELLOW;
        else if (color == DyeColor.LIME) return Tags.Items.DYES_LIME;
        else if (color == DyeColor.PINK) return Tags.Items.DYES_PINK;
        else if (color == DyeColor.GRAY) return Tags.Items.DYES_GRAY;
        else if (color == DyeColor.LIGHT_GRAY) return Tags.Items.DYES_LIGHT_GRAY;
        else if (color == DyeColor.CYAN) return Tags.Items.DYES_CYAN;
        else if (color == DyeColor.PURPLE) return Tags.Items.DYES_PURPLE;
        else if (color == DyeColor.BLUE) return Tags.Items.DYES_BLUE;
        else if (color == DyeColor.BROWN) return Tags.Items.DYES_BROWN;
        else if (color == DyeColor.GREEN) return Tags.Items.DYES_GREEN;
        else if (color == DyeColor.RED) return Tags.Items.DYES_RED;
        else if (color == DyeColor.BLACK) return Tags.Items.DYES_BLACK;

        //default
        else return Tags.Items.DYES_WHITE;
    }

    public static Item getPolystyreneItemBlock (DyeColor color) {
        if (color == DyeColor.WHITE) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_WHITE).getBlockItem();
        else if (color == DyeColor.ORANGE) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_ORANGE).getBlockItem();
        else if (color == DyeColor.MAGENTA) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_MAGENTA).getBlockItem();
        else if (color == DyeColor.LIGHT_BLUE) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_LIGHT_BLUE).getBlockItem();
        else if (color == DyeColor.YELLOW) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_YELLOW).getBlockItem();
        else if (color == DyeColor.LIME) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_LIME).getBlockItem();
        else if (color == DyeColor.PINK) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_PINK).getBlockItem();
        else if (color == DyeColor.GRAY) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_GRAY).getBlockItem();
        else if (color == DyeColor.LIGHT_GRAY) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_GRAY).getBlockItem();
        else if (color == DyeColor.CYAN) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_CYAN).getBlockItem();
        else if (color == DyeColor.PURPLE) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_PURPLE).getBlockItem();
        else if (color == DyeColor.BLUE) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_BLUE).getBlockItem();
        else if (color == DyeColor.BROWN) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_BROWN).getBlockItem();
        else if (color == DyeColor.GREEN) return  ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_GREEN).getBlockItem();
        else if (color == DyeColor.RED) return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_RED).getBlockItem();
        else if (color == DyeColor.BLACK) return  ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_BLACK).getBlockItem();

            //default
        else return ((_ModBlock) ModBlocks.BLOCK_POLYSTYRENE_WHITE).getBlockItem();
    }
}