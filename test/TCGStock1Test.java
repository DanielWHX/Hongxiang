import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.tcg.stock.TCGItem;
import components.tcg.stock.TCGStock1;

public class TCGStock1Test {

    @Test
    public void testAddAndIsInStock() {
        TCGStock1 stock = new TCGStock1();
        TCGItem item = new TCGItem("001", "Pikachu");

        stock.addItem(item);

        assertTrue(stock.isInStock(item));
        assertEquals(1, stock.totalStock());
    }

    @Test
    public void testRemoveItem() {
        TCGStock1 stock = new TCGStock1();
        TCGItem item = new TCGItem("001", "Pikachu");
        stock.addItem(item);
        stock.addItem(item);

        stock.removeItem(item);

        assertEquals(1, stock.totalStock());
        assertTrue(stock.isInStock(item));
    }

    @Test
    public void testRemoveAnyItem() {
        TCGStock1 stock = new TCGStock1();
        TCGItem item1 = new TCGItem("001", "Pikachu");
        TCGItem item2 = new TCGItem("002", "Charizard");

        stock.addItem(item1);
        stock.addItem(item2);

        TCGItem removed = stock.removeAnyItem();

        assertEquals(1, stock.totalStock());
        assertTrue(removed.equals(item1) || removed.equals(item2));
    }

    @Test
    public void testClear() {
        TCGStock1 stock = new TCGStock1();
        stock.addItem(new TCGItem("001", "Pikachu"));
        stock.addItem(new TCGItem("002", "Charizard"));

        stock.clear();

        assertEquals(0, stock.totalStock());
    }

    @Test
    public void testTransferFrom() {
        TCGStock1 source = new TCGStock1();
        TCGStock1 dest = new TCGStock1();

        TCGItem item = new TCGItem("001", "Pikachu");
        source.addItem(item);
        source.addItem(item);

        dest.transferFrom(source);

        assertEquals(2, dest.totalStock());
        assertEquals(0, source.totalStock());
    }
}
