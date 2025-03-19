import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight, value;

    // Constructor
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    
    // Comparator to sort items by value-to-weight ratio in descending order
    static class ItemComparator implements Comparator<Item> {
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1); // Sort in descending order
        }
    }

    // Function to solve the Fractional Knapsack Problem
    public static double fractionalKnapsack(int W, Item[] items) {
        // Sort items by value-to-weight ratio
        Arrays.sort(items, new ItemComparator());

        double totalValue = 0.0;

        for (Item item : items) {
            if (W >= item.weight) {
                // Take the full item
                W -= item.weight;
                totalValue += item.value;
            } else {
                // Take a fraction of the item
                totalValue += item.value * ((double) W / item.weight);
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int W = 50; // Knapsack capacity
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };

        double maxValue = fractionalKnapsack(W, items);
        System.out.println("Maximum value in Knapsack: " + maxValue);
    }
}
