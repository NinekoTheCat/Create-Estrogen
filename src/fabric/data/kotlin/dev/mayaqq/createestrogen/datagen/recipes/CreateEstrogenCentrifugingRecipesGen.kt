package dev.mayaqq.createestrogen.datagen.recipes

import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.datagen.lib.CentrifugingRecipesGen
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

class CreateEstrogenCentrifugingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : CentrifugingRecipesGen(output, MOD_ID) {
    init {
        create("liquid_estrogen") {
            addInput(EstrogenFluids.FiltratedHorseUrine.value, prh.fluidAmount(81))
            addOutput(EstrogenFluids.LiquidEstrogen.value, prh.fluidAmount(81))
        }
    }
}

