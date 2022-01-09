package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/5
 * @time 9:14 PM
 */
public class Solution464 {
    int maxChoosableInteger;
    int desiredTotal;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;

        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }

        if ((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal){
            return false;
        }
        boolean[] visited = new boolean[maxChoosableInteger + 1];

        return dfs(visited, 0, new ArrayList<>());
    }

    private boolean dfs(boolean[] visited, int sum, List<Integer> temp) {
        if (sum >= this.desiredTotal) {
            if (temp.size()%2!=0){
                return true;
            }else{
                return false;
            }
        }
        boolean flag=true;
        for (int i = 1; i <= this.maxChoosableInteger; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(i);
            visited[i] = true;
            if (dfs(visited, sum + i, temp)) {
                visited[i] = false;
                temp.remove(temp.size() - 1);
                flag=false;
                break;
            }
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }

        return flag;

    }

    public static void main(String[] args) {
        Solution464 solution464 = new Solution464();
        boolean     flag        = solution464.canIWin(10, 12);
        System.out.println(flag);
    }
}
