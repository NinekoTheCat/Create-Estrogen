package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.CompactingRecipeGen
import com.simibubi.create.content.kinetics.mixer.CompactingRecipe
import com.simibubi.create.foundation.fluid.FluidIngredient
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.world.item.Items

class CreateEstrogenCompactingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : CompactingRecipeGen(output, MOD_ID) {
    init {
        create<CompactingRecipe>("slime_ball") {
            it.require(FluidIngredient.fromFluid(EstrogenFluids.MoltenSlime.flowing, prh.fluidAmount(54000)))
                .output(Items.SLIME_BALL, 1)
        }
    }
}