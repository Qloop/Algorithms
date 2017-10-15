package Sort.BubbleSort;

import Sort.CallTest;
import Sort.SortTestHelper;

public class BubbleSort {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("冒泡排序", new CallTest() {
            @Override
            public void test() {
                sort(arr);
                SortTestHelper.printArray(arr);
            }
        });
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    SortTestHelper.swap(arr, i, j);
                }
            }
        }
    }
}
