package leetcode.p20210209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        List<int[]> data=Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int diff1=o1[0]-o2[0];
                if (diff1!=0){
                    return diff1;
                }
                else{
                    return o1[1]-o2[1];
                }
            }
        }).collect(Collectors.toList());

        List<int[]> result=new ArrayList<>();
        if (intervals.length>0) {
            result.add(data.get(0));
        }
        else {
            return null;
        }
        for (int[] array:data){
            boolean flag=false;
            int max=result.get(result.size()-1)[1];
            int x = array[0];
            int y = array[1];
            if (x>max){
                result.add(new int[]{x,y});
            }
            else{
                result.get(result.size()-1)[1]=Math.max(y,result.get(result.size()-1)[1]);
            }

        }

        int len=result.size();
        int[][] res=new int[len][2];
        for (int i=0;i<len;i++){
            res[i]=result.get(i);
        }
        return res;
    }
    public static void main(String[] args){
        //[[1,3],[2,6],[8,10],[15,18]]
//        int[][] test=new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] test=new int[][]{{1,4},{4,5}};
//        int[][] test=new int[][]{{1,4},{0,5}};
        int[][] test=new int[][]{{1,4},{0,4}};
//                int[][] test=new int[][]{{4,5},{1,4},{0,1}};
        Solution solution=new Solution();
        int[][] ans=solution.merge(test);
        for (int[] a:ans){
            System.out.println(a[0]+"==>"+a[1]);

        }

    }
}
