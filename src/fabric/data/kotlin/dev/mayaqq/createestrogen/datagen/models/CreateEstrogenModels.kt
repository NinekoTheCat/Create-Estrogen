package dev.mayaqq.createestrogen.datagen.models

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import dev.mayaqq.createestrogen.content.CreateEstrogenItems

class CreateEstrogenModels(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockModelGenerators: BlockModelGenerators) {

    }

    override fun generateItemModels(img: ItemModelGenerators) {
        /*TODO:
        for (styleItem in CreateEstrogenItems.allEstrogenPillBoxes) {
            val style = styleItem.value.style
            val size = "_${style.width}x${style.height}"
            img.generateFlatItem()
            this.getBuilder(style.itemId.path)
                .parent(ModelFile.UncheckedModelFile("create:item/package/cardboard$size"))
                .texture("0", "createestrogen:item/package/estrogen_cardboard")
                .texture("particle", "createestrogen:item/package/estrogen_cardboard_particle")
            this.getBuilder(style.riggingModel.path)
                .parent(ModelFile.UncheckedModelFile("create:item/package/rigging_${style.width}x${style.height}"))
                .texture("0", "createestrogen:item/package/estrogen_cardboard")
                .texture("particle", "createestrogen:item/package/estrogen_cardboard_particle")
        }

         */
    }
}