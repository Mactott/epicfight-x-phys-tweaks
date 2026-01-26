# EpicFight x Physics Tweaks

A Minecraft Forge mod that provides configurable ragdoll physics compatibility between Epic Fight and physics mods.

## Features

- **Master Toggle**: Enable/disable ragdoll physics globally
- **Entity Whitelist/Blacklist**: Choose which entities should use ragdoll physics
- **Player Ragdolls**: Optional player ragdoll physics on death
- **Flexible Configuration**: Multiple modes to control which entities get ragdolls

## How It Works

When an entity dies, this mod can disable Epic Fight's custom death animations and rendering, allowing physics mods (like the Physics Mod) to create ragdoll effects instead.

## Configuration

The config file is generated at `config/epicfightphystweaks-common.toml` after the first run.

### Config Options

```toml
[ragdoll_settings]
    # Master toggle: Enable ragdoll physics compatibility
    enable_ragdolls = true
    
    # If true, all entities (except blacklist) will use ragdolls
    # If false, only whitelist entities will use ragdolls
    ragdoll_all_entities = false
    
    # Allow ragdoll physics for players on death
    ragdoll_players = false
    
    # List mode: WHITELIST or BLACKLIST
    list_mode = "WHITELIST"
    
    # Entities to enable ragdolls for (WHITELIST mode)
    whitelist = [
        "minecraft:zombie",
        "minecraft:skeleton",
        "minecraft:creeper",
        "minecraft:spider",
        "minecraft:enderman"
    ]
    
    # Entities to disable ragdolls for (BLACKLIST mode)
    blacklist = [
        "minecraft:ender_dragon",
        "minecraft:wither"
    ]
```

### Configuration Modes

1. **Whitelist Mode**: Only entities in the whitelist get ragdolls
   - Set `list_mode = "WHITELIST"`
   - Add entity IDs to the `whitelist` array

2. **Blacklist Mode**: All entities except those in blacklist get ragdolls
   - Set `list_mode = "BLACKLIST"`
   - Add entity IDs to the `blacklist` array

3. **All Entities Mode**: Ragdolls for everything (except blacklist)
   - Set `ragdoll_all_entities = true`
   - Uses the `blacklist` to exclude specific entities

## Dependencies

- Minecraft Forge 1.20.1 (47.2.0+)
- Epic Fight Mod (20.0.0+)
- A physics mod that supports ragdolls (e.g., Physics Mod 3.0.0+)

## Compatibility

1. Install Minecraft Forge 1.20.1 (version 47.2.0 or higher)
2. Install [Epic Fight Mod](https://www.curseforge.com/minecraft/mc-mods/epic-fight-mod) (version 20.0.0 or higher)
3. Install a compatible physics mod (e.g., [Physics Mod](https://www.curseforge.com/minecraft/mc-mods/physics-mod))
4. Place this mod's jar in your `mods/` folder
5. Launch the game - config will be generated at `config/epicfightphystweaks-common.toml`
6. Configure which entities you want to have ragdolls
7. Restart or use `/reload` if you change the config

## Compatibility

- **Minecraft**: 1.20.1
- **Forge**: 47.2.0+
- **Epic Fight**: 20.0.0+
- **Physics Mod**: 3.0.0+ (recommended)

This mod is designed to work with any physics mod that creates ragdolls from entity models.

## Troubleshooting

### Ragdolls not appearing
1. Check that `enable_ragdolls = true` in the config
2. Verify the entity is in your whitelist (or not in blacklist)
3. Check logs for `[EpicFight Phys Tweaks]` messages
4. Ensure your physics mod is properly installed

### Game crashes
1. Make sure you have the correct versions of dependencies
2. Check the crash log for mixin errors
3. Verify Epic Fight mod is loaded before this mod

## Building from Source

### Prerequisites

1. JDK 17 or higher
2. Place the Epic Fight mod jar in the `libs/` folder for compilation
3. Git (optional, for cloning)

### Build Commands

Windows:
```bash
.\gradlew.bat clean build
```

Linux/Mac:
```bash
./gradlew clean build
```

The compiled jar will be in `build/libs/epicfight-x-phys-tweaks-1.0.0.jar`

## For Modpack Creators

This mod is modpack-friendly! You can:
- Include pre-configured `epicfightphystweaks-common.toml` in your modpack
- Set up default entity lists for your modpack's content
- Disable ragdolls for specific entities that don't work well with physics

Example config for modpacks with many mods:
```toml
ragdoll_all_entities = true
list_mode = "BLACKLIST"
blacklist = [
    "minecraft:ender_dragon",
    "minecraft:wither",
    "modid:boss_entity"
]
```

## Credits

- Epic Fight Mod team for the amazing combat mod
- Physics Mod team for ragdoll physics implementation
- Mixin framework for bytecode modification capabilities

## Support

If you encounter issues:
1. Check the troubleshooting section above
2. Review the config file for correct settings
3. Check game logs for error messages
4. Report issues on the GitHub repository (if available)

## License

MIT License
