package leetcode.p2022m06.day0601;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/3
 * @time 10:44 PM
 */
public class Solution880 {

    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        // arr[i] 代表S.substring(0,i)解码后的长度
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            char c = S.charAt(i - 1);
            if (Character.isDigit(c)) {
                arr[i] = arr[i - 1] * Integer.valueOf(c + "");
            } else {
                arr[i] = arr[i - 1] + 1;
            }
            if (arr[i] >= K) break;
        }
        System.out.println(Arrays.toString(arr));
        char c = dfs(K, arr, S);
        return String.valueOf(c);
    }

    public char dfs(int K, final long[] array, final String S) {
        int i = 0;
        for (; i < array.length; i++) {
            if (array[i] >= K) {
                break;
            }
        }
        if (array[i] == K) {
            if (Character.isDigit(S.charAt(i - 1))) {
                return dfs((int) (K - array[i - 1]), array, S);
            } else {
                return S.charAt(i - 1);
            }
        } else {
            return dfs((int) (K - array[i - 1]), array, S);
        }
    }


    public static void main(String[] args) {
        Solution880 solution880 = new Solution880();
        String      s           = solution880.decodeAtIndex("a2345678999999999999999", 1);
        System.out.println(s);
    }
}
