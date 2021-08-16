package leetcode.p2021m06.p20210626;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 10:10 AM
 */
public class Solution57I {

    private List<List<Integer>> dataList=new ArrayList<>();
    private int maxSize=-1;
    public int[][] findContinuousSequence(int target) {

        List<Integer> seqList=new ArrayList<>();
        for (int i=1;i<target;i++)
        {
            dfs(target,0,i,seqList);
        }

        int[][] res=new int[dataList.size()][];

        for (int i=0;i<dataList.size();i++)
        {
            List<Integer> secondList=dataList.get(i);

            int[] cols=new int[secondList.size()];
            for (int j=0;j<secondList.size();j++){

                cols[j]=secondList.get(j);
            }
            res[i]=cols;
        }
        return res;

    }

    private void dfs(final int target,int sum,int current,List<Integer> seqList){
        if (target==sum+current){
            if (seqList.isEmpty()){
                return;
            }else {
                List<Integer> newList = new ArrayList<>();
                for (Integer item:seqList)
                {
                    newList.add(item);
                }
                newList.add(current);
                maxSize=Math.max(maxSize,newList.size());
                dataList.add(newList);
            }
        }else if (sum+current<target) {
            seqList.add(current);
            dfs(target, sum + current, current + 1, seqList);
            seqList.remove(seqList.size() - 1);
        }
    }

    public static void main(String[] args){
        Solution57I solution57 =new Solution57I();
        int[][]     ans        =solution57.findContinuousSequence(15);
    }

}

