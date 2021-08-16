package leetcode.p20210701;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/3
 * @time 11:18 AM
 */
public class Solution907 {
    // 3 1 2 4
    public int sumSubarrayMins(int[] arr) {

        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<arr.length;i++){
                while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                    left[i] = stack.pop();
                }
            //A[i]>=A[peek]
            if (stack.isEmpty()){
                    left[i]=-1;
            }else{
                left[i]=stack.peek();
            }

            stack.push(i);
        }


       stack.clear();

        int MOD = 1_000_000_007;
        for (int i=arr.length-1;i>=0;i--){
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            //A[peek]>=A[i]
            if (stack.isEmpty()){
                right[i]=arr.length;
            }else{
                right[i]=stack.peek();
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        long sum=0;
        for (int i=0;i<arr.length;i++){
            long r1=arr[i]*(right[i]-i)%MOD;
            long r2=(i-left[i])%MOD;
            sum+=(r1*r2)%MOD;
            sum=sum%(MOD);
        }
        return (int)(sum);
    }


    public static void main(String[] args){
        Solution907 solution907=new Solution907();
//        71,55,82,55
        int ret=solution907.sumSubarrayMins(new int[]{71,55,82,55});
        System.out.println(ret);
    }
}

