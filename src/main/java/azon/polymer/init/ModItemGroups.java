package azon.polymer.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


public class ModItemGroups {

    public static final ItemGroup POLYMER = new ItemGroup("polymer") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.PLATE_BAKELITE);
        }

        public boolean hasSearchBar() { return false; }

    };

}
