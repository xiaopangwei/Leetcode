package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/7
 * @time 10:29 AM
 */
public class Solution434 {
    public int countSegments(String s) {

        int i      = 0;
        int length = s.length();
        int count  = 0;

        while (i < length) {


            while (i < length && s.charAt(i) == ' ') {
                i++;
            }

            if (i>=length){
                break;
            }
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
        Solution434 solution434 = new Solution434();
        int         count       = solution434.countSegments("    foo    bar");
        System.out.println(count);
    }
}
