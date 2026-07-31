package dev.mayaqq.createestrogen.mixin;

import net.minecraft.world.item.CreativeModeTabs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeModeTabs.class)
public class CreativeModeTabsMixin {
    @Inject(
            method = "validate",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void fuckYou(CallbackInfo ci) {
        //TODO: move to kritter
        ci.cancel();
    }
}
