package azon.polymer.blocks;

import azon.polymer.init.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public abstract class _BlockBase extends Block {

    private Item item;

    public _BlockBase(String name, Properties properties) {
        super(properties);
        setRegistryName(name);

        item = new BlockItem(this, new Item.Properties().group(addGroup()));
        item.setRegistryName(name);
    }

    public static ItemGroup addGroup() {
        return ModItemGroups.POLYMER;
    }

    public Item getBlockItem() {
        return item;
    }

}