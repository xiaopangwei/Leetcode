package leetcode.p2021m09;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 1:08 PM
 */
public class Solution360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        LinkedList<Integer> list = new LinkedList<>();
        if (a == 0) {
            if (b > 0) {
                for (int i = 0; i < nums.length; i++) {
                    list.add(b * nums[i] + c);
                }
            } else {
                for (int i = nums.length - 1; i >= 0; i--) {
                    list.add(b * nums[i] + c);
                }
            }

        } else {
            if (a > 0) {
                int i = 0;
                int j = nums.length - 1;

                while (i <= j) {
                    int x = a * nums[i] * nums[i] + b * nums[i] + c;
                    int y = a * nums[j] * nums[j] + b * nums[j] + c;
                    if (i != j) {
                        if (x < y) {
                            list.addFirst(y);
                            j--;
                        } else if (x > y) {
                            list.addFirst(x);
                            i++;
                        } else {
                            list.addFirst(y);
                            list.addFirst(y);
                            i++;
                            j--;
                        }

                    } else {
                        list.addFirst(x);
                        break;
                    }
                }
            } else {
                int i = 0;
                int j = nums.length - 1;

                while (i <= j) {
                    int x = a * nums[i] * nums[i] + b * nums[i] + c;
                    int y = a * nums[j] * nums[j] + b * nums[j] + c;
                    if (i != j) {
                        if (x < y) {
                            list.addLast(x);
                            i++;
                        } else if (x > y) {
                            list.addLast(y);
                            j--;
                        } else {
                            list.addLast(y);
                            list.addLast(y);
                            i++;
                            j--;
                        }

                    } else {
                        list.addLast(x);
                        break;
                    }
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args){
        Solution360 solution360=new Solution360();

        int[] ans=solution360.sortTransformedArray(new int[]{-4,-2,2,4},-1,3,5);
        System.out.println(Arrays.toString(ans));
    }


}
