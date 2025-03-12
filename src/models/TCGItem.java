package models;

//class representing a TCG item
import java.util.ArrayList;
import java.util.List;

public class TCGItem {
    private String itemID;
    private String itemName;
    private double price;
    private List<Double> priceHistory;
    private boolean isAvailable;

    //constructor method(initialize a new TCG item)
    public TCGItem(String itemID, String itemName, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        //give default value for convenience
        this.priceHistory = new ArrayList<>();
        this.priceHistory.add(price);
        this.isAvailable = true;
    }

    //getter method for itemID (to get variables)
    public final String getItemId() {
        return this.itemID;
    }

    public final String getName() {
        return this.itemName;
    }

    public final double getPrice() {
        return this.price;
    }

    public final List<Double> getPriceHistory() {
        return this.priceHistory;
    }

    public final boolean isAvailable() {
        return this.isAvailable;
    }

    //update price(sync with history price at the same time)
    public void updatePrice(double newPrice) {
        this.price = newPrice;
        this.priceHistory.add(newPrice);
    }

    //mark item as sold
    public void markAsSold() {
        this.isAvailable = false;
    }
}