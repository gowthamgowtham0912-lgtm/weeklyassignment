import java.util.Arrays;

public class AccountID {

    // 🔹 Linear Search - First Occurrence
    public static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear first " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        System.out.println(target + " not found in linear search.");
        return -1;
    }

    // 🔹 Linear Search - Last Occurrence
    public static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear last " + target + ": index " + i + " (" + comparisons + " comparisons)");
                return i;
            }
        }
        System.out.println(target + " not found in linear search.");
        return -1;
    }

    // 🔹 Binary Search - Returns first occurrence
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;
            int cmp = arr[mid].compareTo(target);

            if (cmp == 0) {
                result = mid;
                high = mid - 1; // move left for first occurrence
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (result != -1) {
            // count total occurrences
            int count = 1;
            // check right side
            int i = result + 1;
            while (i < arr.length && arr[i].equals(target)) {
                count++;
                i++;
            }
            // check left side
            i = result - 1;
            while (i >= 0 && arr[i].equals(target)) {
                count++;
                i--;
            }

            System.out.println("Binary " + target + ": index " + result + " (" + comparisons + " comparisons), count=" + count);
        } else {
            System.out.println(target + " not found in binary search.");
        }

        return result;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear search
        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        // Binary search requires sorted array
        Arrays.sort(logs);
        System.out.println("Sorted logs: " + Arrays.toString(logs));

        binarySearch(logs, "accB");
    }
}