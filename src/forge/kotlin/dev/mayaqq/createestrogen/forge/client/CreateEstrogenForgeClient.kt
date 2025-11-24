@file:EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
package dev.mayaqq.createestrogen.forge.client

import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.client.createEstrogenClient
import dev.mayaqq.estrogen.client.content.screen.config.ConfigCategorySelectionScreen
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.Screen
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

@SubscribeEvent
fun onClientInit(event: FMLClientSetupEvent) {
    event.enqueueWork(::createEstrogenClient)

    @Suppress("Deprecation", "Removal")
    ModLoadingContext.get().activeContainer.registerExtensionPoint(
        ConfigScreenHandler.ConfigScreenFactory::class.java
    ) {
        ConfigScreenHandler.ConfigScreenFactory { _: Minecraft, screen: Screen ->
            ConfigCategorySelectionScreen(
                screen,
                listOf("createestrogen/client", "createestrogen/common", "createestrogen/server")
            )
        }
    }
}