package dev.mayaqq.createestrogen.datagen

import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

fun getFluidAmount(amount: Int): Int {
    val fabricBucket = 81000.0
    val forgeBucket = 1000.0
    if (amount == 27000) return 250
    if (amount == 54000) return 500
    return (((amount / fabricBucket) * forgeBucket).toInt())
}

fun getCommonTag(name: String): TagKey<Item> {
    val name = when (name) {
        "copper_plates" -> "plates/copper"
        "zinc_nuggets" -> "nuggets/zinc"
        else -> name
    }
    return TagKey.create(Registries.ITEM, ResourceLocation("forge", name))
}