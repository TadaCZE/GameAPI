package org.mineacademy.gameapi;

/**
 * Represents a snapshot of the arena region.
 *
 * For typical usage see {@link ArenaSnapshotProcedural.DamagedStage}
 */
public interface ArenaSnapshotStage {

	/**
	 * The internal id of the stage, if unsure return from 0 and upwards normally.
	 *
	 * @return the id
	 */
	public int getId();

	/**
	 * Get the formated name representation
	 *
	 * @return the name
	 */
	public String getFormattedName();

	/**
	 * Get the file template name, typically having {arena}
	 * in to be replaced with the arena name
	 *
	 * @return the arena name
	 */
	public String getFileName();
}