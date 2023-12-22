package stack.largestAreaInHistogram;

import java.util.Stack;

public class NSL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
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
            stack.push(arr[i]);
        }
        for (int i : list) {
            System.out.print(i);
        }

    }
}
