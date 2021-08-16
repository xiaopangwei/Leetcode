package leetcode.p20210708;

import java.util.*;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/11
 * @time 10:43 AM
 */
public class Solution274 {
    public int hIndex(int[] citations) {
        //0 0 3 3 6
        // 5 4 2
        Arrays.sort(citations);
        for (int i=citations.length-1;i>=0;i--){
            int hIndex=i+1;
            //>=hIndex
                int cnt=0;
               for (int j=citations.length-1;j>=0;j--){
                   if (citations[j]>=hIndex)
                   {cnt++;}
                   else
                   {
                       break;
                   }
               }
               if(cnt>=hIndex){
                   return hIndex;
               }
        }

        boolean flag=true;
        for (int i=citations.length-1;i>=0;i--){
            if (citations[i]<citations.length){
                flag=false;
            }
        }
        if (flag){
            return citations.length;
        }
        return 0;
    }

    public static void main(String[] args){
        Solution274 solution274=new Solution274();
        int a=solution274.hIndex(new int[]{11,15,4});
        System.out.println(a);
    }
}
