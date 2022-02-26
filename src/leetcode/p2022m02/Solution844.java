package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 10:04 AM
 */
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 && j >= 0) {
            int count1 = 0;
            while (i >= 0) {
                char ch = s.charAt(i);
                if (ch == '#') {
                    count1++;
                } else if (count1 > 0) {
                    count1--;
                } else {
                    break;
                }
                i--;
            }

            int count2 = 0;
            while (j >= 0) {
                char ch = t.charAt(j);
                if (ch == '#') {
                    count2++;
                } else if (count2 > 0) {
                    count2--;
                } else {
                    break;
                }
                j--;
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else if (i >= 0) {
                for (int tt = i; tt >= 0; tt--) {
                    if (s.charAt(tt) != '#') {
                        return false;
                    }
                }
                return true;
            } else {
                for (int tt = j; tt >= 0; tt--) {
                    if (t.charAt(tt) != '#') {
                        return false;
                    }
                }
                return true;
            }
        }

        if (i >= 0) {
            int count = 0;
            int tt    = i;
            while (tt >= 0) {
                if (s.charAt(tt) == '#') {
                    count++;
                    tt--;
                } else if (count > 0) {
                    count--;
                    tt--;
                } else {
                    break;
                }
            }

            if (tt >= 0) {
                return false;
            }
            return true;
        }
        if (j >= 0) {
            int count = 0;
            int tt    = j;
            while (tt >= 0) {
                if (t.charAt(tt) == '#') {
                    count++;
                    tt--;
                } else if (count > 0) {
                    count--;
                    tt--;
                } else {
                    break;
                }
            }

            if (tt >= 0) {
                return false;
            }
            return true;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution844 solution844 = new Solution844();
        //"bbbextm"
        //"bbb#extm"

        //"nzp#o#g"
        //"b#nzp#o#g"
        boolean ans = solution844.backspaceCompare("nzp#o#g", "b#nzp#o#g");
        System.out.println(ans);
    }
}
