package dev.mayaqq.createestrogen.test

import invoke.kitty.kritter.platform.Mod
import invoke.kitty.kritter.platform.forge.EntrypointHandler
import invoke.kitty.kritter.platform.forge.eventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.RegisterGameTestsEvent

@EntrypointHandler("init")
fun init(mod: Mod) {
    mod.eventBus.register(TestRegister)
}
object TestRegister {
    @SubscribeEvent
    fun registerTests(event: RegisterGameTestsEvent) {
        event.register(CentrifugeTests::class.java)
    }
}