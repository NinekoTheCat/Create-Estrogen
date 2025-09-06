package dev.myaqq.createestrogen.datagen.recipe

import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen
import com.simibubi.create.content.fluids.transfer.FillingRecipe
import com.simibubi.create.content.kinetics.deployer.DeployerApplicationRecipe
import com.simibubi.create.content.kinetics.press.PressingRecipe
import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.createestrogen.content.CreateEstrogenItems
import dev.mayaqq.estrogen.content.EstrogenFluids
import dev.mayaqq.estrogen.content.EstrogenItems
import dev.myaqq.createestrogen.datagen.getFluidAmount
import net.minecraft.data.PackOutput
import net.minecraft.world.item.Items

class CreateEstrogenSequencedAssemblyRecipesGen(packOutput: PackOutput) :
    SequencedAssemblyRecipeGen(packOutput, MOD_ID) {
    init {
        create("estrogen_patch") {
            it.require(Items.PAPER)
                .transitionTo(CreateEstrogenItems.IncompleteEstrogenPatch)
                .addOutput(EstrogenItems.EstrogenPatches.getFullStack(), 120f)
                .addOutput(EstrogenItems.EstrogenPill, 16f)
                .addOutput(Items.PAPER, 5f)
                .addOutput(Items.SLIME_BALL, 5f)
                .addOutput(EstrogenItems.HorseUrineBottle, 4f)
                .loops(5)
                .addStep(::FillingRecipe) { rb -> rb.require(EstrogenFluids.MoltenSlime.value, getFluidAmount(27000)) }
                .addStep(::FillingRecipe) { rb ->
                    rb.require(
                        EstrogenFluids.LiquidEstrogen.value,
                        getFluidAmount(27000)
                    )
                }
                .addStep(::DeployerApplicationRecipe) { rb -> rb.require(Items.PAPER) }

        }
        create("uwu") {
            it.require(Items.NETHERITE_INGOT)
                .transitionTo(CreateEstrogenItems.IncompleteUwU)
                .addOutput(EstrogenItems.ColonThree, 1f)
                .loops(10)
                .addStep(::DeployerApplicationRecipe) { rb -> rb.require(Items.NETHER_STAR) }
                .addStep(::PressingRecipe) { rb -> rb }
                .addStep(::DeployerApplicationRecipe) { rb -> rb.require(Items.NETHER_STAR) }
                .addStep(::PressingRecipe) { rb -> rb }
                .addStep(::DeployerApplicationRecipe) { rb -> rb.require(Items.NETHER_STAR) }
                .addStep(::PressingRecipe) { rb -> rb }
        }
    }

}