package azon.polymer.blocks;

import azon.polymer.tiles.TileGeneratorSolidFuel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GeneratorManual extends _Generator {

    public GeneratorManual() {
        super("manual");
    }

    @Override
    public void openContainer(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = world.getTileEntity(pos);
        if (tileentity instanceof TileGeneratorSolidFuel && player instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) player).openContainer((INamedContainerProvider) tileentity);
        }
    }
}