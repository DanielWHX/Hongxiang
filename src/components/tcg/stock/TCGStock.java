package components.tcg.stock;

import java.util.List;

/**
 * Enhanced interface for the TCG Marketplace component. This interface contains
 * high-level utility methods built on top of the kernel methods.
 */
public interface TCGStock extends TCGStockKernel {

    List<TCGItem> getItemsByName(String name);

    void removeAllItems(TCGItem item);
}
