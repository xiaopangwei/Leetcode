package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/5
 * @time 10:22 PM
 */
public class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            char ch = blocks.charAt(i);
            if (ch == 'W') {
                count++;
            }
        }
        int minVal = count;
        int index  = k;
        while (index < blocks.length()) {
            if (blocks.charAt(index) == 'W') {
                count++;
            }
            if (blocks.charAt(index - k) == 'W') {
                count--;
            }

            minVal = Math.min(minVal, count);

//            System.out.println(minVal+" "+(index-k)+" "+index);
            index++;
        }

        return minVal;
    }

    public static void main(String[] args) {
        Solution2379 solution2379 = new Solution2379();
        System.out.println("res:"+solution2379.minimumRecolors("WBWBBBW",2));
    }
}
