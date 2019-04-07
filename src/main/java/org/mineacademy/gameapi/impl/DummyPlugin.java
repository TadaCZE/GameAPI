package org.mineacademy.gameapi.impl;

import org.bukkit.plugin.Plugin;
import org.mineacademy.gameapi.ArenaManager;
import org.mineacademy.gameapi.ArenaPlugin;
import org.mineacademy.gameapi.registry.ArenaRegistry;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents a dummy arena plugin using a shared arena manager.
 */
@RequiredArgsConstructor
public final class DummyPlugin implements ArenaPlugin {

	/**
	 * The JavaPlugin
	 */
	@Getter
	private final Plugin plugin;

	/**
	 * The plugins name
	 */
	@Override
	public String getName() {
		return plugin.getName();
	}

	/**
	 * Should return arena registry but this is unsupported in dummy plugins, use {@link ArenaRegistry} instead
	 *
	 * @deprecated unsupported
	 * @throws UnsupportedOperationException this is not supported
	 */
	@Deprecated
	@Override
	public final ArenaManager getArenas() {
		throw new UnsupportedOperationException("Use ArenaRegistry to get ArenaManager");
	}
}