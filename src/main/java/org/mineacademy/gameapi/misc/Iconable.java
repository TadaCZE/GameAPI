package org.mineacademy.gameapi.misc;

import org.bukkit.inventory.ItemStack;

/**
 * Represents a menu item that can have an icon
 */
public interface Iconable {


	/**
	 * Get the icon
	 *
	 * @return the icon, or null if not set
	 */
	public ItemStack getIcon();

	/**
	 * Is the icon set?
	 *
	 * @return true if the icon has been set
	 */
	public boolean hasIcon();

	/**
	 * Set a new icon for this menu item
	 *
	 * @param icon the new icon, set to null to remove
	 */
	public void setIcon(ItemStack icon);
}
