package dev.myaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.ItemApplicationRecipeGen
import com.simibubi.create.content.kinetics.deployer.ItemApplicationRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenBlocks
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks

class CreateEstrogenItemApplicationRecipesGen(packOutput: PackOutput) : ItemApplicationRecipeGen(packOutput, MOD_ID) {
    init {
        create<ItemApplicationRecipe>("dormant_dream_block") {
            it.require(Blocks.TINTED_GLASS).require(Items.ENDER_PEARL).output(EstrogenBlocks.DormantDreamBlock)
        }
    }
}