package leetcode.springfestival.sf20220130;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 3:46 PM
 */
public class Solution273 {
    static final int thousandVal = 1000;
    static final int millVal     = 1000 * thousandVal;
    static final int billVal     = 1000 * millVal;
    String[] str1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] str2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] str3 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWordsRecur(int num) {
        if (num == 0) {
            return "Zero";
        }

        return dfs(num).trim();

    }

    private String dfs(int num) {

        int billion = num / billVal;
        num %= billVal;

        int million = num / millVal;
        num %= millVal;

        int thousand = num / thousandVal;
        num %= thousandVal;

        StringBuilder stringBuilder = new StringBuilder();
        if (billion != 0) {
            stringBuilder.append(dfs(billion));
            stringBuilder.append("Billion ");
        }

        if (million != 0) {
            stringBuilder.append(dfs(million));
            stringBuilder.append("Million ");
        }

        if (thousand != 0) {
            stringBuilder.append(dfs(thousand));
            stringBuilder.append("Thousand ");
        }

        stringBuilder.append(convertLessThousand(num));

        return stringBuilder.toString();
    }


    private String convertLessThousand(int num) {
        int           h             = num / 100;
        StringBuilder stringBuilder = new StringBuilder();
        if (h != 0) {
            stringBuilder.append(str1[h]).append(" ").append("Hundred").append(" ");
        }

        num %= 100;

        if (num >= 10 && num < 20) {
            stringBuilder.append(str2[num - 10]).append(" ");
            return stringBuilder.toString();
        }
        if (num >= 20) {
            int t = num / 10;
            stringBuilder.append(str3[t]).append(" ");
        }

        num %= 10;
        if (num != 0) {
            stringBuilder.append(str1[num]).append(" ");
        }

        return stringBuilder.toString();
    }

    public String numberToWords(int num) {
        if (num==0){
            return "Zero";
        }
        int                cnt = 0;
        LinkedList<String> ans = new LinkedList<>();
        while (num != 0) {
            int p = 0;
            int q = 0;
            if (cnt != 3) {
                p = num % thousandVal;
                q = num / thousandVal;
            } else {
                p = num;
                q = 0;
            }
            int[]         digits  = convert(p);
            StringBuilder builder = new StringBuilder();

            if (digits[0] != 0) {
                builder.append(str1[digits[0]]).append(" Hundred ");
            }
            int temp = p % 100;
            if (temp >= 10 && temp < 20) {
                builder.append(str2[temp - 10]).append(" ");
            }

            if (temp >= 20) {
                builder.append(str3[temp / 10]).append(" ");
            }
            if (!(temp >= 10 && temp < 20)) {
                int lastDigit = p % 10;
                if (lastDigit != 0) {
                    builder.append(str1[lastDigit]).append(" ");
                }
            }
            if (cnt == 0) {
                builder.append("");
            } else if (cnt == 1) {
                if (builder.length()>0) {
                    builder.append("Thousand");
                }
            } else if (cnt == 2) {
                if (builder.length()>0) {
                    builder.append("Million");
                }
            } else {
                if (builder.length()>0) {
                    builder.append("Billion");
                }
            }
            cnt++;
            if (builder.length()>0) {
                ans.addFirst(builder.toString());
            }
            num = q;
        }
        return String.join(" ", ans).trim();
    }

    private int[] convert(int num) {
        int[] ans   = new int[3];
        int   index = 2;
        while (num != 0) {
            ans[index--] = num % 10;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution273 solution273 = new Solution273();
//        String      temp        = solution273.numberToWords(1);
//        System.out.println(temp);
//        System.out.println(Integer.MAX_VALUE);
        String ans = solution273.numberToWords(1000010);
        System.out.println(ans.trim());
    }


}
