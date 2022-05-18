package leetcode.p2022m05.day0513;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/13
 * @time 10:22 PM
 */
public class Solution0105 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }

        int minLen = Math.min(m, n);
        for (int i = 0; i < minLen; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (m == n) {
                    return first.substring(i + 1).equals(second.substring(i + 1));
                } else if (m < n) {
                    return first.substring(i).equals(second.substring(i + 1));
                } else {
                    return first.substring(i + 1).equals(second.substring(i));
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution0105 solution0105=new Solution0105();
        boolean ans=solution0105.oneEditAway("pales","ple");
        System.out.println(ans);
    }












}
