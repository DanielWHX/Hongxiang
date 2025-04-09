package components.tcg;

import java.util.List;

import components.model.TCGItem;
import components.model.User;

/**
 * Enhanced interface for the TCG Marketplace component. This interface contains
 * high-level utility methods built on top of the kernel methods.
 */
public interface ITCGMarketplace extends ITCGMarketplaceKernel {

    /**
     * Facilitates the purchase of an item by a user.
     *
     * @param itemId
     *            the ID of the item to buy
     * @param buyer
     *            the user who is purchasing the item
     * @requires isItemAvailable(itemId)
     * @ensures the item is marked sold and removed from inventory
     */
    void buyItem(String itemId, User buyer);

    /**
     * Retrieves the quantity of a specific item.
     *
     * @param itemId
     *            the ID of the item
     * @return the current quantity in stock
     * @requires item exists
     * @ensures result = item's quantity
     */
    int getQuantity(String itemId);

    /**
     * Retrieves a list of all category names.
     *
     * @return a list of category strings
     * @ensures result contains all added categories
     */
    List<String> getAllCategories();

    /**
     * Searches items by keyword.
     *
     * @param keyword
     *            the search term to match against item names or descriptions
     * @return a list of matching items
     * @ensures result contains items with names containing the keyword
     */
    List<TCGItem> searchItems(String keyword);

    /**
     * Applies a discount percentage to an item.
     *
     * @param itemId
     *            the item ID
     * @param percent
     *            the percentage discount to apply (e.g., 10 for 10%)
     * @requires 0 < percent <= 100
     * @ensures the item's price is updated with the discount
     */
    void applyDiscount(String itemId, double percent);

    /**
     * Increases the stock of a given item.
     *
     * @param itemId
     *            the item to restock
     * @param amount
     *            the number of items to add
     * @requires amount > 0
     * @ensures quantity is increased by amount
     */
    void restockItem(String itemId, int amount);

    /**
     * Retrieves all items within a specific category.
     *
     * @param category
     *            the category name
     * @return a list of items in that category
     * @requires hasCategory(category)
     * @ensures result contains only items in the given category
     */
    List<TCGItem> getItemsByCategory(String category);

    /**
     * Retrieves all currently listed items for sale.
     *
     * @return a list of all available items
     * @ensures result contains only available items
     */
    List<TCGItem> getAllItemsForSale();

    /**
     * Transfers an item to another marketplace.
     *
     * @param other
     *            the target marketplace
     * @param itemId
     *            the item to transfer
     * @requires isItemAvailable(itemId)
     * @ensures item is removed from current and added to other marketplace
     */
    void transferItemToAnotherMarketplace(ITCGMarketplace other, String itemId);
}
