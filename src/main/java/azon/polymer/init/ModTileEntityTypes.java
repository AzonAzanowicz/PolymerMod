package azon.polymer.init;

import azon.polymer.Polymer;
import azon.polymer.tiles.TileGeneratorSolidFuel;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;


@ObjectHolder(Polymer.MOD_ID)
public class ModTileEntityTypes {

    @ObjectHolder("generator_solid_fuel")
    public static final TileEntityType<TileGeneratorSolidFuel> GENERATOR_SOLID_FUEL = null;

    @ObjectHolder("chopper")
    public static final TileEntityType<TileGeneratorSolidFuel> CHOPPER = null;

    @Mod.EventBusSubscriber(modid = Polymer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration {
        @SubscribeEvent
        public static void onTileEntityRegister(final RegistryEvent.Register<TileEntityType<?>> event) {
            IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();

            registry.register(TileEntityType.Builder.create(TileGeneratorSolidFuel::new, ModBlocks.GENERATOR_SOLID_FUEL).build(null).setRegistryName("generator_solid_fuel"));
            registry.register(TileEntityType.Builder.create(TileGeneratorSolidFuel::new, ModBlocks.CHOPPER).build(null).setRegistryName("chopper"));

            Polymer.LOGGER.info("Registered TileEntities");
        }
    }

}