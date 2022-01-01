package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/29
 * @time 9:34 PM
 */
public class Solution984 {
    public String strWithout3a3b(int a, int b) {
        StringBuilder builder = new StringBuilder();
        while (true) {
            if (a <= 0 || b <= 0) {
                break;
            }
            if (a > b) {

                builder.append('a');
                builder.append('a');
                builder.append('b');
                a -= 2;
                b--;

            } else if (a < b) {
                builder.append('b');
                builder.append('b');
                builder.append('a');
                b -= 2;
                a--;
            } else {

                builder.append('a');
                builder.append('b');
                a--;
                b--;
            }
        }

        for (int i=0;i<a;i++){
            builder.append("a");
        }
        for (int i=0;i<b;i++){
            builder.append("b");
        }
        return builder.toString();

    }

    public static void main(String[] args){
        Solution984 solution984=new Solution984();
        String ans=solution984.strWithout3a3b(4,1);
        System.out.println(ans);
    }
}
