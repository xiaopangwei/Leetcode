package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/16
 * @time 9:15 PM
 */
public class Solution722 {
    public List<String> removeComments(String[] source) {

        boolean       blockComment = false;
        List<String>  ans          = new ArrayList<>();
        StringBuilder builder      = new StringBuilder();
        for (String line : source) {
            int i = 0;
            //["a/*comment", "line", "more_comment*/b"]
            //没有出注释，不要另起一行
            if (!blockComment) {
                builder = new StringBuilder();
            }
            while (i < line.length()) {
                // /*
                if (!blockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    blockComment = true;
                    i += 2;
                }
                //  */
                else if (blockComment && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    blockComment = false;
                    i += 2;
                }
                // //
                else if (!blockComment && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!blockComment) {
                    builder.append(line.charAt(i));
                    i++;
                } else {
                    i++;
                }
            }

            if (!blockComment && builder.length() != 0) {
                ans.add(builder.toString());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution722  solution722 = new Solution722();
        List<String> ans         = solution722.removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"});
        System.out.println(ans);
    }
}
