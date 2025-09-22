package dev.mayaqq.createestrogen.compat.recipeviewers.recipes

import dev.mayaqq.createestrogen.content.recipes.CentrifugingRecipe
import dev.mayaqq.estrogen.client.content.textures.RecipeTextures
import dev.mayaqq.estrogen.compat.recipeviewers.base.RVRecipe
import dev.mayaqq.estrogen.compat.recipeviewers.base.Role
import dev.mayaqq.estrogen.compat.recipeviewers.base.RvRecipeData
import dev.mayaqq.estrogen.compat.recipeviewers.base.ingredient.RvIngredient
import dev.mayaqq.estrogen.content.EstrogenBlocks


class CentrifugingRvRecipe(recipe: CentrifugingRecipe) : RVRecipe<CentrifugingRecipe>(recipe) {
    val centrifuge = CentrifugeBlockElement()

    override fun init() {
        addTexture(RecipeTextures.JEI_SHADOW, 62, 37)
        addTexture(RecipeTextures.JEI_ARROW, 7 + 18 + 4, 32)
        addTexture(RecipeTextures.JEI_ARROW, 152 - 42 - 4, 32)
        addSlot(inputs()[0], 7, 28, Role.INPUT)
        addSlot(outputs()[0], 152, 28, Role.OUTPUT)
        addTexture(RecipeTextures.JEI_LONG_ARROW, 31, 51)
        addTexture(RecipeTextures.JEI_SHADOW, 40, 36)

        addSlot(inputs()[0], 5, 51, Role.INPUT)

        addSlot(outputs()[0], 110, 51, Role.OUTPUT)

        addDrawable(55, 40) { graphics, offsetX, offsetY, mouseX, mouseY, delta ->
            centrifuge.draw(graphics, offsetX, offsetY)
        }
    }

    override fun inputs(): List<RvIngredient> = listOf(RvIngredient.of(recipe.inputs.first().fluid))

    override fun outputs(): List<RvIngredient> = listOf(RvIngredient.of(recipe.result.fluid))

    override fun catalysts(): List<RvIngredient> = listOf(RvIngredient.of(EstrogenBlocks.Centrifuge.asItem().defaultInstance))

    companion object : RvRecipeData<CentrifugingRecipe, CentrifugingRvRecipe>(CentrifugingRecipe, CentrifugingRvRecipe::class, CentrifugingRecipe::class)
}