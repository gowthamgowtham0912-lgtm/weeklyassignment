import java.util.Arrays;

public class RiskThreshold {

    // 🔹 Linear Search
    public static void linearSearch(int[] risks, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < risks.length; i++) {
            comparisons++;
            if (risks[i] == target) {
                System.out.println("Linear: threshold=" + target + " → found at index " + i + " (" + comparisons + " comparisons)");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: threshold=" + target + " → not found (" + comparisons + " comparisons)");
        }
    }

    // 🔹 Binary Search for floor and ceiling
    public static void binaryFloorCeiling(int[] risks, int target) {
        int low = 0, high = risks.length - 1;
        int comparisons = 0;
        int floor = Integer.MIN_VALUE, ceiling = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (risks[mid] == target) {
                floor = ceiling = risks[mid];
                break;
            } else if (risks[mid] < target) {
                floor = risks[mid];
                low = mid + 1;
            } else {
                ceiling = risks[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary floor(" + target + "): " + floor + ", ceiling: " + ceiling + " (" + comparisons + " comparisons)");
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100}; // sorted risk bands

        int threshold = 30;

        // Linear search (unsorted)
        linearSearch(risks, threshold);

        // Binary search (sorted)
        binaryFloorCeiling(risks, threshold);
    }
}