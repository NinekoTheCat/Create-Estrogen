package dev.mayaqq.createestrogen.datagen.models

import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.content.CreateEstrogenItems
import dev.mayaqq.createestrogen.id
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators
import net.minecraft.data.models.model.ModelLocationUtils
import net.minecraft.data.models.model.ModelTemplate
import net.minecraft.data.models.model.TextureMapping
import net.minecraft.data.models.model.TextureSlot
import net.minecraft.resources.ResourceLocation
import java.util.*

class CreateEstrogenModels(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockModelGenerators: BlockModelGenerators) {

    }

    override fun generateItemModels(img: ItemModelGenerators) {
        val textureMapping = TextureMapping.particle(id("item/package/estrogen_cardboard_particle"))
            .put(TextureSlot.LAYER0, id("item/package/estrogen_cardboard"))
        for (styleItem in CreateEstrogenItems.allEstrogenPillBoxes) {
            CreateEstrogen.info("creating item model for ${styleItem.value.style.itemId}")
            val style = styleItem.value.style
            val size = "_${style.width}x${style.height}"
            val template = ModelTemplate(
                Optional.of(ResourceLocation("create:item/package/cardboard$size")), Optional.empty(),
                TextureSlot.LAYER0, TextureSlot.PARTICLE
            )
            val riggingTemplate = ModelTemplate(
                Optional.of(ResourceLocation("create:item/package/rigging$size")), Optional.empty(),
                TextureSlot.LAYER0, TextureSlot.PARTICLE
            )
            template.create(ModelLocationUtils.getModelLocation(styleItem.value), textureMapping, img.output)
            riggingTemplate.create(style.riggingModel, textureMapping, img.output)
        }
    }

    override fun getName(): String = "CreateEstrogenModelProvider"
}