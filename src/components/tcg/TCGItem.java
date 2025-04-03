package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a TCG item in the marketplace.
 */
public class TCGItem {
    private String itemID;
    private String itemName;
    private double price;
    private int quantity;
    private String category;
    private List<Double> priceHistory;
    private boolean isAvailable;

    /**
     * Constructor to initialize a new TCG item.
     * 
     * @param itemID
     *            unique identifier
     * @param itemName
     *            name of the item
     * @param price
     *            initial price
     * @param quantity
     *            initial stock quantity
     * @param category
     *            category name
     */
    public TCGItem(String itemID, String itemName, double price, int quantity,
            String category) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.priceHistory = new ArrayList<>();
        this.priceHistory.add(price);
        this.isAvailable = true;
    }

    public final String getItemId() {
        return this.itemID;
    }

    public final String getName() {
        return this.itemName;
    }

    public final double getPrice() {
        return this.price;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final String getCategory() {
        return this.category;
    }

    public final List<Double> getPriceHistory() {
        return this.priceHistory;
    }

    public final boolean isAvailable() {
        return this.isAvailable && this.quantity > 0;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
        this.priceHistory.add(newPrice);
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
        this.isAvailable = newQuantity > 0;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void markAsSold() {
        this.quantity--;
        if (this.quantity <= 0) {
            this.isAvailable = false;
        }
    }
}
