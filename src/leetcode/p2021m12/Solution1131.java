package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/1
 * @time 10:13 PM
 */
public class Solution1131 {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int maxVal = Integer.MIN_VALUE;

        int len = arr1.length;

        int minA=Integer.MAX_VALUE;
        int maxA=Integer.MIN_VALUE;


        int minB=Integer.MAX_VALUE;
        int maxB=Integer.MIN_VALUE;


        int minC=Integer.MAX_VALUE;
        int maxC=Integer.MIN_VALUE;

        int minD=Integer.MAX_VALUE;
        int maxD=Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int a = arr1[i] + arr2[i] + i;
            minA=Math.min(minA,a);
            maxA=Math.max(maxA,a);
            int b = arr1[i] + arr2[i] - i;
            minB=Math.min(minB,b);
            maxB=Math.max(maxB,b);
            int c = arr1[i] - arr2[i] + i;
            minC=Math.min(minC,c);
            maxC=Math.max(maxC,c);
            int d = arr1[i] - arr2[i] - i;
            minD=Math.min(minD,d);
            maxD=Math.max(maxD,d);
        }

        maxVal=Math.max(maxVal,maxA-minA);
        maxVal=Math.max(maxVal,maxB-minB);
        maxVal=Math.max(maxVal,maxC-minC);
        maxVal=Math.max(maxVal,maxD-minD);
        return maxVal;
    }

    public static void main(String[] args){
        Solution1131 solution1131=new Solution1131();
        int ans=solution1131.maxAbsValExpr(new int[]{1,2,3,4},new int[]{-1,4,5,6});
        System.out.println(ans);
    }
}
