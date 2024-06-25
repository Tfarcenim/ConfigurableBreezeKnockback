package tfar.configurablebreezeknockback.mixin;

import tfar.configurablebreezeknockback.ConfigurableBreezeKnockback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {

        ConfigurableBreezeKnockback.LOG.info("This line is printed by an example mod mixin from NeoForge!");
        ConfigurableBreezeKnockback.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}