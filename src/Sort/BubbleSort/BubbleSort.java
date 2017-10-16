package Sort.BubbleSort;

import Sort.CallTest;
import Sort.SortTestHelper;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        SortTestHelper.testSort("冒泡排序", new CallTest() {
            @Override
            public void test() {
                sort(arr);
//                SortTestHelper.printArray(arr);
            }
        });
        SortTestHelper.testSort("优化的冒泡排序", new CallTest() {
            @Override
            public void test() {
                sortAdvanced(arr2);
            }
        });
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SortTestHelper.swap(arr, i, j);
                }
            }
        }
    }

    private static void sortAdvanced(int[] arr) {
        int n = arr.length;
        int lastSwapIndex;
        do {
            lastSwapIndex = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    SortTestHelper.swap(arr, i - 1, i);
                    lastSwapIndex = i;
                }
            }
            n = lastSwapIndex;
        } while (lastSwapIndex > 0);
    }
}
