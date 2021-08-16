package demo.szse;

public class ClassInitTest {

    private static final String staticCodeBlock = " static code block ";
    private static final String codeBlock = " code block ";
    private static final String constructor = " constructor ";

    private static String className = ClassInitTest.class.getSimpleName();

    static {
        //静态初始代码块，用于验证主函数类的加载
        System.out.println(className + staticCodeBlock);
    }

    static class Motherland{

        static final String name = "China";
        static {
            System.out.println("Motherland " + staticCodeBlock);
            //对类的静态变量进行赋值，但是不能使用定义在静态代码块后面的变量
            age = 79;
        }
        //一个静态字段
        static Motherland motherland = new Motherland();
        //静态字段
        static int age=78;
        static int count;
        {
            //构造代码块
            System.out.println("Motherland " + codeBlock);
        }
        //私有构造器
        private Motherland(){
            System.out.println("Motherland " + constructor);
            age ++;

            count ++;

            System.out.println("Tag1==>"+age+":"+count);
        }


    }

    static class Successor extends Motherland{

        static String name = "cyf";

        int count1 = getCount2();

        int count2 = 2;

        static {
            System.out.println("Successor " + staticCodeBlock);
            name = "chuyf";
        }

        {
            System.out.println("Successor " + codeBlock);
            System.out.println("111111111111111 before:"+count1);
            System.out.println("222222222222222 before:"+count2);
            count2 = 0;
            System.out.println("111111111111111 after:"+count1);
            System.out.println("222222222222222 after :"+count2);
        }

        Successor(){
            System.out.println("Successor " + constructor);
        }

        int getCount2(){
            return count2;
        }
    }

    public static void main(String[] args){

        System.out.println("Motherland name: " + Motherland.name);

        System.out.println("Successor name: " + Successor.name);

        System.out.println("Motherland age: " + Motherland.age);

        Successor successor = new Successor();

        System.out.println("successor count1: " + successor.count1 + "\t" + "successor count2: " + successor.count2);

        System.out.println("Motherland age: " + Motherland.age);

        System.out.println("Motherland count: " + Motherland.count);
    }
}

