package components.tcg;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'addItem'");
    }

    @Override
    public TCGItem removeAnyItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'removeAnyItem'");
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
