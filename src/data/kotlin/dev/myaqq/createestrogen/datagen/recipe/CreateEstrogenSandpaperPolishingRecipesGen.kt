package dev.myaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.PolishingRecipeGen
import com.simibubi.create.content.equipment.sandPaper.SandPaperPolishingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import net.minecraft.data.PackOutput

class CreateEstrogenSandpaperPolishingRecipesGen(packOutput: PackOutput) : PolishingRecipeGen(packOutput, MOD_ID) {
    init {
        create<SandPaperPolishingRecipe>("testosterone_chunk") {
            it.require(EstrogenItems.Balls)
                .output(EstrogenItems.TestosteroneChunk, 1)
        }
    }
}