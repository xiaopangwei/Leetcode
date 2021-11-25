package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/25
 * @time 10:26 PM
 */
public class Solution241 {


    public List<Integer> diffWaysToCompute(String expression) {

        if (isNumber(expression)) {
            return Arrays.asList(Integer.parseInt(expression));
        }
        char[]        arr = expression.toCharArray();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*') {
                List<Integer> leftList  = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                if (leftList.isEmpty() || rightList.isEmpty()) {
                    continue;
                }
                for (int item1 : leftList) {
                    for (int item2 : rightList) {
                        int t = 0;
                        switch (arr[i]) {
                            case '+':
                                t = item1 + item2;
                                break;
                            case '-':
                                t = item1 - item2;
                                break;
                            case '*':
                                t = item1 * item2;
                                break;
                        }

                            ans.add(t);

                    }
                }


            }
        }
        return ans;
    }

    private boolean isNumber(String expression) {
        char[] arr = expression.toCharArray();
        for (char ch : arr) {
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution241 solution241=new Solution241();
        List<Integer> res=solution241.diffWaysToCompute("2*3-4*5");
        System.out.println(res);
    }
}
