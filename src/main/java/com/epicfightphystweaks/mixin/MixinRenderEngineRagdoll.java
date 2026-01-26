package com.epicfightphystweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;

@Pseudo
@Mixin(targets = "yesman.epicfight.client.events.engine.RenderEngine", remap = false)
public class MixinRenderEngineRagdoll {
}
