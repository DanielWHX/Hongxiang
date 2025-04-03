package interfaces;

/**
 * Kernel interface for the TCG Marketplace. Provides the minimal core
 * functionality for managing items and categories.
 */
public interface TCGMarketplaceKernel {

    /**
     * Lists a new item for sale.
     * 
     * @param item
     *            the item to be listed
     * @updates this
     * @ensures item is added to internal item map
     */
    void listItemForSale(TCGItem item);

    /**
     * Checks if an item is currently available for purchase.
     * 
     * @param itemId
     *            the item's ID
     * @return true if the item is available, false otherwise
     */
    boolean isItemAvailable(String itemId);

    /**
     * Gets the price of a specific item.
     * 
     * @param itemId
     *            the item ID
     * @return the current price
     * @requires item exists
     */
    double getItemPrice(String itemId);

    /**
     * Removes an item from sale.
     * 
     * @param itemId
     *            the ID of the item to remove
     * @updates this
     * @ensures the item is removed from internal map
     */
    void removeItem(String itemId);

    /**
     * Updates the price of a given item.
     * 
     * @param itemId
     *            the item ID
     * @param price
     *            the new price
     * @requires price >= 0
     * @updates this
     * @ensures the item's price is set to price
     */
    void updatePrice(String itemId, double price);

    /**
     * Updates the quantity of an item.
     * 
     * @param itemId
     *            the ID of the item
     * @param quantity
     *            the new quantity
     * @requires quantity >= 0
     * @ensures the item's quantity is updated
     */
    void updateQuantity(String itemId, int quantity);

    /**
     * Adds a new category.
     * 
     * @param categoryName
     *            the name of the category
     * @ensures category is added to internal category map if not present
     */
    void addCategory(String categoryName);

    /**
     * Removes a category.
     * 
     * @param categoryName
     *            the name of the category to remove
     * @requires category exists
     * @updates this
     * @ensures the category is removed and no items remain linked to it
     */
    void removeCategory(String categoryName);

    /**
     * Checks whether a category exists.
     * 
     * @param categoryName
     *            the category name to check
     * @return true if it exists, false otherwise
     */
    boolean hasCategory(String categoryName);

    /**
     * Assigns an item to a category.
     * 
     * @param itemId
     *            the ID of the item
     * @param categoryName
     *            the category name
     * @requires item exists && category exists
     * @updates this
     * @ensures item is now associated with the category
     */
    void assignItemToCategory(String itemId, String categoryName);
}
