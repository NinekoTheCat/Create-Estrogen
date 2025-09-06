package dev.mayaqq.createestrogen.content
import net.minecraft.core.registries.Registries
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.cynosure.recipes.codecSerializer
import dev.mayaqq.cynosure.recipes.recipeType
import dev.mayaqq.createestrogen.content.recipes.CentrifugingRecipe
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.item.crafting.RecipeType
import uwu.serenity.kritter.api.Registrar



object CreateEstrogenRecipes : Registrar<RecipeType<*>> by CreateEstrogen..Registries.RECIPE_TYPE {
    val CENTRIFUGING by recipeType<CentrifugingRecipe>("centrifuging")

    object Serializers : Registrar<RecipeSerializer<*>> by sibling(Registries.RECIPE_SERIALIZER) {
        val CENTRIFUGING_SERIALIZER by codecSerializer("centrifuging",
            CentrifugingRecipe::codec, CentrifugingRecipe::netCodec) {}
    }
}