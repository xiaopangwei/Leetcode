package leetcode.p20210626;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 10:10 AM
 */
public class Solution57II {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> pos=new ArrayList<>();
        int left=1;
        int sum=0;
        int right=1;
        //[left,right)

        while (true){
            if (left>=target || right>=target){
                break;
            }
            while (sum<target){
                sum+=right;
                right+=1;
            }
            if (sum==target){
                List<Integer> startEndPos=new ArrayList<>();
                for (int i=left;i<right;i++)
                {
                    startEndPos.add(i);
                }
                pos.add(startEndPos);
            }
            left++;
            right=left;
            sum=0;
        }


        int rows=pos.size();
        int[][] ans=new int[rows][];
        for (int i=0;i<rows;i++){
            List<Integer> colsList=pos.get(i);
            int[] colArray=new int[colsList.size()];
            for (int j=0;j<colsList.size();j++){
                colArray[j]=colsList.get(j);
            }
            ans[i]=colArray;
        }
        return ans;
    }



    public static void main(String[] args){
        Solution57II solution57 =new Solution57II();
        int[][]      ans        =solution57.findContinuousSequence(9);
        for (int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }

}

