package leetcode.p2023m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/5
 * @time 8:27 PM
 */
public class Solution1802 {
    public int maxValue(int n, int index, int maxSum) {
        long left  = 1;
        long right = maxSum;

        while (left <= right) {
            long mid = (left + right) / 2;


            long rightSum = getSum(mid, n - index);

            //0 index
            long leftSum = getSum(mid, index + 1);

//            System.out.println("sum:" + leftSum + " " + rightSum);

            if (leftSum + rightSum - mid > maxSum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }


    private long getSum(long target, long cnt) {

        if (cnt<target){
            return (2*target-cnt+1)*cnt/2;
        }
        return (1+target)*target/2+cnt-target;
    }


    public static void main(String[] args) {
        Solution1802 solution1802 = new Solution1802();
        System.out.println(solution1802.maxValue(6, 2, 931384943));
    }
}
