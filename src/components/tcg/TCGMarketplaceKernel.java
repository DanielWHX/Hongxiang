package tcg;

import models.TCGItem;
import models.User;

public interface TCGMarketplaceKernel {

    /**
     * Lists an item for sale.
     *
     * @param item
     *            the item to list
     * @updates this
     * @requires item != null
     * @ensures this includes the new item listed
     */
    void listItemForSale(TCGItem item);

    /**
     * Allows a user to buy an item.
     *
     * @param itemId
     *            the ID of the item
     * @param buyer
     *            the buyer of the item
     * @updates this
     * @requires itemId exists and buyer != null
     * @ensures item is marked as sold and removed from active listings
     */
    void buyItem(String itemId, User buyer);

    boolean isItemAvailable(String itemId);

    double getItemPrice(String itemId);
}