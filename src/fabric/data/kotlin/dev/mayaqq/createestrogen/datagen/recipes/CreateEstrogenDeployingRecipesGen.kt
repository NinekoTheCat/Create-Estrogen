package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.DeployingRecipeGen
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.world.item.Items

class CreateEstrogenDeployingRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : DeployingRecipeGen(output, MOD_ID) {
    init {
        this.create<DeployerApplicationRecipe>("moth_elytra") {
            it
                .require(Items.ELYTRA)
                .require(EstrogenItems.MothFuzz)
                .output(EstrogenItems.MothElytra)
        }
    }
}