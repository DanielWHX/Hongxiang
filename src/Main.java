public class Main {
    public static void main(String[] args) {
        TCGMarketplace marketplace = new TCGMarketplace();

        // Create items
        TCGItem item1 = new TCGItem("001", "Umbreon ex", 340);
        TCGItem item2 = new TCGItem("002", "Sylveon ex", 127);

        // Create user
        User buyer = new User("14953", "Daniel");

        // List items for sale
        marketplace.listItemForSale(item1);
        marketplace.listItemForSale(item2);

        // Check if an item is available
        System.out.println("Is Umbreon ex available? "
                + marketplace.isItemAvailable("002"));

        // Buy an item
        marketplace.buyItem("002", buyer);
        System.out.println("Is Umbreon ex available after purchase? "
                + marketplace.isItemAvailable("002"));

        // Simulate market price updates
        marketplace.updateMarketPrices();
    }
}
