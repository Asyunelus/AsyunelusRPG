package kr.asyu.rpg;

import kr.asyu.rpg.network.PacketHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SideProxy {

    SideProxy() {
        IEventBus modEventBus = MinecraftForge.EVENT_BUS;
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.register(this);

        PacketHandler.initialize();
    }

    @SubscribeEvent
    public void onLoaded(FMLLoadCompleteEvent event) {

    }

    @SubscribeEvent
    public void setup(FMLCommonSetupEvent event) {

    }

    public static class Server extends SideProxy {

        Server() {

        }
    }

    public static class Client extends SideProxy {
        Client() {
            IEventBus modEventBus = MinecraftForge.EVENT_BUS;
            IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

            eventBus.addListener(this::clientStuff);
        }


        private void clientStuff(final FMLClientSetupEvent event) {
            
        }
    }
}