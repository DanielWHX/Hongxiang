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
        while (this.numberOfUniqueItems() > 0) {
            TCGItem item = this.removeAnyItem();
            if (item.name().equals(name)) {
                items.add(item);
            }
            temp.addItem(item);

        }
        return items;

    }

    // TODO: implement equals, toString, hashCode

}