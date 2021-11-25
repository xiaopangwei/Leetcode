package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 8:27 PM
 */
public class Solution859 {
    public boolean buddyStrings(String s, String goal) {

        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }
        List<Integer> diffPosList = new ArrayList<>();
        int[]         freq        = new int[26];
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffPosList.add(i);
            }
            freq[s.charAt(i) - 'a']++;
        }

        if (diffPosList.isEmpty()) {
            for (int item : freq) {
                if (item >= 2) {
                    return true;
                }
            }
            return false;
        } else {
            if (diffPosList.size() != 2) {
                return false;
            }
            int first  = diffPosList.get(0);
            int second = diffPosList.get(1);
            if (s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args){
        Solution859 solution859=new Solution859();
        boolean ans=solution859.buddyStrings("aaaaaaabc","aaaaaaacb");
        System.out.println(ans);
    }
}
