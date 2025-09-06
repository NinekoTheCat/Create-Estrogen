package dev.mayaqq.createestrogen.test

import dev.mayaqq.createestrogen.MOD_ID
import dev.mayaqq.estrogen.content.EstrogenFluids
import earth.terrarium.botarium.common.fluid.base.FluidContainer
import earth.terrarium.botarium.common.fluid.base.FluidHolder
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.gametest.framework.GameTest
import net.minecraft.gametest.framework.GameTestAssertPosException
import net.minecraft.gametest.framework.GameTestHelper
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
        inputTank.insertFluid(FluidHolder.of(EstrogenFluids.FiltratedHorseUrine.value, 81), false)
        gameTestHelper.succeedWhen {
            if (outputTank.extractFluid(
                    FluidHolder.of(EstrogenFluids.LiquidEstrogen.value, 81),
                    true
                ).fluidAmount == 81L
            ) {
                gameTestHelper.assertTrue(inputTank.isEmpty,"Input tank has to have been used up")
            } else {
                throw GameTestAssertPosException(
                    "output tank hasn't got any estrogen!",
                    centrifugeOutputTankPosition,
                    gameTestHelper.relativePos(centrifugeOutputTankPosition),
                    gameTestHelper.tick
                )
            }
        }

    }
}