package components.tcg;

import components.standard.Standard;

/**
 * Kernel interface for the TCG Marketplace. Provides the minimal core
 * functionality for managing items and categories.
 */
public interface TCGStockKernel extends Standard<TCGStock> {

    /**
     * Adds a TCGItem to the stock. If the item already exists, the count is
     * incremented.
     *
     * @param item
     */
    void addItem(TCGItem item);

    /**
     * Removes one copy of a TCGItem from the stock.
     *
     * @requires [item is in stock]
     * @return
     */
    TCGItem removeAnyItem();

    /**
     * Removes one copy of a TCGItem from the stock.
     *
     * @param itemId
     *            the ID of the item to remove
     * @updates this
     * @ensures the item is removed from internal map
     */
    TCGItem removeItem(TCGItem item);

    /**
     * Gets the number of unique TCGItems in the stock.
     *
     * @return
     */
    int numberOfUniqueItems();

    /**
     * Gets the total number of items in stock.
     *
     * @return
     */
    int totalStock();

    boolean isInStock(TCGItem item);

}
