package leetcode.springfestival.pm20220205;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 11:34 PM
 */
public class Solution848 {
    public String shiftingLetters(String s, int[] shifts) {
        long[] suffixSum = new long[shifts.length];
        suffixSum[suffixSum.length - 1] = shifts[shifts.length - 1];
        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + shifts[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
//        System.out.println(Arrays.toString(suffixSum));
        for (int i = suffixSum.length - 1; i >= 0; i--) {

            char ch = (char) ((s.charAt(i) - 'a' + suffixSum[i]) % 26 + 'a');
            stringBuilder.append(ch);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution848 solution848 = new Solution848();
        String      ans         = solution848.shiftingLetters("abc", new int[]{3, 5, 9});
        System.out.println(ans);
    }
}
