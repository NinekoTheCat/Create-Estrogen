package dev.mayaqq.createestrogen.fabric.extensions

import dev.mayaqq.createestrogen.generics.CreateEstrogenItemHandler
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandler
import net.minecraft.nbt.CompoundTag
import net.minecraft.world.item.ItemStack

@JvmRecord
data class ItemHandlerWrapper(val handler: ItemStackHandler) : CreateEstrogenItemHandler {
    override fun getSlots(): Int {
        return handler.slotCount
    }

    override fun getStackInSlot(slot: Int): ItemStack {
        return handler.getStackInSlot(slot)
    }

    override fun serializeNBT(): CompoundTag? {
        return handler.serializeNBT()
    }
}