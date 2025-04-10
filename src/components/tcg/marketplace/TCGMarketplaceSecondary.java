package components.tcg.marketplace;

import java.util.ArrayList;
import java.util.List;

import components.tcg.customer.User;
import components.tcg.stock.TCGItem;

/**
 * Abstract class that implements secondary methods using composition.
 * Subclasses must provide itemManager and categoryManager.
 */
public abstract class TCGMarketplaceSecondary implements ITCGMarketplace {

    // --------- Secondary Methods ---------
    @Override
    public void buyItem(String itemId, User buyer) {
        if (this.itemManager.isAvailable(itemId)) {
            TCGItem item = this.itemManager.getItem(itemId);
            item.markAsSold();
            System.out.println(buyer.getUserName() + " bought " + item.getName()
                    + " for $" + item.getPrice());
        } else {
            System.out.println("Item not available or does not exist.");
        }
    }

    @Override
    public int getQuantity(String itemId) {
        return this.itemManager.getQuantity(itemId);
    }

    @Override
    public List<String> getAllCategories() {
        return this.categoryManager.getAllCategories();
    }

    @Override
    public List<TCGItem> searchItems(String keyword) {
        List<TCGItem> result = new ArrayList<>();
        for (TCGItem item : this.itemManager.getAllItems()) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void applyDiscount(String itemId, double percent) {
        TCGItem item = this.itemManager.getItem(itemId);
        if (item != null) {
            double discounted = item.getPrice() * (1 - percent / 100.0);
            item.updatePrice(discounted);
        }
    }

    @Override
    public void restockItem(String itemId, int amount) {
        int current = this.itemManager.getQuantity(itemId);
        this.itemManager.updateQuantity(itemId, current + amount);
    }

    @Override
    public List<TCGItem> getItemsByCategory(String category) {
        List<TCGItem> result = new ArrayList<>();
        for (String itemId : this.categoryManager
                .getItemIdsByCategory(category)) {
            TCGItem item = this.itemManager.getItem(itemId);
            if (item != null) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<TCGItem> getAllItemsForSale() {
        List<TCGItem> result = new ArrayList<>();
        for (TCGItem item : this.itemManager.getAllItems()) {
            if (item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void transferItemToAnotherMarketplace(ITCGMarketplace other,
            String itemId) {
        if (this.itemManager.isAvailable(itemId)) {
            TCGItem item = this.itemManager.getItem(itemId);
            other.listItemForSale(item);
            this.itemManager.removeItem(itemId);
        }
    }
}