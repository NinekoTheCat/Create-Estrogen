package dev.mayaqq.createestrogen.generics;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface CreateEstrogenItemHandler {
    int getSlots();

    @NotNull ItemStack getStackInSlot(int slot);

    CompoundTag serializeNBT();
}
