package leetcode.p2021m08;

import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 10:59 PM
 */
public class Solution528 {

    //    2 3 4
    //    0 2 5 9

    private int   sum;
    private int[] prefixSum;

    public Solution528(int[] w) {

        prefixSum = new int[w.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i - 1];
            sum += w[i - 1];
        }
    }

    public int pickIndex() {

        int randomNumber = new Random().nextInt(sum);

        int left  = 0;
        int right = prefixSum.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] <= randomNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

//        System.out.println(randomNumber + " ==> " + prefixSum[left]);
        return left - 1;
    }

    public static void main(String[] args) {
        Solution528 solution528 = new Solution528(new int[]{2, 3, 4});
        for (int i = 0; i < 12; i++) {
            System.out.println(solution528.pickIndex());
        }

    }
}
