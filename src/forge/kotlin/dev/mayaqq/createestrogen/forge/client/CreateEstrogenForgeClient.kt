package dev.mayaqq.createestrogen.forge.client

import dev.mayaqq.createestrogen.client.createEstrogenClient
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

@SubscribeEvent
fun onClientInit(event: FMLClientSetupEvent) {
    event.enqueueWork(::createEstrogenClient)
}