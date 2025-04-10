
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manager class for handling categories and item ID assignments.
 */
public class CategoryManager {
    private final Map<String, List<String>> categoryMap = new HashMap<>();

    public void addCategory(String category) {
        this.categoryMap.putIfAbsent(category, new ArrayList<>());
    }

    public void removeCategory(String category) {
        this.categoryMap.remove(category);
    }

    public boolean hasCategory(String category) {
        return this.categoryMap.containsKey(category);
    }

    public void assignItemToCategory(String itemId, String category) {
        if (!this.categoryMap.containsKey(category)) {
            this.addCategory(category);
        }
        if (!this.categoryMap.get(category).contains(itemId)) {
            this.categoryMap.get(category).add(itemId);
        }
    }

    public List<String> getItemIdsByCategory(String category) {
        return this.categoryMap.getOrDefault(category, new ArrayList<>());
    }

    public List<String> getAllCategories() {
        return new ArrayList<>(this.categoryMap.keySet());
    }
}