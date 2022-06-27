package leetcode.p2022m06.day0601;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/5
 * @time 7:38 PM
 */
public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        return dfs(new ArrayList<>(), 0, num);
    }

    private boolean dfs(List<BigInteger> list, int startIndex, String num) {
        if (startIndex >= num.length()) {
            return true;
        }

        for (int i = 1; i < num.length(); i++) {
            int j = startIndex + i - 1;
            if (j >= num.length()) {
                continue;
            }
            String temp = num.substring(startIndex, j + 1);
            if (temp.length() >= 2 && temp.charAt(0) == '0') {
                continue;
            }
            BigInteger val = new BigInteger(temp);
            if (list.size() < 2) {
                list.add(val);
                if (dfs(list, j + 1, num)) {
                    return true;
                }
                list.remove(list.size() - 1);
            } else {
                BigInteger v1 = list.get(list.size() - 2);
                BigInteger v2 = list.get(list.size() - 1);
                if (v1.add(v2).equals(val)) {
                    list.add(val);
                    if (dfs(list, j + 1, num)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String      t           = "199100199";
        Solution306 solution306 = new Solution306();
        System.out.println(solution306.isAdditiveNumber(t));
    }


}
