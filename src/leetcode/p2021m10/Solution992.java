package leetcode.p2021m10;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/10
 * @time 12:39 PM
 */
public class Solution992 {


    public int subarraysWithKDistinct(int[] A, int K) {


        int ans = getCount(A, K) - getCount(A, K - 1);
        return ans;

    }


    private int getCount(int[] A, int K) {
        if (K==0){
            return 0;
        }
        Map<Integer, Integer> freq = new HashMap<>();

        int left  = 0;
        int right = 0;

        int count = 0;

        while (left < A.length) {
            if (freq.keySet().size() < K) {
                if (right >= A.length) {
                    break;
                }
                freq.put(A[right], freq.getOrDefault(A[right], 0) + 1);
                right++;
                count += (right - left);
            } else {
                if (right >= A.length) {
                    break;
                }
                if (freq.keySet().contains(A[right])) {
                    freq.put(A[right], freq.getOrDefault(A[right], 0) + 1);
                    right++;
                    count += (right - left);
                } else {
                    while (left < A.length) {
                        int f = freq.get(A[left]);
                        if (f > 1) {
                            freq.put(A[left], f - 1);
                        } else {
                            freq.remove(A[left]);
                        }
                        left++;
                        if (freq.keySet().size() < K) {
                            break;
                        }
                    }
                    freq.put(A[right], freq.getOrDefault(A[right], 0) + 1);
                    right++;
                    count += (right - left);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution992 solution992 = new Solution992();
        int         ans         = solution992.subarraysWithKDistinct(new int[]{2,1,2,1,1}, 3);
        System.out.println(ans);
    }
}
