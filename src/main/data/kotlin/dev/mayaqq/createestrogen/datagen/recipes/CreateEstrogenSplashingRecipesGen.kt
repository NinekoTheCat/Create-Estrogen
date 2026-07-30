package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.WashingRecipeGen
import com.simibubi.create.content.kinetics.fan.processing.SplashingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.data.PackOutput

class CreateEstrogenSplashingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : WashingRecipeGen(output, MOD_ID) {
    init {
        create<SplashingRecipe>("thigh_high_washing") {
            it.require(EstrogenItems.ThighHighs).output(EstrogenItems.ThighHighs)
        }
    }
}