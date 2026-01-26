package com.epicfightphystweaks.mixin;

import com.epicfightphystweaks.config.RagdollConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = LivingEntityRenderer.class, priority = 900)
public abstract class MixinLivingEntityRendererRagdoll<T extends LivingEntity, M extends EntityModel<T>> {

    @Shadow
    protected M model;

    @Inject(method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("HEAD"))
    private void ensureModelPartsVisible(T entity, float entityYaw, float partialTicks,
                                          PoseStack poseStack, MultiBufferSource buffer,
                                          int packedLight, CallbackInfo ci) {
        if (entity.getHealth() <= 0.0F && entity.deathTime > 0 && RagdollConfig.shouldEnableRagdoll(entity)) {
            if (this.model instanceof HumanoidModel) {
                HumanoidModel<?> humanoidModel = (HumanoidModel<?>) this.model;
                
                humanoidModel.head.visible = true;
                humanoidModel.body.visible = true;
                humanoidModel.rightArm.visible = true;
                humanoidModel.leftArm.visible = true;
                humanoidModel.rightLeg.visible = true;
                humanoidModel.leftLeg.visible = true;

                humanoidModel.head.skipDraw = false;
                humanoidModel.body.skipDraw = false;
                humanoidModel.rightArm.skipDraw = false;
                humanoidModel.leftArm.skipDraw = false;
                humanoidModel.rightLeg.skipDraw = false;
                humanoidModel.leftLeg.skipDraw = false;
            }
        }
    }
}
