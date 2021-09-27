package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 12:57 PM
 */
public class PhoneDirectory {
    boolean[] flags;

    public PhoneDirectory(int maxNumbers) {
        flags = new boolean[maxNumbers];
    }

    public int get() {
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i]) {
                flags[i] = true;
                return i;
            }
        }
        return -1;
    }

    public boolean check(int number) {

        if (flags[number]) {
            return false;
        }
        return true;
    }

    public void release(int number) {

        flags[number] = false;
    }
}
