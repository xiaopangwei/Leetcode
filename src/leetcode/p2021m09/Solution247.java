package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 3:30 PM
 */
public class Solution247 {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    List<String> ans = new ArrayList<>();

    List<Integer> valid = Arrays.asList(0, 1, 8);

    public List<String> findStrobogrammatic(int n) {

        if (n==1){
            return Arrays.asList("0","1","8");
        }
        char[] array = new char[n];

        dfs(array, 0, n);

        return ans;
    }

    private void dfs(char[] array, int index, final int maxLength) {
        if (index >= array.length || array[index] != 0) {
            ans.add(new String(array));
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
                dfs(array, index + 1, maxLength);

                array[index] = 0;
                array[maxLength - 1 - index] = 0;

            }
        }
        else if (maxLength % 2 == 1 && index == maxLength / 2) {
            for (int i = 0; i < valid.size(); i++) {
                array[index] = (char) (valid.get(i) + '0');
                dfs(array, index + 1, maxLength);
                array[index] = 0;
            }
        } else {
            for (int k : keys) {
                array[index] = (char) (k + '0');
                array[maxLength - 1 - index] = (char) (map.get(k) + '0');
                dfs(array, index + 1, maxLength);

                array[index] = 0;
                array[maxLength - 1 - index] = 0;

            }
        }
    }

    public static void main(String[] args) {
        Solution247  solution247 = new Solution247();
        List<String> ans         = solution247.findStrobogrammatic(4);
        System.out.println(ans);
    }
}
