package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/8
 * @time 3:30 PM
 */
public class Leaderboard {
    Map<Integer, Integer>     map1;
    TreeMap<Integer, Integer> map2;


    public Leaderboard() {
        map1 = new HashMap<>();
        map2 = new TreeMap<>();
    }

    public void addScore(int playerId, int score) {
        if (map1.containsKey(playerId)) {
            int s = map1.get(playerId);
            map2.put(s, map2.getOrDefault(s, 0) - 1);
            int newS = s + score;
            map1.put(playerId, newS);
            map2.put(newS, map2.getOrDefault(newS, 0) + 1);
        } else {
            map1.put(playerId, score);
            map2.put(score, map2.getOrDefault(score, 0) + 1);
        }

    }

    public int top(int K) {
        int                         cnt   = 0;
        Map.Entry<Integer, Integer> entry = map2.lastEntry();

        int sum = 0;
        while (cnt < K) {
            int t = entry.getValue();
            if (cnt + t <= K) {
                sum += t * entry.getKey();
                entry = map2.lowerEntry(entry.getKey());
                cnt += t;
            } else {
                int gap = K - cnt;
                sum += gap * entry.getKey();
                break;
            }
        }
        System.out.println(K + " " + sum);

        return sum;
    }

    public void reset(int playerId) {
        int val = map1.remove(playerId);
        map2.put(val, map2.getOrDefault(val, 0) - 1);
    }


    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        leaderboard.top(1);           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
    }


}
