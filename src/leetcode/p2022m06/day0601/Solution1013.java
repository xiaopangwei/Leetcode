package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/3
 * @time 10:16 PM
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] arr) {

        int s = 0;
        for (int item : arr) {
            s += item;
        }

        if (s % 3 != 0) {
            return false;
        }

        int avg = s / 3;

        int sum = 0;

        int count = 0;

        int i = 0;
        for (; i < arr.length; i++) {
            sum += arr[i];
            if (sum == avg) {
                count++;
                if (count == 2) {
                    break;
                } else {
                    sum = 0;
                }
            }
        }
        return i < arr.length-1;
    }

    public static void main(String[] args) {
        Solution1013 solution1013 = new Solution1013();
        //[1,-1,1,-1]
        boolean ans = solution1013.canThreePartsEqualSum(new int[]{1, -1, 1, -1});
        System.out.println(ans);
    }
}
