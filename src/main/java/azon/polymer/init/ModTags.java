package azon.polymer.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class ModTags {

    public static class Blocks {
        public static final Tag<Block> STORAGE_BLOCKS_POLYSTYRENE = tag("storage_blocks/polystyrene");
        public static final Tag<Block> SLABS_POLYSTYRENE = tag("slabs/polystyrene");

        private static Tag<Block> tag(String name) {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final Tag<Item> STORAGE_BLOCKS_POLYSTYRENE = tag("storage_blocks/polystyrene");
        public static final Tag<Item> SLABS_POLYSTYRENE = tag("slabs/polystyrene");

        private static Tag<Item> tag(String name) {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    }

}
