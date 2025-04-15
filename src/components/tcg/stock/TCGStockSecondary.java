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
        if (!(obj instanceof TCGStock)) {
            return false;
        }

        TCGStock other = (TCGStock) obj;

        // Compare number of unique items
        if (this.numberOfUniqueItems() != other.numberOfUniqueItems()) {
            return false;
        }

        // Compare each item's count by temporarily removing them one by one
        TCGStock tempThis = this.newInstance();
        TCGStock tempOther = other.newInstance();

        while (this.numberOfUniqueItems() > 0) {
            TCGItem item = this.removeAnyItem();
            tempThis.addItem(item);

            int countThis = 1;
            while (this.isInStock(item)) {
                this.removeItem(item);
                tempThis.addItem(item);
                countThis++;
            }

            int countOther = 0;
            while (other.isInStock(item)) {
                other.removeItem(item);
                tempOther.addItem(item);
                countOther++;
            }

            if (countThis != countOther) {
                this.transferFrom(tempThis);
                other.transferFrom(tempOther);
                return false;
            }
        }

        this.transferFrom(tempThis);
        other.transferFrom(tempOther);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        TCGStock temp = this.newInstance();

        boolean first = true;
        while (this.numberOfUniqueItems() > 0) {
            TCGItem item = this.removeAnyItem();
            if (!first) {
                sb.append(", ");
            }
            sb.append(item.name());
            first = false;
            temp.addItem(item);
        }

        this.transferFrom(temp);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        // Hash code is based on the total stock and number of unique items
        return this.totalStock() * 31 + this.numberOfUniqueItems();
    }
}