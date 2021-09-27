package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/27
 * @time 9:18 PM
 */
public class Solution639 {
    private static final int maxVal = 1000000007;
    Map<Integer, Long> cache = new HashMap<>();

    public int numDecodings(String s) {

        long numbers = dfs(s, 0);
        return (int) numbers;
    }

    private long dfs(String source, int index) {

        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index == source.length()) {
            return 1;
        }
        //1个
        long temp1 =(getOneNumOfDecoding(source.charAt(index))
                * dfs(source, index + 1));
        //2个
        long temp2 = 0;
        if (index + 1 < source.length()) {
            temp2 = (getDualNumOfDecoding(source.charAt(index), source.charAt(index + 1))
                    * dfs(source, index + 2));
        }
        long res = (temp1 + temp2) % maxVal;
        cache.put(index, res);
        return res;
    }

    private long getOneNumOfDecoding(char ch) {
        if (ch == '*') {
            return 9;
        } else if (ch == '0') {
            return 0;
        }
        return 1;
    }

    private long getDualNumOfDecoding(char first, char second) {
        if (first == '*') {
            //1-26
            if (second == '*') {
                return 15;
            } else if (second >= '7') {
                return 1;
            } else {
                return 2;
            }
        } else if (first == '0') {
            return 0;
        } else if (first == '1') {
            if (second == '*') {
                return 9;
            } else {
                return 1;
            }
        } else if (first == '2') {
            if (second == '*') {
                return 6;
            } else if (second <= '6') {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    public static void main(String[] args){
        Solution639 solution639=new Solution639();
        int number=solution639.numDecodings("2*");
        System.out.println(number);
    }
}
