package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/16
 * @time 10:29 PM
 */
public class Solution990 {
    public boolean equationsPossible(String[] equations) {

        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String eq : equations) {
            int first  = eq.charAt(0) - 'a';
            int second = eq.charAt(3) - 'a';
            int a      = findFather(parent, first);
            int b      = findFather(parent, second);
            if (eq.charAt(1) == '=') {
                parent[a] = b;
            }
        }

        for (String eq : equations) {
            int first  = eq.charAt(0) - 'a';
            int second = eq.charAt(3) - 'a';
            int a      = findFather(parent, first);
            int b      = findFather(parent, second);
            if (eq.charAt(1) != '=') {
                if (a == b) {
                    return false;
                }
            }
        }
        return true;
    }

    private int findFather(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return findFather(parent, parent[x]);
    }

    public static void main(String[] args) {
        Solution990 solution990 = new Solution990();
        boolean     flag        = true;
        flag = solution990.equationsPossible(new String[]{"a==b", "b!=c", "c==a"});
        System.out.println(flag);
    }
}
