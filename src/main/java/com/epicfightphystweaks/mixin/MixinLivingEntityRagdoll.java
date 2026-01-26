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

@Mixin(LivingEntity.class)
public class MixinLivingEntityRagdoll {
    
    @Inject(at = @At("HEAD"), method = "die")
    private void beforeDie(DamageSource source, CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object)this;
        
        if (!self.level().isClientSide) {
            return;
        }
        
        if (RagdollConfig.shouldEnableRagdoll(self)) {
            @SuppressWarnings("rawtypes")
            LazyOptional capability = self.getCapability(EpicFightCapabilities.CAPABILITY_ENTITY);
            capability.invalidate();
        }
    }
}
