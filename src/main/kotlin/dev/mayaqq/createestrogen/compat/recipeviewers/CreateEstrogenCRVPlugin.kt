package dev.mayaqq.createestrogen.compat.recipeviewers


import dev.mayaqq.createestrogen.compat.recipeviewers.recipes.CentrifugingRvRecipe
import dev.mayaqq.estrogen.compat.recipeviewers.api.CRVPlugin
import dev.mayaqq.estrogen.compat.recipeviewers.api.CRVPluginEntrypoint
import dev.mayaqq.estrogen.compat.recipeviewers.api.ViewerInfo
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack

@CRVPluginEntrypoint
object CreateEstrogenCRVPlugin : CRVPlugin {
    override val removedItems: List<ItemStack> = listOf()
    override val removedRecipes: List<ResourceLocation> = listOf()
    override val recipes: List<ViewerInfo<*, *>> = listOf(CentrifugingRvRecipe)
}