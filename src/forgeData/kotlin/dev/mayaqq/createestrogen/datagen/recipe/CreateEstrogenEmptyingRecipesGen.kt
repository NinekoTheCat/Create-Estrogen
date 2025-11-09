package dev.mayaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.EmptyingRecipeGen
import com.simibubi.create.content.fluids.transfer.EmptyingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.datagen.getFluidAmount
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.EstrogenItems
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items

class CreateEstrogenEmptyingRecipesGen(packOutput: PackOutput) : EmptyingRecipeGen(packOutput, MOD_ID) {
    init {
        create<EmptyingRecipe>("horse_urine") {
            it.require(EstrogenItems.HorseUrineBottle)
                .output(EstrogenFluids.HorseUrine.value, getFluidAmount(27000))
                .output(Items.GLASS_BOTTLE)
        }
    }
}