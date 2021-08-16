package demo.lamba;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/5
 * @time 11:18 PM
 */
public class TestConsumer {
    public static void main(String[] arg){

        Consumer consumer1=x->System.out.println(x);
        consumer1.accept(2);


        Supplier supplier=()->123;
        System.out.println(supplier.get());


        Function<String,String> function=x->x.toUpperCase();
        System.out.println(function.apply("hello"));

        Predicate<String> predicate=x->x.length()>5;
        System.out.println(predicate.test("hello1"));
    }
}
