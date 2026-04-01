import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TransactionFee {
    String id;
    double fee;
    String timestamp;

    TransactionFee(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    public String toString() {
        return id + ":" + fee + "@" + timestamp;
    }
}

public class AuditCompliance {

    // 🔹 Bubble Sort (by fee)
    public static void bubbleSort(List<TransactionFee> list) {
        int n = list.size();
        boolean swapped;
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break; // early termination
        }

        System.out.println("Bubble Sort → Passes: " + passes + ", Swaps: " + swaps);
    }

    // 🔹 Insertion Sort (fee + timestamp)
    public static void insertionSort(List<TransactionFee> list) {
        int shifts = 0;

        for (int i = 1; i < list.size(); i++) {
            TransactionFee key = list.get(i);
            int j = i - 1;

            while (j >= 0 && compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
                shifts++;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort → Shifts: " + shifts);
    }

    // 🔹 Compare (fee first, then timestamp)
    public static int compare(TransactionFee t1, TransactionFee t2) {
        if (t1.fee < t2.fee) return -1;
        if (t1.fee > t2.fee) return 1;
        return t1.timestamp.compareTo(t2.timestamp);
    }

    // 🔹 Outlier detection
    public static void detectOutliers(List<TransactionFee> list) {
        System.out.print("High-fee outliers (>50): ");
        boolean found = false;

        for (TransactionFee t : list) {
            if (t.fee > 50) {
                System.out.print(t + " ");
                found = true;
            }
        }

        if (!found) System.out.print("none");
        System.out.println();
    }

    public static void main(String[] args) {

        List<TransactionFee> transactions = new ArrayList<TransactionFee>();

        transactions.add(new TransactionFee("id1", 10.5, "10:00"));
        transactions.add(new TransactionFee("id2", 25.0, "09:30"));
        transactions.add(new TransactionFee("id3", 5.0, "10:15"));

        int size = transactions.size();

        if (size <= 100) {
            bubbleSort(transactions);
        } else if (size <= 1000) {
            insertionSort(transactions);
        }

        System.out.println("Sorted Transactions: " + transactions);

        detectOutliers(transactions);
    }
}