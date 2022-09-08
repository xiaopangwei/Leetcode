package common.simu;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/8
 * @time 11:02 PM
 */
public class Solution0708 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        System.out.println(Arrays.toString(prefixSum));

        int maxFreq = 1;
        int left    = 0;
        int right   = 1;
        while (right < nums.length) {
            int t = getGap(prefixSum, left, right, nums[right]);
            if (t <= k) {
                maxFreq = Math.max(maxFreq, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return maxFreq;
    }


    private int getGap(int[] prefixSum, int left, int right, int val) {
        int leftSum = 0;
        if (left > 0) {
            leftSum = prefixSum[left - 1];
        }
        int rightSum = prefixSum[right];
        return (right - left + 1) * val - (rightSum - leftSum);
    }

    public String minWindow(String s1, String s2) {
        int    i      = 0;
        int    j      = 0;
        int    minLen = Integer.MAX_VALUE;
        String ans    = "";
        while (i < s1.length()) {
//            System.out.println(i+" "+j);
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;

                if (j == s2.length()) {
                    int t1 = i - 1;
                    int t2 = s2.length() - 1;
                    while (t2 >= 0) {
                        if (s1.charAt(t1) == s2.charAt(t2)) {
                            t1--;
                            t2--;
                        } else {
                            t1--;
                        }
                    }

                    int start = t1 + 1;
                    int end   = i - 1;
                    int len   = end - start + 1;
                    if (len < minLen) {
                        minLen = len;
                        ans = s1.substring(start, start + len);
                    }
                    j = 0;
                    i = start+1;
                }
            } else {
                i++;
            }
        }

        return ans;
    }


    public boolean isSubSequence(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int i = 0;
        int j = 0;
        while (j < s2.length()) {
            while (i < s1.length() && s1.charAt(i) != s2.charAt(j)) {
                i++;
            }
            if (i < s1.length()) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return s2.length() == j;
    }

    public static void main(String[] args) {
        Solution0708 solution0708 = new Solution0708();
//        System.out.println(solution0708.isSubSequence("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "l"));
        String ans = solution0708.minWindow("abcdebdde", "bde");
        System.out.println(ans);
//        int          ans          = solution0708.maxFrequency(new int[]{3, 9, 6}, 2);

    }
}
