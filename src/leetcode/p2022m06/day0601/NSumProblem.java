package leetcode.p2022m06.day0601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/11
 * @time 3:17 PM
 */
public class NSumProblem {

//    nums = [-1,0,1,2,-1,-4] [-4 -1 -1 0 1 2]
//    [[-1,-1,2],[-1,0,1]]

    int[] array;
    int   target;
    int   k;

    public void nsum(int[] array, int target, int k) {
        this.array = array;
        this.target = target;
        this.k = k;
        Arrays.sort(array);
        dfs(0, 0, new ArrayList<>(), new boolean[array.length]);
    }

    private void dfs(int index, int currentSum, List<Integer> list, boolean[] visited) {
        if (index == visited.length) {
            return;
        }
        if (list.size() > k) {
            return;
        }
        if (list.size() == k && currentSum == target) {
            System.out.println(list);
            return;
        }

        for (int i = index; i < array.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && array[i] == array[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(array[i]);
            visited[i] = true;
            dfs(i , currentSum + array[i], list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        NSumProblem nSumProblem = new NSumProblem();
        //[]
        nSumProblem.nsum(new int[]{-1, 0, 1, 2, -1, -4}, 0, 3);
    }
}
