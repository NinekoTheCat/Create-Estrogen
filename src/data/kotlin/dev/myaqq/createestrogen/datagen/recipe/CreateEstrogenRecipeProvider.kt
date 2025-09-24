package dev.myaqq.createestrogen.datagen.recipe

import com.simibubi.create.AllBlocks
import com.simibubi.create.AllItems
import com.simibubi.create.api.data.recipe.BaseRecipeProvider
import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.myaqq.createestrogen.datagen.getCommonTag
import net.minecraft.data.CachedOutput
import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.tags.ItemTags
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer


class CreateEstrogenRecipeProvider(output: PackOutput) : RecipeProvider(output) {
    override fun buildRecipes(writer: Consumer<FinishedRecipe>) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, EstrogenItems.EstrogenChipCookie)
            .requires(EstrogenItems.EstrogenPill)
            .unlockedBy(getHasName(EstrogenItems.EstrogenPill), has(EstrogenItems.EstrogenPill))
            .requires(AllItems.WHEAT_FLOUR)
            .requires(AllItems.BAR_OF_CHOCOLATE)
            .save(writer)
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, CreateEstrogenBlocks.Centrifuge, 1)
            .define('P', AllBlocks.MECHANICAL_PUMP)
            .define('T', AllBlocks.FLUID_TANK)
            .define('C', getCommonTag("copper_plates"))
            .define('M', AllItems.PRECISION_MECHANISM)
            .pattern("CTC")
            .pattern("PMP")
            .pattern("CTC")
            .unlockedBy(getHasName(AllItems.PRECISION_MECHANISM), has(AllItems.PRECISION_MECHANISM))
            .save(writer)
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CreateEstrogenBlocks.MothSeat)
            .requires(EstrogenBlocks.QuiltedMothWool, 1)
            .requires(ItemTags.WOODEN_SLABS)
            .unlockedBy(
                getHasName(EstrogenBlocks.MothWool), has(EstrogenBlocks.MothWool)
            )
            .save(writer)
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, EstrogenBlocks.CookieJar, 1)
            .define('G', getCommonTag("glass_panes"))
            .define('Z', getCommonTag("zinc_nuggets"))
            .pattern("GZG")
            .pattern("G G")
            .pattern("GGG")
            .unlockedBy(getHasName(AllItems.ZINC_NUGGET), has(AllItems.ZINC_NUGGET))
            .save(writer)


    }

    companion object {
        val GENERATORS: MutableList<BaseRecipeProvider> = ArrayList(11)
        fun registerAllProcessing(gen: DataGenerator, output: PackOutput) {
            GENERATORS += arrayOf(
                CreateEstrogenCentrifugingRecipesGen(output),
                CreateEstrogenCompactingRecipesGen(output),
                CreateEstrogenDeployingRecipesGen(output),
                CreateEstrogenEmptyingRecipesGen(output),
                CreateEstrogenFillingRecipesGen(output),
                CreateEstrogenItemApplicationRecipesGen(output),
                CreateEstrogenMillingRecipesGen(output),
                CreateEstrogenMixingRecipesGen(output),
                CreateEstrogenSandpaperPolishingRecipesGen(output),
                CreateEstrogenSequencedAssemblyRecipesGen(output),
                CreateEstrogenSplashingRecipesGen(output)
            )

            gen.addProvider(true, object : DataProvider {
                override fun getName(): String = "Create: Estrogen's Recipes"


                override fun run(output: CachedOutput): CompletableFuture<*> = CompletableFuture.allOf(
                    *GENERATORS.map { it.run(output) }.toTypedArray()
                )
            })
        }
    }
}