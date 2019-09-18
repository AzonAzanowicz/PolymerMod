package azon.polymer.blocks;

import azon.polymer.utill.DirectionalShape;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public abstract class _Generator extends _BlockComplex {

    private static DirectionalShape SHAPE;

    public _Generator(String type) {
        super("generator_"+type, Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(15.0f)
        );
        SHAPE = new DirectionalShape(
                new Double[]{00D, 00D, 00D, 16D, 16D, 08D},
                new Double[]{01D, 01D, 08D, 15D, 15D, 10D},
                new Double[]{04D, 04D, 10D, 12D, 12D, 16D});
    }

    @Override
    public boolean talentFacing() {
        return true;
    }

    @Override
    public boolean talentActive() {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
       return SHAPE.getShape(state.get(FACING));
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(!worldIn.isRemote) {
            openContainer(worldIn, pos, player);
        }
        return true;
    }

    public abstract void openContainer(World world, BlockPos pos, PlayerEntity player);

}