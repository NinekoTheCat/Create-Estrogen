package dev.mayaqq.createestrogen.content

import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.ponders.CentrifugeScenes
import net.createmod.ponder.api.registration.PonderPlugin
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper
import net.minecraft.resources.ResourceLocation

object CreateEstrogenPonderPlugin : PonderPlugin {
    override fun getModId(): String = MOD_ID

    override fun registerScenes(helper: PonderSceneRegistrationHelper<ResourceLocation>) {
        CreateEstrogen.info("registering scenes...")
        helper.forComponents(CreateEstrogenBlocks.Centrifuge.key.location())
            .addStoryBoard("centrifuge/intro", CentrifugeScenes::intro, AllCreatePonderTags.KINETIC_APPLIANCES)
            .addStoryBoard("centrifuge/basic", CentrifugeScenes::basic)
    }

    override fun registerTags(helper: PonderTagRegistrationHelper<ResourceLocation>) {
        helper.addToTag(AllCreatePonderTags.KINETIC_APPLIANCES).add(CreateEstrogenBlocks.Centrifuge.key.location())
        helper.addToTag(AllCreatePonderTags.DISPLAY_SOURCES).add(CreateEstrogenBlocks.MothSeat.key.location())
    }
}