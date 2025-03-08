import models.TCGItem;
import models.User;
import services.TCGMarketplaceImpl;

public class Main {
    public static void main(String[] args) {
        TCGMarketplaceImpl marketplace = new TCGMarketplaceImpl();

        // create items
        TCGItem item1 = new TCGItem("001", "Umbreon ex", 340);
        TCGItem item2 = new TCGItem("002", "Sylveon ex", 127);

        // create user
        User buyer = new User("14953", "Daniel");

        // upload items for sale
        marketplace.listItemForSale(item1);
        marketplace.listItemForSale(item2);

        // buy items
        marketplace.buyItem("001", buyer);
        marketplace.buyItem("002", buyer);
    }
}