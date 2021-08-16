package demo.szse.test20201123;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/12/10
 * @time 7:33 PM
 */
public class Test1 {
    public static boolean eval(Integer o1){
        System.out.println("eval"+o1);
        return o1.compareTo(1)>0;
    }
    public static void main(String[] args){
        List<Integer> list1 =new ArrayList();
        list1.add(2);
        list1.add(3);
        list1.add(4);

        System.out.println(list1.stream().filter(item->eval(item)).findFirst().get());


    }
}
