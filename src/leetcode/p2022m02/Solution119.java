package leetcode.p2022m02;

import leetcode.p2021m06.p20210629.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/17
 * @time 9:10 PM
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0) {
            return row;
        }

        List<Integer> prevList = getRow(rowIndex - 1);

        for (int i = 0; i < prevList.size() - 1; i++) {
            row.add(prevList.get(i) + prevList.get(i + 1));
        }

        row.add(1);
        return row;
    }

    public static void main(String[] args){
        Solution119 solution119=new Solution119();
        System.out.println(solution119.getRow(4));
    }
}
