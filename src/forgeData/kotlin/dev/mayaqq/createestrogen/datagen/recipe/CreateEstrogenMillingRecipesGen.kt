package dev.mayaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.MillingRecipeGen
import com.simibubi.create.content.kinetics.millstone.MillingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import net.minecraft.data.PackOutput

class CreateEstrogenMillingRecipesGen(packOutput: PackOutput) : MillingRecipeGen(packOutput, MOD_ID) {
    init {
        create<MillingRecipe>("testosterone_powder") {
            it.require(EstrogenItems.TestosteroneChunk).output(EstrogenItems.TestosteronePowder, 3)
        }
    }
}