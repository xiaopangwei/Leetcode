package leetcode.p2021m07;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 9:30 AM
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {

        int length=matrix.length;
        int count=0;
        Queue<int[]> queue=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        for (int i=0;i<length;i++){
            queue.add(new int[]{matrix[i][0],i,0});
        }


        while (!queue.isEmpty()){
            int[] temp=queue.poll();
            count++;
            if (count==k){
                return temp[0];
            }else{
                int rowIndex=temp[1];
                int colsIndex=temp[2];
                if (colsIndex<length-1) {
                    queue.add(new int[]{matrix[rowIndex][colsIndex+1], rowIndex, colsIndex+1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Solution378 solution378=new Solution378();
        int ans=solution378.kthSmallest(new int[][]{{1,3,5},{6,7,12},{11,14,14}},6);
        System.out.println(ans);
    }
}
