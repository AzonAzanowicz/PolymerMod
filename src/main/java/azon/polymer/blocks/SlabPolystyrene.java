package azon.polymer.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;

public class SlabPolystyrene extends _ModSlab {

    public SlabPolystyrene(DyeColor color) {
        super("slab_polystyrene", color, Properties.create(Material.ROCK)
                .sound(SoundType.SNOW)
                .hardnessAndResistance(1.0f)
        );
    }
}