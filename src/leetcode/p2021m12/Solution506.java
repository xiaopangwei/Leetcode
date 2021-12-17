package leetcode.p2021m12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/2
 * @time 10:02 PM
 */
public class Solution506 {
    public String[] findRelativeRanks(int[] score) {

        int[] copy=score.clone();
        Arrays.sort(copy);
        Map<Integer,Integer> map=new HashMap<>();
        int i=1;
        for (int item:copy){
            map.put(item,i++);
        }

        int len=score.length;
        String[] ans=new String[len];

        for (int j=0;j<len;j++){
            int index=len-map.get(score[j])+1;
            if (index==1){
                ans[j]="Gold Medal";
            }else if (index==2){
                ans[j]="Silver Medal";
            }else if (index==3){
                ans[j]="Bronze Medal";
            }else{
                ans[j]=String.valueOf(index);
            }
        }
        return ans;

    }

    public static void main(String[] args){
        Solution506 solution506=new Solution506();
        String[] ans=solution506.findRelativeRanks(new int[]{5,4,3,2,1});
        System.out.println(Arrays.toString(ans));
    }
}
