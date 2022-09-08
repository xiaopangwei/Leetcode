package common.ms;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/9/4
 * @time 2:53 PM
 */
public class Daily0904 {
    public String reformat(String s) {
        List<Character> digitFreq = new ArrayList<>();
        List<Character> charFreq  = new ArrayList<>();

        int m = 0;
        int n = 0;
        for (char c : s.toCharArray()) {

            if (c >= '0' && c <= '9') {
                digitFreq.add(c);
                m++;
            } else {
                charFreq.add(c);
                n++;
            }
        }

        if (Math.abs(m - n) > 1) {
            return "";
        }


        StringBuilder sb = new StringBuilder();
        if (m > n) {
            sb.append(digitFreq.remove(0));
        }

        while (!digitFreq.isEmpty() && !charFreq.isEmpty()) {
            sb.append(charFreq.remove(0));
            sb.append(digitFreq.remove(0));
        }

        while (!digitFreq.isEmpty()) {
            sb.append(digitFreq.remove(0));
        }


        while (!charFreq.isEmpty()) {
            sb.append(charFreq.remove(0));
        }


        return sb.toString();

    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 < 0) {
                if (nums[mid + 1] < nums[mid]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (mid + 1 >= nums.length) {
                if (nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] <= nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    int                modVal = 1000000007;
    Map<Integer, Long> freq   = new HashMap<>();

    public int numDecodings(String s) {
        return (int) (dfs(s, 0) % modVal);
    }

    private long dfs(String s, int index) {
        if (freq.containsKey(index)) {
            return freq.get(index);
        }
        if (index >= s.length()) {
            return 1;
        }
        char ch = s.charAt(index);
        if (ch == '0') {
            return 0;
        }
        long ans = 0;
        if (s.charAt(index) == '*') {
            ans = dfs(s, index + 1) * (long) 9;
        } else {
            ans = dfs(s, index + 1);
        }
        if (index + 1 < s.length()) {
            long t = getNumsWithTwoDigits(s.charAt(index), s.charAt(index + 1));
            long p = dfs(s, index + 2);
            ans += ((t % modVal) * (p % modVal)) % modVal;
        }
        freq.put(index, ans);
        return ans;
    }


    private int getNumsWithTwoDigits(char f, char s) {
        if (f == '*') {
            //11-19 9
            //21-26 6
            if (s == '*') {
                return 15;
            } else if (s >= '0' && s <= '6') {
                return 2;
            } else if (s >= '7') {
                return 1;
            } else {
                return 0;
            }
        } else if (f == '0') {
            return 0;
        } else if (f == '1') {
            if (s == '*') {
                return 9;
            } else {
                return 1;
            }
        } else if (f == '2') {
            if (s == '*') {
                return 6;
            } else if (s >= '0' && s <= '6') {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }


    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!posMap.containsKey(nums2[i])) {
                posMap.put(nums2[i], new ArrayList<>());
            }
            posMap.get(nums2[i]).add(i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int val = posMap.get(nums1[i]).remove(0);
            ans[i] = val;
        }

        return ans;
    }


    public int lenLongestFibSubseq(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int     maxLen = 0;
        int     n      = arr.length;
        int[][] dp     = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 2;
                }
            }
        }

        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            posMap.put(arr[i], i);
        }
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int val = arr[i] - arr[j];
                if (posMap.containsKey(val) && val < j) {
                    int k = posMap.get(val);
                    if (arr[i] == arr[k] + arr[j]) {
                        dp[j][i] = Math.max(dp[j][i], dp[k][j] + 1);
                        maxLen = Math.max(maxLen, dp[j][i]);
                    }
                }
            }
        }

        if (maxLen >= 3) {
            return maxLen;
        }
        return 0;

    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int minLen     = Integer.MAX_VALUE;
        int startIndex = -1;
        int left       = 0;
        int right      = 0;

        Map<Character, Integer> sFreq = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tFreq.containsKey(c)) {
                sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
            }
            while (left <= right && isCover(sFreq, tFreq)) {
//                System.out.println(s.substring(left, right + 1));
//                System.out.println(sFreq);
                if (right - left + 1 < minLen) {
                    minLen = Math.min(minLen, right - left + 1);
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                if (sFreq.containsKey(leftChar)) {
                    if (sFreq.get(leftChar) > 1) {
                        sFreq.put(leftChar, sFreq.get(leftChar) - 1);
                    } else {
                        sFreq.remove(leftChar);
                    }
                }

                left++;
            }
            right++;
        }

//        System.out.println(left + " => " + minLen);

        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(startIndex, startIndex + minLen);
        }
    }


    private boolean isCover(Map<Character, Integer> f1, Map<Character, Integer> f2) {
        for (Map.Entry<Character, Integer> entry : f2.entrySet()) {
            int  f = entry.getValue();
            char k = entry.getKey();
            if (f1.getOrDefault(k, 0) < f) {
                return false;
            }
        }
        return true;
    }

    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (char item : s.toCharArray()) {
            if ('A' == item) {
                x = x * 2 + y;
            } else {
                y = 2 * y + x;
            }
        }
        return x + y;
    }

    class BiKey {
        int[]  array;
        String direction;

        public BiKey(int[] array, String direction) {
            this.array = array;
            this.direction = direction;
        }
    }

    static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Queue<BiKey> queue = new LinkedList<>();
        queue.add(new BiKey(ball, ""));
        String ans = null;
        while (!queue.isEmpty()) {
            BiKey  biKey     = queue.poll();
            int[]  temp      = biKey.array;
            String direction = biKey.direction;
            if (temp[0] == hole[0] && temp[1] == hole[1]) {
                if (ans == null) {
                    ans = direction;
                } else {
                    if (direction.compareTo(ans) < 0) {
                        ans = direction;
                    }
                }
            }


            for (int i = 0; i < directions.length; i++) {
                int x = temp[0];
                int y = temp[1];
                while (isValid(x, y, maze) && isNotHole(temp, x, y)) {
                    x = x + directions[i][0];
                    y = y + directions[i][1];
                }

                if (isValid(x, y, maze)) {
                    queue.add(new BiKey(new int[]{x, y}, direction + i));
                }
                if (isNotHole(temp, x, y)) {
                    if (temp[0] == hole[0] && temp[1] == hole[1]) {
                        if (ans == null) {
                            ans = direction;
                        } else {
                            if (direction.compareTo(ans) < 0) {
                                ans = direction;
                            }
                        }
                    }
                }
            }

        }
        return ans;
    }


    private boolean isValid(int x, int y, int[][] maze) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }
        return true;
    }

    private boolean isNotHole(int[] temp, int x, int y) {
        return temp[0] == x && temp[1] == y;
    }

    public static void main(String[] args) {
        Daily0904 daily0904 = new Daily0904();
        System.out.println(daily0904.findShortestWay(
                new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}},
                new int[]{4, 3},
                new int[]{0, 1}));
//        System.out.println(daily0904.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
