package dev.myaqq.createestrogen.datagen

import com.simibubi.create.api.data.recipe.BaseRecipeProvider
import net.minecraft.data.CachedOutput
import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeProvider
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer


class CreateEstrogenRecipeProvider(output: PackOutput) : RecipeProvider(output) {
    override fun buildRecipes(writer: Consumer<FinishedRecipe>) {}

    companion object {
        val GENERATORS: MutableList<BaseRecipeProvider> = ArrayList()
        fun registerAllProcessing(gen: DataGenerator, output: PackOutput) {
            GENERATORS.add(CreateEstrogenCentrifugingRecipesGen(output))
            gen.addProvider(true, object : DataProvider {
                override fun getName(): String = "Create: Estrogen's Recipes"


                override fun run(output: CachedOutput): CompletableFuture<*> = CompletableFuture.allOf(*GENERATORS.map { it.run(output) }.toTypedArray()
                )
            })
        }
    }
}