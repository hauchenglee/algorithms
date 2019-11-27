package sort;

import util.Constants;

import java.util.Arrays;

public class InsertionSort {
    private static int[] ar = Constants.ar;
    private static int al = Constants.al;

    private static void sort(Comparable[] a, int lo, int hi) {

    }

    private static void sort_G() {
        // GeeksforGeeks
        for (int i = 1; i < al; i++) {
            // 从1开始是因为将index 0的元素当作已经排序完成（也就是自己）
            // key就是未排序的元素
            // j是左边未排序最后一个元素
            int key = ar[i]; // select the first unsorted element
            int j = i - 1; // the begin compare element index

            // swap other elements to the right to create the correct position
            // and shift the unsorted element
            while (j >= 0 && ar[j] > key) {
                // j >= 0 --> ensure array index >= 0
                // ar[j] > key --> ensure left value > select value

                // ar[j]就是key元素跟当下已排序元素（箭头）比较
                // 如果ar[j] > key，表示是当下最大的值
                // 大的元素往后移位（j + 1 index）
                ar[j + 1] = ar[j];

                // 往前一个index比对
                j = j - 1;
            }
            ar[j + 1] = key;
        }
    }

    private static void sort_other() {
        // first
        for (int i = 1; i < al; i++) {
            int temp = ar[i];
            int j;
            for (j = i - 1; j >= 0 && temp < ar[j]; j--) {
                ar[j + 1] = ar[j];
            }
            ar[j + 1] = temp;
        }
        System.out.println(Arrays.toString(ar));

        // second
        for (int i = 1; i < al; i++) {
            int temp = ar[i]; // 要比較的value
            int j; //
            for (j = i - 1; j >= 0; j--) {
                if (temp < ar[j]) {
                    ar[j + 1] = ar[j];
                } else {
                    break;
                }
            }
            ar[j + 1] = temp;
        }
        System.out.println(Arrays.toString(ar));

        // third
        int preIndex, current;
        for (int i = 1; i < al; i++) {
            preIndex = i - 1;
            current = ar[i];
            while (preIndex >= 0 && ar[preIndex] > current) {
                ar[preIndex + 1] = ar[preIndex];
                preIndex--;
            }
            ar[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(ar));
    }
}
