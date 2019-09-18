package azon.polymer.init;

import azon.polymer.Polymer;
import azon.polymer.blocks.*;
import azon.polymer.temp.MachineBlock;
import net.minecraft.block.Block;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@ObjectHolder(Polymer.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Polymer.MOD_ID)
public class ModBlocks {

    private static final List<Block> BLOCKS = new ArrayList<Block>();
    private static final List<Item> ITEMS = new ArrayList<Item>();

    public static Block BLOCK_INJECTION_MACHINE = register(new BlockInjectionMachine());
    public static Block CHOPPER = register(new Chopper());
    public static Block BLOCK_MOTOR_BASIC = register(new BlockMotorBasic());
    public static Block BLOCK_MOTOR_STANDARD = register(new BlockMotorStandard());
    public static Block BLOCK_POLYPROPYLENE = register(new BlockPolypropylene());
    public static Block BLOCK_VINYL = register(new BlockVinyl());
    public static Block GENERATOR_SOLID_FUEL = register(new GeneratorSolidFuel());
    public static Block GENERATOR_MANUAL = register(new GeneratorManual());
    public static Block BLOCK_POLYSTYRENE_WHITE = register(new BlockPolystyrene(DyeColor.WHITE));
    public static Block BLOCK_POLYSTYRENE_ORANGE = register(new BlockPolystyrene(DyeColor.ORANGE));
    public static Block BLOCK_POLYSTYRENE_MAGENTA = register(new BlockPolystyrene(DyeColor.MAGENTA));
    public static Block BLOCK_POLYSTYRENE_LIGHT_BLUE = register(new BlockPolystyrene(DyeColor.LIGHT_BLUE));
    public static Block BLOCK_POLYSTYRENE_YELLOW = register(new BlockPolystyrene(DyeColor.YELLOW));
    public static Block BLOCK_POLYSTYRENE_LIME = register(new BlockPolystyrene(DyeColor.LIME));
    public static Block BLOCK_POLYSTYRENE_PINK = register(new BlockPolystyrene(DyeColor.PINK));
    public static Block BLOCK_POLYSTYRENE_GRAY = register(new BlockPolystyrene(DyeColor.GRAY));
    public static Block BLOCK_POLYSTYRENE_LIGHT_GRAY = register(new BlockPolystyrene(DyeColor.LIGHT_GRAY));
    public static Block BLOCK_POLYSTYRENE_CYAN = register(new BlockPolystyrene(DyeColor.CYAN));
    public static Block BLOCK_POLYSTYRENE_PURPLE = register(new BlockPolystyrene(DyeColor.PURPLE));
    public static Block BLOCK_POLYSTYRENE_BLUE = register(new BlockPolystyrene(DyeColor.BLUE));
    public static Block BLOCK_POLYSTYRENE_BROWN = register(new BlockPolystyrene(DyeColor.BROWN));
    public static Block BLOCK_POLYSTYRENE_GREEN = register(new BlockPolystyrene(DyeColor.GREEN));
    public static Block BLOCK_POLYSTYRENE_RED = register(new BlockPolystyrene(DyeColor.RED));
    public static Block BLOCK_POLYSTYRENE_BLACK = register(new BlockPolystyrene(DyeColor.BLACK));


    @SubscribeEvent
    public static void onBlcoksRegistry(final RegistryEvent.Register<Block> event) {
        BLOCKS.forEach(block -> {
            event.getRegistry().register(block);
        });
        Polymer.LOGGER.debug("Registered blocks");
    }

    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        ITEMS.forEach(item -> {
            event.getRegistry().register(item);
        });
        Polymer.LOGGER.debug("Registered item blocks");
    }

    private static Block register(_BlockBase block) {
        BLOCKS.add(block);
        ITEMS.add(block.getBlockItem());
        return block;
    }

}