package leetcode.p2022q4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/27
 * @time 10:56 PM
 */
public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });


        int trunkSum=0;
        int ans=0;
        for (int i=0;i<boxTypes.length;i++){
            if (trunkSum+boxTypes[i][0]<truckSize){
                trunkSum+=boxTypes[i][0];
                ans+=boxTypes[i][0]*boxTypes[i][1];
            }else {
                ans+=(truckSize-trunkSum)*boxTypes[i][1];
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution1710 solution1710=new Solution1710();

        int ans=solution1710.maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},10);
        System.out.println(ans);
    }
}
