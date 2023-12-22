package stack.largestAreaInHistogram;

import java.util.*;

public class MaxmimumAreaInHistogram {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 6, 2, 3 };
        int NSL[] = NSL(arr);
        int NSR[] = NSR(arr);
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = NSR[i] - NSL[i] - 1;
            int area = width * arr[i];
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);

    }

    public static int[] NSL(int[] arr) {
        int[] list = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < arr[i]) {
                list[i] = stack.peek();
            } else if (stack.isEmpty()) {
                list[i] = -1;
            }
            stack.push(i);
        }
        return list;
    }

    public static int[] NSR(int[] arr) {
        int[] list = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < arr[i]) {
                list[i] = stack.peek();
            } else if (stack.isEmpty()) {
                list[i] = arr.length;
            }
            stack.push(i);
        }
        return list;
    }
}
