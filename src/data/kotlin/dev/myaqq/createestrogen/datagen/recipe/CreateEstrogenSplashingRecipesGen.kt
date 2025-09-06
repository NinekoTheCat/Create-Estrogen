package dev.myaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.WashingRecipeGen
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import net.minecraft.data.PackOutput

class CreateEstrogenSplashingRecipesGen(packOutput: PackOutput) : WashingRecipeGen(packOutput, MOD_ID) {
    init {
        create<SplashingRecipe>("thigh_high_washing") {
            it.require(EstrogenItems.ThighHighs).output(EstrogenItems.ThighHighs)
        }
    }
}