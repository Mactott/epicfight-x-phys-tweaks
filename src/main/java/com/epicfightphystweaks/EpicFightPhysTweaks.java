package com.epicfightphystweaks;

import com.mojang.logging.LogUtils;
import com.epicfightphystweaks.config.RagdollConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EpicFightPhysTweaks.MODID)
public class EpicFightPhysTweaks {
    public static final String MODID = "epicfightphystweaks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EpicFightPhysTweaks(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        context.registerConfig(ModConfig.Type.CLIENT, RagdollConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("EpicFight x Physics Tweaks initialized (Client-Side Only)!");
    }
}
