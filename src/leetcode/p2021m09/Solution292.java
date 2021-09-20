package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/18
 * @time 9:02 AM
 */
public class Solution292 {


    public boolean canWinNim(int n) {

        if (n>=10000){
            return n%4!=0;
        }
        if (n <= 3) {
            return true;
        }
        boolean a = true;
        boolean b = true;
        boolean c = true;
        boolean temp =false;
        for (int i = 4; i <= n; i++) {
            temp=!c || !b || !a;
            a = b;
            b = c;
            c = temp;
        }

        return temp;
    }

    public static void main(String[] args) {
        Solution292 solution292 = new Solution292();
//        System.out.println(solution292.canWinNim(1348820612));
        for (int i = 0; i <=10; i++) {
            System.out.println(i + " " + solution292.canWinNim(i));
        }

    }
}
