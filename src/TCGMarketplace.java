import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TCGMarketplace {
    private Map<String, TCGItem> itemsForSale; //store items currently for sale

    //constructor: initialize the marketplace
    public TCGMarketplace() {
        this.itemsForSale = new HashMap<>();
    }

    //method to list and item for sale
    public void listItemForSale(TCGItem item) {
        this.itemsForSale.put(item.getItemId(), item); //put sales item
        System.out.println(
                item.getName() + " listed for sale at $" + item.getPrice());
    }

    //method to buy an item
    public void buyItem(String itemId, User buyer) {
        if (this.itemsForSale.containsKey(itemId)) { //check if item exist
            //if exist
            TCGItem item = this.itemsForSale.get(itemId);
            if (item.isAvailable()) { //check if is in stock
                item.markAsSold();
                this.itemsForSale.remove(itemId);
                System.out.println(buyer.getUserName() + " bought "
                        + item.getName() + " for $" + item.getPrice());
            } else {
                System.out.println("Item out of stock");
            }
        } else {
            System.out.println("Item not found in marketplace");
        }
    }

    //method to check if an item is available
    public boolean isItemAvailable(String itemId) {
        return this.itemsForSale.containsKey(itemId)
                && this.itemsForSale.get(itemId).isAvailable();
    }

    //method to get an item's price
    public double getItemPrice(String itemId) {
        return this.itemsForSale.containsKey(itemId)
                ? this.itemsForSale.get(itemId).getPrice()
                : -1; //if item exist we get the price or return -1

    }

    //method to update market prices(Test purpose, will be change in future)
    public void updateMarketPrices() {
        Random random = new Random();
        //iterate all items in marketplace
        for (TCGItem item : this.itemsForSale.values()) {
            double newPrice = item.getPrice()
                    * (0.9 + (random.nextDouble() * 0.2)); // This formula adjusts the price randomly between -10% and +10%

            item.updatePrice(newPrice);
            System.out.println("Updated price for " + item.getName() + " to $"
                    + String.format("%.2f", newPrice));
        }
    }
}
