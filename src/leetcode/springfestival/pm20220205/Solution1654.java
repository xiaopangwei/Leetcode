package leetcode.springfestival.pm20220205;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 11:56 AM
 */
public class Solution1654 {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[] visited = new boolean[8001];
        for (int item : forbidden) {
            visited[item] = true;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {

            int[] temp = queue.poll();
//            System.out.println(temp[0]+","+temp[1]);
            if (visited[temp[0]]){
                continue;
            }
            if (temp[0] == x) {
                return temp[1];
            }
            visited[temp[0]] = true;
            //前进一步
            int forward = temp[0] + a;
            if (forward <= 6000 && !visited[forward]) {
                queue.add(new int[]{forward, temp[1] + 1});
            }
            //后退一步
            int backword = forward - b;
            if (backword >= 0 && !visited[backword]) {
                queue.add(new int[]{backword, temp[1] + 2});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1654 solution1654 = new Solution1654();
        int          ans          = solution1654.minimumJumps(new int[]{8,3,16,6,12,20},
                15, 13, 11);
        System.out.println(ans);
    }
}
