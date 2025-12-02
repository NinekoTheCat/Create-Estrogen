package dev.mayaqq.createestrogen.forge.client

import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.client.createEstrogenClient
import dev.mayaqq.estrogen.client.content.screen.config.ConfigCategorySelectionScreen
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
object CreateEstrogenForgeClient {
    @SubscribeEvent
    fun onClientInit(event: FMLClientSetupEvent) {
        event.enqueueWork(::createEstrogenClient)

        @Suppress("Deprecation", "Removal")
        ModLoadingContext.get().activeContainer.registerExtensionPoint(
            ConfigScreenHandler.ConfigScreenFactory::class.java
        ) {
            ConfigScreenHandler.ConfigScreenFactory { _, screen ->
                ConfigCategorySelectionScreen(
                    screen,
                    listOf("createestrogen/client", "createestrogen/common", "createestrogen/server")
                )
            }
        }
    }
}