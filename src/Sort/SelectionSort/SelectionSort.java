package Sort.SelectionSort;

import Sort.CallTest;
import Sort.SortTestHelper;

/**
 * This class created on 2017/10/14
 *
 * @author Boris
 * @since
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] list = SortTestHelper.generateRandomArray(10000, 1, 10000);
//        SelectionSort.selectionSort(list);
//        SortTestHelper.printArray(list);
        SortTestHelper.testSort("选择排序", new CallTest() {
            @Override
            public void test() {
                selectionSort(list);
//                SortTestHelper.printArray(list);
            }
        });
    }

    private static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            SelectionSort.swap(list, i, minIndex);
        }
    }

    public static void swap(int[] list, int srcIndex, int destIndex) {
        int temp = list[srcIndex];
        list[srcIndex] = list[destIndex];
        list[destIndex] = temp;
    }

}
