package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import interfaces.TCGMarketplace;
import models.TCGItem;
import models.User;

public class TCGMarketplaceImpl implements TCGMarketplace {
    private Map<String, TCGItem> itemsForSale = new HashMap<>();

    @Override
    public void listItemForSale(TCGItem item) {
        this.itemsForSale.put(item.getItemId(), item);
        System.out.println(item.getName() + " listed for sale.");
    }

    @Override
    public void buyItem(String itemId, User buyer) {
        if (this.itemsForSale.containsKey(itemId)) {
            TCGItem item = this.itemsForSale.get(itemId);
            this.itemsForSale.remove(itemId);
            System.out
                    .println(buyer.getUserName() + " bought " + item.getName());
        }
    }

    @Override
    public boolean isItemAvailable(String itemId) {
        return this.itemsForSale.containsKey(itemId);
    }

    @Override
    public double getItemPrice(String itemId) {
        return this.itemsForSale.getOrDefault(itemId, new TCGItem("", "", -1))
                .getPrice();
    }

    @Override
    public List<TCGItem> getAllItemsForSale() {
        return new ArrayList<>(this.itemsForSale.values());
    }

    @Override
    public List<TCGItem> getItemsBelowPrice(double maxPrice) {
        List<TCGItem> filteredItems = new ArrayList<>();
        for (TCGItem item : this.itemsForSale.values()) {
            if (item.getPrice() < maxPrice) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    @Override
    public double getAverageMarketPrice(TCGItem item) {
        List<Double> priceHistory = item.getPriceHistory();
        return priceHistory.stream().mapToDouble(Double::doubleValue).average()
                .orElse(0);
    }

    @Override
    public void updateMarketPrices() {
        Random random = new Random();
        for (TCGItem item : this.itemsForSale.values()) {
            double newPrice = item.getPrice()
                    * (0.9 + (random.nextDouble() * 0.2));
            item.updatePrice(newPrice);
        }
    }

    @Override
    public List<TCGItem> getUserListedItems(User seller) {
        return new ArrayList<>(this.itemsForSale.values());
    }
}