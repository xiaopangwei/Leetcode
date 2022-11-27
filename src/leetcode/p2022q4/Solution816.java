package leetcode.p2022q4;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/26
 * @time 3:04 PM
 */
public class Solution816 {


    public List<String> ambiguousCoordinates(String s) {
        List<String> ans   = new ArrayList<>();
        String       trimS = s.substring(1, s.length() - 1);
        for (int i = 0; i < trimS.length(); i++) {
            String       left      = trimS.substring(0, i);
            String       right     = trimS.substring(i);
            List<String> leftList  = dotSplit(left);
            List<String> rightList = dotSplit(right);

            if (!leftList.isEmpty() && !rightList.isEmpty()) {
                for (String l : leftList) {
                    for (String r : rightList) {
                        String t = "(" + l.trim() + "," + r.trim() + ")";
//                        System.out.println(t);
                        ans.add(t);
                    }
                }
            }
        }
        return ans;
    }


    public List<String> dotSplit(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (left.length() > 1 && left.charAt(0) == '0') {
                continue;
            }
            String  right = s.substring(i, s.length());
            boolean flag  = false;
            int     index = 0;
            for (; index < right.length(); index++) {
                char c = right.charAt(index);
                if (c != '0') {
                    flag = true;
                    break;
                }
            }
            if (!flag || (right.length() > 1 && right.charAt(right.length() - 1) == '0')) {
                continue;
            }
            ans.add(left.trim() + "." + right.trim());
        }
        if ((s.length() > 1 && s.charAt(0) != '0') || s.length() == 1) {
            ans.add(s.trim());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution816 solution816 = new Solution816();
        System.out.println(solution816.ambiguousCoordinates("(0010)"));
    }
}
