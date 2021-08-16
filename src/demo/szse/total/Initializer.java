package demo.szse.total;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/1
 * @time 12:45 AM
 */
public class Initializer {

    private int age;
    private String name;
    private int salary=123;

    {
        common=128;
        System.out.println("huangwei");
    }

    private static Initializer instance=new Initializer();
    static {
        common=88;
    }


    static int common;


    public Initializer(){
        common=256;
        System.out.println(age+" "+name+" "+this.salary);
    }


    public static void main(String[] args){
        System.out.println(Initializer.common);

    }
}
