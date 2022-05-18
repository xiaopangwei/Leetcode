package leetcode.p2022m05.day0505;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 10:08 PM
 */
public class Solution315 {


    List<Integer> ans = new ArrayList<>();

    public List<Integer> countSmaller(int[] nums) {


        int[][] biArray = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            biArray[i][0] = i;
            biArray[i][1] = nums[i];
            ans.add(0);
        }

        mergeSort(biArray, 0, nums.length - 1);


//        for (int[] item : biArray) {
//            System.out.println(item[0] + " " + item[1]);
//        }
        return ans;
    }


    private void mergeSort(int[][] biArray, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(biArray, start, mid);
        mergeSort(biArray, mid + 1, end);

        merge(biArray, start, mid, mid + 1, end);
    }


    private void merge(int[][] biArray, int start1, int end1, int start2, int end2) {
        int[][] temp  = new int[end2 - start1 + 1][2];
        int     index = 0;
        int     i     = start1;
        int     j     = start2;
        while (i <= end1 && j <= end2) {
            if (biArray[i][1] <= biArray[j][1]) {
                temp[index++] = biArray[i];
                int t = ans.get(biArray[i][0]) + j - start2;
                ans.set(biArray[i][0], t);
                System.out.println(biArray[i][0]+" delta:"+(j-start2));
                i++;
            } else {
                temp[index++] = biArray[j++];
            }
        }

        while (i <= end1) {

            temp[index++] = biArray[i];
            int t = ans.get(biArray[i][0]) + j - start2;
            ans.set(biArray[i][0], t);
            i++;

        }

        while (j <= end2) {
            temp[index++] = biArray[j++];
        }


        for (int t = 0; t < temp.length; t++) {
            biArray[t + start1] = temp[t];
        }


    }


    public static void main(String[] args) {
        Solution315   solution315 = new Solution315();
        List<Integer> ans         = solution315.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(ans);
    }
}
