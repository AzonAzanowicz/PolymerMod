package azon.polymer.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPolypropylene extends _ModBlockComplex {

    public BlockPolypropylene() {
        super("block_polypropylene", Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(15.0f)
        );
    }

    @Override
    public boolean talentHorizontalFacing() {
        return true;
    }
}