package dev.myaqq.createestrogen.datagen

import com.simibubi.create.AllTags
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class CreateEstrogenBlockTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, lookupProvider, MOD_ID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(EstrogenTags.Blocks.PICKAXE_MINABLE)
            .add(CreateEstrogenBlocks.Centrifuge)
        tag(BlockTags.MINEABLE_WITH_AXE)
            .add(CreateEstrogenBlocks.MothSeat)
        tag(AllTags.AllBlockTags.SEATS.tag)
            .add(CreateEstrogenBlocks.MothSeat)

    }
}