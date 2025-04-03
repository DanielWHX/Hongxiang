package components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the ITCGMarketplace interface. Stores and manages TCG
 * items, prices, quantities, and categories.
 */
public class TCGMarketplace1 implements ITCGMarketplace {

    private final Map<String, TCGItem> itemMap;
    private final Map<String, List<String>> categoryMap;

    public TCGMarketplace1() {
        this.itemMap = new HashMap<>();
        this.categoryMap = new HashMap<>();
    }

    // ---------------- Kernel Methods ----------------

    @Override
    public void listItemForSale(TCGItem item) {
        this.itemMap.put(item.getItemId(), item);
    }

    @Override
    public boolean isItemAvailable(String itemId) {
        return this.itemMap.containsKey(itemId)
                && this.itemMap.get(itemId).isAvailable();
    }

    @Override
    public double getItemPrice(String itemId) {
        return this.itemMap.containsKey(itemId)
                ? this.itemMap.get(itemId).getPrice()
                : -1;
    }

    @Override
    public void removeItem(String itemId) {
        this.itemMap.remove(itemId);
        for (List<String> items : this.categoryMap.values()) {
            items.remove(itemId);
        }
    }

    @Override
    public void updatePrice(String itemId, double price) {
        if (this.itemMap.containsKey(itemId)) {
            this.itemMap.get(itemId).updatePrice(price);
        }
    }

    @Override
    public void updateQuantity(String itemId, int quantity) {
        if (this.itemMap.containsKey(itemId)) {
            this.itemMap.get(itemId).updateQuantity(quantity);
        }
    }

    @Override
    public void addCategory(String categoryName) {
        this.categoryMap.putIfAbsent(categoryName, new ArrayList<>());
    }

    @Override
    public void removeCategory(String categoryName) {
        this.categoryMap.remove(categoryName);
    }

    @Override
    public boolean hasCategory(String categoryName) {
        return this.categoryMap.containsKey(categoryName);
    }

    @Override
    public void assignItemToCategory(String itemId, String categoryName) {
        if (this.itemMap.containsKey(itemId)
                && this.categoryMap.containsKey(categoryName)) {
            this.categoryMap.get(categoryName).add(itemId);
            this.itemMap.get(itemId).setCategory(categoryName);
        }
    }
}
