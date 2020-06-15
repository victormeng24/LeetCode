package SortAlgorithm;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        bubble(arr);
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序，两两交换相邻元素
     * @param arr
     */
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
