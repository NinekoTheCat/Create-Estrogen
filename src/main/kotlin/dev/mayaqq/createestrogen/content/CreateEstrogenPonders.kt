package dev.mayaqq.createestrogen.content

import dev.mayaqq.createestrogen.MOD_ID
import net.createmod.ponder.api.registration.PonderPlugin
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper
import net.minecraft.resources.ResourceLocation

object CreateEstrogenPonderPlugin : PonderPlugin {

    override fun getModId(): String = MOD_ID
    override fun registerScenes(helper: PonderSceneRegistrationHelper<ResourceLocation>) {
//        helper.addStoryBoard()
    }
}