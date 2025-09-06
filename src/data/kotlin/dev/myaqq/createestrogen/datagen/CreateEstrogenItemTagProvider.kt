package dev.myaqq.createestrogen.datagen

import com.simibubi.create.AllTags
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class CreateEstrogenItemTagProvider(
    packOutput: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    p_275322_: CompletableFuture<TagLookup<Block>>,
    existingFileHelper: ExistingFileHelper?
) : ItemTagsProvider(packOutput, lookupProvider, p_275322_, MOD_ID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(AllTags.AllItemTags.SEATS.tag)
            .add(CreateEstrogenBlocks.MothSeat.value.asItem())
        tag(EstrogenTags.Items.NON_RECOLORABLE)
            .add(CreateEstrogenBlocks.MothSeat.value.asItem())
    }
}