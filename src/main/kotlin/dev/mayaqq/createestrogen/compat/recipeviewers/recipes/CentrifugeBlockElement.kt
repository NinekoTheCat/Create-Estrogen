package dev.mayaqq.createestrogen.compat.recipeviewers.recipes

import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics
import dev.mayaqq.createestrogen.client.content.blockRenderers.centrifuge.CreateEstrogenRenderer
import dev.mayaqq.cynosure.client.utils.pushPop
import dev.mayaqq.estrogen.content.EstrogenBlocks
import net.minecraft.client.gui.GuiGraphics

class CentrifugeBlockElement : AnimatedKinetics() {
    override fun draw(graphics: GuiGraphics, offsetX: Int, offsetY: Int) {
        val scale = 22.0

        val matrixStack = graphics.pose()
        matrixStack.pushPose()
        graphics.pushPop {
            translate(offsetX.toDouble(), offsetY.toDouble(), 0.0)
            translate(-2f, 18f, 0f)
            blockElement(CreateEstrogenRenderer.CENTRIFUGE_COG)
                .rotateBlock(22.5, (getCurrentAngle() * 10).toDouble(), 0.0)
                .scale(scale)
                .render(graphics)

            blockElement(EstrogenBlocks.Centrifuge.defaultBlockState())
                .rotateBlock(22.5, 22.5, 0.0)
                .scale(scale)
                .render(graphics)
        }
    }
}