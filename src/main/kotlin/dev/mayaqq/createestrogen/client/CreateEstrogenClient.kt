package dev.mayaqq.createestrogen.client

import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.content.CreateEstrogenPonderPlugin
import net.createmod.ponder.foundation.PonderIndex

fun createEstrogenClient() {
    CreateEstrogen.info("init client..")
    PonderIndex.addPlugin(CreateEstrogenPonderPlugin)

}