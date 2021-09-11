package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/9
 * @time 9:13 PM
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> ans = new ArrayList<>();

        List<List<String>> list = new ArrayList<>();
        int                len  = 0;
        List<String>       temp = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() <= maxWidth) {
                len += words[i].length();
                temp.add(words[i]);
            } else {
                len = words[i].length();
                temp.add(words[i]);
            }

            if (i != words.length - 1) {
                int concatLen = len + 1 + words[i + 1].length();
                if (concatLen > maxWidth) {
                    list.add(temp);
                    len = 0;
                    temp = new ArrayList<>();
                } else {
                    len++;
                }
            } else {
                if (!temp.isEmpty()) {
                    list.add(temp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            List<String> sub = list.get(i);
            if (i == list.size() - 1) {
                String prev   = String.join(" ", sub);
                int    lenGap = maxWidth - prev.length();
                if (lenGap != 0) {
                    char[] charArray = new char[lenGap];
                    Arrays.fill(charArray, ' ');
                    ans.add(prev + new String(charArray));
                } else {
                    ans.add(prev);
                }
            } else {
                int total = 0;
                for (String item : sub) {
                    total += item.length();
                }
                int   gap   = maxWidth - total;
                int   size  = sub.size();
                int[] extra = null;
                if (size > 1) {
                    int avg = gap / (size - 1);
                    int mod = gap % (size - 1);
                    extra = new int[size - 1];
                    Arrays.fill(extra, avg);
                    if (mod != 0) {
                        for (int k = 0; k < mod; k++) {
                            extra[k]++;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int k = 0; k < size - 1; k++) {
                        stringBuilder.append(sub.get(k));
                        for (int j = 0; j < extra[k]; j++) {
                            stringBuilder.append(" ");
                        }
                    }
                    stringBuilder.append(sub.get(sub.size() - 1));
                    ans.add(stringBuilder.toString());
                } else {
                    int    tmp  = maxWidth - sub.get(0).length();
                    String prev = sub.get(0);
                    if (tmp != 0) {
                        char[] charArray = new char[tmp];
                        Arrays.fill(charArray, ' ');
                        ans.add(prev + new String(charArray));
                    } else {
                        ans.add(prev);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        List<String> ans = solution68.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a",
                "computer.","Art","is","everything","else","we","do"}, 20);

        System.out.println(ans);
    }
}
