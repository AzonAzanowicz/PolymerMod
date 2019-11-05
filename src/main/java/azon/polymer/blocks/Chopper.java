package azon.polymer.blocks;

import azon.polymer.tiles.TileChopper;
import azon.polymer.utill.DirectionalShape;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class Chopper extends _ModBlockComplex {

    private static DirectionalShape SHAPE;

    public Chopper() {
        super("chopper", Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(15.0f)
        );

        SHAPE = new DirectionalShape(
                new Double[]{01D, 00D, 01D, 15D, 11D, 15D},
                new Double[]{06D, 11D, 06D, 10D, 12D, 10D},
                new Double[]{05D, 12D, 05D, 11D, 15D, 11D},
                new Double[]{04D, 15D, 04D, 12D, 16D, 12D},
                new Double[]{05D, 04D, 00D, 11D, 10D, 01D},
                new Double[]{05D, 03D, 15D, 11D, 07D, 16D});
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE.getShape(state.get(HORIZONTAL_FACING));
    }

    @Override
    public boolean talentHorizontalFacing() {
        return true;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileChopper();
    }
}