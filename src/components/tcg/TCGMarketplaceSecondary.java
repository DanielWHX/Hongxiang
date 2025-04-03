package components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Abstract class providing default secondary method implementations for a
 * marketplace. Implements ITCGMarketplace but leaves Kernel methods abstract.
 */
public abstract class TCGMarketplaceSecondary implements ITCGMarketplace {

    // --------- Kernel Method Stubs (to be implemented by subclass) ---------

    @Override
    public abstract void listItemForSale(TCGItem item);

    @Override
    public abstract boolean isItemAvailable(String itemId);

    @Override
    public abstract double getItemPrice(String itemId);

    @Override
    public abstract void removeItem(String itemId);

    @Override
    public abstract void updatePrice(String itemId, double price);

    @Override
    public abstract void updateQuantity(String itemId, int quantity);

    @Override
    public abstract void addCategory(String categoryName);

    @Override
    public abstract void removeCategory(String categoryName);

    @Override
    public abstract boolean hasCategory(String categoryName);

    @Override
    public abstract void assignItemToCategory(String itemId,
            String categoryName);

    // --------- Secondary Method Implementations ---------

    protected abstract Map<String, TCGItem> getItemMap();

    protected abstract Map<String, List<String>> getCategoryMap();

    @Override
    public void buyItem(String itemId, User buyer) {
        if (this.isItemAvailable(itemId)) {
            TCGItem item = this.getItemMap().get(itemId);
            item.markAsSold();
            System.out.println(buyer.getUserName() + " bought " + item.getName()
                    + " for $" + item.getPrice());
        } else {
            System.out.println("Item not available or does not exist.");
        }
    }

    @Override
    public int getQuantity(String itemId) {
        return this.getItemMap().containsKey(itemId)
                ? this.getItemMap().get(itemId).getQuantity()
                : 0;
    }

    @Override
    public List<String> getAllCategories() {
        return new ArrayList<>(this.getCategoryMap().keySet());
    }

    @Override
    public List<TCGItem> searchItems(String keyword) {
        List<TCGItem> result = new ArrayList<>();
        for (TCGItem item : this.getItemMap().values()) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void applyDiscount(String itemId, double percent) {
        if (this.getItemMap().containsKey(itemId)) {
            TCGItem item = this.getItemMap().get(itemId);
            double discountedPrice = item.getPrice() * (1 - percent / 100.0);
            item.updatePrice(discountedPrice);
        }
    }

    @Override
    public void restockItem(String itemId, int amount) {
        if (this.getItemMap().containsKey(itemId) && amount > 0) {
            TCGItem item = this.getItemMap().get(itemId);
            item.updateQuantity(item.getQuantity() + amount);
        }
    }

    @Override
    public List<TCGItem> getItemsByCategory(String category) {
        List<TCGItem> result = new ArrayList<>();
        if (this.getCategoryMap().containsKey(category)) {
            for (String itemId : this.getCategoryMap().get(category)) {
                if (this.getItemMap().containsKey(itemId)) {
                    result.add(this.getItemMap().get(itemId));
                }
            }
        }
        return result;
    }

    @Override
    public List<TCGItem> getAllItemsForSale() {
        List<TCGItem> result = new ArrayList<>();
        for (TCGItem item : this.getItemMap().values()) {
            if (item.isAvailable()) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public void transferItemToAnotherMarketplace(ITCGMarketplace other,
            String itemId) {
        if (this.isItemAvailable(itemId)) {
            TCGItem item = this.getItemMap().get(itemId);
            other.listItemForSale(item);
            this.removeItem(itemId);
        }
    }
}