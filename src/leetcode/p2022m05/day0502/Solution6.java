package leetcode.p2022m05.day0502;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 10:48 AM
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int rowIndex = 0;
        int len      = s.length();

        boolean directions = true;

        for (int i = 0; i < len; i++) {
            list.get(rowIndex).append(s.charAt(i));
            if (directions) {
                rowIndex++;
            } else {
                rowIndex--;
            }
            if (rowIndex == numRows) {
                directions = !directions;
                rowIndex = numRows - 2;
            }
            if (rowIndex == -1) {
                directions = !directions;
                rowIndex = 1;
            }

        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : list) {
            ans.append(sb);
        }
        return ans.toString();
    }

    public static void main(String[] args){
        Solution6 solution6=new Solution6();
        String ans=solution6.convert("PAYPALISHIRING",4);
        System.out.println(ans);
        System.out.println("PINALSIGYAHRPI");
    }
}
