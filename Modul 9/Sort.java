import java.util.*;

public class Sort{

    public static int[] bubble(int[] list) {
    int tukarAtauGeser = 0;
    for (int i = 0; i < list.length - 1; i++) {
        for (int k = i + 1; k < list.length; k++) {
            System.out.printf("%d:%d\n", list[k], list[i]);
            if (list[k] > list[i]) {
                int t = list[i];
                list[i] = list[k];
                list[k] = t;
                tukarAtauGeser++;
            }
        }
    }
    System.out.println("Jumlah tukar atau geser Bubble Sort: " + tukarAtauGeser);
    return list;
    }

    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;
            /*
            * Move elements of arr[0..i-1], that are greater than key,
            * to one position ahead of their current position
            */
            while (k >= 0 && list[k] < key) {
                list[k + 1] = list[k];
                k = k - 1;
            }
            list[k + 1] = key;
            tukarAtauGeser++;
        }
        System.out.println("Jumlah tukar atau geser Insertion Sort: " + tukarAtauGeser);
        return list;
    }

    public static int[] selection(int[] list) {
        int tukarAtauGeser = 0;
    // One by one move boundary of unsorted subarray
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[minIndex])
                minIndex = k;
            }
            // Swap the found minimum element
            // with the first element
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;
            tukarAtauGeser++;
        }
        System.out.println("Jumlah tukar atau geser Selection Sort: " + tukarAtauGeser);
        return list;
    }

    public static void main(String[] args) {
        // ubah nilai default Array ini menjadi sebanyak 30 elemen
        // acak/tidak terurut dan nilai elemennya tidak ada yang ganda.
        int[] arr = {  47, 12, 83, 5, 61, 29, 74, 3, 19, 55, 68, 9, 41, 26, 90, 17, 34, 72, 8, 53, 66, 14, 39, 80, 2, 24, 77, 11, 45, 63 };
        int[] sorted;

        System.out.println(Arrays.toString(arr));
        sorted = bubble(arr);
        System.out.println("Bubble Sort: " + Arrays.toString(sorted));
        sorted = insertion(arr);
        System.out.println("Insertion Sort: " + Arrays.toString(sorted));
        sorted = selection(arr);
        System.out.println("Selection Sort: " + Arrays.toString(sorted));
    }
}
