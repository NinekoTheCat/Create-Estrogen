package dev.mayaqq.createestrogen.compat.recipeviewers.recipes

import dev.mayaqq.createestrogen.content.recipes.CentrifugingRecipe
import dev.mayaqq.estrogen.client.content.textures.RecipeTextures
import dev.mayaqq.estrogen.compat.recipeviewers.api.CRVIngredient
import dev.mayaqq.estrogen.compat.recipeviewers.api.CRVRecipe
import dev.mayaqq.estrogen.compat.recipeviewers.api.Role
import dev.mayaqq.estrogen.compat.recipeviewers.api.ViewerInfo
import dev.mayaqq.estrogen.compat.recipeviewers.api.elements.GuiBlockRenderer
import dev.mayaqq.estrogen.content.EstrogenBlocks
import net.minecraft.world.phys.Vec3


class CentrifugingRvRecipe(recipe: CentrifugingRecipe) : CRVRecipe<CentrifugingRecipe>(recipe) {

    override fun init() {
        addTexture(RecipeTextures.JEI_LONG_ARROW, 31, 51);
        addTexture(RecipeTextures.JEI_SHADOW, 40, 36);

        addSlot(inputs[0], 5, 51, Role.INPUT)
        addSlot(outputs[0], 110, 51, Role.OUTPUT)

        addDrawable(55, 40, GuiBlockRenderer(
            EstrogenBlocks.Centrifuge.defaultBlockState(),
            null,
            0, 0, 0,
            Vec3(22.5, 45.0, 0.0),
            20.0))
    }

    override val inputs: List<CRVIngredient> = listOf(CRVIngredient.of(recipe.inputs.first().fluid))

    override val outputs: List<CRVIngredient> = listOf(CRVIngredient.of(recipe.result.fluid))

    override val catalysts: List<CRVIngredient> = listOf(CRVIngredient.of(EstrogenBlocks.Centrifuge.asItem().defaultInstance))

    companion object : ViewerInfo<CentrifugingRecipe, CentrifugingRvRecipe>(
        CentrifugingRecipe,
        { CentrifugingRvRecipe(it as CentrifugingRecipe) },
        CentrifugingRecipe::class
    )
}