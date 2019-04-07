package org.mineacademy.gameapi;

import java.util.List;

import org.bukkit.Location;
import org.mineacademy.gameapi.ArenaSign.SignType;

/**
 * Represents signs manager storing all signs
 */
public interface ArenaSigns {

	/**
	 * Find a sign at a location
	 *
	 * @param loc the location
	 * @return the sign, or null
	 */
	public ArenaSign getSignAt(Location loc);

	/**
	 * Get all stored signs of a certain type
	 *
	 * @param type the sign type
	 * @return the signs
	 */
	public List<ArenaSign> getSigns(SignType type);

	/**
	 * Calls {@link ArenaSign#updateState()} for all signs of a certain type in an arena
	 *
	 * @param type the sign type
	 * @param arena the arena
	 */
	public void updateSigns(SignType type, Arena arena);
}