package azon.polymer.proxy;


import azon.polymer.Polymer;
import azon.polymer.init.ModContainerTypes;
import azon.polymer.screens.ScreenGeneratorSolidFuel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        Polymer.LOGGER.debug("ClientProxy clientSetup method");
        ScreenManager.registerFactory(ModContainerTypes.GENERATOR_SOLID_FUEL, ScreenGeneratorSolidFuel::new);
        OBJLoader.INSTANCE.addDomain(Polymer.MOD_ID);
    }
}