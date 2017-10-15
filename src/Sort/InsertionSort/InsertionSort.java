package Sort.InsertionSort;

import Sort.CallTest;
import Sort.SortTestHelper;

public class InsertionSort {

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("插入排序", new CallTest() {
            @Override
            public void test() {
//                sort(arr);
                sortAdvanced(arr);
                SortTestHelper.printArray(arr);
            }
        });
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                SortTestHelper.swap(array, j, j - 1);
            }
        }
    }

    //优化插入排序
    //不再比较一次符合就做swap 【一次swap 需要三次赋值 很耗时】
    //改为比较一次符合 把前一位的后移 本位的继续往前比较 直到找到合适的位置再赋值
    public static void sortAdvanced(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }
}
