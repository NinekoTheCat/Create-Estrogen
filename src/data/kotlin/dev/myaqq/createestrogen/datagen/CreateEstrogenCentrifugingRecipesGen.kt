package dev.myaqq.createestrogen.datagen

import dev.mayaqq.createestrogen.MOD_ID
import net.minecraft.data.PackOutput
import net.minecraft.world.level.material.Fluids

class CreateEstrogenCentrifugingRecipesGen(output: PackOutput?
) : CentrifugingRecipesGen(output, MOD_ID) {
    var TEST = create("test") {
        addInput(Fluids.LAVA,1)
        addOutput(Fluids.WATER,20)
    }
}

