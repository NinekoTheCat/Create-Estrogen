package dev.mayaqq.createestrogen.utils.recipe

import com.google.gson.JsonObject
import com.mojang.serialization.JsonOps
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder
import dev.mayaqq.createestrogen.content.recipes.CentrifugingRecipe
import dev.mayaqq.createestrogen.content.recipes.RatioFluidIngredient
import dev.mayaqq.createestrogen.content.recipes.RatioFluidOutput
import dev.mayaqq.createestrogen.id
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.material.Fluid
import java.util.function.Consumer

class CreateEstrogenCentrifugingRecipeBuilder(val _id: ResourceLocation) {
    private val recipeInputs = mutableListOf<RatioFluidIngredient>()
    private var recipeOutput: RatioFluidOutput? = null

    fun addInput(fluid: Fluid,amountPerTick: Long) : CreateEstrogenCentrifugingRecipeBuilder {
        recipeInputs.add(RatioFluidIngredient(fluid,amountPerTick))
        return this
    }
    fun addOutput(fluid: Fluid,amountPerTick: Long): CreateEstrogenCentrifugingRecipeBuilder {
        recipeOutput = RatioFluidOutput(fluid,amountPerTick)
        return this
    }
     fun build(): CentrifugingRecipe {
        return CentrifugingRecipe(_id,recipeInputs,recipeOutput!!)
    }

    fun build(consumer: Consumer<FinishedRecipe?>) {
        consumer.accept(
            DataGenResult(
                this.build()
            )
        )
    }
    class DataGenResult(val recipe: CentrifugingRecipe) : FinishedRecipe {
        override fun serializeRecipeData(json: JsonObject)  {
            CentrifugingRecipe.codec(recipe.id).encode(recipe,JsonOps.INSTANCE,json)
        }
            override fun getId(): ResourceLocation  = ResourceLocation(recipe.id.namespace, "centrifuging/${recipe.id.path}")

        override fun getType(): RecipeSerializer<*> =recipe.serializer

        override fun serializeAdvancement(): JsonObject? = null

        override fun getAdvancementId(): ResourceLocation? = null
    }
}

