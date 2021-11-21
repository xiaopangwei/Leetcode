package leetcode.p2021m11;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/11
 * @time 10:01 PM
 */
public class Solution1093 {
    public double[] sampleStats(int[] count) {

        double[] ans = new double[5];

        int min        = Integer.MAX_VALUE;
        int max        = Integer.MIN_VALUE;
        int sumCount   = 0;
        long sum        = 0;
        int len        = count.length;
        int maxFreqNum = 0;
        int maxFreq    = 0;
        for (int i = 0; i < len; i++) {
            if (count[i] != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sumCount += count[i];
                sum += (count[i] * i);

                if (count[i] > maxFreq) {
                    maxFreq = count[i];
                    maxFreqNum = i;
                }
            }
        }

        int half = sumCount / 2;
        if (sumCount % 2 == 0) {
            int base = 0;

            int a = 0;
            int b = 0;
            for (int i = 0; i < len; i++) {
                if (count[i] != 0) {
                    if (base + count[i] >= half) {
                        a = i;
                        break;
                    } else {
                        base += count[i];
                    }
                }
            }

            base=0;
            for (int i = 0; i < len; i++) {
                if (count[i] != 0) {
                    if (base + count[i] >= half + 1) {
                        b = i;
                        break;
                    } else {
                        base += count[i];
                    }
                }
            }

            ans[3] = (a + b) * 1.0 / 2;
        } else {
            int base = 0;
            for (int i = 0; i < len; i++) {
                if (count[i] != 0) {
                    if (base + count[i] >= half+1) {
                        ans[3] = i * 1.0;
                        break;
                    } else {
                        base += count[i];
                    }
                }
            }
        }

        ans[0] = min * 1.0;
        ans[1] = max * 1.0;
        ans[2] = sum * 1.0 / sumCount;
        ans[4] = maxFreqNum;
        return ans;

    }

    public static void main(String[] args) {
        Solution1093 solution1093 = new Solution1093();
        double[]     res          = solution1093.sampleStats(new int[]{0, 1, 3, 5, 0});
        System.out.println(Arrays.toString(res));

    }
}
