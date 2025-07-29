package dev.mayaqq.createestrogen.test

import dev.mayaqq.createestrogen.MOD_ID
import earth.terrarium.botarium.common.fluid.base.FluidContainer
import earth.terrarium.botarium.common.fluid.base.FluidHolder
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.gametest.framework.GameTest
import net.minecraft.gametest.framework.GameTestHelper
import net.minecraft.world.level.material.Fluids
import net.minecraftforge.gametest.GameTestHolder
import net.minecraftforge.gametest.PrefixGameTestTemplate
// TODO: replace with whatever is fabric's version of this
@GameTestHolder(MOD_ID)
class CentrifugeTests {
    @PrefixGameTestTemplate(false)
    @GameTest(template = "centrifugetest", timeoutTicks = 1)
    fun testCentrifugeCrafts(gameTestHelper: GameTestHelper) {
        val centrifugePosition = gameTestHelper.absolutePos(BlockPos(0,3,0))
        val centrifugeInputTankPosition = gameTestHelper.absolutePos(BlockPos(0,2,0))
        val centrifugeOutputTankPosition = gameTestHelper.absolutePos(BlockPos(0,4,0))
        val inputTank  = FluidContainer.of(gameTestHelper.level,centrifugeInputTankPosition,Direction.UP)!!

        val outputTank  = FluidContainer.of(gameTestHelper.level,centrifugeOutputTankPosition,Direction.DOWN)!!
        inputTank.insertFluid(FluidHolder.of(Fluids.LAVA,1000),false)
        gameTestHelper.succeedWhen {
            if (outputTank.extractFluid(FluidHolder.of(Fluids.WATER,1000),true).fluidAmount == 1000L) {
                gameTestHelper.assertTrue(inputTank.isEmpty,"Input tank has to have been used up")
            } else {
                gameTestHelper.fail("output tank hasn't got any water")
            }
        }

    }
}