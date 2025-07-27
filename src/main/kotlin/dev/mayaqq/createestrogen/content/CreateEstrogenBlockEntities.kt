package dev.mayaqq.createestrogen.content

import com.simibubi.create.content.kinetics.base.SingleAxisRotatingVisual
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.content.blockEntities.CentrifugeBlockEntity
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.entity.BlockEntityType
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.client.stdlib.renderer
import uwu.serenity.kritter.stdlib.blockEntity
import  dev.mayaqq.createestrogen.client.content.blockRenderers.centrifuge.CentrifugeRenderer
import dev.mayaqq.createestrogen.client.content.blockRenderers.centrifuge.CreateEstrogenRenderer
import uwu.serenity.kritter.client.stdlib.clientOnly

object CreateEstrogenBlockEntities : Registrar<BlockEntityType<*>> by CreateEstrogen..Registries.BLOCK_ENTITY_TYPE {
    val factory = SingleAxisRotatingVisual.of<CentrifugeBlockEntity>(CreateEstrogenRenderer.CENTRIFUGE_COG)
    val Centrifuge : BlockEntityType<CentrifugeBlockEntity> by blockEntity("centrifuge", ::CentrifugeBlockEntity){
        validBlock(CreateEstrogenBlocks::Centrifuge)
        renderer(::CentrifugeRenderer)
        visual( factory::create) { false }

    }
}