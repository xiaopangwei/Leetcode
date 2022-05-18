package leetcode.p2022m05.day0510;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 8:31 PM
 */
public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {

        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() < t.length()) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        return s.length() != t.length();
    }

    public static void main(String[] args){
        Solution161 solution161=new Solution161();
        boolean ans=solution161.isOneEditDistance("cab","ad");
        System.out.println(ans);
    }


}
