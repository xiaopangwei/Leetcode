package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/26
 * @time 8:56 AM
 */
public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {

        // 3 3 4 5
        // 1 2 2 3
        Arrays.sort(people);
        int left  = 0;
        int right = people.length - 1;
        int ans   = 0;
        while (left <= right) {
            if (left == right) {
                ans += 1;
                break;
            }
            if (people[left] + people[right] <= limit) {
                ans += 1;
                left++;
                right--;

            } else {
                ans += 1;
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Solution881 solution881=new Solution881();
        int ans=solution881.numRescueBoats(new int[]{3,3,4,5},5);
        System.out.println(ans);
    }
}
