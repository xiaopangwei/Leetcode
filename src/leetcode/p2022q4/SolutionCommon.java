package leetcode.p2022q4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/23
 * @time 9:14 PM
 */
public class SolutionCommon {
    public String oddString(String[] words) {
        Map<String, Integer> serialSet = new HashMap<>();
        Map<String, String>  last      = new HashMap<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                sb.append(s.charAt(i) - s.charAt(i - 1));
                sb.append("#");
            }
            String temp = sb.toString();
            last.put(temp, s);
            serialSet.put(temp, serialSet.getOrDefault(temp, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : serialSet.entrySet()) {
            if (entry.getValue() == 1) {
                return last.get(entry.getKey());
            }
        }
        return "";
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String q : queries) {
            boolean flag = false;
            for (String d : dictionary) {
                if (q.length() != d.length()) {
                    continue;
                }
                int cnt = 0;
                for (int i = 0; i < q.length(); i++) {
                    if (q.charAt(i) != d.charAt(i)) {
                        cnt++;
                        if (cnt > 2) {
                            break;
                        }
                    }
                }
                if (cnt <= 2) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                ans.add(q);
            }
        }
        return ans;
    }

    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> freq   = new HashMap<>();
        int                   maxVal = 0;
        for (int t : nums) {
            int temp  = t % space;
            int times = freq.getOrDefault(temp, 0) + 1;
            freq.put(temp, times);
            if (times > maxVal) {
                maxVal = times;
            }
        }

        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            int t = num % space;
            if (freq.get(t) == maxVal) {
                minVal = Math.min(minVal, num);
            }
        }
        return minVal;

    }

    public static void main(String[] args) {
        SolutionCommon solutionCommon = new SolutionCommon();
        System.out.println(solutionCommon.destroyTargets(new int[]{625879766, 235326233, 250224393, 501422042, 683823101,
                948619719, 680305710, 733191937, 182186779, 353350082}, 4));

    }
}
