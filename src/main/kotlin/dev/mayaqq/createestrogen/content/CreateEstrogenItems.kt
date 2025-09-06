package dev.mayaqq.createestrogen.content

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem
import dev.mayaqq.createestrogen.CreateEstrogen
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.stdlib.item

object CreateEstrogenItems: Registrar<Item> by CreateEstrogen..Registries.ITEM{
    val IncompleteEstrogenPatch by  item("incomplete_estrogen_patches", ::SequencedAssemblyItem) {
        properties {
            stacksTo(1)
        }
    }
    val IncompleteUwU by item("incomplete_uwu", ::SequencedAssemblyItem) {
        properties {
            stacksTo(1)
        }
    }

}