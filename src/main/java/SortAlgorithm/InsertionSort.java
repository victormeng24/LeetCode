package SortAlgorithm;


import java.util.Random;

import static util.ArrayUtil.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        insertionSort(arr);
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                }
            }
        }
    }
}
