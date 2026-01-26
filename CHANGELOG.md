# Changelog

All notable changes to this project will be documented in this file.

## [1.0.1] - 2026-01-25

### Changed
- **Client-side only execution**: Mod now runs exclusively on client, safe for multiplayer servers
- Capability invalidation now checks `isClientSide` to prevent server-side modifications
- Updated mods.toml dependencies to specify CLIENT side
- Changed config type from COMMON to CLIENT

### Fixed
- Removed server-side capability tampering that could trigger anti-cheat systems
- Eliminated duplicate capability invalidation on server and client threads

### Removed
- Server startup event handler (no longer needed for client-only mod)
- Unnecessary server-side execution paths

## [1.0.0] - 2026-01-23

### Added
- Initial release
- Configurable ragdoll physics compatibility between Epic Fight and physics mods
- Master toggle for enabling/disabling ragdoll physics
- Whitelist/Blacklist system for controlling which entities get ragdolls
- Optional player ragdoll physics
- Three configuration modes:
  - Whitelist Mode: Only specified entities use ragdolls
  - Blacklist Mode: All entities except specified use ragdolls
  - All Entities Mode: Everything uses ragdolls (with blacklist exceptions)
- Capability invalidation to disable Epic Fight animations for dead entities
- Model part visibility forcing for ragdoll creation
- RenderEngine integration to prevent Epic Fight interference

### Technical Details
- Uses Mixin framework to modify Epic Fight behavior
- Forge event handlers for render compatibility
- Config system with TOML format
- Compatible with Minecraft 1.20.1 and Epic Fight 20.0.0+
