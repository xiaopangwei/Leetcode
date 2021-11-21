package leetcode.p2021m11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/9
 * @time 10:02 PM
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> dist =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]*o1[0]+o1[1]*o1[1]-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });

        for (int[] item:points){
            dist.add(new int[]{item[0],item[1]});
        }

        int index=0;
        int[][] res=new int[k][2];
        for (int i=0;i<k;i++){
            int[] temp=dist.poll();
            res[index][0]=temp[0];
            res[index][1]=temp[1];
            index++;
        }

        return res;
    }

    public static void main(String[] args){
        Solution973 solution973=new Solution973();
        int[][] res=solution973.kClosest(new int[][]{{3,3},{5,-1},{-2,4}},2);
        for (int i=0;i<res.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
