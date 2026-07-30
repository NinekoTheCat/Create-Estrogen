package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.EmptyingRecipeGen
import com.simibubi.create.content.fluids.transfer.EmptyingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.world.item.Items

class CreateEstrogenEmptyingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : EmptyingRecipeGen(output, MOD_ID) {
    init {
        create<EmptyingRecipe>("horse_urine") {
            it.require(EstrogenItems.HorseUrineBottle)
                .output(EstrogenFluids.HorseUrine.value, prh.fluidAmount(27000))
                .output(Items.GLASS_BOTTLE)
        }
    }
}