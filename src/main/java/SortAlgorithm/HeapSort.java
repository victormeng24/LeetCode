package SortAlgorithm;

import java.util.Random;

import static util.ArrayUtil.swap;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        heapsort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void heapsort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            sink(a, i, a.length - 1);
        }
        int n = a.length - 1;
        while(n >= 0) {
            swap(a, 0, n--);
            sink(a, 0, n);
        }
    }

    public static void sink(int[] a, int k, int n) {
        while (2 * k + 1 <= n) {
            int j = 2 * k + 1;
            if (j < n && a[j + 1] > a[j]) {
                j++;
            }
            if (a[k] > a[j]) break;
            swap(a, k, j);
            k = j;
        }
    }

}
