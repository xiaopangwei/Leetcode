package leetcode.springfestival.pm20220205;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/5
 * @time 11:03 AM
 */
public class Solution1154 {
    public int dayOfYear(String date) {
        int[]    array      = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] components = date.split("-");

        int year  = Integer.parseInt(components[0]);
        int month = Integer.parseInt(components[1]) - 1;
        int day   = Integer.parseInt(components[2]);

        int ans = 0;
        for (int i = 0; i < month; i++) {
            if (i < month) {
                if (i == 1) {
                    if (isLeap(year)) {
                        ans += (array[i] + 1);
                    } else {
                        ans += array[i];
                    }
                } else {
                    ans += array[i];
                }
            }
        }

        ans += day;
        return ans;

    }

    private boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        }

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution1154 solution1154=new Solution1154();
        int ans=solution1154.dayOfYear("2019-02-10");
        System.out.println(ans);
    }

    /**
     * <p>Description: </p>
     * <p>Company: Harbin Institute of Technology</p>
     *
     * @author weihuang
     * @date 2022/2/1
     * @time 2:56 PM
     */
    public static class Solution556 {
        public int nextGreaterElement(int n) {
            Stack<Integer> stack       = new Stack<>();
            int            idx         = -1;
            char[]         array       = String.valueOf(n).toCharArray();
            boolean        flag        = false;
            int            breakpoints = -1;
            for (int i = array.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && array[i] < array[stack.peek()]) {
                    idx = stack.pop();
                }
                if (idx != -1) {
                    char temp = array[i];
                    array[i] = array[idx];
                    array[idx] = temp;
                    flag = true;
                    breakpoints = i;
                    break;
                }
                stack.push(i);
            }

            if (!flag) {
                return -1;
            }
            Arrays.sort(array, breakpoints + 1, array.length);
            long res=Long.parseLong(new String(array));
            if (res>Integer.MAX_VALUE){
                return -1;
            }
            return (int)res;
        }

        public static void main(String[] args) {
            Solution556 solution556 = new Solution556();
            int         n           = solution556.nextGreaterElement(2147483486);
            System.out.println(n);
        }
    }
}
