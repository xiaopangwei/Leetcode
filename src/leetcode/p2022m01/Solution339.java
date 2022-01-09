package leetcode.p2022m01;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/8
 * @time 3:59 PM
 */
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class Solution339 {
    int sum = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        for (NestedInteger item:nestedList){
            dfs(item,1);
        }
        return sum;
    }

    private void dfs(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            sum += depth * nestedInteger.getInteger();
            return;
        } else {
            if (nestedInteger.getList()!=null) {
                for (NestedInteger item : nestedInteger.getList()) {
                    dfs(item, depth + 1);
                }
            }
        }
    }
}
