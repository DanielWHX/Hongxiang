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
        //step1:alias check
        if (this == obj) {
            return true;
        }
        //step2:null check
        if (obj == null) {
            return false;
        }
        //step3:interface check
        if (!(obj instanceof TCGStock)) {
            return false;
        }

        TCGStock other = (TCGStock) obj;

        // Step 4: Quick check - different size
        if (this.totalStock() != other.totalStock()) {
            return false;
        }
        if (this.numberOfUniqueItems() != other.numberOfUniqueItems()) {
            return false;
        }

        // Step 5: Deep comparison via item count
        TCGStock tempThis = this.newInstance();
        TCGStock tempOther = other.newInstance();
        boolean isEqual = true;

        while (this.totalStock() > 0 && isEqual) {
            TCGItem item = this.removeAnyItem();
            int countThis = 1;
            while (this.isInStock(item)) {
                this.removeItem(item);
                countThis++;
            }

            int countOther = 0;
            while (other.isInStock(item)) {
                other.removeItem(item);
                countOther++;
            }

            if (countThis != countOther) {
                isEqual = false;
            }

            for (int i = 0; i < countThis; i++) {
                tempThis.addItem(item);
                tempOther.addItem(item);
            }
        }

        this.transferFrom(tempThis);
        other.transferFrom(tempOther);

        return isEqual;
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