package components.tcg;

import components.tcg.stock.TCGItem;
import components.tcg.stock.TCGStock;
import components.tcg.stock.TCGStock1;

public class useCase1 {
    public static void main(String[] args) {
        TCGStock stock = new TCGStock1();

        TCGItem pikachu = new TCGItem("001", "Pikachu");
        TCGItem eevee = new TCGItem("002", "eevee");
        TCGItem charzard = new TCGItem("003", "charzard");

        stock.addItem(eevee);
        stock.addItem(pikachu);
        stock.addItem(pikachu);
        stock.addItem(eevee);
        stock.addItem(charzard);

        System.out.println("Total stock count: " + stock.totalStock());
        System.out.println("Is Pikachu in stock? " + stock.isInStock(pikachu));
        System.out.println("Unique items: " + stock.numberOfUniqueItems());
        System.out.println("Stock contents: " + stock.toString());
    }
}
