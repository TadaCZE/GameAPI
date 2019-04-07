package org.mineacademy.gameapi;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;
import org.mineacademy.gameapi.misc.Iconable;

/**
 * Represents a team, if arena supports that
 */
public interface Team extends Iconable {

	/**
	 * Get the name of the team
	 *
	 * @return the teams name
	 */
	public String getName();

	/**
	 * Get {@link #getChatColor()} + {@link #getName()}
	 *
	 * @return the colored name
	 */
	public String getFormattedName();

	/**
	 * Get the leather color of the team
	 * Typically used for helmets.
	 *
	 * @return the leather color
	 */
	public DyeColor getColor();

	/**
	 * Set the dye color of the team
	 *
	 * @param color the new color of the team
	 */
	public void setColor(DyeColor color);

	/**
	 * Get the chat color of the team
	 *
	 * Typically this is calculated from the leather color and cannot be set
	 *
	 * @return the chat color
	 */
	public ChatColor getChatColor();

	/**
	 * Get the permission to join this team
	 *
	 * @return the join permission
	 */
	public String getPermission();

	/**
	 * Set the permission to join this team
	 *
	 * @param permission the join permission
	 */
	public void setPermission(String permission);

	/**
	 * Check if the player is eligible for obtaining this team
	 * typically we check if they have join permission
	 *
	 * @param player the player
	 * @return true if player can obtain this team
	 */
	public boolean mayObtain(Player player);

	/**
	 * Gives the player the colored leather helmet
	 *
	 * @param player the player to give to
	 */
	public void giveTeamHelmet(Player player);

	/**
	 * Permanently remove the team
	 */
	public void deleteTeam();
}
