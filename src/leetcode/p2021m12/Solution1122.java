package leetcode.p2021m12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/28
 * @time 9:48 PM
 */
public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> freq = new TreeMap<>();
        for (int item : arr1) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        int   index = 0;
        int[] ans   = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            int f = freq.getOrDefault(arr2[i], 0);
            for (int j = 0; j < f; j++) {
                ans[index++] = arr2[i];
            }
            freq.remove(arr2[i]);
        }


        for (Map.Entry<Integer,Integer> entry:freq.entrySet()){
            for (int i=0;i<entry.getValue();i++){
                ans[index++]=entry.getKey();
            }
        }

        return ans;

    }

    public static void main(String[] args){
        Solution1122 solution1122=new Solution1122();
        int[] arr=solution1122.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19},new int[]{2,1,4,3,9,6});
        System.out.println(Arrays.toString(arr));
    }
}
