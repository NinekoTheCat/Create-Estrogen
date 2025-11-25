package dev.mayaqq.createestrogen.fabric.compat

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import dev.mayaqq.estrogen.client.content.screen.config.ConfigCategorySelectionScreen


class ModMenuIntegration : ModMenuApi {
    override fun getModConfigScreenFactory(): ConfigScreenFactory<*> {
        return ConfigScreenFactory { ConfigCategorySelectionScreen(
            it,
            listOf("createestrogen/client", "createestrogen/common", "createestrogen/server")
        )}
    }
}