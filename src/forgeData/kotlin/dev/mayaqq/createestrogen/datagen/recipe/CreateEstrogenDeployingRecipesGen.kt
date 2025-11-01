package dev.mayaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.DeployingRecipeGen
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenItems
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items

class CreateEstrogenDeployingRecipesGen(packOutput: PackOutput) : DeployingRecipeGen(packOutput, MOD_ID) {
    init {
        this.create<DeployerApplicationRecipe>("moth_elytra") {
            it
                .require(Items.ELYTRA)
                .require(EstrogenItems.MothFuzz)
                .output(EstrogenItems.MothElytra)
        }
    }
}