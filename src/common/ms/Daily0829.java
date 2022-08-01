package common.ms;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/29
 * @time 9:15 PM
 */
public class Daily0829 {

    interface ArrayReader {
        public int get(int index);

    }

    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) {
            return 0;
        }
        int idx   = 1;
        int left  = -1;
        int right = -1;
        while (reader.get(idx) < target) {
            left = idx;
            idx <<= 1;
        }
        right = idx;

        if (reader.get(right) == target) {
            return right;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    public boolean increasingTriplet(int[] nums) {
        int firstMin  = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < firstMin) {
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            } else if (nums[i] > secondMin) {
                return true;
            }
        }
        return false;
    }


    Map<String, Integer> cached = new HashMap<>();


    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int r : rods) {
            sum += r;
        }
        return dfs(rods, 0, 0, 0, sum);
    }

    public int findJudge(int n, int[][] trust) {
        //不可能
        boolean[] flag1 = new boolean[n + 1];
        //可能
        boolean[] flag2 = new boolean[n + 1];
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            //a 相信 b
            flag1[a] = true;
            flag2[b] = true;
        }

        System.out.println(Arrays.toString(flag1));
        System.out.println(Arrays.toString(flag2));

        for (int i = 1; i <= n; i++) {
            if (!flag1[i] && flag2[i]) {

                for (int j = 0; j < trust.length; j++) {
                    if (trust[j][0] == i) {

                    }

                }
                return i;
            }


        }

        return -1;
    }

    private int dfs(int[] rods, int startIndex, int currentSum1, int currentSum2, int remained) {
        if (Math.abs(currentSum1 - currentSum2) > remained) {
            return 0;
        }
        String biKey = startIndex + "#" + currentSum1 + "#" + currentSum2;
        if (currentSum1 == currentSum2 && currentSum1 != 0) {
            cached.put(biKey, currentSum1);
            return currentSum1;
        }
        if (startIndex >= rods.length) {
            return 0;
        }

        int flag1 = dfs(rods, startIndex + 1, currentSum1 + rods[startIndex], currentSum2, remained - rods[startIndex]);
        int flag2 = dfs(rods, startIndex + 1, currentSum1, currentSum2, remained);
        int flag3 = dfs(rods, startIndex + 1, currentSum1, currentSum2 + rods[startIndex], remained - rods[startIndex]);
        int res   = Math.max(flag1, Math.max(flag2, flag3));
        cached.put(biKey, res);
        return res;
    }


    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public double minAreaFreeRect(int[][] points) {

        Set<Point> pointSet = new HashSet<>();
        for (int[] item : points) {
            pointSet.add(new Point(item[0], item[1]));
        }
        double minVal = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] xvector = new int[]{points[j][0] - points[i][0], points[j][1] - points[i][1]};
                    int[] yvector = new int[]{points[k][0] - points[i][0], points[k][1] - points[i][1]};
                    int   dot     = xvector[0] * yvector[0] + xvector[1] * yvector[1];
                    if (dot != 0) {
                        continue;
                    }
                    int x = points[j][0] + points[k][0] - points[i][0];
                    int y = points[j][1] + points[k][1] - points[i][1];


                    if (pointSet.contains(new Point(x, y))) {
                        System.out.println(i+" "+j+" "+k+" ("+x+" "+y+")");
                        int    t1 = points[j][1] - points[i][1];
                        int    t2 = points[j][0] - points[i][0];
                        double d1 = Math.sqrt(t1 * t1 + t2 * t2);
                        int    t3 = points[k][1] - points[i][1];
                        int    t4 = points[k][0] - points[i][0];
                        double d2 = Math.sqrt(t3 * t3 + t4 * t4);
                        minVal = Math.min(minVal, d1 * d2);
                    }
                }
            }
        }
        return minVal;
    }

    public static void main(String[] args) {
        Daily0829 daily0829 = new Daily0829();
//        int       len       = daily0829.tallestBillboard(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 50, 50, 50, 150, 150, 150, 100, 100, 100, 123});
//        System.out.println(len);
//        int n = daily0829.findJudge(2, new int[][]{{1, 2}});
        double max = daily0829.minAreaFreeRect(new int[][]{{0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}});
        System.out.println(max);
    }
}
