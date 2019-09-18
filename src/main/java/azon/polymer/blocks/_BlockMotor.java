package azon.polymer.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public abstract class _BlockMotor extends _BlockBase {

    public _BlockMotor(String tier) {
        super("block_motor_"+tier, Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(4.0f)
        );
    }
}