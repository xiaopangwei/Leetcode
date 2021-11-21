package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 3:22 PM
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list =new ArrayList<>();

        int i=0;
        int j=0;
        while (i<nums1.length && j<nums2.length){
            if (nums1[i]<nums2[j]){
                i++;
            }else if (nums1[i]>nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] array=new int[list.size()];
        int index=0;
        for (int t=0;t<list.size();t++){
            array[index++]=list.get(t);
        }

        return array;
    }

    public static void main(String[] args){
        Solution350 solution350=new Solution350();
        int[] ans=solution350.intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(ans));
    }
}
