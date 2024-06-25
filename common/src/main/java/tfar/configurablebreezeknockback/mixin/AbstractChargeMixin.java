package tfar.configurablebreezeknockback.mixin;

import net.minecraft.world.entity.projectile.windcharge.AbstractWindCharge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import tfar.configurablebreezeknockback.BreezeChargeDuck;
import tfar.configurablebreezeknockback.ConfigurableBreezeKnockback;

@Mixin(AbstractWindCharge.class)
public abstract class AbstractChargeMixin implements BreezeChargeDuck {

    @Unique
    private float power = ConfigurableBreezeKnockback.DEFAULT;

    @Unique
    private float knockbackPower = ConfigurableBreezeKnockback.DEFAULT;

    @Override
    public float getPower() {
        return power;
    }

    @Override
    public float getKnockbackPower() {
        return knockbackPower;
    }

    @Override
    public void setKnockbackPower(float knockbackPower) {
        this.knockbackPower = knockbackPower;
    }

    @Override
    public void setPower(float power) {
        this.power = power;
    }

}