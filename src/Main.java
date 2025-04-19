<<<<<<< HEAD
import components.model.TCGItem;
import components.tcg.customer.User;
import components.tcg.marketplace.TCGMarketplace1;
>>>>>>> 4e98dc3ee1682ca2d6d468a484d88c61564e7a43

public class Main {
        public static void main(String[] args) {
                TCGMarketplace1 marketplace = new TCGMarketplace1();

                // Add categories
                marketplace.addCategory("Booster Box");
                marketplace.addCategory("Psychic Set");

                // Add items
                TCGItem item1 = new TCGItem("001", "Charizard EX", 300.0, 3,
                                "Booster Box");
                TCGItem item2 = new TCGItem("002", "Pikachu VMAX", 150.0, 2,
                                "Booster Box");
                TCGItem item3 = new TCGItem("003", "Sylveon GX", 120.0, 5,
                                "Psychic Set");

                marketplace.listItemForSale(item1);
                marketplace.listItemForSale(item2);
                marketplace.listItemForSale(item3);

                marketplace.assignItemToCategory("001", "Booster Box");
                marketplace.assignItemToCategory("002", "Booster Box");
                marketplace.assignItemToCategory("003", "Psychic Set");

                // Add a user.
                User user = new User("U001", "Daniel");

                // Buy an item.
                System.out.println("Buying item 001...");
                marketplace.buyItem("001", user);

                // Print results.
                System.out.println("Available? "
                                + marketplace.isItemAvailable("001"));
                System.out.println("Quantity left: "
                                + marketplace.getQuantity("001"));
                System.out.println("Items in 'Booster Box': " + marketplace
                                .getItemsByCategory("Booster Box"));
                System.out.println("All available items: "
                                + marketplace.getAllItemsForSale());
        }
}
