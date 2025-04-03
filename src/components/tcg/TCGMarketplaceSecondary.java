package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import interfaces.TCGMarketplace;
import models.TCGItem;
import models.User;

/**
 * Abstract class implementing the TCGMarketplace interface. Implements all
 * secondary methods using kernel methods only.
 */
public abstract class TCGMarketplaceSecondary implements TCGMarketplace {
    // Underlying storage assumed for kernel methods to function
    protected Map<String, TCGItem> itemsForSale = new HashMap<>();

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
