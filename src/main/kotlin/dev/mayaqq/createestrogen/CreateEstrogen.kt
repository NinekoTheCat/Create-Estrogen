package dev.mayaqq.createestrogen

import dev.mayaqq.createestrogen.content.CreateEstrogenBlockEntities
import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks
import dev.mayaqq.createestrogen.content.CreateEstrogenPonderPlugin
import dev.mayaqq.createestrogen.content.CreateEstrogenRecipes
import dev.mayaqq.cynosure.events.api.EventSubscriber
import net.createmod.ponder.foundation.PonderIndex
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import uwu.serenity.kritter.RegistryManager

const val MOD_ID = "createestrogen"
const val MOD_NAME = "Create: Estrogen"
internal inline fun id(path: String) = ResourceLocation(MOD_ID, path)

@EventSubscriber
object CreateEstrogen : Logger by LoggerFactory.getLogger(MOD_NAME),  RegistryManager by RegistryManager(MOD_ID) {
    fun init() {
        CreateEstrogenRecipes.register()
        CreateEstrogenBlocks.register()
        CreateEstrogenBlockEntities.register()
        PonderIndex.addPlugin(CreateEstrogenPonderPlugin)
    }
}