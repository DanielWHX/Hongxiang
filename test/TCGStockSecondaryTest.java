import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import components.tcg.stock.TCGItem;
import components.tcg.stock.TCGStock;
import components.tcg.stock.TCGStock1;

public class TCGStockSecondaryTest {

    @Test
    public void testGetItemsByName() {
        TCGStock stock = new TCGStock1();
        stock.addItem(new TCGItem("001", "Pikachu"));
        stock.addItem(new TCGItem("002", "Charizard"));
        stock.addItem(new TCGItem("003", "Pikachu"));

        List<TCGItem> result = stock.getItemsByName("Pikachu");

        assertEquals(2, result.size());
        for (TCGItem item : result) {
            assertEquals("Pikachu", item.name());
        }
    }

    @Test
    public void testRemoveAllItems() {
        TCGStock stock = new TCGStock1();
        TCGItem item = new TCGItem("001", "Pikachu");
        stock.addItem(item);
        stock.addItem(item);

        stock.removeAllItems(item);

        assertFalse(stock.isInStock(item));
    }

    @Test
    public void testEqualsSameStock() {
        TCGStock s1 = new TCGStock1();
        TCGStock s2 = new TCGStock1();
        TCGItem item = new TCGItem("001", "Pikachu");

        s1.addItem(item);
        s2.addItem(item);

        assertTrue(s1.equals(s2));
    }

    @Test
    public void testToStringNotNull() {
        TCGStock stock = new TCGStock1();
        stock.addItem(new TCGItem("001", "Pikachu"));
        String output = stock.toString();
        assertNotNull(output);
        assertTrue(output.contains("Pikachu"));
    }

    @Test
    public void testHashCodeConsistency() {
        TCGStock s1 = new TCGStock1();
        s1.addItem(new TCGItem("001", "Pikachu"));
        int hash1 = s1.hashCode();
        int hash2 = s1.hashCode();
        assertEquals(hash1, hash2);
    }
}
