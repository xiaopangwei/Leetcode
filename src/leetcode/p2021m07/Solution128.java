package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/21
 * @time 10:54 PM
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {

        if (nums.length<=1){
            return nums.length;
        }
        int maxLen=1;
        Map<Integer,List<Integer>> numberAndLengthRefMap =new HashMap<>();

        for (int i=0;i<nums.length;i++){
            int num=nums[i];
            if (numberAndLengthRefMap.containsKey(num)){
                continue;
            }

            List<Integer> defaultList= Arrays.asList(1,1);
            numberAndLengthRefMap.put(num,defaultList);

            if (numberAndLengthRefMap.containsKey(num-1) && numberAndLengthRefMap.containsKey(num+1)){
//                System.out.println(num+" "+"+++1");
                 List<Integer> prev=numberAndLengthRefMap.get(num-1);
                 List<Integer> next=numberAndLengthRefMap.get(num+1);

                 defaultList.set(0,next.get(0)+1);
                 defaultList.set(1,prev.get(1)+1);


                 int newLength=prev.get(1)+1+next.get(0);

                 //左边
                 int startIndex=num-1-(prev.get(1))+1;
                 //右边
                 int endIndex=num+1+(next.get(0))-1;

                 maxLen=Math.max(maxLen,newLength);
//                 numberAndLengthRefMap.put(startIndex,newLength);
                addDelta(numberAndLengthRefMap,startIndex,0,newLength);
                addDelta(numberAndLengthRefMap,endIndex,1,newLength);
            }

            else if (numberAndLengthRefMap.containsKey(num-1)){
//                System.out.println(num+" "+"+++2");
                List<Integer> prev=numberAndLengthRefMap.get(num-1);
                int newLength=prev.get(1)+1;
                int startIndex=num-1-prev.get(1)+1;
                maxLen=Math.max(maxLen,newLength);
                addDelta(numberAndLengthRefMap,startIndex,0,newLength);
                defaultList.set(1,newLength);

            }else if (numberAndLengthRefMap.containsKey(num+1)){
//                System.out.println(num+" "+"+++3");
                List<Integer> next=numberAndLengthRefMap.get(num+1);
                int newLength=next.get(0)+1;
                int endIndex=num+1+next.get(0)-1;
                maxLen=Math.max(maxLen,newLength);
                addDelta(numberAndLengthRefMap,endIndex,1,newLength);
                defaultList.set(0,newLength);
            }
//            System.out.println("index:"+i+" number:"+num+" "+numberAndLengthRefMap);
        }

        return maxLen;
    }

    private void addDelta(Map<Integer,List<Integer>> map,int key,int index,int newValue){

        map.get(key).set(index,newValue);
    }

    public static void main(String[] args){
        Solution128 solution128=new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{100,4,200,1,3}));
    }
}
