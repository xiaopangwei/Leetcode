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
public class Daily0905 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int item : arr) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        int half = arr.length / 2;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }

        int count = 0;
        int temp  = 0;
        while (!pq.isEmpty()) {
            count += pq.poll().getValue();
            temp++;
            if (count >= half) {
                break;
            }
        }
        return temp;
    }


    class MyCalendar {

        TreeMap<Integer, Integer> posMap = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer k1 = posMap.floorKey(start);
            Integer k2 = posMap.ceilingKey(start);

            if ((k1 == null || posMap.get(k1) <= start) && (k2 == null || k2 >= end)) {
                posMap.put(start, end);
                return true;
            }
            return false;

        }
    }


    class BiKey {
        int[] array;
        int   direction;
        String path = "";

        public BiKey(int[] array, int direction) {
            this.array = array;
            this.direction = direction;
        }
    }

    static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    String[] charDirect = new String[]{"l", "r", "d", "u"};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Queue<BiKey>  queue   = new LinkedList<>();
        int           m       = maze.length;
        int           n       = maze[0].length;
        boolean[][][] visited = new boolean[m][n][4];
        queue.add(new BiKey(ball, 4));
        while (!queue.isEmpty()) {
            BiKey biKey      = queue.poll();
            int[] temp       = biKey.array;
            int   lastDirect = biKey.direction;
            if (temp[0] == hole[0] && temp[1] == hole[1]) {
                return biKey.path;
            }

            int newX = temp[0];
            int newY = temp[1];
            if (lastDirect < 4) {
                newX += directions[lastDirect][0];
                newY += directions[lastDirect][1];
            }
            if (lastDirect >= 4 || newX < 0 || newY < 0 || newX >= m || newY >= n ||
                    maze[newX][newY] == 1) {

                for (int i = 0; i < 4; i++) {
                    if (i == lastDirect) {
                        continue;
                    }
                    newX = temp[0] + directions[i][0];
                    newY = temp[1] + directions[i][1];
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n ||
                            maze[newX][newY] == 1 || visited[newX][newY][i]) {
                        continue;
                    }
                    visited[newX][newY][i] = true;
                    BiKey t = new BiKey(new int[]{newX, newY}, i);
                    t.path = biKey.path + charDirect[i];
                    queue.add(t);
                }
            } else if (!visited[newX][newY][lastDirect]) {
                visited[newX][newY][lastDirect] = true;
                BiKey t = new BiKey(new int[]{newX, newY}, lastDirect);
                t.path = biKey.path;
                queue.add(t);
            }

        }
        return "impossible";
    }


    public static void main(String[] args) {
        Daily0905 daily0904 = new Daily0905();
        System.out.println(daily0904.findShortestWay(
                new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}},
                new int[]{4, 3},
                new int[]{0, 1}));
//        System.out.println(daily0904.minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
    }
}
