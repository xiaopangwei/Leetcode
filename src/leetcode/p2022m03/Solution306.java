package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/14
 * @time 8:18 PM
 */
public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2) {
            return false;
        }
        return dfs(num, 0, new ArrayList<>());
    }

    private boolean dfs(String num, int index, List<String> list) {
        if (index == num.length()) {
            return true;
        }

        for (int i = index + 1; i <= num.length(); i++) {
            String temp = num.substring(index, i);
            if (temp.charAt(0) == '0' && temp.length() > 1) {
                continue;
            }
            if (list.size() < 2) {
                list.add(temp);
                if (dfs(num, i, list) && list.size() > 2) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
            if (list.size() >= 2 && isOk(
                    list.get(list.size() - 1).toCharArray(),
                    list.get(list.size() - 2).toCharArray(),
                    temp.toCharArray())) {
                list.add(temp);
                if (dfs(num, i, list) && list.size() > 2) {
                    return true;
                }
                list.remove(list.size() - 1);
            }
        }

        return false;
    }

    private boolean isOk(char[] array1, char[] array2, char[] target) {
        char[] ans = new char[Math.max(array1.length, array2.length) + 1];
        Arrays.fill(ans, '0');
        int index = ans.length - 1;
        int i     = array1.length - 1;
        int j     = array2.length - 1;
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int temp = carry + array1[i] - '0' + array2[j] - '0';
            int mod  = temp % 10;
            i--;
            j--;
            ans[index--] = (char) (mod + '0');
            carry = temp / 10;
        }
        while (i >= 0) {
            int temp = carry + array1[i] - '0';
            ans[index--] = (char) (temp % 10 + '0');
            carry = temp / 10;
            i--;
        }
        while (j >= 0) {
            int temp = carry + array2[j] - '0';
            ans[index--] = (char) (temp % 10 + '0');
            carry = temp / 10;
            j--;
        }
        if (carry != 0) {
            ans[index--] = (char) (carry + '0');
        }
        i = 0;
        while (i < ans.length && ans[i] == '0') {
            i++;
        }
        j = 0;
        while (j < target.length && target[j] == '0') {
            j++;
        }

        if (ans.length - i != target.length - j) {
            return false;
        }
        while (i < ans.length && j < target.length) {
            if (ans[i] == target[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution306 solution306 = new Solution306();
        //1234
        //0784
        //2018
//        boolean ans = solution306.isOk("1234".toCharArray(), "784".toCharArray(), "02018".toCharArray());
        boolean ans = solution306.isAdditiveNumber("199100199");
        System.out.println(ans);
    }
}
