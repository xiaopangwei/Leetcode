package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/26
 * @time 2:57 PM
 */
public class Solution1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int           i  = 0;
        while (i < command.length()) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                sb.append(ch);
                i++;
            } else if (i + 1 < command.length() && ch == '(' && command.charAt(i + 1) == ')') {
                sb.append("o");
                i += 2;
            } else {
                sb.append("al");
                i += 4;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution1678 solution1678=new Solution1678();
        String ans=solution1678.interpret("(al)G(al)()()G");
        System.out.println(ans);
    }
}
