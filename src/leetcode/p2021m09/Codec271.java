package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 8:46 PM
 */
public class Codec271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            builder.append(composeHead(strs.get(i).length()));
            builder.append(strs.get(i));
        }
        return builder.toString();
    }

    //size
    private String composeHead(int size) {
        if (size == 0) {
            return "00000000";
        }
        String val = String.valueOf(size);
        int    gap = 8 - val.length();
        if (gap == 0) {
            return val;
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < gap; i++) {
                builder.append("0");
            }
            builder.append(val);
            return builder.toString();
        }
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int          i    = 0;
        while (i < s.length()) {
            int j = i + 8;
            if (j > s.length()) {
                break;
            }
            int temp = 0;

            for (int k = i; k < j; k++) {
                temp = temp * 10 + (s.charAt(k) - '0');
            }
            list.add(s.substring(j, j + temp));
            i = j + temp;
        }
        return list;
    }

    public static void main(String[] args) {
        Codec271     codec271 = new Codec271();
        List<String> list     = Arrays.asList("");
//        List<String> list=Arrays.asList("","I", "am", "weiweizi", "Hello", "world","hhhhhhhhhhhggggdsw");
        String str = codec271.encode(list);

        System.out.println(str);
        List<String> ans = codec271.decode(str);
        System.out.println(ans);
    }
}
