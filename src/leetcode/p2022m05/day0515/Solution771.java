package leetcode.p2022m05.day0515;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 9:48 PM
 */
public class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> sets=new HashSet<>();
        for (char ch:jewels.toCharArray()){
            sets.add(ch);
        }

        int cnt=0;
        for (char ch:stones.toCharArray()){
            if (sets.contains(ch)){
                cnt++;
            }
        }
        return cnt;
    }
}
