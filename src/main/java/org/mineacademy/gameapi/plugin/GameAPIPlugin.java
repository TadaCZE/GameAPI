package org.mineacademy.gameapi.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.Messenger;
import org.mineacademy.gameapi.data.PlayerData;
import org.mineacademy.gameapi.listener.PlayerListener;
import org.mineacademy.gameapi.registry.ArenaRegistry;

/**
 * The main class of GameAPI library that loads the library as a plugin.
 *
 * To get started using this library, refer to {@link ArenaRegistry}.
 *
 * @author kangarko
 */
public final class GameAPIPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		// Create data folder
		if (!getDataFolder().exists())
			saveResource("data.db", false);

		// Register events
		getServer().getPluginManager().registerEvents(new PlayerListener(), this);

		// Register BungeeCord channel, for ArenaCommands
		final Messenger messenger = getServer().getMessenger();
		if (!messenger.isOutgoingChannelRegistered(this, "BungeeCord"))
			messenger.registerOutgoingPluginChannel(this, "BungeeCord");
	}

	/**
	 * Get the instance of this library, loaded on the server
	 *
	 * TIP: To start with, see {@link ArenaRegistry} and {@link PlayerData}
	 *
	 * @return this instance
	 */
	public static final GameAPIPlugin getInstance() {
		return (GameAPIPlugin) Bukkit.getPluginManager().getPlugin("GameAPI");
	}
}
