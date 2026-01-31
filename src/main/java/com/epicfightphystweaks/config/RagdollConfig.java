package com.epicfightphystweaks.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Arrays;
import java.util.List;

public class RagdollConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue ENABLE_RAGDOLLS;
    public static final ForgeConfigSpec.BooleanValue RAGDOLL_ALL_ENTITIES;
    public static final ForgeConfigSpec.BooleanValue RAGDOLL_PLAYERS;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> RAGDOLL_WHITELIST;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> RAGDOLL_BLACKLIST;
    public static final ForgeConfigSpec.EnumValue<ListMode> LIST_MODE;

    static {
        BUILDER.push("ragdoll_settings");

        ENABLE_RAGDOLLS = BUILDER
                .comment("Master toggle: Enable ragdoll physics compatibility")
                .define("enable_ragdolls", true);

        RAGDOLL_ALL_ENTITIES = BUILDER
                .comment("If true, all entities (except those in blacklist) will use ragdolls.",
                         "If false, only entities in the whitelist will use ragdolls.")
                .define("ragdoll_all_entities", false);

        RAGDOLL_PLAYERS = BUILDER
                .comment("Allow ragdoll physics for players on death")
                .define("ragdoll_players", false);

        LIST_MODE = BUILDER
                .comment("List mode: WHITELIST (only listed entities) or BLACKLIST (all except listed)")
                .defineEnum("list_mode", ListMode.WHITELIST);

        RAGDOLL_WHITELIST = BUILDER
                .comment("Entity IDs to enable ragdolls for (when list_mode is WHITELIST)",
                         "Examples: minecraft:zombie, minecraft:skeleton, minecraft:creeper")
                .defineListAllowEmpty(List.of("whitelist"),
                    () -> Arrays.asList(
                        "minecraft:zombie",
                        "minecraft:skeleton",
                        "minecraft:creeper",
                        "minecraft:spider",
                        "minecraft:enderman"
                    ),
                    obj -> obj instanceof String);

        RAGDOLL_BLACKLIST = BUILDER
                .comment("Entity IDs to disable ragdolls for (when list_mode is BLACKLIST)",
                         "Examples: minecraft:ender_dragon, minecraft:wither")
                .defineListAllowEmpty(List.of("blacklist"),
                    () -> Arrays.asList(
                        "minecraft:ender_dragon",
                        "minecraft:wither"
                    ),
                    obj -> obj instanceof String);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public enum ListMode {
        WHITELIST,
        BLACKLIST
    }

    public static boolean shouldEnableRagdoll(Entity entity) {
        if (!ENABLE_RAGDOLLS.get()) {
            return false;
        }

        // Check player setting
        if (entity instanceof net.minecraft.world.entity.player.Player) {
            return RAGDOLL_PLAYERS.get();
        }

        EntityType<?> entityType = entity.getType();
        ResourceLocation entityId = ForgeRegistries.ENTITY_TYPES.getKey(entityType);
        
        if (entityId == null) {
            return false;
        }

        String entityIdString = entityId.toString();

        // Check all entities mode
        if (RAGDOLL_ALL_ENTITIES.get()) {
            // All entities except blacklist
            return !RAGDOLL_BLACKLIST.get().contains(entityIdString);
        }

        // Use list mode
        if (LIST_MODE.get() == ListMode.WHITELIST) {
            return RAGDOLL_WHITELIST.get().contains(entityIdString);
        } else {
            return !RAGDOLL_BLACKLIST.get().contains(entityIdString);
        }
    }
}
