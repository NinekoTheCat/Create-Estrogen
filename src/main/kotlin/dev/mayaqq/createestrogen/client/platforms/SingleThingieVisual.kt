package dev.mayaqq.createestrogen.client.platforms

import com.simibubi.create.content.kinetics.base.KineticBlockEntity
import dev.engine_room.flywheel.api.visual.BlockEntityVisual
import dev.engine_room.flywheel.api.visualization.VisualizationContext
import dev.engine_room.flywheel.lib.model.baked.PartialModel

expect fun <BE : KineticBlockEntity>PartialModel.ofVisual(ctx: VisualizationContext, entity: BE, f: Float): BlockEntityVisual<in BE>