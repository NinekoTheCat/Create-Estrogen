package dev.myaqq.createestrogen.datagen

import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks
import net.minecraft.data.PackOutput
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets

class CreateEstrogenLootTableProvider(
    output: PackOutput,
) : LootTableProvider(
    output,
    mutableSetOf(),
    mutableListOf(SubProviderEntry(::CreateEstrogenBlockLootTableSubProvider, LootContextParamSets.ALL_PARAMS))
)

class CreateEstrogenBlockLootTableSubProvider : BlockLootSubProvider(emptySet(), FeatureFlags.REGISTRY.allFlags()) {
    override fun generate() {
        dropSelf(CreateEstrogenBlocks.Centrifuge.value)
        dropSelf(CreateEstrogenBlocks.MothSeat.value)
    }

    override fun getKnownBlocks(): MutableIterable<Block> =
        mutableListOf(CreateEstrogenBlocks.MothSeat.value, CreateEstrogenBlocks.Centrifuge.value)
}