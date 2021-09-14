package leetcode.p2021m09;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/13
 * @time 9:59 PM
 */
public class Solution437 {
    int                    ans       = 0;
    Map<TreeNode, Integer> prefixSum = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, 0);
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 0);
        search(root, targetSum, new ArrayList<>(), freqMap);
        return ans;
    }

    private void search(TreeNode root, int targetSum, List<Integer> cnt, Map<Integer, Integer> freq) {
        if (root == null) {
            return;
        }
        cnt.add(prefixSum.get(root));
        int currentPrefixSum = prefixSum.get(root);
        int count            = freq.getOrDefault(currentPrefixSum - targetSum, 0);
        if (count > 0) {
//            System.out.println(cnt);
            ans += count;
        }
        freq.put(currentPrefixSum, freq.getOrDefault(currentPrefixSum, 0) + 1);
        search(root.left, targetSum, cnt, freq);
        search(root.right, targetSum, cnt, freq);
        cnt.remove(cnt.size() - 1);
        freq.put(currentPrefixSum, freq.getOrDefault(currentPrefixSum, 0) - 1);
    }

    private void dfs(TreeNode root, int accumulator) {

        if (root == null) {
            return;
        }
        prefixSum.put(root, accumulator + root.val);
        dfs(root.left, accumulator + root.val);
        dfs(root.right, accumulator + root.val);
    }

    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
        TreeNode    root        = TreeNode.ofArray("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int         ans         = solution437.pathSum(root, 22);
        System.out.println(ans);
    }
}
