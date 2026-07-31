package dev.mayaqq.createestrogen.mixin;
import net.minecraft.world.item.CreativeModeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(CreativeModeTabs.class)
public class CreativeTabsMixin {
    /**
     * @author Niko Dale
     * @reason redundant check
     */
    @Inject(
            method = "validate",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void validate(CallbackInfo c) {
        c.cancel(); // we shouldn't validate because it is redundant
    }
}
