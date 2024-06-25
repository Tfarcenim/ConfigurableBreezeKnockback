package tfar.configurablebreezeknockback.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.configurablebreezeknockback.BreezeChargeDuck;
import tfar.configurablebreezeknockback.ConfigurableBreezeKnockback;

@Mixin(AbstractHurtingProjectile.class)
public class AbstractHurtingProjectileMixin {

    @Inject(method = "addAdditionalSaveData",at = @At("RETURN"))
    private void addExtraData(CompoundTag tag, CallbackInfo ci) {
        if (this instanceof BreezeChargeDuck breezeChargeDuck ) {
            tag.putFloat(ConfigurableBreezeKnockback.KEY,breezeChargeDuck.getPower());
            tag.putFloat(ConfigurableBreezeKnockback.k_KEY,breezeChargeDuck.getKnockbackPower());
        }
    }
    @Inject(method = "readAdditionalSaveData",at = @At("RETURN"))
    private void loadAdditionalData(CompoundTag tag, CallbackInfo ci) {
        if (this instanceof BreezeChargeDuck breezeChargeDuck) {
            if (tag.contains(ConfigurableBreezeKnockback.KEY)) {
                breezeChargeDuck.setPower(tag.getFloat(ConfigurableBreezeKnockback.KEY));
            }
            if (tag.contains(ConfigurableBreezeKnockback.k_KEY)) {
                breezeChargeDuck.setKnockbackPower(tag.getFloat(ConfigurableBreezeKnockback.k_KEY));
            }
        }
    }
}
