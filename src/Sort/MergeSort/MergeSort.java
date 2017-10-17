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
        int n = 10;
        int[] arr = SortTestHelper.generateRandomArray(n, 0, n);
        SortTestHelper.testSort("归并排序", new CallTest() {
            @Override
            public void test() {
                sort(arr);
                SortTestHelper.printArray(arr);
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

}
