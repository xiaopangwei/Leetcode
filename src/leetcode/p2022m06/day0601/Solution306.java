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
//            System.out.println(list);
            if (list.size()>2){
                return true;
            }
            return false;
        }
        for (int len = 1; len <= num.length(); len++) {
            int endIndex = len + startIndex - 1;
            if (endIndex >= num.length()) {
                continue;
            }
            String sub  = num.substring(startIndex, endIndex + 1);
            if (num.charAt(startIndex)=='0' && sub.length()>=2){
                continue;
            }
            BigInteger temp=new BigInteger(sub);
            if (list.size() < 2 || list.get(list.size() - 1).add(list.get(list.size() - 2)).equals(temp)) {
                list.add(temp);
                boolean flag = dfs(list, endIndex + 1, num);
                if (flag) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String      t           = "11235813213455890144";
        Solution306 solution306 = new Solution306();
        System.out.println(solution306.isAdditiveNumber(t));
    }



}
