package azon.polymer;

import azon.polymer.proxy.ClientProxy;
import azon.polymer.proxy.CommonProxy;
import azon.polymer.proxy.ServerProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Polymer.MOD_ID)
public class Polymer {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "polymer";

    public static Polymer instance;
    public static CommonProxy proxy;

	public Polymer() {
        instance = this;
        proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    }

}

        /*
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {


        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            IForgeRegistry<Block> reg = event.getRegistry();

            for (Block block : ModBlocks.blocks)
                event.getRegistry().register(block);

        }



        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> reg = event.getRegistry();


            for (Item item : ModBlocks.items)
                reg.register(item);



            for (Item item : ModItems.items)
                reg.register(item);

        }





        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            IForgeRegistry<TileEntityType<?>> reg = event.getRegistry();

            reg.register(TileEntityType.Builder.create((Supplier<TileEntity>) TileInjectionMachine::new, ModBlocks.BLOCK_INJECTION_MACHINE).build(null).setRegistryName("block_injection_machine"));


        }

            /*
        @SubscribeEvent
        public static void onContainerTypeRegister(final RegistryEvent.Register<ContainerType<?>> event) {
            IForgeRegistry<ContainerType<?>> reg = event.getRegistry();

            reg.register(new ContainerType<ContainerGeneratorSolidFuel>(ContainerGeneratorSolidFuel::new).setRegistryName(new ResourceLocation("generator_solid_fuel")));


            event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                return new ContainerGeneratorSolidFuel(windowId, Polymer.proxy.getClientWorld(), pos, inv, Polymer.proxy.getClientPlayer());
            }).setRegistryName("generator_solid_fuel"));

             */
