package dev.mayaqq.createestrogen.client

import com.simibubi.create.AllPartialModels
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.config.CreateEstrogenClientConfig
import dev.mayaqq.createestrogen.content.CreateEstrogenPonderPlugin
import dev.mayaqq.createestrogen.content.packages.CreateEstrogenPackageStyles
import net.createmod.ponder.foundation.PonderIndex
import net.minecraft.resources.ResourceLocation
import uwu.serenity.kittyconfig.load

fun createEstrogenClient() {
    CreateEstrogenClientConfig.load()

    PonderIndex.addPlugin(CreateEstrogenPonderPlugin)
    for (style in CreateEstrogenPackageStyles.estrogenPillStyles) {
        AllPartialModels.PACKAGES[style.itemId] = PartialModel.of(ResourceLocation(MOD_ID, "item/${style.itemId.path}"))
        AllPartialModels.PACKAGE_RIGGING[style.itemId] = PartialModel.of(style.riggingModel)
    }
}