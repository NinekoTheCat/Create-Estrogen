package dev.mayaqq.createestrogen.client.platforms;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.msrandom.multiplatform.annotations.Actual;
import net.msrandom.multiplatform.annotations.Expect;


public class CreateEstrogenFluidRenderer {
    @Actual
    public static void renderCommonFluid(
            FluidHolder fluid,
            float xMin,
            float yMin,
            float zMin,
            float xMax,
            float yMax,
            float zMax,
            MultiBufferSource buffer,
            PoseStack ms,
            int light,
            boolean renderBottom) {
        CreateEstrogenFluidRenderer_implementationKt.renderCommonFluid(fluid, xMin, yMin, zMin, xMax, yMax, zMax, buffer, ms, light, renderBottom);
    }
}
