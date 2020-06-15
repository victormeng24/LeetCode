package SortAlgorithm;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,1,4,8,-1,6};
        new MergeSort().mergeSort(arr, 0 , 5);
        for(int num: arr) {
            System.out.println(num);
        }
    }

    public void mergeSort(int[] arr, int begin, int end) {
        if (begin >= end) return;
        ;
        int mid = begin + (end - begin) / 2;
        mergeSort(arr, begin, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    public void merge(int[] arr, int begin, int mid, int end) {
        int tmp[] = new int[end - begin + 1];
        int i1 = begin, i2 = mid + 1, i = 0;
        while (i1 <= mid && i2 <= end) {
            if (arr[i1] < arr[i2]) {
                tmp[i++] = arr[i1++];
            } else {
                tmp[i++] = arr[i2++];
            }
        }
        while (i1 <= mid) {
            tmp[i++] = arr[i1++];
        }
        while (i2 <= end) {
            tmp[i++] = arr[i2++];
        }
        i = 0;
        for (; i < tmp.length; i++) {
            arr[begin + i] = tmp[i];
        }
    }
}
