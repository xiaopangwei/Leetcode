package leetcode.p2022m05.day0504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/4
 * @time 8:07 PM
 */
public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> alphaLogList = new ArrayList<>();
        List<String> digitLogList = new ArrayList<>();
        for (String item : logs) {
            int     blankIndex = item.indexOf(" ");
            boolean flag       = false;
            for (int i = blankIndex + 1; i < item.length(); i++) {
                if (item.charAt(i)==' '){
                    continue;
                }
                if (!(item.charAt(i) >= '0' && item.charAt(i) <= '9')) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                alphaLogList.add(item);
            } else {
                digitLogList.add(item);
            }
        }

        alphaLogList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ");
                int index2 = o2.indexOf(" ");

                String next1 = o1.substring(index1 + 1);
                String next2 = o2.substring(index2 + 1);
                if (!next1.equals(next2)) {
                    return next1.compareTo(next2);
                } else {
                    return o1.substring(0, index1).compareTo(o2.substring(0, index2));
                }
            }
        });

        String[] ans = new String[logs.length];
        int      i   = 0;
        for (String item : alphaLogList) {
            ans[i++] = item;
        }
        for (String item : digitLogList) {
            ans[i++] = item;
        }
        return ans;
    }

    public static void main(String[] args){
        Solution937 solution937=new Solution937();
        String[] ans=solution937.reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"});
        System.out.println(Arrays.toString(ans));
    }
}
