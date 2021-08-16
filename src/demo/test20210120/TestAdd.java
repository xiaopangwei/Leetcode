package demo.test20210120;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/20
 * @time 10:04 PM
 */
public class TestAdd {

    public int getSum(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;

    }

    public static void main(String[] args) throws Exception{

        int a=17;
        int b=16;
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);

        TestAdd adder=new TestAdd();
        System.out.println(adder.getSum(13,45));
        System.out.println(adder.hammingWeight(13));
    }
}
