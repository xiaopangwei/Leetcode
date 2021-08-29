package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/29
 * @time 5:08 PM
 */
public class Solution1558 {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }

        int sum    = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int len = 1; len <= length; len += 2) {
                int j = i + len - 1;
                if (j < length) {
                    //<i,j>
                    int temp = prefix[j + 1] - prefix[i];
//                    System.out.println(i + " " + j + " " + temp);
                    sum += temp;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1558 solution1558 = new Solution1558();
        int          ans          = solution1558.sumOddLengthSubarrays(new int[]{10,11,12});
        System.out.println(ans);
    }
}
