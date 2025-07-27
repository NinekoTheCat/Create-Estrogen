package dev.mayaqq.createestrogen.content.blockEntities

import com.simibubi.create.content.kinetics.base.KineticBlockEntity
import dev.mayaqq.createestrogen.content.CreateEstrogenRecipes
import dev.mayaqq.createestrogen.content.recipes.CentrifugingContainer
import dev.mayaqq.createestrogen.content.recipes.CentrifugingRecipe
import earth.terrarium.botarium.common.fluid.base.FluidContainer
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.Mth
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import java.rmi.UnexpectedException
import kotlin.math.absoluteValue

// TODO: Register impact with BlockStressValues.java
class CentrifugeBlockEntity(type: BlockEntityType<*>, pos: BlockPos, state: BlockState) :
    KineticBlockEntity(type, pos, state) {
    override fun tick() {
        super.tick()
        if (isVirtual || level?.isClientSide == true || speed.absoluteValue < 256) return
        val currentLevel = level as ServerLevel
        val outputFluidTank = FluidContainer.of(currentLevel, blockPos, Direction.UP) ?: return
        val inputFluidTank = FluidContainer.of(currentLevel, blockPos, Direction.DOWN) ?: return
        if (!inputFluidTank.allowsExtraction()) return
        if (!outputFluidTank.allowsInsertion()) return
        val foundRecipe = findApplicableRecipes(currentLevel, inputFluidTank).firstOrNull() ?: return
        doRecipe(foundRecipe, inputFluidTank, outputFluidTank)
    }

    private fun doRecipe(recipe: CentrifugingRecipe, inputTank: FluidContainer, outputTank: FluidContainer) {
        // check if we can actually output it
        if (recipe.result.amountPerTick != outputTank.insertFluid(recipe.result.holder, true)) return
        // can we actually extract those fluids to start it
        val canStartRecipe = recipe.inputs.toList().all {
            val extracted = inputTank.extractFluid(it.holder, true)
            extracted.fluidAmount == it.amountPerTick
        }
        if (!canStartRecipe) return
        /// actually extract the fluids
        val actuallyExtracted = recipe.inputs.toList().all {
            val extracted = inputTank.extractFluid(it.holder, false)
            extracted.fluidAmount == it.amountPerTick
        }
        if (!actuallyExtracted) throw UnexpectedException("Container $inputTank lied when simulated to $this!")
        val inserted = outputTank.insertFluid(recipe.result.holder,false)
        if (inserted != recipe.result.amountPerTick) throw UnexpectedException("Container $inputTank lied when simulated to $this!")
    }


    private fun findApplicableRecipes(serverLevel: ServerLevel, inputTank: FluidContainer): List<CentrifugingRecipe> {
        val container = CentrifugingContainer(inputTank)
        return serverLevel.server.recipeManager.getAllRecipesFor(CreateEstrogenRecipes.CENTRIFUGING).filter {
            it.matches(container, serverLevel)
        }
    }
}