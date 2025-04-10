package components.tcg.marketplace;

import components.tcg.stock.TCGItem;

public record Listing(TCGItem item, double price, int quantity,
        String category) {

}
