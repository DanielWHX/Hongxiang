package components.tcg.stock;

import java.util.HashMap;
import java.util.Map;

public class TCGStock1 extends TCGStockSecondary {

    /**
     * Stores items and their counts;
     */
    private Map<TCGItem, Integer> stock;

    public TCGStock1() {
        this.stock = new HashMap<>();
    }

    @Override
    public void addItem(TCGItem item) {
        // increment the count of the item in stock
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
    public int numberOfUniqueItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'numberOfItems'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public TCGStock newInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'newInstance'");
    }

    @Override
    public void transferFrom(TCGStock arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }

    @Override
    public TCGItem removeItem(TCGItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'removeItem'");
    }

    @Override
    public int totalStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'totalStock'");
    }

    @Override
    public boolean isInStock(TCGItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'isInStock'");
    }

}
