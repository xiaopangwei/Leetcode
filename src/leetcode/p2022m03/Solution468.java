package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/3
 * @time 10:19 PM
 */
public class Solution468 {
    String V4      = "IPv4";
    String V6      = "IPv6";
    String NEITHER = "Neither";

    public String validIPAddress(String queryIP) {
        if (queryIP.length() <= 0) {
            return NEITHER;
        }

        String[] array1  = queryIP.split("\\.",-1);
        int      length1 = array1.length;

        String[] array2  = queryIP.split(":",-1);
        int      length2 = array2.length;

        if (length1 == 4) {
            return isV4(array1);
        }

        if (length2 == 8) {
            return isV6(array2);
        }


        return NEITHER;
    }

    private String isV4(String[] array) {
        for (String item : array) {
            if (item.length()<=0 || item.length()>3){
                return NEITHER;
            }
            if (item.length() > 1 && item.charAt(0) == '0') {
                return NEITHER;
            }
            int val = 0;
            for (int i = 0; i < item.length(); i++) {
                char ch = item.charAt(i);
                if (!(ch >= '0' && ch <= '9')) {
                    return NEITHER;
                } else {
                    val = val * 10 + (ch - '0');
                }
            }
            if (val > 255) {
                return NEITHER;
            }
        }
        return V4;
    }

    private String isV6(String[] array) {
        for (String item : array) {
            if (!(item.length() >= 1 && item.length() <= 4)) {
                return NEITHER;
            }
            for (int i = 0; i < item.length(); i++) {
                char    ch    = item.charAt(i);
                boolean flag1 = ch >= '0' && ch <= '9';
                boolean flag2 = ch >= 'a' && ch <= 'f';
                boolean flag3 = ch >= 'A' && ch <= 'F';

                if (!(flag1 || flag2 || flag3)) {
                    return NEITHER;
                }
            }
        }
        return V6;
    }
    public static void main(String[] args) {
        Solution468 solution468 = new Solution468();
        System.out.println(solution468.validIPAddress("1.0.1."));
        System.out.println(solution468.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(solution468.validIPAddress("256.256.256.256"));
    }
}
