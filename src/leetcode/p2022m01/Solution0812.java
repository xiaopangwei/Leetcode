package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/18
 * @time 9:20 PM
 */
public class Solution0812 {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(new ArrayList<>(), n, 0);
        return ans;
    }

    private void dfs(List<Integer> temp, final int n, int rowId) {
        if (rowId == n) {
            ans.add(format(temp, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(temp, rowId, i)) {
                continue;
            }
            temp.add(i);
            dfs(temp, n, rowId + 1);
            temp.remove(temp.size() - 1);
        }

    }


    private boolean isValid(List<Integer> list, int rowId, int colId) {
        for (int i = 0; i < list.size(); i++) {
            int row = i;
            int col = list.get(i);
            if (row - col == rowId - colId || row + col == rowId + colId || col==colId) {
                return false;
            }
        }
        return true;
    }

    private List<String> format(List<Integer> list, int n) {
        List<StringBuilder> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                stringBuilder.append(".");
            }
            temp.add(stringBuilder);
        }
        for (int i = 0; i < list.size(); i++) {
            int row = i;
            int col = list.get(i);
            temp.get(row).setCharAt(col, 'Q');
        }

        List<String> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ret.add(temp.get(i).toString());
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution0812 solution0812 = new Solution0812();
        System.out.println(solution0812.solveNQueens(4));
    }
}
