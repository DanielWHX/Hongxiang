package components.old;

import components.tcg.TCGItem;

public record Listing(TCGItem item, double price, int quantity,
                String category) {

}
