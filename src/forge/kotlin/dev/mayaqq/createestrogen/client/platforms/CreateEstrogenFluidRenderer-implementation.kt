package dev.mayaqq.createestrogen.client.platforms

import com.mojang.blaze3d.vertex.PoseStack
import dev.mayaqq.createestrogen.CreateEstrogen
import earth.terrarium.botarium.common.fluid.base.FluidHolder
import net.createmod.catnip.platform.ForgeCatnipServices
import net.minecraft.client.renderer.MultiBufferSource
import net.minecraftforge.fluids.FluidStack


 fun renderCommonFluid(
fluid: FluidHolder,
xMin: Float,
yMin: Float,
zMin: Float,
xMax: Float,
yMax: Float,
zMax: Float,
buffer: MultiBufferSource,
ms: PoseStack,
light: Int,
renderBottom: Boolean
) {
    CreateEstrogen.info("hi from gex")
    val fluidStack = FluidStack(fluid.fluid, fluid.fluidAmount.toInt(), fluid.compound)
ForgeCatnipServices.FLUID_RENDERER.renderFluidBox(fluidStack, xMin, yMin, zMin, xMax, yMax, zMax, buffer, ms, light, renderBottom,false)

}