package org.mineacademy.gameapi;

import org.bukkit.Location;
import org.mineacademy.gameapi.misc.ConfigSerializable;
import org.mineacademy.gameapi.type.SpawnPointType;

/**
 * Represents a simple spawn point
 */
public interface SpawnPoint extends ConfigSerializable {

	/**
	 * Get the location of this spawn point
	 *
	 * @return the location
	 */
	public Location getLocation();

	/**
	 * Get this spawn point type
	 *
	 * @return the type
	 */
	public SpawnPointType getType();
}
