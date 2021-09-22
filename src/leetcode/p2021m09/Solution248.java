package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 5:38 PM
 */
public class Solution248 {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    int count = 0;

    List<Integer> valid = Arrays.asList(0, 1, 8);

    public boolean isStrobogrammatic(String num) {

        char[] array = num.toCharArray();
        int    i     = 0;
        int    j     = array.length - 1;


        while (i <= j) {
            if (i == j) {
                if (!map.containsKey(array[i] - '0')) {
                    return false;
                } else if (!map.get(array[i] - '0').equals(array[i] - '0')) {
                    return false;
                }
            } else {
                if (!map.containsKey(array[i] - '0') || !map.containsKey(array[j] - '0')) {
                    return false;
                }
                if (!map.get(array[i] - '0').equals(array[j] - '0')) {
                    return false;
                }

                if (!map.get(array[j] - '0').equals(array[i] - '0')) {
                    return false;
                }
            }


            i++;
            j--;

        }

        return true;
    }

    public int strobogrammaticInRange(String low, String high) {

        int lowLen  = low.length();
        int highLen = high.length();

        int lower = Integer.parseInt(low);
        int upper = Integer.parseInt(high);


        if (lower == upper) {
            if (isStrobogrammatic(low)) {
                return 1;
            } else {
                return 0;
            }
        }

        if (lowLen==highLen && lowLen==1){
            int cnt=0;
            for (int i=lower;i<=upper;i++){
                if (valid.contains(i)){
                    cnt++;
                }
            }
            return cnt;
        }
        for (int i = lowLen; i <= highLen; i++) {
            char[] array = new char[i];
            dfs(array, 0, i, lower, upper);
        }

        return count;
    }

    private void dfs(char[] array, int index, final int maxLength, int lower, int upper) {
        if (index >= array.length || array[index] != 0) {
            String temp = new String(array);
            if (Integer.parseInt(temp) >= lower && Integer.parseInt(temp) <= upper) {
                System.out.println(temp);
                count++;
            }
            return;
        }
        Set<Integer> keys = map.keySet();
        if (index == 0) {
            for (int k : keys) {
                if (k == 0) {
                    continue;
                }
                array[index] = (char) (k + '0');
                array[maxLength - 1 - index] = (char) (map.get(k) + '0');
                dfs(array, index + 1, maxLength, lower, upper);

                array[index] = 0;
                array[maxLength - 1 - index] = 0;

            }
        } else if (maxLength % 2 == 1 && index == maxLength / 2) {
            for (int i = 0; i < valid.size(); i++) {
                array[index] = (char) (valid.get(i) + '0');
                dfs(array, index + 1, maxLength, lower, upper);
                array[index] = 0;
            }
        } else {
            for (int k : keys) {
                array[index] = (char) (k + '0');
                array[maxLength - 1 - index] = (char) (map.get(k) + '0');
                dfs(array, index + 1, maxLength, lower, upper);

                array[index] = 0;
                array[maxLength - 1 - index] = 0;

            }
        }
    }

    public static void main(String[] args) {
        Solution248 solution248 = new Solution248();
        int         count       = solution248.strobogrammaticInRange("0", "100");
        System.out.println(count);
    }
}
