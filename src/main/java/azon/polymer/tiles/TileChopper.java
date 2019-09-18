package azon.polymer.tiles;

import azon.polymer.init.ModTileEntityTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileChopper extends TileEntity implements ITickableTileEntity {

    public TileChopper() {
        super(ModTileEntityTypes.CHOPPER);
    }

    @Override
    public void tick() {
        System.out.println("tick");
    }

}