package components.tcg;

import components.model.TCGItem;

public class TCGMarketplace1 extends TCGMarketplaceSecondary {

    private ItemManager itemManager;
    private CategoryManager categoryManager;

    public TCGMarketplace1() {
        this.itemManager = new ItemManager();
        this.categoryManager = new CategoryManager();
    }

    // Constructor to initialize itemManager and categoryManager
    @Override
    public void listItemForSale(TCGItem item) {
        this.itemManager.addItem(item);
        this.categoryManager.assignItemToCategory(item.getItemId(),
                item.getCategory());
    }

    @Override
    public boolean isItemAvailable(String itemId) {
        return this.itemManager.isAvailable(itemId);
    }

    @Override
    public double getItemPrice(String itemId) {
        return this.itemManager.getItem(itemId).getPrice();
    }

    @Override
    public void removeItem(String itemId) {
        this.itemManager.removeItem(itemId);
    }

    @Override
    public void updatePrice(String itemId, double price) {
        this.itemManager.updatePrice(itemId, price);
    }

    @Override
    public void updateQuantity(String itemId, int quantity) {
        this.itemManager.updateQuantity(itemId, quantity);
    }

    @Override
    public void addCategory(String categoryName) {
        this.categoryManager.addCategory(categoryName);
    }

    @Override
    public void removeCategory(String categoryName) {
        this.categoryManager.removeCategory(categoryName);
    }

    @Override
    public boolean hasCategory(String categoryName) {
        return this.categoryManager.hasCategory(categoryName);
    }

    @Override
    public void assignItemToCategory(String itemId, String categoryName) {
        this.categoryManager.assignItemToCategory(itemId, categoryName);
    }
}
