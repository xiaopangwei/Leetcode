package demo.test20210120;

import java.io.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/19
 * @time 11:23 PM
 */
public class TestSerializable {


    static class Person implements Serializable{
        String name;
        int age=10;
        transient double salary =10000;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }



    }
    public static void main(String[] args) throws Exception{

        String path="/Users/weihuang/LeetCode-Practice/data/serial.bin";
        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream(path))){
            Person p=new Person();
            p.name="HW";
            p.age=234;
            p.salary=123.0;
            outputStream.writeObject(p);

            p.age=100;
            outputStream.writeObject(p);
        }

        try(ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(path))){
            Person p1=(Person)inputStream.readObject();
            System.out.println(p1);

            Person p2=(Person)inputStream.readObject();
            System.out.println(p2);
        }
    }
}
