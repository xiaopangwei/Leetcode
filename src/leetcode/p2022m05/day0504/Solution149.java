package leetcode.p2022m05.day0504;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 7:09 PM
 */
public class Solution149 {

    private int max=0;
    public int maxPoints(int[][] points) {

        for (int i = 0; i < points.length; i++) {

            Map<String,Integer> map=new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {

                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                int k=gcd(deltaX,deltaY);
                String key=(deltaX/k)+"#"+(deltaY/k);
                int temp=map.getOrDefault(key,0)+1;
                map.put(key,temp);
                max=Math.max(max,temp);
            }
//            System.out.println(i+" "+map);
        }
        return max+1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args){
        Solution149 solution149=new Solution149();
        //[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        int ans=solution149.maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}});
        System.out.println(ans);

    }
}
