package components.tcg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import components.model.TCGItem;
import components.model.User;

/**
 * Abstract class implementing the TCGMarketplace interface. Implements all
 * secondary methods using kernel methods only.
 */
<<<<<<< HEAD
public abstract class TCGMarketplaceSecondary implements TCGMarketplace {
=======
public abstract class TCGMarketplaceSecondary implements ITCGMarketplace {

    // --------- Kernel Method Stubs (to be implemented by subclass) ---------

    @Override
    public abstract void listItemForSale(TCGItem item);

    @Override
    public abstract boolean isItemAvailable(String itemId);

    @Override
    public abstract double getItemPrice(String itemId);

    @Override
    public abstract void removeItem(String itemId);

    @Override
    public abstract void updatePrice(String itemId, double price);

    @Override
    public abstract void updateQuantity(String itemId, int quantity);

    @Override
    public abstract void addCategory(String categoryName);

    @Override
    public abstract void removeCategory(String categoryName);

    @Override
    public abstract boolean hasCategory(String categoryName);

    @Override
    public abstract void assignItemToCategory(String itemId,
            String categoryName);

    // --------- Secondary Method Implementations ---------
    /**
     * Provides access to the internal map storing all items by itemId.
     * protected：subclass can access
     *
     * @return the map containing all items, keyed by item ID
     */
    protected abstract Map<String, TCGItem> getItemMap();

    /**
     * Provides access to the internal map storing category-to-itemID mappings.
     * Each category name maps to a list of item IDs that belong to that
     * category. protected：subclass can access
     *
     * @return the category map: category name ➝ list of item IDs
     */
    protected abstract Map<String, List<String>> getCategoryMap();

    @Override
    public void buyItem(String itemId, User buyer) {
        if (this.isItemAvailable(itemId)) {
            TCGItem item = this.getItemMap().get(itemId);
            item.markAsSold();
            System.out.println(buyer.getUserName() + " bought " + item.getName()
                    + " for $" + item.getPrice());
        } else {
            System.out.println("Item not available or does not exist.");
        }
    }

    @Override
    public int getQuantity(String itemId) {
        return this.getItemMap().containsKey(itemId)
                ? this.getItemMap().get(itemId).getQuantity()
                : 0;
    }

    @Override
    public List<String> getAllCategories() {
        return new ArrayList<>(this.getCategoryMap().keySet());
    }

    @Override
    public List<TCGItem> searchItems(String keyword) {
        List<TCGItem> result = new ArrayList<>();
        for (TCGItem item : this.getItemMap().values()) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void applyDiscount(String itemId, double percent) {
        if (this.getItemMap().containsKey(itemId)) {
            TCGItem item = this.getItemMap().get(itemId);
            double discountedPrice = item.getPrice() * (1 - percent / 100.0);
            item.updatePrice(discountedPrice);
        }
    }

    @Override
    public void restockItem(String itemId, int amount) {
        if (this.getItemMap().containsKey(itemId) && amount > 0) {
            TCGItem item = this.getItemMap().get(itemId);
            item.updateQuantity(item.getQuantity() + amount);
        }
    }

    @Override
    public List<TCGItem> getItemsByCategory(String category) {
        List<TCGItem> result = new ArrayList<>();
        if (this.getCategoryMap().containsKey(category)) {
            for (String itemId : this.getCategoryMap().get(category)) {
                if (this.getItemMap().containsKey(itemId)) {
                    result.add(this.getItemMap().get(itemId));
                }
            }
        }
        return result;
    }
>>>>>>> 4e98dc3ee1682ca2d6d468a484d88c61564e7a43

    /**
     * Return all items currently listed for sale.
     */
    @Override
    public List<TCGItem> getAllItemsForSale() {
        List<TCGItem> result = new ArrayList<>();
        for (String itemId : this.itemsForSale.keySet()) {
            if (this.isItemAvailable(itemId)) {
                result.add(this.itemsForSale.get(itemId));
            }
        }
        return result;
    }

    /**
     * Returns items listed below a certain price.
     */
    @Override
    public List<TCGItem> getItemsBelowPrice(double maxPrice) {
        List<TCGItem> result = new ArrayList<>();
        for (TCGItem item : this.getAllItemsForSale()) {
            if (item.getPrice() < maxPrice) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Calculates the average market price of a TCG item based on its price
     * history.
     */
    @Override
    public double getAverageMarketPrice(TCGItem item) {
        List<Double> history = item.getPriceHistory();
        double sum = 0.0;
        for (double price : history) {
            sum += price;
        }
        return history.isEmpty() ? 0.0 : sum / history.size();
    }

    /**
     * Updates the prices of all items randomly for demonstration.
     */
    @Override
    public void updateMarketPrices() {
        Random random = new Random();
        for (String itemId : this.itemsForSale.keySet()) {
            if (this.isItemAvailable(itemId)) {
                TCGItem item = this.itemsForSale.get(itemId);
                double newPrice = item.getPrice()
                        * (0.9 + random.nextDouble() * 0.2);
                item.updatePrice(newPrice);
            }
        }
    }

    /**
     * Returns all items listed by a specific user.
     */
    @Override
    public List<TCGItem> getUserListedItems(User seller) {
        List<TCGItem> result = new ArrayList<>();
        for (String itemId : this.itemsForSale.keySet()) {
            TCGItem item = this.itemsForSale.get(itemId);
            if (this.isItemAvailable(itemId)
                    && item.getName().contains(seller.getUserName())) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of the marketplace.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Marketplace Listings:\n");
        for (TCGItem item : this.getAllItemsForSale()) {
            sb.append(item.getName()).append(" - $")
                    .append(String.format("%.2f", item.getPrice()))
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * Compares two marketplaces for equality based on item listings.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof TCGMarketplace))
            return false;
        TCGMarketplace other = (TCGMarketplace) obj;

        List<TCGItem> thisItems = this.getAllItemsForSale();
        List<TCGItem> otherItems = other.getAllItemsForSale();
        return new HashSet<>(thisItems).equals(new HashSet<>(otherItems));
    }
}
