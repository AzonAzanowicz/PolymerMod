package azon.polymer.utill;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

import java.util.ArrayList;

public class DirectionalShape {

    private ArrayList<Double[]> voxelList = new ArrayList<>();
    private VoxelShape north;
    private VoxelShape south;
    private VoxelShape east;
    private VoxelShape west;
    private VoxelShape up;
    private VoxelShape down;

    public DirectionalShape(Double[]... voxel) {
        for (Double[] v : voxel) {
            if (v.length!=6)
                v = new Double[] {0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D};
            voxelList.add(v);
        }
        genNorth();
        genSouth();
        genEast();
        genWast();
        genUp();
        genDown();
    }

    private void genNorth() {
        north = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        for (Double[] v : voxelList) {
            VoxelShape shape2 = Block.makeCuboidShape(v[0], v[1], v[2], v[3], v[4], v[5]);
            north = VoxelShapes.or(north, shape2);
        }
    }

    private void genSouth() {
        south = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        for (Double[] v : voxelList) {
            VoxelShape shape2 = Block.makeCuboidShape(16.0D-v[3], v[1], 16.0D-v[5], 16.0D-v[0], v[4], 16.0D-v[2]);
            south = VoxelShapes.or(south, shape2);
        }
    }

    private void genEast() {
        east = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        for (Double[] v : voxelList) {
            VoxelShape shape2 = Block.makeCuboidShape(16.0D-v[5], v[1], v[0], 16.0D-v[2], v[4], v[3]);
            east = VoxelShapes.or(east, shape2);
        }
    }

    private void genWast() {
        west = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        for (Double[] v : voxelList) {
            VoxelShape shape2 = Block.makeCuboidShape(v[2], v[1], 16.0D-v[3], v[5], v[4], 16.0D-v[0]);
            west = VoxelShapes.or(west, shape2);
        }
    }

    private void genUp() {
        up = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        for (Double[] v : voxelList) {
            VoxelShape shape2 = Block.makeCuboidShape(v[0], 16.0D-v[2], v[4], v[3], 16.0D-v[5], v[1]);
            up = VoxelShapes.or(up, shape2);
        }
    }

    private void genDown() {
        down = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        for (Double[] v : voxelList) {
            VoxelShape shape2 = Block.makeCuboidShape(v[0], v[2], 16.0D-v[4], v[3], v[5], 16.0D-v[1]);
            down = VoxelShapes.or(down, shape2);
        }
    }

    public VoxelShape getShape(Direction direction) {
        switch(direction) {
            case NORTH:
                return getNorth();
            case SOUTH:
                return getSouth();
            case EAST:
                return getEast();
            case WEST:
                return getWest();
            case UP:
                return getUp();
            case DOWN:
                return getDown();
            default:
                return getNorth();
        }
    }

    public VoxelShape getNorth() {
        return north;
    }

    public VoxelShape getSouth() {
        return south;
    }

    public VoxelShape getEast() {
        return east;
    }

    public VoxelShape getWest() {
        return west;
    }

    public VoxelShape getUp() {
        return up;
    }

    public VoxelShape getDown() {
        return down;
    }

}