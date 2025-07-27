package dev.myaqq.createestrogen.tests

import dev.mayaqq.createestrogen.MOD_ID
import net.minecraft.gametest.framework.GameTest
import net.minecraft.gametest.framework.GameTestHelper
import net.minecraftforge.gametest.GameTestHolder

@GameTestHolder(MOD_ID)
object CentrifugeTests {
    @GameTest(template = "centrifugetest")
    fun testCentrifugeThinksItCanCraft(gameTestHelper: GameTestHelper): Unit {
        gameTestHelper.succeed()
    }
}