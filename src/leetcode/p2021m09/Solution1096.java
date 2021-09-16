package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/14
 * @time 9:32 PM
 */
public class Solution1096 {
    public List<String> braceExpansionII(String expression) {

        Set<String> sets = new HashSet<>();
        if (!expression.contains("{")) {
            return Arrays.asList(expression);
        } else {

            Queue<String> queue = new LinkedList<>();
            queue.add(expression);
            while (!queue.isEmpty()) {
                String parent = queue.poll();
                if (!parent.contains("{")) {
                    String[] strArray=parent.split(",");
                    for (String item:strArray){
                        sets.add(item);
                    }
                    continue;
                }
                int[]    pos    = getPosition(parent);
                String[] array  = parent.substring(pos[0]+1, pos[1]).split(",");
                String   left   = parent.substring(0, pos[0]);
                String   right  = parent.substring(pos[1]+1, parent.length());

                for (int i = 0; i < array.length; i++) {
                    StringBuilder builder = new StringBuilder();
                    builder.append(left).append(array[i]).append(right);
                    String t=builder.toString();
                    System.out.println(t+" <== "+parent);
                    queue.add(t);
                }
            }

        }

        List<String> res=new ArrayList<>();
        for (String item:sets){
            res.add(item);
        }
        Collections.sort(res);
        return res;
    }
    private int[] getPosition(String exp) {
        int i     = 0;
        int left  = 0;
        int right = 0;
        while (i < exp.length()) {
            char ch = exp.charAt(i);
            if (ch == '{') {
                left = i;
            } else if (ch == '}') {
                right = i;
                break;
            }
            i++;
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        Solution1096 solution1096 = new Solution1096();
        List<String> ans          = solution1096.braceExpansionII("{a,b},x{c,{d,e}y}");
        System.out.println(ans);
    }


}
