package leetcode.p2022q4;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/10/9
 * @time 8:36 PM
 */
public class PRAC20221011 {

    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int item : nums) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        while (freq.size() > 0) {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (freq.size() > 0) {
                    Map.Entry<Integer, Integer> t = freq.pollFirstEntry();
                    list.add(t);
                } else {
                    return false;
                }
            }

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getKey() != list.get(i - 1).getKey() + 1) {
                    return false;
                }
            }


            for (Map.Entry<Integer, Integer> entry : list) {

                if (entry.getValue() - 1 > 0) {
                    freq.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }

        return freq.isEmpty();
    }


    Map<String, Integer> freqMap = new HashMap<>();
    List<TreeNode>       ans     = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }


    private String dfs(TreeNode root) {
        if (root == null) {
            return "NULL";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append("[");
        sb.append(dfs(root.left));
        sb.append("]");
        sb.append("[");
        sb.append(dfs(root.right));
        sb.append("]");
        String res = sb.toString();

        freqMap.put(res, freqMap.getOrDefault(res, 0) + 1);
        if (freqMap.get(res) == 2) {
            ans.add(root);
        }
        return res;
    }


    public int findSubstringInWraproundString(String p) {
        int   len = p.length();
        int[] dp  = new int[26];
        dp[p.charAt(0) - 'a'] = 1;
        int k=0;
        for (int i = 0; i < len; i++) {
            if (i>0 && (p.charAt(i) - p.charAt(i-1) + 26) % 26 ==1) {
                k++;
            }else{
                k=1;
            }
            dp[p.charAt(i)-'a']=Math.max(dp[p.charAt(i)-'a'],k);
        }
        int s = 0;
        for (int v : dp) {
            s += v;
        }
        return s;
    }


    public static void main(String[] args) {
        PRAC20221011 prac20221011 = new PRAC20221011();
        System.out.println(prac20221011.findSubstringInWraproundString("zab"));
//        int[]        array        = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
//        System.out.println(prac20221011.isPossibleDivide(array, 4));
//        prac20221011.findDuplicateSubtrees(TreeNode.ofArray("[2,1,11,11,null,1]"));
    }

}
