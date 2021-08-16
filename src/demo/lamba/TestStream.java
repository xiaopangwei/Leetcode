package demo.lamba;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/5
 * @time 11:18 PM
 */
public class TestStream {
    public static void main(String[] arg){

//        Stream<Integer> stream=Stream.of(1,2,3,4,5,6);
//        stream.filter(x->x>3).forEach(x->System.out.println(x));


//        List<String> list  = Arrays.asList("a", "b", "c");
//        List<String> list2 = Arrays.asList("f","d");
//        list.stream().flatMap(x->list2.stream().map(y-> x + y)).forEach(System.out::println);

        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.reduce(11,(x,y)->x+y));

        Person person1=new Person();
        person1.age=45;
        person1.name="WEIWEIZI";

        Person person2=new Person();
        person2.age=36;
        person2.name="xiaochaochao";

        Person person3=new Person();
        person3.age=12;
        person3.name="personperson";

        Person person4=new Person();
        person4.age=45;
        person4.name="huangxiaowei";

        List<Person> personList=new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

//        Function<Person,String>  keyFunction   =x->x.name;
//        Function<Person,Integer> valueFunction =x->x.age;
//        Map<String,Integer>      map           =personList.stream().collect(Collectors.toMap(keyFunction,valueFunction));
//        System.out.println(map);
//
//        Function<Person,Integer> function=x->x.age;
//        System.out.println(personList.stream().collect(Collectors.groupingBy(function)));

        IntBinaryOperator operator=(x,y)->x+y;
        System.out.println(operator.applyAsInt(1,2));








    }


    static class Person{
        private String name;
        private int age;
    }
}
