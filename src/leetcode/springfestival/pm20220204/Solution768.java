package leetcode.springfestival.pm20220204;

import leetcode.p2021m06.p20210629.Solution;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 11:27 PM
 */
public class Solution768 {
    public int maxChunksToSorted(int[] arr) {

        int[] copy = arr.clone();
        Arrays.sort(copy);

        int s1 = 0;
        int s2 = 0;

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            s1 += arr[i];
            s2 += copy[i];
            if (s1 == s2) {
                ans++;
                s1 = 0;
                s2 = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution768 solution768=new Solution768();
        int ans=solution768.maxChunksToSorted(new int[]{2,1,3,4,4});
        System.out.println(ans);
    }
}
