package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 1:56 PM
 */
public class Solution76 {
    public String minWindow(String s, String t) {

        int length=s.length();
        if (s.length()<length){
            return "";
        }

        Map<Character,Integer> targetMap=new HashMap<>();
        for (int i=0;i<=t.length()-1;i++){
            targetMap.put(t.charAt(i),targetMap.getOrDefault(t.charAt(i),0)+1);
        }

        int needCount=t.length();

        int left=0;
        int right=0;
        int startPos=-1;
        int minLen=Integer.MAX_VALUE;
        if (targetMap.containsKey(s.charAt(left))){
            needCount--;
            targetMap.put(s.charAt(left),targetMap.get(s.charAt(left))-1);
        }
        while (right<=length-1){

            if (needCount<=0){
                int  currentLen=right-left+1;
                if (currentLen<minLen){
                    startPos=left;
                    minLen=currentLen;
                }

                while (left<=right){
                    if (targetMap.containsKey(s.charAt(left))){
                        needCount++;
                        targetMap.put(s.charAt(left),targetMap.get(s.charAt(left))-1);
                    }
                    left++;
                    if (needCount!=0){
                        break;
                    }else{
                        startPos=left;
                        currentLen=right-left+1;
                        if (currentLen<minLen){
                            startPos=left;
                            minLen=currentLen;
                        }
                    }
                }

            }

            if (targetMap.containsKey(s.charAt(right))){
                int temp=targetMap.get(s.charAt(right));
                if (temp>0){
                    targetMap.put(s.charAt(right),temp-1);
                    needCount--;
                }
            }
        }

        if (startPos<0)
        {
            return "";
        }
        String res=s.substring(startPos,startPos+minLen);
        return res;
    }

    private boolean isCover(String src,int start,int end,String target,Map<Character,Integer> map2){
        if (end-start+1<target.length()){
            return false;
        }
        Map<Character,Integer> map1=new HashMap<>();


        for (int i=start;i<=end;i++){
            map1.put(src.charAt(i),map1.getOrDefault(src.charAt(i),0)+1);
        }

        for (Character key:map2.keySet()){
            if (map1.getOrDefault(key,0)<map2.get(key)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution76 solution76=new Solution76();
        String src="ADOBECODEBANC";
        String target="ABC";
        System.out.println(solution76.minWindow(src,target));
    }
}
