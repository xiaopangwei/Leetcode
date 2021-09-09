package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 11:19 PM
 */
public class Solution1228 {
    public int missingNumber(int[] arr) {

        int minVal = arr[0];
        int maxVal = arr[arr.length-1];

        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp += arr[i];
        }
        int headAndTailSum = minVal + maxVal;
        int sum            = 0;
        int len            = arr.length;
        if (len % 2 == 0) {
            sum = (len / 2) * headAndTailSum + headAndTailSum / 2;
        } else {
            sum = (len + 1) / 2 * headAndTailSum;
        }
        return sum - temp;
    }

    public static void main(String[] args){
        Solution1228 solution1228=new Solution1228();
        int ans=solution1228.missingNumber(new int[]{15,13,12});
        System.out.println(ans);
    }
}
