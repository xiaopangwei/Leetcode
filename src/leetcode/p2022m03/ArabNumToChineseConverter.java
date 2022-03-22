package leetcode.p2022m03;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/21
 * @time 10:07 PM
 */
public class ArabNumToChineseConverter {
    public String convert(int num) {
        String             reversed = new StringBuilder(String.valueOf(num)).reverse().toString();
        String[]           units    = new String[]{"", "万", "亿"};
        LinkedList<String> list     = new LinkedList<>();
        for (int i = 0; i < reversed.length(); i += 4) {
            int minLen = Math.min(i + 4, reversed.length());
            char[] temp =
                    reversed.substring(i, minLen).toCharArray();
            list.add(simpleConvert(temp));
        }

        StringBuilder builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
            builder.append(units[i]);
        }

        return builder.toString();


    }

    public String simpleConvert(char[] arr) {
        char[]                digits = new char[]{'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
        String[]              units  = new String[]{"", "十", "百", "千"};
        LinkedList<Character> ans    = new LinkedList<>();
        ans.add(digits[arr[0] - '0']);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '0' && arr[i - 1] == '0')
                continue;
            if (arr[i] == '0') {
                ans.addFirst(digits[arr[i] - '0']);
            } else {
                ans.addFirst(units[i].charAt(0));
                ans.addFirst(digits[arr[i] - '0']);
            }

        }
        int len = ans.size();
        if (ans.get(len - 1) == '零' && len != 1) ans.remove(ans.size() - 1);
        if (arr.length == 2 && ans.get(0) == '一') ans.remove(0);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            builder.append(String.valueOf(ans.get(i)));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ArabNumToChineseConverter arabNumToChineseConverter = new ArabNumToChineseConverter();
//        String                    ans                       = arabNumToChineseConverter.simpleConvert("1232".toCharArray());
        String ans = arabNumToChineseConverter.simpleConvert(new char[]{'2','3','0'});
        System.out.println(ans);

    }
}
