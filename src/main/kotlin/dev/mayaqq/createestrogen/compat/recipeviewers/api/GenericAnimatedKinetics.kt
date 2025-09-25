package dev.mayaqq.createestrogen.compat.recipeviewers.api

import com.simibubi.create.AllBlocks
import com.simibubi.create.AllPartialModels
import com.simibubi.create.foundation.gui.CustomLightingSettings
import dev.engine_room.flywheel.lib.model.baked.PartialModel
import dev.mayaqq.estrogen.compat.recipeviewers.api.CRVDrawable
import net.createmod.catnip.animation.AnimationTickHolder
import net.createmod.catnip.gui.ILightingSettings
import net.createmod.catnip.gui.element.GuiGameElement
import net.minecraft.core.Direction
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.BlockStateProperties

abstract class GenericAnimatedKinetics : CRVDrawable {

    fun getCurrentAngle(): Float {
        return AnimationTickHolder.getRenderTime() * 4.0f % 360.0f
    }

    protected fun shaft(axis: Direction.Axis): BlockState {
        return AllBlocks.SHAFT.defaultState.setValue(BlockStateProperties.AXIS, axis) as BlockState
    }

    protected fun cogwheel(): PartialModel {
        return AllPartialModels.SHAFTLESS_COGWHEEL
    }

    protected fun blockElement(state: BlockState): GuiGameElement.GuiRenderBuilder {
        return defaultBlockElement(state)
    }

    protected fun blockElement(partial: PartialModel): GuiGameElement.GuiRenderBuilder {
        return defaultBlockElement(partial)
    }

    companion object {
        fun defaultBlockElement(state: BlockState): GuiGameElement.GuiRenderBuilder {
            return GuiGameElement.of(state).lighting(DEFAULT_LIGHTING)
        }

        fun defaultBlockElement(partial: PartialModel): GuiGameElement.GuiRenderBuilder {
            return GuiGameElement.of(partial).lighting(DEFAULT_LIGHTING)
        }

        var offset: Int = 0
        val DEFAULT_LIGHTING: ILightingSettings = CustomLightingSettings.builder().firstLightRotation(12.5f, 45.0f).secondLightRotation(-20.0f, 50.0f).build()
    }
}