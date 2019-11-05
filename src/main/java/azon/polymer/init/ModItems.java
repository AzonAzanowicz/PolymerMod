package azon.polymer.init;

import azon.polymer.Polymer;
import azon.polymer.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@ObjectHolder(Polymer.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Polymer.MOD_ID)
public class ModItems {

    private static final List<Item> ITEMS = new ArrayList<Item>();

    public static Item GRAINS_BAKELITE = register(new GrainsBakelite());
    public static Item GRAINS_POLYPROPYLENE = register(new GrainsPolypropylene());
    public static Item GRAINS_POLYSTYRENE = register(new GrainsPolystyrene());
    public static Item GRAINS_VINYL = register(new GrainsVinyl());
    public static Item GRAINS_ACRYLIC = register(new GrainsAcrylic());
    public static Item GRAINS_ABS = register(new GrainsAbs());
    public static Item PLATE_BAKELITE = register(new PlateBakelite());
    public static Item PLATE_POLYPROPYLENE = register(new PlatePolypropylene());
    public static Item PLATE_POLYSTYRENE = register(new PlatePolystyrene());
    public static Item PLATE_VINYL = register(new PlateVinyl());
    public static Item PLATE_ABS = register(new PlateAbs());

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        ITEMS.forEach(item -> {
            event.getRegistry().register(item);
        });
        Polymer.LOGGER.debug("Registered items");
    }

    private static Item register(_ItemBase item) {
        ITEMS.add(item);
        return item;
    }

}