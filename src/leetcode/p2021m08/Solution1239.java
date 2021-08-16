package leetcode.p2021m08;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 6:16 PM
 */
public class Solution1239 {
    private int maxValue = 0;

    public int maxLength(List<String> arr) {
        dfs(0, arr, new HashSet<>());
        return maxValue;
    }

    private void dfs(int idx, final List<String> arr, Set<Character> sets) {


        if (idx == arr.size()) {
            maxValue = Math.max(maxValue, sets.size());
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            String  current   = arr.get(i);
            char[]  charArray = current.toCharArray();
            boolean flag      = contains(charArray, sets);
            if (flag) {
//                System.out.println("1 开始"+" "+(idx+1)+" "+sets);
                dfs(idx + 1, arr, sets);
//                System.out.println("1 结束"+" "+(idx+1)+" "+sets);
                for (char ch : charArray) {
                    sets.add(ch);
                }
//                System.out.println("2 开始"+" "+(idx+1)+" "+sets);
                dfs(idx + 1, arr, sets);
                for (char ch : charArray) {
                    sets.remove(ch);
                }
//                System.out.println("2 结束"+" "+(idx+1)+" "+sets);
            } else {
//                System.out.println("3 开始"+" "+(idx+1)+" "+sets);
                dfs(idx + 1, arr, sets);
//                System.out.println("3 结束"+" "+(idx+1)+" "+sets);
            }
        }

    }

    private boolean contains(char[] charArray, Set<Character> sets) {
        for (char ch : charArray) {
            if (sets.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1239 solution1239 = new Solution1239();
        int          ans          = solution1239.maxLength(Arrays.asList(
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"));
        System.out.println(ans);
    }
}
