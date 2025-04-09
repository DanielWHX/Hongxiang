package components.tcg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.model.TCGItem;

/**
 * Concrete implementation of TCG marketplace. Implements all kernel methods and
 * provides internal storage.
 */
public class TCGMarketplace1 extends TCGMarketplaceSecondary {

    private final Map<String, TCGItem> itemMap;
    private final Map<String, List<String>> categoryMap;

    /**
     * Constructor to initialize storage.
     */
    public TCGMarketplace1() {
        this.itemMap = new HashMap<>();
        this.categoryMap = new HashMap<>();
    }

    // ------------------- Kernel Method Implementations -------------------

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
        if (this.categoryMap.containsKey(categoryName)) {
            List<String> itemIds = this.categoryMap.get(categoryName);
            for (String itemId : itemIds) {
                if (this.itemMap.containsKey(itemId)) {
                    this.itemMap.get(itemId).setCategory(null);
                }
            }
            this.categoryMap.remove(categoryName);
        }
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

    // ------------------- Required by Abstract Superclass -------------------

    @Override
    protected Map<String, TCGItem> getItemMap() {
        return this.itemMap;
    }

    @Override
    protected Map<String, List<String>> getCategoryMap() {
        return this.categoryMap;
    }
}
