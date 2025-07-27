package dev.mayaqq.createestrogen.content

import com.simibubi.create.api.stress.BlockStressValues
import com.simibubi.create.foundation.data.SharedProperties
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.registry.blocks.CentrifugeBlock
import net.minecraft.client.renderer.RenderType
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.MapColor
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.client.stdlib.renderType
import uwu.serenity.kritter.stdlib.block

object CreateEstrogenBlocks: Registrar<Block> by CreateEstrogen..Registries.BLOCK {
    val Centrifuge : CentrifugeBlock by block("centrifuge", ::CentrifugeBlock)
    {
        copyProperties(SharedProperties::copperMetal)
        properties{
            requiresCorrectToolForDrops()
            mapColor(MapColor.COLOR_ORANGE).noOcclusion()
        }

        renderType = RenderType::cutoutMipped
        onRegister {
            BlockStressValues.IMPACTS.register(it) {
                256.0
            }
        }
        simpleItem()

    }

}