package dev.mayaqq.createestrogen

import dev.mayaqq.createestrogen.config.CreateEstrogenCommonConfig
import dev.mayaqq.createestrogen.config.CreateEstrogenServerConfig
import dev.mayaqq.createestrogen.content.*
import dev.mayaqq.cynosure.events.api.EventSubscriber
import dev.mayaqq.cynosure.utils.colors.Color
import dev.mayaqq.estrogen.api.EstrogenEntrypoint
import dev.mayaqq.estrogen.api.EstrogenFlag
import dev.mayaqq.estrogen.api.EstrogenModule
import dev.mayaqq.estrogen.client.content.screen.config.ConfigCategorySelectionScreen
import net.minecraft.client.gui.screens.Screen
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import uwu.serenity.kittyconfig.load
import uwu.serenity.kritter.RegistryManager

const val MOD_ID = "createestrogen"
const val MOD_NAME = "Create: Estrogen"
fun id(path: String) = ResourceLocation(MOD_ID, path)

@EstrogenEntrypoint
@EventSubscriber
object CreateEstrogen : Logger by LoggerFactory.getLogger(MOD_NAME), RegistryManager by RegistryManager(MOD_ID),
    EstrogenModule {
    fun init() {
        CreateEstrogenCommonConfig.load()
        CreateEstrogenServerConfig.load()

        CreateEstrogenRecipes.register()
        CreateEstrogenRecipes.Serializers.register()
        CreateEstrogenBlocks.register()
        CreateEstrogenBlockEntities.register()
        CreateEstrogenItems.register()
        CreateEstrogenCreativeTab.register()
    }

    override val color: Color = Color(0xFFC7A7)
    override val description: String = "Create module for Estrogen"
    override val flags: Array<EstrogenFlag> = arrayOf(EstrogenFlag.DISABLES_CAULDRON_ESTROGEN)

    override fun createConfigScreen(): (Screen) -> Screen = {
        ConfigCategorySelectionScreen(
            it,
            listOf("createestrogen/client", "createestrogen/common", "createestrogen/server")
        )
    }
}