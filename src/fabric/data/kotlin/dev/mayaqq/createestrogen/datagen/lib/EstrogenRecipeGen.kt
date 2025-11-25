package dev.mayaqq.createestrogen.datagen.lib

import com.simibubi.create.api.data.recipe.ProcessingRecipeGen
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput

//TODO: this for custom recipe gen i think
class EstrogenRecipeGen(
    output: FabricDataOutput, val helper: PlatformRecipeHelper, val recipeTypeInfo: IRecipeTypeInfo
) : ProcessingRecipeGen(
    output,
    MOD_ID,
) {
    override fun getRecipeType(): IRecipeTypeInfo = recipeTypeInfo
}