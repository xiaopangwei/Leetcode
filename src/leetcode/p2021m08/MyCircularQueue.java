package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 2:12 PM
 */
public class MyCircularQueue {

    int rPointer = 0;
    int wPointer = 0;
    int[] data;

    int rTimes = 0;
    int wTimes = 0;
    int maxCapacity;

    public MyCircularQueue(int k) {
        data = new int[k];
        maxCapacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[wPointer] = value;
        if (wPointer + 1 == maxCapacity) {
            wPointer = 0;
            wTimes++;
        } else {
            wPointer += 1;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (rPointer + 1 == maxCapacity) {
            rPointer = 0;
            rTimes++;
        } else {
            rPointer += 1;
        }
        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        } else {
            int pos = (rPointer) % maxCapacity;
            return data[pos];
        }

    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            int pos = (wPointer - 1 + maxCapacity) % maxCapacity;
            return data[pos];
        }
    }

    public boolean isEmpty() {

        if (wPointer == rPointer && wTimes <= rTimes) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (wPointer == rPointer && wTimes > rTimes) {
            return true;
        }
        return false;
    }
}
