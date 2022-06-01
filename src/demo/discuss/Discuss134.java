package demo.discuss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/17
 * @time 10:21 PM
 */
public class Discuss134 {
    //有一些数组a1,a2,a3,a4,... 依次（a1,a2,a3,a4,...）在每个数组里取一个数，要求每个数递增 求有多少种取法

    public int numOfWays(List<int[]> nums) {
        return dfs(nums, 0, Integer.MIN_VALUE,new ArrayList<>());
    }

    public int dfs(List<int[]> nums, int index, int currentMax, List<Integer> list) {
        if (index >= nums.size()) {
            System.out.println(list);
            return 1;
        }

        int   ans   = 0;
        int[] array = nums.get(index);
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= currentMax) {
                continue;
            }
            list.add(array[i]);
            ans += dfs(nums, index + 1, nums.get(index)[i], list);
            list.remove(list.size() - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Discuss134 discuss134 = new Discuss134();
        //[1,2,9,16]
        //[-1,3,4]
        //[7,10]
        int ans = discuss134.numOfWays(Arrays.asList(new int[]{1, 2, 9, 16}, new int[]{-1, 3, 4}, new int[]{7, 10}));
        System.out.println(ans);
    }
}
