package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.AllBlocks
import com.simibubi.create.AllItems
import dev.mayaqq.createestrogen.content.CreateEstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenBlocks
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.data.recipes.*
import net.minecraft.tags.ItemTags
import java.util.function.Consumer


class CreateEstrogenRecipeProvider(output: FabricDataOutput, val prh: PlatformRecipeHelper) : RecipeProvider(output) {
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
            .define('C', prh.commonTag("copper_plates"))
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
            .define('G', prh.commonTag("glass_panes"))
            .define('Z', prh.commonTag("zinc_nuggets"))
            .pattern("GZG")
            .pattern("G G")
            .pattern("GGG")
            .unlockedBy(getHasName(AllItems.ZINC_NUGGET), has(AllItems.ZINC_NUGGET))
            .save(writer)


    }
}