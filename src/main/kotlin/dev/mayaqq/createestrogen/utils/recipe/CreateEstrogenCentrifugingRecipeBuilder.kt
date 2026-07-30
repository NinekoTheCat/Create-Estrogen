package dev.mayaqq.createestrogen.utils.recipe


import dev.mayaqq.createestrogen.content.recipes.CentrifugingRecipe
import dev.mayaqq.createestrogen.content.recipes.RatioFluidIngredient
import dev.mayaqq.createestrogen.content.recipes.RatioFluidOutput
import net.minecraft.advancements.Advancement
import net.minecraft.advancements.Criterion
import net.minecraft.data.recipes.RecipeBuilder
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import net.minecraft.world.level.material.Fluid


class CreateEstrogenCentrifugingRecipeBuilder(val _id: ResourceLocation) : RecipeBuilder {
    private val recipeInputs = mutableListOf<RatioFluidIngredient>()
    private var recipeOutput: RatioFluidOutput? = null
    protected val advancementBuilder: Advancement.Builder = Advancement.Builder.recipeAdvancement()
    fun addInput(fluid: Fluid, amountPerTick: Long): CreateEstrogenCentrifugingRecipeBuilder {
        recipeInputs.add(RatioFluidIngredient(fluid, amountPerTick))
        return this
    }

    fun addOutput(fluid: Fluid, amountPerTick: Long): CreateEstrogenCentrifugingRecipeBuilder {
        recipeOutput = RatioFluidOutput(fluid, amountPerTick)
        return this
    }

    fun build(): CentrifugingRecipe {
        return CentrifugingRecipe(_id, recipeInputs, recipeOutput!!)
    }

    override fun unlockedBy(
        name: String,
        criterion: Criterion<*>
    ): RecipeBuilder {
        this.advancementBuilder.addCriterion(name, criterion)
        return this
    }

    override fun group(groupName: String?): RecipeBuilder {
        return this
    }

    override fun getResult(): Item =
        recipeOutput!!.fluid.bucket


    override fun save(
        recipeOutput: RecipeOutput,
        id: ResourceLocation
    ) {
        val recipe = CentrifugingRecipe(_id, recipeInputs, this.recipeOutput!!)
        recipeOutput.accept(id, recipe, advancementBuilder.build(id))
    }
}



