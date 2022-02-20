package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/17
 * @time 8:30 PM
 */
public class Solution168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        int           num     = columnNumber;
        //1   A
        //2   B
        //27  AA
        //28  AB
        while (num != 0) {
            num--;
            int a = num % 26;
            int b = num / 26;
            builder.append((char) ('A' + a));
            num = b;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        String      ans         = solution168.convertToTitle(1);
        System.out.println(ans);
    }
}
