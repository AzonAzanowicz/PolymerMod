package azon.polymer.proxy;

import azon.polymer.Polymer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


public class CommonProxy {

    public CommonProxy() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInit);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::postInit);
    }

    protected void preInit(FMLCommonSetupEvent event) {
        Polymer.LOGGER.debug("CommonProxy preInit method");
    }

    protected void init(InterModEnqueueEvent event) {
        Polymer.LOGGER.debug("CommonProxy init method");
    }

    protected void postInit(InterModProcessEvent event) {
        Polymer.LOGGER.debug("CommonProxy postInit method");
    }

    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }

}