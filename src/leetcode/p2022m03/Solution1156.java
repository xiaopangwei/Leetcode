package leetcode.p2022m03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/21
 * @time 8:27 PM
 */
public class Solution1156 {
    public int maxRepOpt1(String text) {
        int[]                   left  = new int[text.length()];
        int[]                   right = new int[text.length()];
        Map<Character, Integer> freq  = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int maxVal = 1;
        for (int i = 1; i < left.length; i++) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
            maxVal = Math.max(maxVal, left[i]);

        }


        for (int i = right.length - 2; i >= 0; i--) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
            maxVal = Math.max(maxVal, right[i]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for (int i = 1; i < text.length() - 1; i++) {

            if (freq.getOrDefault(text.charAt(i - 1), 0) > left[i - 1]) {
                maxVal = Math.max(maxVal, left[i - 1] + 1);
            }

            if (freq.getOrDefault(text.charAt(i + 1), 0) > right[i + 1]) {
                maxVal = Math.max(maxVal, right[i + 1] + 1);

            }

            if (text.charAt(i - 1) == text.charAt(i + 1)) {
                int sumFreq = left[i - 1] + right[i + 1];
                if (sumFreq < freq.getOrDefault(text.charAt(i - 1), 0)) {
                    sumFreq++;
                }
                maxVal = Math.max(maxVal, sumFreq);
            }
        }
        return maxVal;

    }

    public static void main(String[] arg) {
        Solution1156 solution1156 = new Solution1156();
        int          ans          = solution1156.maxRepOpt1("ababa");
        System.out.println(ans);
    }
}
