package common.ms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/28
 * @time 8:08 PM
 */
public class Daily0828 {
    public int smallestDivisor(int[] nums, int threshold) {

        Arrays.sort(nums);
        int left  = 1;
        int right = threshold;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int s   = 0;
            for (int item : nums) {
                if (item % mid == 0) {
                    s += item / mid;
                } else {
                    s += ((item / mid) + 1);
                }
            }
            if (s <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public int shortestSubarray(int[] nums, int k) {
        LinkedList<Integer> monoQueue = new LinkedList<>();
        long[]              prefixSum = new long[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (long) nums[i - 1];
        }
//        System.out.println(Arrays.toString(prefixSum));
        //[2,1,3]
        int shortestLen = nums.length + 1;
        for (int i = 0; i < prefixSum.length; i++) {
            if (monoQueue.isEmpty()) {
                monoQueue.add(i);
            } else {
                while (!monoQueue.isEmpty() && prefixSum[monoQueue.getLast()] > prefixSum[i]) {
                    monoQueue.removeLast();
                }
                monoQueue.add(i);

                while (!monoQueue.isEmpty() && prefixSum[monoQueue.getLast()] - prefixSum[monoQueue.getFirst()] >= k) {
                    shortestLen = Math.min(shortestLen, monoQueue.getLast() - monoQueue.getFirst());
                    monoQueue.removeFirst();
                }
            }
        }
        if (shortestLen == nums.length + 1) {
            return -1;
        }
        return shortestLen;
    }


    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int[] dp = new int[time + 1];
        Arrays.fill(dp, clips.length + 1);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int j = 0; j < clips.length; j++) {
                if (clips[j][1] < i) {
                    continue;
                }
                int index = Math.min(clips[j][0], time);
                dp[i] = Math.min(dp[i], dp[index] + 1);
            }
        }
        if (dp[time] == clips.length + 1) {
            return -1;
        } else {
            return dp[time];
        }
    }


    int MOD_VAL = 1337;

    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int item : b) {
            list.add(item);
        }
        return superPow(a, list);
    }

    public int superPow(int a, LinkedList<Integer> b) {
        if (b.isEmpty()) {
            return 1;
        }

        int last = (int) (pow(a, b.removeLast()) % MOD_VAL);

        int temp = (int) (pow(superPow(a, b), 10) % MOD_VAL);

        return (last * temp) % MOD_VAL;
    }

    private long pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        long temp = pow(x, n / 2) % (long) MOD_VAL;
        if ((n & 1) == 1) {
            return (temp * temp * (x % MOD_VAL)) % MOD_VAL;
        }
        return (temp * temp) % MOD_VAL;

    }

    public static void main(String[] args) {
        Daily0828 daily0829 = new Daily0828();
        //[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]
//        int t = daily0829.videoStitching(new int[][]{{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}}, 5);
        int t = daily0829.superPow(2147483647, new int[]{2, 0, 0});
        System.out.println(t);
    }
}
