package leetcode.p20210312;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/12
 * @time 2:26 PM
 */
public class Solution315 {

    private  Map<Integer,Integer> counter=new LinkedHashMap<>();
    private  Map<Integer,Integer> refMap=new HashMap<>();
    public List<Integer> countSmaller(int[] nums) {

        int len=nums.length;

        for (int i=0;i<len;i++){
            counter.put(i,0);
            refMap.put(i,i);
        }

        mergetSort(nums,0,len-1);

        return counter.entrySet().stream().map(item->item.getValue()).collect(Collectors.toList());


    }


    private void mergetSort(int[] num,int start,int end){

        if (start==end){
            return ;
        }


        int mid=start+(end-start)/2;
        //[start,mid]
        mergetSort(num,start, mid);
        //[mid+1,end]
        mergetSort(num,mid+1,end);

        merge(num,start,mid,end);


    }


    private void merge(int[] num,int start,int mid,int end){

        int i=start;
        int j=mid+1;

        int count=0;

        int[] sorted=new int[end-start+1];

        while (i<=mid && j<=end){

            if (num[i]>num[j]){
                sorted[count++]=j;
                j++;
                counter.put(reverseSearch(i),counter.get(reverseSearch(i))+(j-mid));
            }
            else if(num[i]==num[j]){
                sorted[count++]=i;
                sorted[count++]=j;
                i++;
                j++;
            }
            else{
                sorted[count++]=i;
                i++;
            }
        }

        if (i<=mid)
        {
            int len=end-mid-1;
            int k=i;
            for (;k<=mid;k++){
                counter.put(reverseSearch(i),counter.get(reverseSearch(i))+len);
                sorted[count++]=k;
            }

        }

        if (j<=end){
            int k=j;
            for (;k<=end;k++){
                sorted[count++]=k;
            }

        }

        int con=0;
        int[] copyArray=num.clone();
        for (int a=start;a<=end;a++){
            int index=sorted[con++];
            refMap.put(a,index);
            num[a]=copyArray[index];
        }

        System.out.println("refMap:"+refMap);
        System.out.println("counter:"+counter);
        System.out.println("nums:"+Arrays.toString(num));

    }
    public static void main(String[] args){
        Solution315 solution315=new Solution315();
        List<Integer> result=solution315.countSmaller(new int[]{5,2,6,1});
        System.out.println(result);
    }

    private Integer reverseSearch(int value){
        for (Map.Entry<Integer,Integer> entry:refMap.entrySet()){
            if (entry.getValue().equals(value)){
                return entry.getKey();
            }
        }
        return -1;
    }
}
