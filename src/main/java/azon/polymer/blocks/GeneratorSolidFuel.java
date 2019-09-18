package azon.polymer.blocks;

import azon.polymer.containers.ContainerGeneratorSolidFuel;
import azon.polymer.tiles.TileGeneratorSolidFuel;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class GeneratorSolidFuel extends _Generator implements ITileEntityProvider
{

    public GeneratorSolidFuel() {
        super("solid_fuel");
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileGeneratorSolidFuel();
    }

    @Override
    public void openContainer(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if(tileEntity instanceof TileGeneratorSolidFuel && player instanceof ServerPlayerEntity) {
            ((ServerPlayerEntity) player).openContainer((INamedContainerProvider) tileEntity);
        }
    }

}