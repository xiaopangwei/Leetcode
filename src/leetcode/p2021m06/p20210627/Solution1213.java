package leetcode.p2021m06.p20210627;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 1:38 PM
 */
public class Solution1213 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i=0,j=0,k=0;
        List<Integer> ans=new ArrayList<>();
        while (i<arr1.length && j<arr2.length && k<arr3.length){
            System.out.println(i+" "+j+" "+k);
            if (arr1[i]==arr2[j] && arr1[i]==arr3[k]){
                ans.add(arr1[i]);
                i++;j++;k++;
            }
            else if (arr1[i]<=arr2[j] && arr1[i]<=arr3[k]){
                i++;
            }
            else if (arr2[j]<=arr1[i] && arr2[j]<=arr3[k]){
                j++;
            }
            else if (arr3[k]<=arr1[i] && arr3[k]<=arr2[j]){
                k++;
            }
        }
        return ans;

    }

    public static void main(String[] args){
        Solution1213 solution1213=new Solution1213();
        System.out.println(solution1213.arraysIntersection(new int[]{1,12,13,14,15},
                new int[]{1,2,13,15,17},new int[]{1,13,14,15,18}));
    }
}
