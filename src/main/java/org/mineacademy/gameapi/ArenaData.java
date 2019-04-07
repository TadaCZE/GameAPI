package org.mineacademy.gameapi;

import java.util.List;

import org.bukkit.Location;
import org.mineacademy.gameapi.misc.Iconable;
import org.mineacademy.gameapi.type.RegionPoint;
import org.mineacademy.gameapi.type.SpawnPointType;

/**
 * Represents the part of data.db file that has stored data about an arena
 *
 */
public interface ArenaData extends Iconable {

	/**
	 * Is the arena enabled?
	 *
	 * @return true if the arena is enabled
	 */
	public boolean isEnabled();

	/**
	 * Set whether the arena is joinable
	 *
	 * @param enabled, true if the arena can be joined
	 */
	public void setEnabled(boolean enabled);

	/**
	 * Get the arena lobby
	 *
	 * @return the arena lobby
	 */
	public Lobby getLobby();

	/**
	 * Set the arena lobby location
	 *
	 * @param loc the new lobby location
	 */
	public void setLobby(Location loc);

	/**
	 * Remove the arena lobby permanently
	 */
	public void removeLobby();

	/**
	 * Get the arena region
	 *
	 * @return the arena region
	 */
	public ArenaRegion getRegion();

	/**
	 * Set a certain location in a world to represent an arena point, primary or secondary
	 * When both points are set, arena will have a valid region
	 *
	 * @param loc the location
	 * @param point the point type
	 */
	public void setRegion(Location loc, RegionPoint point);

	/**
	 * Remove a certain region point
	 *
	 * @param point, the region point type to remove
	 */
	public void removeRegion(RegionPoint point);

	/**
	 * Get arena signs manager
	 *
	 * @return the signs in the arena
	 */
	public ArenaSigns getSigns();

	/**
	 * Add a new sign to the arena
	 *
	 * @param sign the new sign
	 */
	public void addSign(ArenaSign sign);

	/**
	 * Remove a sign at a specific location
	 *
	 * @param loc location where the sign is located
	 */
	public void removeSign(Location loc);

	/**
	 * Remove a specific arena sign
	 *
	 * @param sign the sign to remove
	 */
	public void removeSign(ArenaSign sign);

	/**
	 * Get the list of spawn points of a certain type
	 *
	 * @param type the type of spawn points
	 * @return the list of them
	 */
	public List<SpawnPoint> getSpawnPoints(SpawnPointType type);

	/**
	 * Finds the spawn point at a location
	 *
	 * @param loc the location
	 * @return the point, or null if not present
	 */
	public SpawnPoint findSpawnPoint(Location loc);

	/**
	 * Add a spawn point to a certain location
	 *
	 * @param point the new point
	 */
	public void addSpawnPoint(SpawnPoint point);

	/**
	 * Removes a certain spawn point
	 *
	 * @param type spawn point type to remove
	 * @param loc the location where the point is located
	 */
	public void removeSpawnPoint(SpawnPointType type, Location loc);

	/**
	 * Updates an already existing spawning point
	 *
	 * @param point the point with updated information
	 */
	public void updateSpawnPoint(SpawnPoint point);

	/**
	 * An internal method called after data is loaded
	 */
	public void onPostLoad();

	/**
	 * Return if the arena data section is valid
	 *
	 * @return true if the section exists in data.db
	 */
	public boolean isDataValid();

	/**
	 * Remove the data section permantly. DANGEROUS!
	 */
	public void deleteDataSection();
}
