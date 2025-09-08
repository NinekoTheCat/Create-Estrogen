package dev.mayaqq.createestrogen.content


import dev.engine_room.flywheel.api.visual.BlockEntityVisual
import dev.engine_room.flywheel.api.visualization.VisualizationContext
import dev.engine_room.flywheel.lib.visualization.SimpleBlockEntityVisualizer
import net.minecraft.world.level.block.entity.BlockEntity
import uwu.serenity.kritter.client.stdlib.clientOnly
import uwu.serenity.kritter.stdlib.BlockEntityBuilder

// Block entities
// these need to be inline/crossinline for server-side safety
inline fun <BE : BlockEntity> BlockEntityBuilder<BE>.visual(crossinline factory: (VisualizationContext, BE, Float) -> BlockEntityVisual<in BE>, noinline predicate: (BE) -> Boolean = { true }) {
    clientOnly {
        onRegister {
            val builder = SimpleBlockEntityVisualizer.builder(it)
                .factory { ctx, be, f -> factory(ctx, be, f) }
            predicate.let { builder.skipVanillaRender(it) }
            builder.apply()
        }
    }
}

val matchIdRegex = Regex("[A-Za-z]+:.*")