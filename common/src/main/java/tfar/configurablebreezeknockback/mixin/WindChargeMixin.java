package tfar.configurablebreezeknockback.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.SimpleExplosionDamageCalculator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Optional;
import java.util.function.Function;

@Mixin(WindCharge.class)
public class WindChargeMixin extends AbstractChargeMixin{

    @ModifyArg(method = "explode",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;explode(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/damagesource/DamageSource;Lnet/minecraft/world/level/ExplosionDamageCalculator;DDDFZLnet/minecraft/world/level/Level$ExplosionInteraction;Lnet/minecraft/core/particles/ParticleOptions;Lnet/minecraft/core/particles/ParticleOptions;Lnet/minecraft/core/Holder;)Lnet/minecraft/world/level/Explosion;"),index = 2)
    private ExplosionDamageCalculator modifyFormula(ExplosionDamageCalculator p_255867_) {
        return new SimpleExplosionDamageCalculator(true, false, Optional.of(getKnockbackPower()), BuiltInRegistries.BLOCK.getTag(BlockTags.BLOCKS_WIND_CHARGE_EXPLOSIONS).map(Function.identity()));
    }

  /*  @ModifyExpressionValue(at = @At(value = "CONSTANT", args = "floatValue=1.2"), method = "explode")
    private float init(float original) {
        return ((BreezeChargeDuck)this).getPower();
    }*/

}
