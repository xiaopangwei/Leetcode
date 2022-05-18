package leetcode.p2022m05.day0515;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 10:24 PM
 */
public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        nextVal = iterator.next();
    }

    // Returns the nextVal element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextVal;
    }

    // hasNext() and nextVal() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer newNext = this.iterator.hasNext() ? this.iterator.next() : null;
        Integer ret     = nextVal;
        this.nextVal = newNext;
        return ret;
    }

    @Override
    public boolean hasNext() {
        if (nextVal == null) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        ["PeekingIterator","nextVal","peek","nextVal","nextVal","hasNext"]
//[[[1,2,3]],[],[],[],[],[]]
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}