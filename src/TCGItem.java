//class representing a TCG item

import java.util.List;

public class TCGItem {
    private String itemID;
    private String itemName;
    private double price;
    private List<Double> priceHistory;
    private boolean isAvailable;

    //constructor method(initialize a new TCG item)
    public TCGItem(String itemID, String itemName, double price,
            List<Double> priceHistory, boolean isAvailable) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.priceHistory = priceHistory;
        this.isAvailable = isAvailable;
    }

    //getter method for itemID

}