package dev.mayaqq.createestrogen.content


import dev.engine_room.flywheel.api.visual.BlockEntityVisual
import dev.engine_room.flywheel.api.visualization.VisualizationContext
import dev.engine_room.flywheel.lib.visualization.SimpleBlockEntityVisualizer
import dev.mayaqq.cynosure.tooltips.DescriptionTooltip
import invoke.kitty.kritter.registry.blockEntity.BlockEntityBuilder
import invoke.kitty.kritter.registry.item.ItemBuilder
import invoke.kitty.kritter.utils.clientOnly
import net.minecraft.world.level.block.entity.BlockEntity
import dev.mayaqq.cynosure.items.extensions.registerExtension
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