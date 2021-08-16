package leetcode.p20210218;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 10:41 PM
 */
public class PartitionSort {

    public void sortColors(int[] nums) {
      int firstIdx=0;

      int secondIdx=nums.length-1;

      int tempIdx=0;

      //0 [0,firstIdx-1)
      //1 [firstIdx-1,secondIdx-1]
      //2 (secondIdx,length-1]


        while (tempIdx<=secondIdx){

            if (nums[tempIdx]==0){
                swap(nums,firstIdx,tempIdx);
                firstIdx++;
                tempIdx++;
            }
            else if (nums[tempIdx]==1){
                tempIdx++;
            }
            else{
                swap(nums,secondIdx,tempIdx);
                secondIdx--;
            }
        }
    }

    private void swap(int[] num,int i,int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
    public static void main(String[] args){
        PartitionSort partitionSort=new PartitionSort();
        int[] array=new int[]{2,1,0,0,2,1,1,1};
        partitionSort.sortColors(array);
        System.out.println(Arrays.toString(array));

    }
}
