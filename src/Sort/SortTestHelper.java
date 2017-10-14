package Sort;

import java.util.Random;

/**
 * This class created on 2017/10/14
 *
 * @author Boris
 * @since
 */
public class SortTestHelper {

    //生成 n 个元素的随机数数组，每个元素的随机范围是 [rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        checkRange(rangeL, rangeR);
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return array;
    }

    public static void testSort(String sortName, CallTest callTest){
        long startTime = System.currentTimeMillis();
        callTest.test();
        long endTime = System.currentTimeMillis();
        System.out.println(sortName + "耗时： " + (endTime - startTime) + "毫秒");
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.println(num);
        }
    }

    public static void checkRange(int rangeL, int rangeR) {
        if (rangeL > rangeR) {
            throw new IllegalArgumentException("范围参数不合法!");
        }
    }
}
