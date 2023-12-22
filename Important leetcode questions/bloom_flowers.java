import java.util.Arrays;

public class bloom_flowers {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[persons.length];

        for (int i = 0; i < persons.length; i++) {
            int t = persons[i];
            int started = binarySearchUpperBound(start, t);
            int ended = binarySearchLowerBound(end, t);
            res[i] = started - ended;
        }

        return res;
    }
   //this will check how many flowers are bloom first than time or on that time and return the index next to it
    private int binarySearchUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
  // this will check how many flowrs are still bloom after the time and return the index of the first flower that is still bloom 
    private int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        bloom_flowers solution = new bloom_flowers();

        int[][] flowers = { { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 } };
        int[] persons = { 2, 3, 7, 11 };

        int[] result = solution.fullBloomFlowers(flowers, persons);

        // Print the results
        for (int i = 0; i < result.length; i++) {
            System.out.println("Person " + (i + 1) + ": " + result[i]);
        }
    }
}
