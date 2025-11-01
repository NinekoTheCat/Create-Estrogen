package dev.mayaqq.createestrogen.client.platforms

import com.mojang.blaze3d.vertex.PoseStack
import dev.mayaqq.createestrogen.CreateEstrogen
import earth.terrarium.botarium.common.fluid.base.FluidHolder
import io.github.fabricators_of_create.porting_lib.fluids.FluidStack
import net.createmod.catnip.platform.FabricCatnipServices
import net.minecraft.client.renderer.MultiBufferSource


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
    val fluidStack = FluidStack(fluid.fluid, fluid.fluidAmount, fluid.compound)
    FabricCatnipServices.FLUID_RENDERER.renderFluidBox(
        fluidStack,
        xMin,
        yMin,
        zMin,
        xMax,
        yMax,
        zMax,
        buffer,
        ms,
        light,
        renderBottom,
        false
    )

}