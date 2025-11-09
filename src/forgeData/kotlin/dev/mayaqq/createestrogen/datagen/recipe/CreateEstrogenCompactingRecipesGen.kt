package dev.mayaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.CompactingRecipeGen
import com.simibubi.create.content.kinetics.mixer.CompactingRecipe
import com.simibubi.create.foundation.fluid.FluidIngredient
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.datagen.getFluidAmount
import dev.mayaqq.estrogen.content.EstrogenFluids
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items

class CreateEstrogenCompactingRecipesGen(output: PackOutput) : CompactingRecipeGen(output, MOD_ID) {
    init {
        create<CompactingRecipe>("slime_ball") {
            it.require(FluidIngredient.fromFluid(EstrogenFluids.MoltenSlime.flowing, getFluidAmount(54000)))
                .output(Items.SLIME_BALL, 1)
        }
    }
}