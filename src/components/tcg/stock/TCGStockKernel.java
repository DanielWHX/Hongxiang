package components.tcg.stock;

import components.standard.Standard;

/**
 * Kernel interface for the TCG Stock component. Provides minimal core
 * functionality for managing item stock.
 */
public interface TCGStockKernel extends Standard<TCGStock> {

    /**
     * Adds one copy of the given item to the stock.
     *
     * @param item
     *            the item to add
     * @updates this
     * @ensures stock[item] += 1
     */
    void addItem(TCGItem item);

    /**
     * Removes one copy of a random item from the stock.
     *
     * @return the item that was removed
     * @updates this
     * @requires totalStock() > 0
     */
    TCGItem removeAnyItem();

    /**
     * Removes one copy of the given item from the stock.
     *
     * @param item
     *            the item to remove
     * @return the removed item
     * @updates this
     * @requires isInStock(item)
     */
    TCGItem removeItem(TCGItem item);

    /**
     * Checks if the given item is in stock.
     *
     * @param item
     *            the item to check
     * @return true if item is in stock, false otherwise
     */
    boolean isInStock(TCGItem item);

    /**
     * Returns the number of unique items in the stock.
     *
     * @return count of unique item names
     */
    int numberOfUniqueItems();

    /**
     * Returns the total number of items in stock.
     *
     * @return total quantity of all items
     */
    int totalStock();
}
