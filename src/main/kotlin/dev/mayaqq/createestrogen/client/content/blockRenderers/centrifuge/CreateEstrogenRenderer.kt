package dev.mayaqq.createestrogen.client.content.blockRenderers.centrifuge

import dev.engine_room.flywheel.lib.model.baked.PartialModel
import dev.mayaqq.createestrogen.id
import dev.mayaqq.cynosure.core.Environment
import dev.mayaqq.cynosure.events.api.EventSubscriber


@EventSubscriber(env = [Environment.CLIENT])
object CreateEstrogenRenderer  {
    val CENTRIFUGE_COG: PartialModel = PartialModel.of(id("block/centrifuge/cog"))
}