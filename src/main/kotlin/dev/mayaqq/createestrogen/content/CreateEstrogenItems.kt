package dev.mayaqq.createestrogen.content

import com.simibubi.create.content.logistics.box.PackageItem
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.content.packages.CreateEstrogenPackageStyles
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.Item
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.api.entry.RegistryEntry
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
    val allEstrogenPillBoxes: List<RegistryEntry<PackageItem>> =
        CreateEstrogenPackageStyles.estrogenPillStyles.map { style ->
            style.itemId
            item(style.itemId.path, { PackageItem(it, style) }) {
                properties {
                    stacksTo(1)
                }

            }
        }

}