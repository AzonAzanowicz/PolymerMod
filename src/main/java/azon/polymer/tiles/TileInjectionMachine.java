package azon.polymer.tiles;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class TileInjectionMachine extends TileEntity implements ITickableTileEntity {

    @ObjectHolder("polymer:block_injection_machine")
    public static TileEntityType<TileInjectionMachine> type;

    public TileInjectionMachine() {
        super(type);
    }

    public static TileEntityType<?> getTileType() {
        return type;
    }

    @Override
    public void tick() {
        System.out.println("tick");
    }
}