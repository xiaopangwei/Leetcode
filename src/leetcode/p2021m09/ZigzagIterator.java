package leetcode.p2021m09;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 10:18 PM
 */
public class ZigzagIterator {

    int     idx1 = 0;
    int     idx2 = 0;
    //true 下一个遍历第一个列表
    boolean flag = true;

    List<Integer> list1;
    List<Integer> list2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

        this.list1 = v1;
        this.list2 = v2;
    }

    public int next() {
        if (flag) {
            if (idx1 == list1.size()) {
                flag = false;
                return list2.get(idx2++);
            } else {
                flag = false;
                return list1.get(idx1++);
            }
        } else {
            if (idx2 == list2.size()) {
                flag = true;
                return list1.get(idx1++);
            } else {
                flag = true;
                return list2.get(idx2++);
            }
        }
    }

    public boolean hasNext() {

        if (idx1 >= list1.size() && idx2 >= list2.size()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        ZigzagIterator zigzagIterator=new ZigzagIterator(Arrays.asList(1,2,3),Arrays.asList(4,5,6,7,8));

        for (int i=0;i<8;i++){
            System.out.println(zigzagIterator.next()+" ==> "+zigzagIterator.hasNext());
        }


    }
}
