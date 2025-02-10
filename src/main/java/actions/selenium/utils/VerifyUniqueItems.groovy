package actions.selenium.utils;

import java.util.HashMap;
import java.util.Map;

class VerifyUniqueItems{
    public static boolean run(def params){
        //verifies if any item count in give array is greater than 1
        //items (array<String>) given items
        
        // Create a map to store item counts
        Map<String, Integer> itemCounts = new HashMap<>();
        // Populate the map with item counts
        for (String item : params.Items) {
            itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        }
        // Flag to track if there are duplicate items
        boolean noDuplicates = true;
        // Check if any item count is greater than 1
        for (int count : itemCounts.values()) {
            if (count > 1) {
                noDuplicates = false;
                break;
            }
        }
        return noDuplicates
    }
}