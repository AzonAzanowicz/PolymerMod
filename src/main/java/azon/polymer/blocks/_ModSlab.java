package azon.polymer.blocks;

import azon.polymer.init.ModItemGroups;
import azon.polymer.utill.IProvideBlockItem;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import javax.annotation.Nullable;

public abstract class _ModSlab extends SlabBlock implements IProvideBlockItem {

    private Item item;
    private DyeColor color;

    public _ModSlab(String name, Properties properties) {
        super(properties);
        setRegistryName(name);

        item = new BlockItem(this, new Item.Properties().group(addGroup()));
        item.setRegistryName(name);
    }

    public _ModSlab(String name, DyeColor color, Properties properties) {
        this(name+"_"+color.getTranslationKey(), properties);
        this.color=color;
    }

    public static ItemGroup addGroup() {
        return ModItemGroups.POLYMER;
    }

    @Nullable
    public DyeColor getColor() {
        return color;
    }

    @Override
    public Item getBlockItem() {
        return item;
    }

}