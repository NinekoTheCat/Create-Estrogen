package dev.mayaqq.createestrogen.datagen

import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.CreateEstrogenItems
import net.minecraft.data.PackOutput
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile
import net.minecraftforge.common.data.ExistingFileHelper

class CreateEstrogenItemModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) : ItemModelProvider(
    output, MOD_ID,
    existingFileHelper
) {
    override fun registerModels() {
        for (styleItem in CreateEstrogenItems.allEstrogenPillBoxes) {
            val style = styleItem.value.style
            val size = "_${style.width}x${style.height}"
            this.getBuilder(style.itemId.path)
                .parent(ModelFile.UncheckedModelFile("create:item/package/cardboard$size"))
                .texture("0", "createestrogen:item/package/estrogen_cardboard")
                .texture("particle", "createestrogen:item/package/estrogen_cardboard_particle")
            this.getBuilder(style.riggingModel.path)
                .parent(ModelFile.UncheckedModelFile("create:item/package/rigging_${style.width}x${style.height}"))
                .texture("0", "createestrogen:item/package/estrogen_cardboard")
                .texture("particle", "createestrogen:item/package/estrogen_cardboard_particle")
        }

    }
}