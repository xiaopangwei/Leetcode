package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/29
 * @time 8:22 PM
 */
public class Solution38 {

    List<String> ans = new ArrayList<>();

    public String[] permutation(String s) {
        int tLen = s.length();


        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        char[]    temp    = new char[tLen];
        boolean[] visited = new boolean[tLen];
        dfs(charArray, visited, temp, 0);
        String[] arr   = new String[ans.size()];
        int      index = 0;
        for (String item : ans) {
            arr[index++] = item;
        }
        return arr;
    }

    private void dfs(char[] array, boolean[] visited, char[] temp, int pIndex) {
        if (pIndex == temp.length) {
            ans.add(new String(temp));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (i > 0 && array[i] == array[i - 1] && visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                temp[pIndex] = array[i];
                visited[i] = true;
                dfs(array, visited, temp, pIndex + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        String[]   ans        = solution38.permutation("aab");
        System.out.println(Arrays.toString(ans));
    }
}
