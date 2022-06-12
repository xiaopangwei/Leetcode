package leetcode.p2022m06.day0601;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/11
 * @time 3:17 PM
 */
public class NSumProblem2 {

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

        System.out.println(dfs(0, k, target));

    }

    private LinkedList<List<Integer>> dfs(int startIndex, int count, int targetSum) {
        if (count <= 2) {
            return twoSum(array, startIndex, array.length - 1,targetSum);
        }
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int                       i   = startIndex;
        while (i < array.length) {
            int                       temp = array[i];
            LinkedList<List<Integer>> list = dfs(i + 1, count - 1, targetSum - temp);
            if (!list.isEmpty()) {
                for (List<Integer> item : list) {
                    LinkedList<Integer> tList = new LinkedList<>();
                    tList.addAll(item);
                    tList.add(temp);
                    ans.add(tList);
                }
            }

            int j = i + 1;
            while (j < array.length && array[j] == array[i]) {
                j++;
            }
            i = j;
        }
        return ans;
    }

    private LinkedList<List<Integer>> twoSum(int[] array, int i, int j,int target) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        while (i < j) {
            if (array[i] + array[j] == target) {
                list.add(Arrays.asList(array[i], array[j]));
                int t1 = i + 1;
                while (t1 < j && array[t1] == array[i]) {
                    t1++;
                }
                i = t1;

                int t2 = j - 1;
                while (i < t2 && array[t2] == array[j]) {
                    t2--;
                }
                j = t2;
            } else if (array[i] + array[j] < target) {
                int t1 = i + 1;
                while (t1 < j && array[t1] == array[i]) {
                    t1++;
                }
                i = t1;
            } else {
                int t2 = j - 1;
                while (i < t2 && array[t2] > array[j]) {
                    t2--;
                }
                j = t2;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        NSumProblem2 nSumProblem = new NSumProblem2();
        //[]
        nSumProblem.nsum(new int[]{1,0,-1,0,-2,2}, 0, 4);
    }
}
