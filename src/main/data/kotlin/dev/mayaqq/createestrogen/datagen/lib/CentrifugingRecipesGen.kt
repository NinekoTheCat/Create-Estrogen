package dev.mayaqq.createestrogen.datagen.lib

import com.simibubi.create.api.data.recipe.BaseRecipeProvider
import dev.mayaqq.createestrogen.utils.recipe.CreateEstrogenCentrifugingRecipeBuilder
import net.minecraft.data.PackOutput

abstract class CentrifugingRecipesGen(output: PackOutput?,modId: String) : BaseRecipeProvider(output,modId ) {

    override fun getName(): String {
        return "$modid's Centrifuging Recipes"
    }
    protected fun create(name: String, transform: CreateEstrogenCentrifugingRecipeBuilder.() -> CreateEstrogenCentrifugingRecipeBuilder) : GeneratedRecipe {
        val recipe = GeneratedRecipe {
            transform.invoke(
                CreateEstrogenCentrifugingRecipeBuilder(
                    asResource(
                        name
                    )
                )
            ).build(it)
        }
        all.add(recipe)
        return recipe
    }

}