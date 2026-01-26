package com.epicfightphystweaks.event;

import com.epicfightphystweaks.config.RagdollConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "epicfightphystweaks", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RenderEventHandler {
    
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onRenderLiving(RenderLivingEvent.Pre<?, ?> event) {
        LivingEntity living = event.getEntity();
        
        if (living.getHealth() <= 0.0F && 
            living.deathTime > 0 && 
            RagdollConfig.shouldEnableRagdoll(living)) {
            // Epic Fight should skip rendering due to capability invalidation
        }
    }
}
