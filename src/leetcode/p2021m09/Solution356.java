package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/27
 * @time 10:43 PM
 */
public class Solution356 {

    static class Point {
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

    public boolean isReflected(int[][] points) {

        Map<Integer, List<Point>> map    = new HashMap<>();
        int                       minVal = Integer.MAX_VALUE;
        int                       maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            maxVal = Math.max(maxVal, points[i][0]);
            minVal = Math.min(minVal, points[i][0]);
            if (!map.containsKey(points[i][1])) {
                map.put(points[i][1], new ArrayList<>());
            }
            Point p = new Point(points[i][0], points[i][1]);
            if (!map.get(points[i][1]).contains(p)) {
                map.get(points[i][1]).add(p);
            }
        }

        int sum = maxVal + minVal;

        for (Map.Entry<Integer, List<Point>> entry : map.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.x-o2.x;
                }
            });
            List<Point> pList = entry.getValue();
            int         i     = 0;
            int         j     = pList.size() - 1;

            while (i <= j) {
                if (pList.get(i).x + pList.get(j).x != sum) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        Solution356 solution356 = new Solution356();
        boolean     ans         = solution356.isReflected(new int[][]{{1, 1}, {-1, -1}});
        System.out.println(ans);
    }
}
