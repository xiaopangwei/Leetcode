package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/15
 * @time 10:27 PM
 */
public class Solution470 extends SolBase {
    public int rand10() {
        //     1 2 3 4 5 6 7
        //0 0  1 2 3 4 5 6 7
        //1 7  8 9 10......14
        //2 14
        //3 21
        //4 28             35
        //5 35 36          42
        //6 42 43          49

        //(rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
        int x = (rand7() - 1) * 7 + rand7();

        while (true) {
            if (x <= 40) {
                return x % 10 + 1;
            }
            x = (rand7() - 1) * 7 + rand7();
        }

    }
}
