package org.mineacademy.gameapi;

import org.bukkit.plugin.Plugin;
import org.mineacademy.gameapi.registry.ArenaRegistry;

/**
 * Represents a minigame plugin that uses GameAPI.
 *
 * Typically, your main plugin class should implement this.
 */
public interface ArenaPlugin {

	/**
	 * Get the arena manager.
	 *
	 * If you don't have one, you can just return {@link ArenaRegistry#getArenaManager()}
	 * and that will use our shared manager.
	 *
	 * @return the arena manager
	 */
	ArenaManager getArenas();

	/**
	 * Get the name of this plugin
	 *
	 * @return the name of this plugin
	 */
	String getName();

	/**
	 * Get the {@link Plugin} representation
	 *
	 * @return the plugin
	 */
	Plugin getPlugin();
}
