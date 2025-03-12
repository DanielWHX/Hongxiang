package interfaces;

import models.TCGItem;
import models.User;

public interface TCGMarketplaceKernel {
    void listItemForSale(TCGItem item);

    void buyItem(String itemId, User buyer);

    boolean isItemAvailable(String itemId);

    double getItemPrice(String itemId);
}