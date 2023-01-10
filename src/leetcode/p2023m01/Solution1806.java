package leetcode.p2023m01;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/9
 * @time 10:34 PM
 */
public class Solution1806 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        int[] original = perm.clone();

        for (int i = 0; i < perm.length; i++) {
            if (i % 2 == 0) {
                perm[i] = original[i / 2];
            } else {
                perm[i] = original[n / 2 + (i - 1) / 2];
            }
        }

        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(perm));
        int count = 0;
        while (!Arrays.equals(original, perm)) {
            count++;
            int[] t = new int[n];
            for (int i = 0; i < perm.length; i++) {
                if (i % 2 == 0) {
                    t[i] = perm[i / 2];
                } else {
                    t[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = t;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Solution1806 solution1806 = new Solution1806();
        System.out.println(solution1806.reinitializePermutation(2));
    }
}
