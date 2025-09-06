package dev.myaqq.createestrogen.datagen.recipe

import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenFluids
import net.minecraft.data.PackOutput

class CreateEstrogenCentrifugingRecipesGen(output: PackOutput?
) : CentrifugingRecipesGen(output, MOD_ID) {
    init {
        create("liquid_estrogen") {
            addInput(EstrogenFluids.FiltratedHorseUrine.value, 81)
            addOutput(EstrogenFluids.LiquidEstrogen.value, 81)
        }
    }
}

