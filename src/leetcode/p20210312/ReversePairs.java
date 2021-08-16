package leetcode.p20210312;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/12
 * @time 2:26 PM
 */
public class ReversePairs {


    private int pairCount =0;
    public int reversePairs(int[] nums)  {

        if (nums.length==0){
            return 0;
        }
        int len=nums.length;
        mergeSort(nums,0,len-1);
        return pairCount;
    }


    private void mergeSort(int[] num, int start, int end){

        if (start==end){
            return ;
        }
        int mid=start+(end-start)/2;
        //[start,mid]
        mergeSort(num,start, mid);
        //[mid+1,end]
        mergeSort(num,mid+1,end);
        merge(num,start,mid,end);
    }


    private void merge(int[] num,int start,int mid,int end){

        int i=start;
        int j=mid+1;

        int count=0;

        int[] sorted=new int[end-start+1];

        while (i<=mid && j<=end){

            if (num[i]>num[j]){
                sorted[count++]=num[j];
                pairCount+=(mid-i+1);
                j++;

            }
            else{
                sorted[count++]=num[i];
                i++;
            }
        }

        if (i<=mid)
        {
           for (int k=i;k<=mid;k++){
                sorted[count++]=num[k];
           }

        }

        if (j<=end){
            for (int k=j;k<=end;k++){
                sorted[count++]=num[k];
            }
        }

        int idx=0;
        for (int k=start;k<=end;k++){
            num[k]=sorted[idx++];
        }


    }
    public static void main(String[] args){
        ReversePairs  solution315 =new ReversePairs();
        int result=solution315.reversePairs(new int[]{1,3,2,3,1});
        System.out.println(result);
    }
}
