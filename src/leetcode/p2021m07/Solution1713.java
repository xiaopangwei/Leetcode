package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/26
 * @time 10:40 AM
 */
public class Solution1713 {
    public int minOperations(int[] target, int[] arr) {

        Map<Integer,Integer> map1=new HashMap<>();
        int[] targetIndex=new int[target.length];

        for (int i=0;i<target.length;i++){
            map1.put(target[i],i);
            targetIndex[i]=i;
        }

        List<Integer> sourceIndexList=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
           if (map1.containsKey(arr[i])){
               sourceIndexList.add(map1.get(arr[i]));
           }
        }

        int[] sourceIndex=new int[sourceIndexList.size()];
        int k=0;
        for (int item:sourceIndexList){
            sourceIndex[k++]=item;
        }

        int length=target.length-getLIS(sourceIndex);
        return length;
    }


    public int  getLIS(int[] num){
        if (num.length==0){
            return 0;
        }
        int[] tail=new int[num.length];
        tail[0]=num[0];
        int end=0;

        for (int i=1;i<num.length;i++){
            int target=num[i];
            if (target>tail[end]) {
                end++;
                tail[end] = num[i];
            }

            int left=0;
            int right=end;
            while (left<=right){
                int mid=(left+right)/2;
                if (tail[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

            //left>right
            tail[left]=target;
        }
        return end+1;
    }


    public static void main(String[] args){
        Solution1713 solution1713=new Solution1713();
//        int[] currentSum=new int[]{5,1,3};
//        int[] arr=new int[]{9,4,2,3,4};
//
        int[] target=new int[]{1,3,8};
        int[] arr=new int[]{2,6};
        int length=solution1713.minOperations(target,arr);
        System.out.println(length);
    }
}
