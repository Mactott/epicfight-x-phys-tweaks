package com.epicfightphystweaks.mixin;

import com.epicfightphystweaks.config.RagdollConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "yesman.epicfight.client.events.engine.RenderEngine", remap = false)
public class MixinRenderEngineRagdoll {
    
    @Inject(at = @At("HEAD"), method = "hasRendererFor", cancellable = true, remap = false)
    private void preventRendererForDeadEntities(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof LivingEntity living && 
            living.getHealth() <= 0.0F && 
            living.deathTime > 0 &&
            RagdollConfig.shouldEnableRagdoll(entity)) {
            cir.setReturnValue(false);
        }
    }
}
