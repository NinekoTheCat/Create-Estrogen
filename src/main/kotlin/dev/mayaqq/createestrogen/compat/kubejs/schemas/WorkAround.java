package dev.mayaqq.createestrogen.compat.kubejs.schemas;

import dev.latvian.mods.kubejs.fluid.FluidStackJS;
import net.minecraft.world.level.material.Fluid;

///  This is needed because for some weird reason cloche doesn't like kubejs
public class WorkAround {
    public static Fluid getFluid(FluidStackJS js) {
        return js.getFluid();
    }
}
