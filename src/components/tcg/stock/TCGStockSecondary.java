package components.tcg.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that implements secondary methods using composition.
 * Subclasses must provide itemManager and categoryManager.
 */
public abstract class TCGStockSecondary implements TCGStock {

    // --------- Secondary Methods ---------

    @Override
    public List<TCGItem> getItemsByName(String name) {
        List<TCGItem> items = new ArrayList<>();
        TCGStock temp = this.newInstance();
        // Move all items to a temporary stock and check if they match the name
        while (this.numberOfUniqueItems() > 0) {
            TCGItem item = this.removeAnyItem();
            if (item.name().equals(name)) {
                items.add(item);
            }
            temp.addItem(item);

        }
        return items;

    }

    @Override
    public void removeAllItems(TCGItem item) {
        // Remove all copies of a given item
        while (this.isInStock(item)) {
            this.removeItem(item);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TCGStock))
            return false;

        TCGStock thisCopy = this.newInstance();
        TCGStock otherCopy = ((TCGStock) obj).newInstance();

        // Clone both sides
        while (this.totalStock() > 0) {
            TCGItem item = this.removeAnyItem();
            thisCopy.addItem(item);
        }

        while (((TCGStock) obj).totalStock() > 0) {
            TCGItem item = ((TCGStock) obj).removeAnyItem();
            otherCopy.addItem(item);
        }

        // Now compare by count
        return thisCopy.totalStock() == otherCopy.totalStock() && thisCopy
                .numberOfUniqueItems() == otherCopy.numberOfUniqueItems();
    }

    @Override
    public String toString() {
        TCGStock temp = this.newInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("TCGStock: [");
        boolean first = true;

        while (this.totalStock() > 0) {
            TCGItem item = this.removeAnyItem();
            if (!first)
                sb.append(", ");
            sb.append(item.name());
            first = false;
            temp.addItem(item);
        }

        this.transferFrom(temp); // restore
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 17;
        TCGStock temp = this.newInstance();

        while (this.totalStock() > 0) {
            TCGItem item = this.removeAnyItem();
            hash = 31 * hash + item.hashCode();
            temp.addItem(item);
        }

        this.transferFrom(temp);
        return hash;
    }

}