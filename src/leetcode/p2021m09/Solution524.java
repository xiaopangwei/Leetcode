package leetcode.p2021m09;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/14
 * @time 5:11 PM
 */
public class Solution524 {
    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });


        for (String item : dictionary) {
            if (isSubSeq(s, item)) {
                return item;
            }
        }


        return "";
    }

    public boolean isSubSeq(String source, final String sub) {
        int i = 0;
        int j = 0;

        while (i < source.length() && j < sub.length()) {
            if (source.charAt(i) == sub.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j >= sub.length()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution524 solution524 = new Solution524();
//        System.out.println(solution524.isSubSeq("abbac", "bba"));
        String ans = solution524.findLongestWord("abpcplea", Arrays.asList("a", "b", "c"));
        System.out.println(ans);
    }
}
