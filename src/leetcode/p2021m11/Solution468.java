package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 3:13 PM
 */
public class Solution468 {
    static final String V4      = "IPv4";
    static final String V6      = "IPv6";
    static final String Neither = "Neither";

    public String validIPAddress(String IP) {
        int len = IP.length();
        if (IP.contains(":")) {
            if (IP.charAt(len - 1) == ':') {
                return Neither;
            }
            String[] array = IP.split(":");
            if (array.length != 8) {
                return Neither;
            }

            for (String item : array) {
                if (item.length() > 4) {
                    return Neither;
                }
            }

            int i = 0;

            while (i < len) {
                while (i < len && IP.charAt(i) != ':') {
                    if (IP.charAt(i)>'f'  && IP.charAt(i)<='z' ){
                        return Neither;
                    }
                    if (IP.charAt(i)>'F'  && IP.charAt(i)<='Z' ){
                        return Neither;
                    }
                    i++;
                }
                if (i + 1 < len && IP.charAt(i + 1) == ':') {
                    return Neither;
                } else {
                    i++;
                }
            }
            return V6;
        } else if (IP.contains(".")) {
            if (IP.charAt(len - 1) == '.') {
                return Neither;
            }
            String[] array = IP.split("\\.");
            if (array.length != 4) {
                return Neither;
            }
            for (String item : array) {
                if (!isValid(item)) {
                    return Neither;
                }
            }

            return V4;

        } else {
            return Neither;
        }
    }


    private boolean isValid(String c) {
        if (c.length() >= 4 || c.length() == 0) {
            return false;
        }
        if (c.startsWith("0") && c.length()>1) {
            return false;
        }

        for (int i = 0; i < c.length(); i++) {
            if (!(c.charAt(i) >= '0' && c.charAt(i) <= '9')) {
                return false;
            }
        }

        int number = Integer.parseInt(c);
        if (number > 255) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution468 solution468 = new Solution468();
        //"20EE:FGb8:85a3:0:0:8A2E:0370:7334"
        System.out.println(solution468.validIPAddress("192.0.0.1"));
    }
}
