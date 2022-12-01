package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/30
 * @time 10:06 PM
 */
public class Solution2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i=0;
        int j=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int matched=0;
        while (i<players.length && j<trainers.length){
            if (players[i]<=trainers[j]){
                i++;
                j++;
                matched++;
            }else {
                j++;
            }
        }
        return matched;
    }

    public static void main(String[] args){
        Solution2410 solution2410=new Solution2410();

        System.out.println(solution2410.matchPlayersAndTrainers(new int[]{1,1,1},new int[]{10}));
    }
}
