package components.tcg;

import java.util.List;

import components.tcg.stock.TCGItem;
import components.tcg.stock.TCGStock;
import components.tcg.stock.TCGStock1;

public class useCase2 {
    public static void main(String[] args) {
        TCGStock stock = new TCGStock1();

        stock.addItem(new TCGItem("001", "Pikachu"));
        stock.addItem(new TCGItem("002", "Eevee"));
        stock.addItem(new TCGItem("003", "Pikachu"));
        stock.addItem(new TCGItem("004", "Charizard"));

        System.out.println("what we have now:");
        System.out.println(stock.toString());

        // get the "pikachu" item
        List<TCGItem> pikachus = stock.getItemsByName("Pikachu");
        System.out.println("Found Pikachu items: " + pikachus);

        // remove all the card
        for (int i = 0; i < stock.totalStock(); i++) {
            TCGItem item = stock.removeAnyItem(); // remove temporarily
            if (!item.name().equals("Pikachu")) {
                stock.addItem(item); // put back if not Pikachu
            }
        }

        System.out.println("After removal:");
        System.out.println(stock.toString());
    }
}
