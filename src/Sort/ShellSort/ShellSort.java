package Sort.ShellSort;

import Sort.CallTest;
import Sort.SortTestHelper;

/**
 * This class created on 2017/10/16
 * 原理: 首先取的 d1(假设数组长度为 n 一般 的 d1 = n/2),把数组分为d1个分组，所有间隔为 d1的倍数的元素为一组，然后分别对这 d1个分组进行 ""插入排序;
 * 取 d2(一般 =d1/2),重复上述步骤；
 * 直到 dn = 1时，做最后一次插入排序后 得到有序数组
 * 【逐步增加数组的有序性，大幅提高插入排序的效率】
 *
 * @author Boris
 * @since
 */
public class ShellSort {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("希尔排序", new CallTest() {
            @Override
            public void test() {
                sort(arr);
                SortTestHelper.printArray(arr);
            }
        });
    }

    private static void sort(int[] arr) {
        int length = arr.length;
        int gap = (int) Math.floor(length / 2);
        while (gap > 0) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j > 0 && j >= gap && arr[j] < arr[j - gap]; j -= gap) {
                    SortTestHelper.swap(arr, j, j - gap);
                }
            }
            gap = (int) Math.floor(gap / 2);
        }
    }
}
