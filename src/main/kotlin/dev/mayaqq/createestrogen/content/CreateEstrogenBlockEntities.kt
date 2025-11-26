package dev.mayaqq.createestrogen.content

import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.client.content.blockRenderers.centrifuge.CentrifugeRenderer
import dev.mayaqq.createestrogen.client.content.blockRenderers.centrifuge.CreateEstrogenRenderer
import dev.mayaqq.createestrogen.client.platforms.ofVisual
import dev.mayaqq.createestrogen.content.blockEntities.CentrifugeBlockEntity
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.entity.BlockEntityType
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.client.stdlib.clientOnly
import uwu.serenity.kritter.client.stdlib.renderer
import uwu.serenity.kritter.stdlib.blockEntity

object CreateEstrogenBlockEntities : Registrar<BlockEntityType<*>> by CreateEstrogen..Registries.BLOCK_ENTITY_TYPE {
    val Centrifuge : BlockEntityType<CentrifugeBlockEntity> by blockEntity("centrifuge", ::CentrifugeBlockEntity) {
        validBlock(CreateEstrogenBlocks::Centrifuge)
        renderer(::CentrifugeRenderer)
        clientOnly {
            visual(CreateEstrogenRenderer.CENTRIFUGE_COG::ofVisual, { false })
        }
    }
}