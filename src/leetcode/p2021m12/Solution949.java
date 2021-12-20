package leetcode.p2021m12;

import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 4:27 PM
 */
public class Solution949 {
    //[1,2,3,4]
    //[0,0,1,0]

    private boolean help(final TreeMap<Integer, Integer> freq, int key, final int[] ans, int index) {
        Integer k = freq.floorKey(key);
        if (k == null) {
            return false;
        } else {
            ans[index] = k;
            int newFreq = freq.getOrDefault(k, 0) - 1;
            if (newFreq > 0) {
                freq.put(k, newFreq);
            } else {
                freq.remove(k);
            }
            return true;
        }
    }

    public String largestTimeFromDigits(int[] arr) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        int                       cnt  = 0;
        for (int item : arr) {
            if (item > 5) {
                cnt++;
            }
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        int[] ans = new int[4];
        if (cnt >= 2) {
            int max = -1;
            for (int i = 0; i < 4; i++) {
                ans[i] = -1;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        int l      = 6 - i - j - k;
                        int hour   = arr[i] * 10 + arr[j];
                        int minute = arr[k] * 10 + arr[l];
                        if (hour < 24 && minute < 60) {
                            if (hour * 60 + minute > max) {
                                ans[0] = arr[i];
                                ans[1] = arr[j];
                                ans[2] = arr[k];
                                ans[3] = arr[l];
                                max = hour * 60 + minute;
                            }
                        }
                    }
                }
            }
        } else {
            boolean flag = true;
            flag = help(freq, 2, ans, 0);
            if (!flag) {
                return "";
            }

            if (ans[0] != 2) {
                flag = help(freq, 9, ans, 1);
                if (!flag) {
                    return "";
                }
            } else {
                flag = help(freq, 3, ans, 1);
                if (!flag) {
                    return "";
                }
            }

            flag = help(freq, 5, ans, 2);
            if (!flag) {
                return "";
            }

            flag = help(freq, 9, ans, 3);
            if (!flag) {
                return "";
            }
        }

        if (ans[0]==-1 && ans[1]==-1 && ans[2]==-1 && ans[3]==-1){
            return "";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(ans[0]);
        builder.append(ans[1]);
        builder.append(":");
        builder.append(ans[2]);
        builder.append(ans[3]);
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution949 solution949 = new Solution949();
        String      ans         = solution949.largestTimeFromDigits(new int[]{4, 8, 8, 8});
        System.out.println(ans);
    }


}
