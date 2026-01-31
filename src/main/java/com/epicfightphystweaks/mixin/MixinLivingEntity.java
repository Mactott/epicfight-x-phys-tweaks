package com.epicfightphystweaks.mixin;

import com.epicfightphystweaks.config.RagdollConfig;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.LazyOptional;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;

@Mixin(value = LivingEntity.class, remap = true)
public abstract class MixinLivingEntity {

    @SuppressWarnings("rawtypes")
    @Inject(at = @At("HEAD"), method = "die")
    private void beforeDie(DamageSource source, CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object)this;
        
        if (self.level().isClientSide && RagdollConfig.shouldEnableRagdoll(self)) {
            LazyOptional capability = self.getCapability(EpicFightCapabilities.CAPABILITY_ENTITY);
            capability.invalidate();
        }
    }
}
