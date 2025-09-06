package dev.mayaqq.createestrogen.client.platforms;

import com.mojang.blaze3d.vertex.PoseStack;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.msrandom.multiplatform.annotations.Expect;


public class CreateEstrogenFluidRenderer {
    @Expect
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
            boolean renderBottom);
}
