package dev.mayaqq.createestrogen.compat.recipeviewers


import dev.mayaqq.createestrogen.compat.recipeviewers.recipes.CentrifugingRvRecipe
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack

object GenericRecipeViewerPlugin {
    val removedFromRecipeViewers = listOf<ItemStack>()
    val removedRecipesFromRecipeViewers = listOf<ResourceLocation>()

    val rvRecipes = listOf(
        CentrifugingRvRecipe
    )
}