package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/20
 * @time 5:29 PM
 */
public class Solution1818 {
    static final int MAXVAL=(int)(10e9+7);


    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {


        int length=nums1.length;
        int[] newNum1=new int[length];
        long total=0;
        for (int i=0;i<length;i++){
            total+=Math.abs(nums1[i]-nums2[i]);
        }

        long res=Integer.MAX_VALUE;
        System.arraycopy(nums1,0,newNum1,0,length);
        Arrays.sort(newNum1);
        for (int i=0;i<length;i++){
            int target=nums2[i];
            long temp=0;
            if (nums1[i]!=target){
                temp+=search(newNum1, target);
            }

            temp=total-Math.abs(nums1[i]-nums2[i])+temp;
            res=Math.min(res,temp);
        }

        return (int) (res%MAXVAL);

    }


    private long search(int[] array,int target){

        int minDiff=Integer.MAX_VALUE;
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (array[mid]==target)
            {
                return 0;
            }
            else if (array[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if (left>=0 && left<array.length){
            minDiff=Math.min(minDiff,Math.abs(target-array[left]));
        }

        int idx=left-1;
        if (left>=0 && left<array.length) {
            while (idx >= 0 && array[idx] == array[left]) {
                idx--;
            }
        }
        if (idx>=0){
            minDiff=Math.min(minDiff,Math.abs(target-array[idx]));
        }

        return minDiff;
    }



    public static void main(String[] args){
//        int[] array1=new int[]{53,48,14,71,31,55,6,80,28,19,15,40,7,21,69,15,5,42,86,15,11,54,44,62,9,100,2,26,81,87,87,18,45,29,46,100,20,87,49,86,14,74,74,52,52,60,8,25,21,96,7,90,91,42,32,34,55,20,66,36,64,67,44,51,4,46,25,57,84,23,10,84,99,33,51,28,59,88,50,41,59,69,59,65,78,50,78,50,39,91,44,78,90,83,55,5,74,96,77,46};
//        int[] array2=new int[]{39,49,64,34,80,26,44,3,92,46,27,88,73,55,66,10,4,72,19,37,40,49,40,58,82,32,36,91,62,21,68,65,66,55,44,24,78,56,12,79,38,53,36,90,40,73,92,14,73,89,28,53,52,46,84,47,51,31,53,22,24,14,83,75,97,87,66,42,45,98,29,82,41,36,57,95,100,2,71,34,43,50,66,52,6,43,94,71,93,61,28,84,7,79,23,48,39,27,48,79};

        int[] array1={56,51,39,1,12,14,58,82,18,41,70,64,18,7,44,90,55,23,11,79,59,76,67,92,60,80,57,11,66,32,76,73,35,65,55,37,38,26,4,7,64,84,98,61,78,1,80,33,5,66,32,30,52,29,41,2,21,83,30,35,21,30,13,26,36,93,81,41,98,23,20,19,45,52,25,51,52,24,2,45,21,97,11,92,28,37,58,29,5,18,98,94,86,65,88,8,75,12,9,66};
        int[] array2={64,32,98,65,67,40,71,93,74,24,49,80,98,35,86,52,99,65,15,92,83,84,80,71,46,11,26,70,80,2,81,57,97,12,68,10,49,80,24,18,45,72,33,94,60,5,94,99,14,41,25,83,77,67,49,70,94,83,55,17,61,44,50,62,3,36,67,10,2,39,53,62,44,72,66,7,3,6,80,38,43,100,17,25,24,78,8,4,36,86,9,68,99,64,65,15,42,59,79,66};
//        int[] array2=new int[]{9,3,5,1,7,4};
        Solution1818 solution1818=new Solution1818();
        System.out.println(solution1818.minAbsoluteSumDiff(array1,array2));
    }
}
