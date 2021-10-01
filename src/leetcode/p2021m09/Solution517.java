package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/29
 * @time 10:25 PM
 */
public class Solution517 {
    public int findMinMoves(int[] machines) {

        int sum = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }

        int len = machines.length;

        if (sum % len != 0) {
            return -1;
        }

        int target = sum / len;

        int maxStep = Integer.MIN_VALUE;

        int[] diff = new int[machines.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = machines[i]-target;
        }

        int balance=0;
        for (int i = 0; i < diff.length; i++) {


            balance+=diff[i];
            maxStep=Math.max(Math.abs(balance),maxStep);
            maxStep=Math.max(machines[i]-target,maxStep);

        }
        return maxStep;


    }

    public static void main(String[] args) {
        Solution517 solution517 = new Solution517();
        int         ans         = solution517.findMinMoves(new int[]{1,0,5});
        System.out.println(ans);
    }
}
