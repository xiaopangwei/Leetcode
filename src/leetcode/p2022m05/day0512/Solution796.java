package leetcode.p2022m05.day0512;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:39 PM
 */
public class Solution796 {
    public boolean rotateString(String s, String goal) {
        if (s.length()!=goal.length()){
            return false;
        }

        return (s+s).contains(goal);
    }
}
