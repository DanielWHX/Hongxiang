package interfaces;

import java.util.List;

import models.TCGItem;
import models.User;

public interface TCGMarketplace extends TCGMarketplaceKernel {
    List<TCGItem> getAllItemsForSale();

    List<TCGItem> getItemsBelowPrice(double maxPrice);

    double getAverageMarketPrice(TCGItem item);

    void updateMarketPrices();

    List<TCGItem> getUserListedItems(User seller);
}