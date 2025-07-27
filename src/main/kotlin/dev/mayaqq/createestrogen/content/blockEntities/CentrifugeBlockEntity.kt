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

private class RecipeWithProgress(val recipe: CentrifugingRecipe) {
    var progress: Float = 0f
        private set
    val isFinished get() = progress >= recipe.processingTime

    fun increment(rpm: Float) {
        val processingSpeed = Mth.clamp(rpm / 24, 1f, 128f)
        progress += processingSpeed
        progress.coerceIn(0f..recipe.processingTime.toFloat())
    }
}
// TODO: Register impact with BlockStressValues.java
class CentrifugeBlockEntity(type: BlockEntityType<*>, pos: BlockPos, state: BlockState) :
    KineticBlockEntity(type, pos, state) {
    private var currentRecipeWithProgress: RecipeWithProgress? = null
    override fun tick() {
        super.tick()
        if (isVirtual || level?.isClientSide == true || speed.absoluteValue < 256) return
        val currentLevel = level as ServerLevel
        val outputFluidTank = FluidContainer.of(currentLevel, blockPos, Direction.UP)
        if (currentRecipeWithProgress?.isFinished == true && outputFluidTank != null)
            finishRecipe(outputFluidTank)
        if (!isOverStressed) {
            currentRecipeWithProgress?.increment(getSpeed())
        }
        if (currentRecipeWithProgress != null || outputFluidTank == null) return
        val inputFluidTank = FluidContainer.of(currentLevel, blockPos, Direction.DOWN) ?: return
        if (!inputFluidTank.allowsExtraction()) return
        if (!outputFluidTank.allowsInsertion()) return
        val foundRecipe = findApplicableRecipes(currentLevel, inputFluidTank).firstOrNull() ?: return
        startRecipe(foundRecipe, inputFluidTank, outputFluidTank)
    }

    private fun startRecipe(recipe: CentrifugingRecipe, inputTank: FluidContainer, outputTank: FluidContainer) {
        // check if we can actually output it
        if (recipe.result.fluidAmount != outputTank.insertFluid(recipe.result.copyHolder(), true)) return
        // can we actually extract those fluids to start it
        val canStartRecipe = recipe.inputs.fluids.toList().all {
            val extracted = inputTank.extractFluid(it.copyHolder(), true)
            extracted.fluidAmount == it.fluidAmount
        }
        if (!canStartRecipe) return
        /// actually extract the fluids
        val actuallyStarted = recipe.inputs.fluids.toList().all {
            val extracted = inputTank.extractFluid(it.copyHolder(), false)
            extracted.fluidAmount == it.fluidAmount
        }
        if (!actuallyStarted) throw UnexpectedException("Container $inputTank lied when simulated to $this!")
        this.currentRecipeWithProgress = RecipeWithProgress(recipe)
    }

    private fun finishRecipe(output: FluidContainer) {
        val result = currentRecipeWithProgress!!.recipe.result.copyHolder()
        // check if we can actually output the amount listed
        if (output.insertFluid(result.copyHolder(), true) != result.fluidAmount) return
        if (output.insertFluid(result.copyHolder(), false) != result.fluidAmount)
            throw UnexpectedException("Container $output lied when simulated to $this!")
        currentRecipeWithProgress = null
    }

    private fun findApplicableRecipes(serverLevel: ServerLevel, inputTank: FluidContainer): List<CentrifugingRecipe> {
        val container = CentrifugingContainer(inputTank)
        return serverLevel.server.recipeManager.getAllRecipesFor(CreateEstrogenRecipes.CENTRIFUGING).filter {
            it.matches(container, serverLevel)
        }
    }
}