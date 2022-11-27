package leetcode.p2022q4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/27
 * @time 9:27 PM
 */
public class Solution6251 {
    public int countPalindromes(String s) {
        int[] left  = new int[100];
        int[] right = new int[100];
        int   MOD   = (int) (1e9 + 7);

        Map<Integer, Integer> leftFreq  = new HashMap<>();
        Map<Integer, Integer> rightFreq = new HashMap<>();

        Map<Integer, int[]> leftMap  = new HashMap<>();
        Map<Integer, int[]> rightMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                left[j * 10 + num] += leftFreq.getOrDefault(num, 0);
            }
            leftMap.put(i, left.clone());
            Arrays.fill(left, 0);
            leftFreq.put(num, leftFreq.getOrDefault(num, 0) + 1);
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                right[num * 10 + j] += rightFreq.getOrDefault(num, 0);
            }
            rightMap.put(i, right.clone());
            Arrays.fill(right, 0);
            rightFreq.put(num, rightFreq.getOrDefault(num, 0) + 1);
        }


        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] l = leftMap.get(i - 1);
            int[] r = rightMap.get(i + 1);

            for (int t = 0; t < 100; t++) {
                int newT=(t%10)*10+t/10;
                System.out.println(newT);
                ans += (l[t] * r[newT]) % MOD;
            }
        }
        return (int) ans;

    }

    public static void main(String[] args){
        Solution6251 solution6251=new Solution6251();
        int ans=solution6251.countPalindromes("103301");
        System.out.println(ans);
    }
}
