package org.mineacademy.gameapi.impl;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.mineacademy.gameapi.Arena;
import org.mineacademy.gameapi.ArenaMessenger;
import org.mineacademy.gameapi.ArenaPlugin;
import org.mineacademy.gameapi.ArenaSnapshotStage;
import org.mineacademy.gameapi.ExpItem;
import org.mineacademy.gameapi.cause.DeathCause;
import org.mineacademy.gameapi.cause.JoinCause;
import org.mineacademy.gameapi.cause.LeaveCause;
import org.mineacademy.gameapi.cause.StopCause;
import org.mineacademy.gameapi.event.ArenaJoinEvent;
import org.mineacademy.gameapi.event.ArenaLeaveEvent;
import org.mineacademy.gameapi.event.ArenaPostStartEvent;
import org.mineacademy.gameapi.event.ArenaPostStopEvent;
import org.mineacademy.gameapi.event.ArenaPreJoinEvent;
import org.mineacademy.gameapi.event.ArenaPreLeaveEvent;
import org.mineacademy.gameapi.event.LobbyStartEvent;
import org.mineacademy.gameapi.type.ArenaState;

import lombok.RequiredArgsConstructor;

/**
 * A very simple implementation of the Arena, firing
 * events automatically on
 *
 *  1) player join & quit,
 * 	2) lobby start, and
 *  3) arena start & end.
 *
 *  Finally, we also handle a simple end count down.
 *  Feel free to explore this class to get a basics understanding on how it works.
 */
@RequiredArgsConstructor
public abstract class DummyArena implements Arena {

	/**
	 * The name of your arena
	 */
	private final String name;

	/**
	 * Your plugin that creates the arena
	 */
	private final ArenaPlugin plugin;

	/**
	 * The inbuilt messenger for sending messages.
	 */
	private final ArenaMessenger messenger = new BasicMessenger(this);

	/**
	 * Arena state.
	 */
	private ArenaState state = ArenaState.STOPPED;

	/**
	 * An internal flag to workaround some stuff.
	 */
	private boolean stopping;

	@Override
	public void onPostLoad() {
	}

	@Override
	public final boolean joinPlayer(Player player, JoinCause cause) {
		if (!callEvent(new ArenaPreJoinEvent(this, cause, player)))
			return false;

		final boolean success = handleJoin(player, cause);

		callEvent(new ArenaJoinEvent(this, cause, player));
		return success;
	}

	/**
	 * Called after the player attempts to join,
	 * and the {@link ArenaPreJoinEvent} has been fired and not cancelled.
	 *
	 * @param player the player
	 * @param cause the cause
	 */
	protected abstract boolean handleJoin(Player player, JoinCause cause);

	@Override
	public final boolean kickPlayer(Player player, LeaveCause cause) {
		if (!callEvent(new ArenaPreLeaveEvent(this, cause, player)))
			return false;

		final boolean success = handleLeave(player, cause);

		callEvent(new ArenaLeaveEvent(this, cause, player));
		return success;
	}

	/**
	 * Called after the player attempts to quit,
	 * and the {@link ArenaPreLeaveEvent} has been fired and not cancelled.
	 *
	 * @param player the player
	 * @param cause the cause
	 */
	protected abstract boolean handleLeave(Player player, LeaveCause cause);

	@Override
	public final boolean startArena() {
		state = ArenaState.RUNNING;

		callEvent(new ArenaPostStartEvent(this));
		return handleArenaStart();
	}

	/**
	 * Called after arena starts and the {@link ArenaPostStartEvent} has been fired.
	 */
	protected abstract boolean handleArenaStart();

	@Override
	public final void startLobby() {
		state = ArenaState.LOBBY;

		Bukkit.getPluginManager().callEvent(new LobbyStartEvent(this));
	}

	@Override
	public final void stopArena(StopCause cause) {
		if (stopping)
			return;

		state = ArenaState.STOPPED;
		stopping = true;

		try {
			handleArenaStop(cause);

			Bukkit.getPluginManager().callEvent(new ArenaPostStopEvent(this, cause));
		} finally {
			stopping = false;
		}
	}

	/**
	 * Called when the arena ends and the {@link ArenaPostStopEvent} has been fired.
	 */
	protected abstract void handleArenaStop(StopCause cause);

	@Override
	public void teleportPlayerBack(Player player) {
	}

	@Override
	public void onPlayerPvP(EntityDamageByEntityEvent event, Player damager, Player victim, double damage) {
	}

	@Override
	public void onPlayerPvE(Player damager, LivingEntity victim, double damage) {
	}

	@Override
	public void onPlayerDamage(EntityDamageByEntityEvent event, Player player, Entity source, double damage) {
	}

	@Override
	public void onPlayerBlockDamage(EntityDamageByBlockEvent event, Player player, double damage) {
	}

	@Override
	public void onPlayerDeath(Player player, Player killer) {
	}

	@Override
	public void onPlayerDeath(Player player, DeathCause cause) {
	}

	@Override
	public void onPlayerClick(Player player, Block clickedBlock, ItemStack hand) {
	}

	@Override
	public void onPlayerClickAir(Player player, ItemStack hand) {
	}

	@Override
	public void onPlayerBlockPlace(BlockPlaceEvent event) {
	}

	@Override
	public void onPlayerBlockBreak(BlockBreakEvent event) {
	}

	@Override
	public void onEntityTarget(EntityTargetEvent event) {
	}

	@Override
	public void onEntityDeath(EntityDeathEvent event) {
	}

	@Override
	public void onPlayerRespawn(PlayerRespawnEvent event) {
	}

	@Override
	public void onPlayerPickupTag(PlayerPickupItemEvent event, ExpItem expItem) {
	}

	@Override
	public void onProjectileHit(ProjectileHitEvent event) {
	}

	@Override
	public void onProjectileLaunch(ProjectileLaunchEvent event) {
	}

	@Override
	public void onEntitySpawn(EntitySpawnEvent event) {
	}

	@Override
	public void onSnapshotUpdate(ArenaSnapshotStage newState) {
	}

	@Override
	public void setRestoreSnapshots(boolean restoreSnapshots) {
	}

	/**
	 * An utility method to call events.
	 *
	 * @param event the event
	 * @return true if the event was not cancelled, meaning it has passed.
	 */
	private final boolean callEvent(org.bukkit.event.Event event) {
		Bukkit.getPluginManager().callEvent(event);

		return event instanceof Cancellable ? !((Cancellable) event).isCancelled() : true;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public final ArenaPlugin getPlugin() {
		return plugin;
	}

	@Override
	public final ArenaMessenger getMessenger() {
		return messenger;
	}

	@Override
	public final boolean isStopping() {
		return stopping;
	}

	@Override
	public final ArenaState getState() {
		return state;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
	}

	@Override
	public String toString() {
		return "DummyArena{name=" + name + ",plugin=" + plugin.getName() + "}";
	}
}
