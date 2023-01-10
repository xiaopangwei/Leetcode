package leetcode.p2023m01;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/7
 * @time 3:20 PM
 */
public class FlightsDemo {

    class Flight {

        private String flightId;
        int cost;
        int sourceId;
        int targetId;
        private Date takeoffTime;
        private Date landingTime;

        public Flight(String flightId) {
            this.flightId = flightId;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Flight flight = (Flight) o;

            return flightId.equals(flight.flightId);
        }

        @Override
        public int hashCode() {
            return flightId.hashCode();
        }
    }


    class FlightManager {
        List<Flight>               flights;
        Map<Integer, List<Flight>> siteAndFlightMap;
        final static int MAX_SIZE = 10;

        public FlightManager(List<Flight> flights) {
            this.flights = flights;
            siteAndFlightMap = new HashMap<>();
            for (Flight flight : flights) {
                int sourceId = flight.sourceId;
                if (!siteAndFlightMap.containsKey(sourceId)) {
                    siteAndFlightMap.put(sourceId, new ArrayList<>());
                }
                siteAndFlightMap.get(sourceId).add(flight);
            }
        }


        public boolean isDirectConnected(int sourceId, int targetId) {
            for (Flight flight : siteAndFlightMap.get(sourceId)) {
                if (flight.targetId == targetId) {
                    return true;
                }
            }
            return false;
        }

        public boolean isConnected(int sourceId, int targetId) {
            return bfs(sourceId, targetId) >= 0;
        }


        class Tuple {
            String path;
            int    minDist;
            int    lastId;

            public Tuple(String path, int minDist) {
                this.path = path;
                this.minDist = minDist;
            }
        }

        private int bfs(int sourceId, int targetId) {
            Set<Integer> visitedSite = new HashSet<>();
            Queue<Tuple> queue       = new LinkedList<>();
            Tuple        tuple       = new Tuple(sourceId + "->", 0);
            tuple.lastId = sourceId;
            queue.add(tuple);
            visitedSite.add(sourceId);
            int level = 0;
            while (!queue.isEmpty()) {
                int s = queue.size();
                for (int i = 0; i < s; i++) {
                    Tuple temp = queue.poll();
                    if (temp.lastId == targetId) {
                        return level;
                    }
                    List<Flight> flightList = siteAndFlightMap.get(temp.lastId);
                    for (Flight flight : flightList) {
                        if (!visitedSite.contains(flight.targetId)) {
                            visitedSite.add(flight.targetId);
                            Tuple next = new Tuple(temp.path + flight.targetId + "->", temp.minDist + 1);
                            next.lastId = flight.targetId;
                            queue.add(next);
                        }
                    }
                }
                level++;
            }
            return -1;
        }

        public int getMinDist(int sourceId, int targetId) {
            Map<Integer, Integer> distMap = new HashMap<>();
            distMap.put(sourceId, 0);
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            pq.add(new int[]{sourceId, 0});
            while (!pq.isEmpty()) {
                int[] temp = pq.poll();
                if (distMap.getOrDefault(temp[0], Integer.MAX_VALUE) < temp[1]) {
                    continue;
                }
                List<Flight> flightList = siteAndFlightMap.get(temp[0]);
                for (Flight f : flightList) {
                    if (temp[1] != Integer.MAX_VALUE) {
                        int currentMinDist = temp[1] + f.cost;
                        if (currentMinDist < distMap.getOrDefault(f.targetId, Integer.MAX_VALUE)) {
                            distMap.put(f.targetId, currentMinDist);
                            pq.add(new int[]{f.targetId, currentMinDist});
                        }
                    }
                }
            }

            return distMap.getOrDefault(targetId, Integer.MAX_VALUE);
        }


        public int getMinDist2(int sourceId, int targetId, Date currentDate) {
            int[][] graph = new int[MAX_SIZE][MAX_SIZE];
            for (int i = 0; i < MAX_SIZE; i++) {
                for (int j = 0; j < MAX_SIZE; j++) {
                    if (i == j) {
                        graph[i][j] = 0;
                    } else {
                        graph[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for (Flight flight : flights) {
                if (flight.landingTime.after(currentDate)) {
                    int s = flight.sourceId;
                    int t = flight.targetId;
                    graph[s][t] = Math.min(graph[s][t], flight.cost);
                }
            }

            boolean[] visited = new boolean[MAX_SIZE];
            int[]     minDist = new int[MAX_SIZE];
            int[]     prev    = new int[MAX_SIZE];
            Arrays.fill(minDist, Integer.MAX_VALUE);
            minDist[sourceId] = 0;
            visited[sourceId] = true;

            for (int i = 0; i < MAX_SIZE - 1; i++) {
                int[] temp = getMinIndex(graph, visited, sourceId);
                visited[temp[0]] = true;
                for (int j = 0; j < MAX_SIZE; j++) {
                    if (!visited[j] && temp[1] + graph[temp[0]][j] < minDist[j]) {
                        minDist[j] = temp[1] + graph[i][j];
                        prev[j] = temp[0];
                    }
                }
            }


            return minDist[targetId];
        }

        private int[] getMinIndex(int[][] graph, boolean[] visited, int startId) {

            int minIndex = -1;
            int minDist  = Integer.MAX_VALUE;
            for (int i = 0; i < graph.length; i++) {
                if (!visited[i] && graph[startId][i] < minDist) {
                    minIndex = i;
                    minDist = graph[startId][i];
                }
            }
            return new int[]{minIndex, minDist};
        }
    }


}
