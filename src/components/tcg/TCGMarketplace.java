package components.tcg;

import java.util.List;

public interface TCGMarketplace extends TCGMarketplaceKernel {

    List<TCGItem> getAllItemsForSale();

    List<TCGItem> getItemsBelowPrice(double maxPrice);

    double getAverageMarketPrice(TCGItem item);

    void updateMarketPrices();

    List<TCGItem> getUserListedItems(User seller);
}