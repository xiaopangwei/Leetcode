package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/17
 * @time 9:25 PM
 */
public class Solution293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans      = new ArrayList<>();
        char[]       template = currentState.toCharArray();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                char[] array = template.clone();
                array[i] = '-';
                array[i + 1] = '-';
                ans.add(new String(array));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution293 solution293 = new Solution293();
        System.out.println(solution293.generatePossibleNextMoves("++++"));
    }
}
