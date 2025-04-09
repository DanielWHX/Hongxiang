import components.tcg.TCGItem;
import components.tcg.TCGMarketplace;
import components.tcg.TCGMarketplace1;
import components.tcg.User;

public class Main {
    public static void main(String[] args) {
        // Use the concrete implementation
        TCGMarketplace marketplace = new TCGMarketplace1();

        // Create items
        TCGItem item1 = new TCGItem("001", "Umbreon ex", 340.00);
        TCGItem item2 = new TCGItem("002", "Sylveon ex", 127.00);
        TCGItem item3 = new TCGItem("003", "Pikachu VMAX", 88.88);

        // Create user
        User buyer = new User("14953", "Daniel");

        // List items for sale
        marketplace.listItemForSale(item1);
        marketplace.listItemForSale(item2);
        marketplace.listItemForSale(item3);

        // Display all items
        System.out.println("All items for sale:");
        for (TCGItem item : marketplace.getAllItemsForSale()) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }

        // Display items below a certain price
        System.out.println("\nItems below $200:");
        for (TCGItem item : marketplace.getItemsBelowPrice(200)) {
            System.out.println("- " + item.getName());
        }

        // Check average market price
        System.out.println("\nAverage price of Umbreon ex: $" + String
                .format("%.2f", marketplace.getAverageMarketPrice(item1)));

        // Buy an item
        System.out.println("\nBuying 'Sylveon ex'...");
        marketplace.buyItem("002", buyer);

        // Try to buy the same item again
        System.out.println("\nTrying to buy 'Sylveon ex' again...");
        marketplace.buyItem("002", buyer);

        // Check availability
        System.out.println("\nIs Pikachu VMAX available? "
                + marketplace.isItemAvailable("003"));

        // Update market prices
        System.out.println("\nUpdating market prices...");
        marketplace.updateMarketPrices();

        // Print marketplace summary
        System.out.println("\nMarketplace toString():");
        System.out.println(marketplace.toString());
    }
}
