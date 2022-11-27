package leetcode.p2022q4;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/21
 * @time 8:45 PM
 */
public class Solution2476 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sortedList = new ArrayList<>();
        dfs(root, sortedList);
        List<List<Integer>> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(Arrays.asList(searchMin(sortedList, q), searchMax(sortedList, q)));
        }
        return ans;
    }


    private int searchMin(List<Integer> sortedList, int target) {
        int i = 0;
        int j = sortedList.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (sortedList.get(mid) > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (j>=sortedList.size() || j<0){
            return -1;
        }
        return sortedList.get(j);
    }

    private int searchMax(List<Integer> sortedList, int target) {
        int i = 0;
        int j = sortedList.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (sortedList.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (i>=sortedList.size() || i<0){
            return -1;
        }
        return sortedList.get(i);
    }

    private void dfs(TreeNode root, List<Integer> sortedList) {
        if (root == null) {
            return;
        }
        dfs(root.left, sortedList);
        sortedList.add(root.val);
        dfs(root.right, sortedList);
    }

    public static void main(String[] args) {
        Solution2476 solution2476 = new Solution2476();
        System.out.println(solution2476.closestNodes(TreeNodeBuilder.build("[6,2,13,1,4,9,15,null,null,null,null,null,null,14]"),
                Arrays.asList(2, 5, 16)));
    }
}
