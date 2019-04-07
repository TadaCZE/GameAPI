package org.mineacademy.gameapi;

import java.util.List;
import java.util.Set;

import org.bukkit.entity.Player;

/**
 * Represents an arena with team support
 */
public interface TeamedArena extends Arena {

	/**
	 * Get all teams that play in this arena
	 *
	 * @return list of all teams
	 */
	public Set<Team> getTeams();

	/**
	 * Get the team of the player
	 *
	 * @param player the player
	 * @return the players team
	 */
	public Team getTeam(Player player);

	/**
	 * Get the original list of players who started to play this arena in a team
	 *
	 * @param team the team
	 * @return the join players list
	 */
	public List<Player> getStartingTeamPlayers(Team team);

	/**
	 * Get the alive and current players in a team
	 *
	 * @param team the team
	 * @return the alive remaining players
	 */
	public List<Player> getTeamPlayers(Team team);

	/**
	 * Give a team to a player
	 *
	 * @param player the player
	 * @param team the team
	 */
	public void assignTeam(Player player, Team team);
}
