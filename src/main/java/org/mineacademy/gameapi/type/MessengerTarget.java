package org.mineacademy.gameapi.type;

import org.mineacademy.gameapi.ArenaMessenger;

/**
 * Represents to whom we should send messages from {@link ArenaMessenger}
 */
public enum MessengerTarget {

	/**
	 * The default
	 *
	 * Players in the arena
	 */
	ARENA,

	/**
	 * Players in the same world as the arena is within, used by world automatic mode
	 */
	WORLD,

	/**
	 * Everyone on the server, used by server automatic mode
	 */
	SERVER
}
