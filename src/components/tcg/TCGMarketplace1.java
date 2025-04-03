package components.tcg;

/**
 * Concrete implementation of TCGMarketplace component. Implements the kernel
 * methods using the internal representation.
 */
public class TCGMarketplace1 extends TCGMarketplaceSecondary {

    @Override
    public void listItemForSale(TCGItem item) {
        assert item != null : "Item must not be null";
        this.itemsForSale.put(item.getItemId(), item);
    }

    @Override
    public void buyItem(String itemId, User buyer) {
        assert buyer != null : "Buyer must not be null";
        if (this.itemsForSale.containsKey(itemId)) {
            TCGItem item = this.itemsForSale.get(itemId);
            if (item.isAvailable()) {
                item.markAsSold();
            }
        }
    }

    /**
     * Checks if an item is available.
     *
     * @param itemId
     *            the ID of the item
     * @return true if available
     */
    @Override
    public boolean isItemAvailable(String itemId) {
        return this.itemsForSale.containsKey(itemId)
                && this.itemsForSale.get(itemId).isAvailable();
    }

    /**
     * Gets the price of a listed item.
     *
     * @param itemId
     *            the ID of the item
     * @return the price or -1 if not found
     */
    @Override
    public double getItemPrice(String itemId) {
        return this.itemsForSale.containsKey(itemId)
                ? this.itemsForSale.get(itemId).getPrice()
                : -1;
    }
}
