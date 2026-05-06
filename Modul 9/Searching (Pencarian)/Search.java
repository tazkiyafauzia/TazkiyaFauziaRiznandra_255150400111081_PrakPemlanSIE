public class Search {

    public static int linearSearch(int[] arr, int search) {
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            check++;
            if (arr[i] == search) {
                System.out.println("Check Linear Search: " + check);
                return i;
            }
        }
        System.out.println("Check Linear Search: " + check);
        return -1;
    }

    public static int binarySearch(int[] arr, int search ) {
        int low = 0, high = arr.length - 1;
        int check = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == search) {
                System.out.println("Check Binary Search: " + check);
                return mid;
            }
            if (arr[mid] < search) low = mid + 1;
            else high = mid - 1;
            check++;
        }
        System.out.println("Check Binary Search: " + check);
        return -1;
    }
    public static void main(String[] args) {
        int[] list = {1, 3, 4, 6, 9, 14, 17, 20, 21, 25, 30, 40, 47, 50, 63, 66, 69, 70, 74, 79, 80, 83, 85, 88, 90, 92, 95, 97, 99, 100};

        int index = linearSearch(list, 30);
        System.out.println("Linear Search: " + index);

        int i = binarySearch(list, 5);
        System.out.println("Binary Search: " + i);
    }
}
