package dev.mayaqq.createestrogen.forge.extensions

import dev.mayaqq.createestrogen.generics.CreateEstrogenItemHandler
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.item.ItemStack
import net.minecraftforge.items.ItemStackHandler

@JvmRecord
data class ItemHandlerWrapper(val handler: ItemStackHandler) : CreateEstrogenItemHandler {
    override fun getSlots(): Int {
        return handler.slots
    }

    override fun getStackInSlot(slot: Int): ItemStack {
        return handler.getStackInSlot(slot)
    }

    override fun serializeNBT(): CompoundTag? {
        return handler.serializeNBT()
    }
}