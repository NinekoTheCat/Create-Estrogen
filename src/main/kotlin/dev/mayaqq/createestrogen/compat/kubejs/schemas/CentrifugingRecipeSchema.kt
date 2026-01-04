package dev.mayaqq.createestrogen.compat.kubejs.schemas

import com.google.gson.JsonElement
import com.mojang.serialization.JsonOps
import dev.latvian.mods.kubejs.fluid.FluidStackJS
import dev.latvian.mods.kubejs.fluid.InputFluid
import dev.latvian.mods.kubejs.fluid.OutputFluid
import dev.latvian.mods.kubejs.recipe.RecipeJS
import dev.latvian.mods.kubejs.recipe.RecipeKey
import dev.latvian.mods.kubejs.recipe.component.FluidComponents
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent
import dev.latvian.mods.kubejs.recipe.component.RecipeComponentWithParent
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema
import dev.mayaqq.createestrogen.content.recipes.RatioFluidIngredient
import dev.mayaqq.createestrogen.content.recipes.RatioFluidOutput

object CentrifugingRecipeSchema {
    val INPUTS = object : RecipeComponentWithParent<Array<InputFluid>> {
        override fun parentComponent(): RecipeComponent<Array<InputFluid>> =
            FluidComponents.INPUT_ARRAY
        override fun write(p0: RecipeJS, p1: Array<InputFluid>): JsonElement {
            val inputs = p1.map { it as FluidStackJS }.map { RatioFluidIngredient(WorkAround.getFluid(it),it.amount) }
            return JsonOps.INSTANCE.createList(inputs.map { RatioFluidIngredient.codec().encodeStart(JsonOps.INSTANCE,it).result().orElseThrow() }.stream())
        }

    }
    val RESULTS = object : RecipeComponentWithParent<OutputFluid> {
    override fun parentComponent(): RecipeComponent<OutputFluid> = FluidComponents.OUTPUT
    override fun write(p0: RecipeJS?, p1: OutputFluid?): JsonElement {
        p1 as FluidStackJS
        val realOutput = RatioFluidOutput(WorkAround.getFluid(p1),p1.amount)
        return RatioFluidOutput.codec().encodeStart(JsonOps.INSTANCE,realOutput).result().orElseThrow()
    }
    }
    val RESULTS_REAL: RecipeKey<OutputFluid?>? = RESULTS.key("result")
    val INPUTS_REAL: RecipeKey<Array<InputFluid>?>? = INPUTS.key("ingredients")
    val SCHEMA = RecipeSchema(RESULTS_REAL,INPUTS_REAL)

}