package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/4
 * @time 3:48 PM
 */
public class Solution616 {
    public String addBoldTag(String s, String[] words) {
        if (words == null || words.length == 0) {
            return s;
        }

        int         len      = s.length();
        List<int[]> indexPos = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            for (String word : words) {
                int subLen = word.length();
                if (i + subLen <= len) {
                    if (word.equals(s.substring(i, i + subLen))) {
                        indexPos.add(new int[]{i, i + subLen - 1});
                    }
                }
            }
        }

        if (indexPos.isEmpty()) {
            return s;
        }

        List<int[]> mergedIntervalList = merge(indexPos);


        StringBuilder sb = new StringBuilder();


        int start  = 0;
        int preEnd = mergedIntervalList.get(0)[0] - 1;

        sb.append(s.substring(start,preEnd+1));

        for (int i = 0; i < mergedIntervalList.size(); i++) {
            int[] arr = mergedIntervalList.get(i);
            int   t   = arr[1] - arr[0] + 1;
            sb.append("<b>");
            sb.append(s.substring(arr[0], arr[0] + t));
            sb.append("</b>");

            if (i < mergedIntervalList.size() - 1) {
                int[] gap = new int[]{mergedIntervalList.get(i)[1] + 1, mergedIntervalList.get(i + 1)[0] - 1};
                sb.append(s.substring(gap[0], gap[1] + 1));
            } else {
                int[] gap = new int[]{mergedIntervalList.get(i)[1] + 1, s.length() - 1};
                sb.append(s.substring(gap[0], gap[1] + 1));
            }

        }
        return sb.toString();
    }

    private List<int[]> merge(List<int[]> source) {
        List<int[]> target = new ArrayList<>();
        target.add(source.get(0).clone());

        for (int i = 1; i < source.size(); i++) {
            int[] last = target.get(target.size() - 1);
            int[] curr = source.get(i).clone();
            if (last[1] >= curr[0]) {
                int maxEnd = Math.max(last[1], curr[1]);
                last[1] = maxEnd;
            } else {
                if (curr[0] == last[1] + 1) {
                    last[1] = curr[1];
                } else {
                    target.add(curr);
                }

            }
        }

        return target;
    }

    public static void main(String[] args) {
        Solution616 solution616 = new Solution616();
        String res = solution616.addBoldTag("deabc88812391abc",
                new String[]{"abc", "123"});
        System.out.println(res);
    }
}
