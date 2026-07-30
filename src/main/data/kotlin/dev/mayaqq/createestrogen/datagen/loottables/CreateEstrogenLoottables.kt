package dev.mayaqq.createestrogen.datagen.loottables

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks

class CreateEstrogenLoottables(output: FabricDataOutput) : FabricBlockLootTableProvider(output) {
    override fun generate() {
        dropSelf(CreateEstrogenBlocks.Centrifuge)
        dropSelf(CreateEstrogenBlocks.MothSeat)
    }
}