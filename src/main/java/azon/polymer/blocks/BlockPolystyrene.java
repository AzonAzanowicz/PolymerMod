package azon.polymer.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;

public class BlockPolystyrene extends _BlockComplex {

    public BlockPolystyrene(DyeColor color) {
        super("block_polystyrene", color, Properties.create(Material.ROCK)
                .sound(SoundType.SNOW)
                .hardnessAndResistance(1.0f)
        );
    }
}