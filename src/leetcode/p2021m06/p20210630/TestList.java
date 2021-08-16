package leetcode.p2021m06.p20210630;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 3:26 PM
 */
public class TestList {

    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1,100);

        System.out.println(list);

    }
}
