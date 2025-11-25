package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.MillingRecipeGen
import com.simibubi.create.content.kinetics.millstone.MillingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.data.PackOutput

class CreateEstrogenMillingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : MillingRecipeGen(output, MOD_ID) {
    init {
        create<MillingRecipe>("testosterone_powder") {
            it.require(EstrogenItems.TestosteroneChunk).output(EstrogenItems.TestosteronePowder, 3)
        }
    }
}