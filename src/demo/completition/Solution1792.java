package demo.completition;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/24
 * @time 10:38 AM
 */
public class Solution1792 {
//    private double maxAvgRate=Double.MIN_VALUE;
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double rate1=(o1[0]+1)*1.0/(o1[1]+1)-o1[0]*1.0/o1[1];
                double rate2=(o2[0]+1)*1.0/(o2[1]+1)-o2[0]*1.0/o2[1];
                if (rate1>rate2)
                {
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        for (int i=0;i<classes.length;i++){
            queue.add(classes[i]);
        }
        int stuCount=extraStudents;
        while (stuCount>0){
            int[] temp=queue.poll();
            int p=temp[0]+1;
            int q=temp[1]+1;
//            System.out.println(p+" "+q);
            queue.add(new int[]{p,q});
            stuCount--;
        }
        double sum=0;
        int len=classes.length;
        while (!queue.isEmpty()){
            int[] ele=queue.poll();
//            System.out.println(ele[0]+"=>"+ele[1]);
            sum+=ele[0]*1.0/ele[1];
        }

        return sum/len;

    }




    public static void main(String[] args){
        Solution1792 solution1792=new Solution1792();
//        double max=solution1792.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}},2);
        double max=solution1792.maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}},4);
        System.out.println(max);
    }
}
