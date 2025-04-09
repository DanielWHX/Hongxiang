package components.tcg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.model.TCGItem;

/**
 * Manager class responsible for managing TCG items in the marketplace.
 */
public class ItemManager {
    private final Map<String, TCGItem> itemMap = new HashMap<>();

    public void addItem(TCGItem item) {
        this.itemMap.put(item.getItemId(), item);
    }

    public void removeItem(String itemId) {
        this.itemMap.remove(itemId);
    }

    public boolean isAvailable(String itemId) {
        return this.itemMap.containsKey(itemId) && this.itemMap.get(itemId).isAvailable();
    }

    public void updatePrice(String itemId, double price) {
        if (this.itemMap.containsKey(itemId)) {
            this.itemMap.get(itemId).updatePrice(price);
        }
    }

    public void updateQuantity(String itemId, int quantity) {
        if (this.itemMap.containsKey(itemId)) {
            this.itemMap.get(itemId).updateQuantity(quantity);
        }
    }

    public TCGItem getItem(String itemId) {
        return this.itemMap.get(itemId);
    }

    public List<TCGItem> getAllItems() {
        return new ArrayList<>(this.itemMap.values());
    }

    public int getQuantity(String itemId) {
        return this.itemMap.containsKey(itemId) ? this.itemMap.get(itemId).getQuantity()
                : 0;
    }
}