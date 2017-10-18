package Sort.MergeSort;

import Sort.CallTest;
import Sort.SortTestHelper;

import java.util.Arrays;

/**
 * This class created on 2017/10/17
 *
 * @author Boris
 * @since
 */
public class MergeSort {

    public static void main(String[] args) {
        int n = 10000000;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("归并排序", new CallTest() {
            @Override
            public void test() {
                sort(arr);
//                SortTestHelper.printArray(arr);
            }
        });
        SortTestHelper.testSort("归并排序", new CallTest() {
            @Override
            public void test() {
                sort(arr, 0, arr.length - 1, true);
//                SortTestHelper.printArray(arr);
            }
        });
        SortTestHelper.testSort("归并排序", new CallTest() {
            @Override
            public void test() {
                sortBU(arr);
//                SortTestHelper.printArray(arr);
            }
        });
    }

    private static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        //优化
//        if (arr[mid] < arr[mid + 1]) {
//            return;
//        }
        merge(arr, l, mid, r);
    }

    //优化
    private static void sort(int[] arr, int l, int r, boolean advanced) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

//        优化  当数组已经有序的时候不再进行merge
        if (arr[mid] < arr[mid + 1]) {
            return;
        }
        merge(arr, l, mid, r);
    }

    //将 arr[l...mid] 和 arr[mid +1...r]进行归并
    private static void merge(int[] arr, int l, int mid, int r) {
        //        for (int i = l; i <= r; i++) {
//            aux[i - l] = arr[i];
//        }
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }


    //自底向上的归并排序
    private static void sortBU(int[] arr) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }
        }
    }
}
