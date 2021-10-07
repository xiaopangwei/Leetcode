package leetcode.p2021m10;

import java.util.Iterator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/5
 * @time 9:27 AM
 */
public class PeekingIterator implements Iterator<Integer> {
    Integer nextVal = null;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        nextVal = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {

        return nextVal;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int ans = nextVal;
        if (iterator.hasNext()) {
            nextVal = iterator.next();
        } else {
            nextVal = null;
        }
        return ans;
    }

    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}
