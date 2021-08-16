package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 9:59 PM
 */
public class Solution165 {
    public int compareVersion(String version1, String version2) {
//        System.out.println("Compare "+version1+" "+version2);
        int len1 = version1.length();
        int len2 = version2.length();

        int sum1 = 0;
        int sum2 = 0;

        int i = 0;
        int j = 0;
        int m = 0;
        int n = 0;
        while (i < len1 && j < len2) {

            m = i;
            while (m < len1 && version1.charAt(m) != '.') {
                sum1 = 10 * sum1 + (version1.charAt(m) - '0');
                m++;
            }


            n = j;
            while (n < len2 && version2.charAt(n) != '.') {
                sum2 = 10 * sum2 + (version2.charAt(n) - '0');
                n++;
            }

//            System.out.println(sum1+" "+sum2);
            if (sum1 < sum2) {
                return -1;
            } else if (sum1 > sum2) {
                return 1;
            } else {
                i = m + 1;
                j = n + 1;
                sum1 = 0;
                sum2 = 0;
            }
        }


        while (i < len1) {
            m = i;
            sum1 = 0;
            while (m < len1 && version1.charAt(m) != '.') {
                sum1 = 10 * sum1 + (version1.charAt(m) - '0');
                m++;
            }
//            System.out.println("s1:"+sum1);
            if (sum1 > 0) {
                return 1;
            } else {
                i = m + 1;
            }
        }


        while (j < len2) {
            n = j;
            sum2 = 0;
            while (n < len2 && version2.charAt(n) != '.') {
                sum2 = 10 * sum2 + (version2.charAt(n) - '0');
                n++;
            }
//            System.out.println("s2:"+sum2);
            if (sum2 > 0) {
                return -1;
            } else {
                j = n + 1;
            }
        }


        return 0;
    }

    public static void main(String[] args) {
        Solution165 solution165 = new Solution165();
        int         ans         = -2;
        ans = solution165.compareVersion("1.01", "1.001");
        System.out.println(ans);

        ans = solution165.compareVersion("1.0", "1.0.0");
        System.out.println(ans);

        ans = solution165.compareVersion("0.1", "1.1");
        System.out.println(ans);

        ans = solution165.compareVersion("1.0.1", "1");
        System.out.println(ans);

        ans = solution165.compareVersion("7.5.2.4", "7.5.2.4");
        System.out.println(ans);
    }
}
