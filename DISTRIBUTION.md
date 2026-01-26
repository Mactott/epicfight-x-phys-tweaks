# EpicFight x Physics Tweaks - Distribution Guide

## Release Files

The following files are ready for distribution:

### Required Files for Upload:
- `build/libs/epicfight-x-phys-tweaks-1.0.0.jar` - The mod file
- `README.md` - Documentation
- `CHANGELOG.md` - Version history
- `LICENSE` - MIT License

### Distribution Platforms

#### CurseForge
1. Create a new project at https://www.curseforge.com/minecraft/mc-mods
2. Upload the jar file from `build/libs/`
3. Set game version: Minecraft 1.20.1
4. Set mod loader: Forge
5. Add dependencies:
   - Epic Fight Mod (required)
   - Physics Mod (optional/recommended)
6. Copy README.md content to project description
7. Add changelog from CHANGELOG.md

#### Modrinth
1. Create a new project at https://modrinth.com/mods
2. Upload the jar file from `build/libs/`
3. Set game version: 1.20.1
4. Set mod loader: Forge
5. Add dependencies:
   - Epic Fight (required)
   - Physics Mod (optional)
6. Use README.md for description
7. Add changelog from CHANGELOG.md

#### GitHub Releases
1. Create a new release tag: `v1.0.0`
2. Upload the jar file
3. Copy CHANGELOG.md to release notes
4. Add installation instructions from README.md

## Mod Information

**Mod ID**: `epicfightphystweaks`  
**Version**: 1.0.0  
**Minecraft**: 1.20.1  
**Forge**: 47.2.0+  
**License**: MIT

### Short Description (for mod portals):
"Configurable ragdoll physics compatibility between Epic Fight and physics mods. Choose which entities get ragdoll effects with whitelist/blacklist system."

### Tags/Categories:
- Utility
- Game Mechanics
- Combat
- Compatibility

### Dependencies:
- **Required**: Epic Fight Mod (20.0.0+)
- **Optional**: Physics Mod (3.0.0+) or any ragdoll physics mod

## Testing Checklist

Before release, verify:
- [ ] Mod loads without crashes
- [ ] Config file generates correctly
- [ ] Capability invalidation works (check logs)
- [ ] Ragdolls appear for configured entities
- [ ] Whitelist mode works correctly
- [ ] Blacklist mode works correctly
- [ ] Player ragdolls toggle works
- [ ] Compatible with Epic Fight animations when disabled
- [ ] No conflicts with other mods

## Build Information

**Build Date**: January 23, 2026  
**Java Version**: 17  
**Gradle Version**: 8.10.2  
**MixinGradle**: 0.7.38  
**Mixin Version**: 0.8.5

## Post-Release

After publishing:
1. Update project links in README.md
2. Create GitHub repository (if desired)
3. Monitor for bug reports
4. Prepare for future updates based on feedback
5. Consider adding wiki/documentation pages

## Future Development Ideas

- Support for more Minecraft versions
- Per-entity ragdoll settings
- Animation smoothing options
- API for other mods
- In-game config GUI
- More granular control over Epic Fight features
