package leetcode.p2021m10;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/14
 * @time 8:54 PM
 */
public class Solution1304 {
    public int[] sumZero(int n) {
        int[] array = new int[n];

        if (n % 2 == 0) {
            int p1 = n / 2 - 1;
            int p2 = p1 + 1;
            array[p1] = -1;
            array[p2] = 1;
            p1--;
            p2++;
            int base = 2;
            while (p1 >= 0 && p2 < n) {
                array[p1--] = -base;
                array[p2++] = base;
                base++;
            }

        } else {
            int p1 = n / 2;

            array[p1] = 0;
            int left  = p1 - 1;
            int right = p1 + 1;

            int base = 1;
            while (left >= 0 && right < n) {
                array[left--] = -base;
                array[right++] = base;
                base++;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Solution1304 solution1304 = new Solution1304();
        int[]        array        = solution1304.sumZero(5);
        System.out.println(Arrays.toString(array));
    }
}
