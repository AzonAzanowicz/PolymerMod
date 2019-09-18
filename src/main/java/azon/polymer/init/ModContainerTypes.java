package azon.polymer.init;

import azon.polymer.Polymer;
import azon.polymer.containers.ContainerGeneratorSolidFuel;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Polymer.MOD_ID)
public class ModContainerTypes {

    @ObjectHolder("generator_solid_fuel")
    public static final ContainerType<ContainerGeneratorSolidFuel> GENERATOR_SOLID_FUEL = null;

    @Mod.EventBusSubscriber(modid = Polymer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Registration {
        @SubscribeEvent
        public static void onContainerTypeRegister(final RegistryEvent.Register<ContainerType<?>> event) {
            IForgeRegistry<ContainerType<?>> registry = event.getRegistry();

            registry.register(new ContainerType<ContainerGeneratorSolidFuel>(ContainerGeneratorSolidFuel::new).setRegistryName(new ResourceLocation(Polymer.MOD_ID, "generator_solid_fuel")));

            Polymer.LOGGER.info("Registered container types");
        }
    }

}
