package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.PolishingRecipeGen
import com.simibubi.create.content.equipment.sandPaper.SandPaperPolishingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class CreateEstrogenSandpaperPolishingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : PolishingRecipeGen(output, MOD_ID) {
    init {
        create<SandPaperPolishingRecipe>("testosterone_chunk") {
            it.require(EstrogenItems.Balls)
                .output(EstrogenItems.TestosteroneChunk, 1)
        }
    }
}