package org.mineacademy.gameapi;

import org.bukkit.inventory.ItemStack;
import org.mineacademy.gameapi.type.RewardType;

/**
 * Represents a material reward that can be purchased for Nuggets
 * after the game is finished.
 */
public interface Reward {

	/**
	 * The reward type
	 */
	public RewardType getType();

	/**
	 * The Nugget costs to obtain it
	 *
	 * @return the cost
	 */
	public int getCost();

	/**
	 * Set a new Nugget cost to obtain it
	 *
	 * @param cost the new cost
	 */
	public void setCost(int cost);

	/**
	 * Get the item for this reward
	 *
	 * @return the itemstack
	 */
	public ItemStack getItem();

	/**
	 * Set the item for this reward
	 *
	 * @param item new item
	 */
	public void setItem(ItemStack item);
}
