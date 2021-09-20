package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 11:05 PM
 */
public class StringIterator {
    int currentCharIndex = 0;
    int totalRepeatTimes = 0;
    int currentTime      = 0;
    char[] charArray;

    int nextCharIndex = 0;

    boolean flag = false;

    public StringIterator(String compressedString) {
        charArray = compressedString.toCharArray();
        int i = 1;

        int temp = 0;
        while (i < charArray.length && (charArray[i] >= '0' && charArray[i] <= '9')) {
            temp = temp * 10 + (charArray[i] - '0');
            i++;
        }
        totalRepeatTimes = temp;
        nextCharIndex = i;
    }

    public char next() {
        if (!this.hasNext()) {
            return ' ';
        }
        if (currentTime < totalRepeatTimes) {
            currentTime++;
            return charArray[currentCharIndex];
        } else {

            reset();
            currentTime++;
            if (currentCharIndex >= charArray.length) {
                flag = true;
                return ' ';
            } else {
                return charArray[currentCharIndex];
            }
        }
    }


    private void reset() {
        currentCharIndex = nextCharIndex;
        currentTime = 0;
        int i    = currentCharIndex + 1;
        int temp = 0;
        while (i < charArray.length && (charArray[i] >= '0' && charArray[i] <= '9')) {
            temp = temp * 10 + (charArray[i] - '0');
            i++;
        }

        totalRepeatTimes = temp;
        nextCharIndex = i;
    }

    public boolean hasNext() {
        if (nextCharIndex >= charArray.length) {
            if (currentTime >= totalRepeatTimes) {
                return false;
            }
        }
        if (flag) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("i11");

        for (int i = 0; i < 13; i++) {

            if (iterator.hasNext()) {
                System.out.println("YES " + iterator.next() + " " + i);
            } else {
                System.out.println("NO " + i);
            }
        }
    }
}