package dev.myaqq.createestrogen.tests.platform

import net.minecraftforge.event.RegisterGameTestsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus
import dev.myaqq.createestrogen.tests.CentrifugeTests
@Mod.EventBusSubscriber(bus = Bus.MOD)
object TestRegister {
    @SubscribeEvent
    fun registerTests(event: RegisterGameTestsEvent) {
        event.register(CentrifugeTests::class.java)
    }
}