package leetcode.p2022q4;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/6
 * @time 9:03 PM
 */
public class Solution1805 {
    public int numDifferentIntegers(String word) {
        int         i    = 0;
        Set<String> list = new HashSet<>();
        while (i < word.length()) {
            if (Character.isDigit(word.charAt(i))) {
                while (i < word.length() && word.charAt(i) == '0') {
                    i++;
                }
                int j = i;
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                String subStr = word.substring(i, j);
                list.add(subStr);
                i = j;
            }else{
                i++;
            }
        }

        return list.size();
    }

    public static void main(String[] args) {
        Solution1805 solution1805 = new Solution1805();
        System.out.println(solution1805.numDifferentIntegers("0a0"));
    }
}
