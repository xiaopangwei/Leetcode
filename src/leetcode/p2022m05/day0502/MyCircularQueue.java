package leetcode.p2022m05.day0502;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 11:07 AM
 */
//LC 622
public class MyCircularQueue {
    int[] data;
    int     firstIndex = 0;
    int     lastIndex  = 0;
    boolean isEmpty    = true;
    int k;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.data[lastIndex] = value;
        lastIndex = (lastIndex + 1) % k;
        isEmpty = false;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        int idx = (firstIndex + 1) % k;
        if (idx == this.lastIndex) {
            isEmpty = true;
        }
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[firstIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(lastIndex - 1 + k) % k];
    }

    public boolean isEmpty() {

        return isEmpty && this.firstIndex == this.lastIndex;
    }

    public boolean isFull() {
        return !isEmpty && this.firstIndex == this.lastIndex;
    }
}
