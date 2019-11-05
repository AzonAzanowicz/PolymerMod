package azon.polymer.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public abstract class _ModBlockComplex extends _ModBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final DirectionProperty HORIZONTAL_FACING = HorizontalBlock.HORIZONTAL_FACING;
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public _ModBlockComplex(String name, Properties properties) {
        super(name, properties);
        checkTalents();
    }

    public _ModBlockComplex(String name, DyeColor color, Properties properties) {
        super(name, color, properties);
        checkTalents();
    }

    private void checkTalents() {
        if (talentFacing())
            this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
        if (talentHorizontalFacing())
            this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.NORTH));
        if (talentActive())
            this.setDefaultState(this.stateContainer.getBaseState().with(ACTIVE, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        if (talentFacing())
            builder.add(FACING);
        if (talentHorizontalFacing())
            builder.add(HORIZONTAL_FACING);
        if (talentActive())
            builder.add(ACTIVE);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
    /*
        if (context.isPlacerSneaking())
            return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());

     */
        if (talentFacing())
            return this.getDefaultState().with(FACING, context.getNearestLookingDirection());
        if (talentHorizontalFacing())
            return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
        else return this.getDefaultState();
    }

    public boolean talentFacing() {
        return false;
    }

    public boolean talentHorizontalFacing() {
        return false;
    }

    public boolean talentActive() {
        return false;
    }

}