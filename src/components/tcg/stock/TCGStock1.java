package components.tcg.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * Concrete class for TCGStock component. Implements all kernel methods using a
 * HashMap to manage stock.
 */
public class TCGStock1 extends TCGStockSecondary {

    /**
     * Stores items and their counts.
     */
    private Map<TCGItem, Integer> stock;

    public TCGStock1() {
        this.stock = new HashMap<>();
    }

    @Override
    public void addItem(TCGItem item) {
        // Add item or increment its count
        this.stock.put(item, this.stock.getOrDefault(item, 0) + 1);
    }

    @Override
    public TCGItem removeItem(TCGItem item) {
        // Remove one copy of the given item
        if (!this.stock.containsKey(item)) {
            throw new IllegalArgumentException("Item not in stock: " + item);
        }

        int count = this.stock.get(item);
        if (count == 1) {
            this.stock.remove(item);
        } else {
            this.stock.put(item, count - 1);
        }

        return item;
    }

    @Override
    public TCGItem removeAnyItem() {
        // Remove one copy of any item (we pick the first one from the map)
        if (this.stock.isEmpty()) {
            throw new IllegalStateException("Stock is empty");
        }
        //actually the next item in the iterator
        TCGItem anyItem = this.stock.keySet().iterator().next();
        return this.removeItem(anyItem);
    }

    @Override
    public boolean isInStock(TCGItem item) {
        // Check if item is present and has non-zero count
        return this.stock.containsKey(item);
    }

    @Override
    public int numberOfUniqueItems() {
        // Number of unique items = size of the map
        return this.stock.size();
    }

    @Override
    public int totalStock() {
        // Sum all item counts
        int total = 0;
        for (int count : this.stock.values()) {
            total += count;
        }
        return total;
    }

    @Override
    public void clear() {
        // Remove all entries from the map
        this.stock.clear();
    }

    @Override
    public TCGStock newInstance() {
        // Create and return a new empty instance of this component
        return new TCGStock1();
    }

    @Override
    public void transferFrom(TCGStock other) {
        // Copy all items from another stock instance and clear it
        if (!(other instanceof TCGStock1)) {
            throw new IllegalArgumentException("Incompatible stock type");
        }

        TCGStock1 that = (TCGStock1) other;
        this.stock = that.stock;
        that.stock = new HashMap<>();
    }
}
