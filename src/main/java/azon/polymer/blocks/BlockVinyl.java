package azon.polymer.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockVinyl extends _BlockBase {

    public BlockVinyl() {
        super("block_vinyl", Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(15.0f)
        );
    }
}