package dev.mayaqq.createestrogen.content

import com.simibubi.create.AllDisplaySources
import com.simibubi.create.api.behaviour.display.DisplaySource
import com.simibubi.create.api.behaviour.interaction.MovingInteractionBehaviour
import com.simibubi.create.api.behaviour.movement.MovementBehaviour
import com.simibubi.create.api.stress.BlockStressValues
import com.simibubi.create.content.contraptions.actors.seat.SeatBlock
import com.simibubi.create.content.contraptions.actors.seat.SeatInteractionBehaviour
import com.simibubi.create.content.contraptions.actors.seat.SeatMovementBehaviour
import com.simibubi.create.foundation.data.SharedProperties
import dev.mayaqq.createestrogen.CreateEstrogen
import dev.mayaqq.createestrogen.registry.blocks.CentrifugeBlock
import net.minecraft.client.renderer.RenderType
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import uwu.serenity.kritter.api.Registrar
import uwu.serenity.kritter.client.stdlib.renderType
import uwu.serenity.kritter.stdlib.block

object CreateEstrogenBlocks: Registrar<Block> by CreateEstrogen..Registries.BLOCK {
    val Centrifuge = block("centrifuge", ::CentrifugeBlock)
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
    val MothSeat = block("moth_seat", ::newMothSeat) {
        copyProperties(Blocks::STRIPPED_SPRUCE_WOOD)
        properties {
            mapColor(MapColor.COLOR_ORANGE)
        }
        onRegister {
            MovingInteractionBehaviour.REGISTRY.register(it,SeatInteractionBehaviour())
            MovementBehaviour.REGISTRY.register(it,SeatMovementBehaviour())
        }
        //TODO: check that this works
        onSetup {
            DisplaySource.BY_BLOCK.register(it, listOf(AllDisplaySources.ENTITY_NAME.get()))
        }
        simpleItem()



    }
    internal fun newMothSeat(p: BlockBehaviour.Properties) = SeatBlock(p,null)
}