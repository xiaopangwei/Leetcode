package leetcode.p2021m10;

import leetcode.p2021m06.p20210628.Reader4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 9:35 AM
 */
public class Solution158 extends Reader4 {


    private char[] externalBuffer = new char[4];
    private int    maxLimit       = 0;
    private int    pointer        = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            char temp = read();
            if (temp == (char) -1) {
                break;
            } else {
                buf[i] = temp;
                count++;
            }
        }

        return count;

    }

    private char read() {
        if (pointer == maxLimit) {
            maxLimit = read4(externalBuffer);
            pointer = 0;
            if (maxLimit == 0) {
                return (char) -1;
            } else {
                return externalBuffer[pointer++];
            }
        } else {
            return externalBuffer[pointer++];
        }
    }

    @Override
    public int read4(char[] buf4) {
        return 1;
    }
}
