package stack.largestAreaInHistogram;

import java.util.Stack;

public class NSR {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        int[] list = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < arr[i]) {
                list[i] = stack.peek();
            } else if (stack.isEmpty()) {
                list[i] = 0;
            }
            stack.push(arr[i]);
        }
        for (int i : list) {
            System.out.print(i);
        }

    }
}
