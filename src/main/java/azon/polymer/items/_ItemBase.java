package azon.polymer.items;

import azon.polymer.init.ModItemGroups;
import azon.polymer.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public abstract class _ItemBase extends Item {

    public _ItemBase(String name) {
        super(new Properties().group(addGroup()));
        setRegistryName(name);
    }

    private static ItemGroup addGroup() {
        return ModItemGroups.POLYMER;
    }

}