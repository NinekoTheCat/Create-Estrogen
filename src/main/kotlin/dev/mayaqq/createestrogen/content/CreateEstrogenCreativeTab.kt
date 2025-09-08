package dev.mayaqq.createestrogen.content

import dev.mayaqq.createestrogen.CreateEstrogen
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.stdlib.creativeTab

object CreateEstrogenCreativeTab: Registrar<CreativeModeTab> by CreateEstrogen..Registries.CREATIVE_MODE_TAB {
    val CreateEstrogen = creativeTab("createestrogen") {
        title = Component.translatable("itemGroup.createestrogen.createestrogen")
        icon { CreateEstrogenBlocks.Centrifuge.value.asItem().defaultInstance }
        displayItems {
            accept(CreateEstrogenBlocks.Centrifuge.value)
            accept(CreateEstrogenBlocks.MothSeat.value)
            acceptAll(CreateEstrogenItems.allEstrogenPillBoxes.map { it.value.defaultInstance })
        }
    }
}