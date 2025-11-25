package dev.mayaqq.createestrogen.datagen.recipes

import com.simibubi.create.api.data.recipe.ItemApplicationRecipeGen
import com.simibubi.create.content.kinetics.deployer.ItemApplicationRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenBlocks
import dev.mayaqq.estrogen.datagen.api.platform.PlatformRecipeHelper
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks

class CreateEstrogenItemApplicationRecipesGen(output: FabricDataOutput, prh: PlatformRecipeHelper) : ItemApplicationRecipeGen(output, MOD_ID) {
    init {
        create<ItemApplicationRecipe>("dormant_dream_block") {
            it.require(Blocks.TINTED_GLASS).require(Items.ENDER_PEARL).output(EstrogenBlocks.DreamBlock)
        }
    }
}