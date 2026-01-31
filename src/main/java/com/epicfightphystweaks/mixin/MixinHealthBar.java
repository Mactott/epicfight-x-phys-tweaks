package com.epicfightphystweaks.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.client.gui.HealthBar;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

import javax.annotation.Nullable;

@Mixin(value = HealthBar.class, remap = false)
public abstract class MixinHealthBar {
    @Inject(method = "draw", at = @At("HEAD"), cancellable = true)
    private void beforeDraw(LivingEntity entity,
                            @Nullable LivingEntityPatch<?> entitypatch,
                            LocalPlayerPatch playerpatch,
                            PoseStack poseStack,
                            MultiBufferSource buffers,
                            float partialTicks,
                            CallbackInfo ci) {
        if (entitypatch == null) ci.cancel();
    }
}