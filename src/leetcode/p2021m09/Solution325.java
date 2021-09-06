package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/4
 * @time 10:51 PM
 */
public class Solution325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        Map<Integer, List<Integer>> sumAndIndexMap = new HashMap<>();


        List<Integer> list = new ArrayList<>();
        list.add(0);
        sumAndIndexMap.put(0, list);
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            if (!sumAndIndexMap.containsKey(prefixSum[i])) {
                sumAndIndexMap.put(prefixSum[i], new ArrayList<>());
            }

            sumAndIndexMap.get(prefixSum[i]).add(i);
        }

        int maxLen = 0;


        for (int i = 0; i < prefixSum.length; i++) {
            int           left       = prefixSum[i] - k;
            int           right      = k + prefixSum[i];
            List<Integer> indexList1 = sumAndIndexMap.get(left);
            if (indexList1 != null && !indexList1.isEmpty()) {

                int firstIndex = indexList1.get(0);
                if (firstIndex < i) {
//                    System.out.println("first " + i + " " + firstIndex);
                    maxLen = Math.max(i - firstIndex, maxLen);
                }

            }
            List<Integer> indexList2 = sumAndIndexMap.get(right);
            if (indexList2 != null && !indexList2.isEmpty()) {

                int lastIndex = indexList2.get(indexList2.size() - 1);
                if (lastIndex > i) {
//                    System.out.println("last " + i + " " + lastIndex);
                    maxLen = Math.max(lastIndex - i, maxLen);
                }

            }

        }


        return maxLen;
    }


    public static void main(String[] args) {
        Solution325 solution325 = new Solution325();
        int         ans         = solution325.maxSubArrayLen(new int[]{2,3,1,0,0}, 1);
        System.out.println(ans);
    }
}
