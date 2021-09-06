package leetcode.p2021m09;

import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/5
 * @time 10:51 AM
 */

abstract class SolBase {
    public int rand7() {
        return new Random(System.currentTimeMillis()).nextInt(7);
    }
}

public class Solution470 extends SolBase {

    public int rand10() {

        while (true) {
            //[0,6]
            int t1 = rand7();
            //[0,6]*7=[0,42]
            int t2 = (rand7() - 1) * 7;
            //[0,48]
            int temp = t1 + t2;

            //1-10      2 3 4 5 6 7 8 9 1
            //11-20     2 3 4 5 6 7 8 9 1
            //21-30     2 3 4 5 6 7 8 9 1
            //31-40     2 3 4 5 6 7 8 9 1
            //[1-40]
            if (temp >= 1 && temp <= 40) {
                return temp % 10 + 1;
            }
        }
    }

}
