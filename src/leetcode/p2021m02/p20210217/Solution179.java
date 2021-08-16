package leetcode.p2021m02.p20210217;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/17
 * @time 10:31 AM
 */
public class Solution179 {
    public String largestNumber(int[] nums) {

        return null;
    }


    static class MyComparator implements Comparator<String>
    {


        @Override
        public int compare(String o1, String o2) {
            String a=o1+o2;
            String b=o2+o1;
            //o1="9"
            //o2="98"
            //a="998"
            //b="989"
            return b.compareTo(a);
        }
    }


    public static void main(String[] args) throws Exception{
        Solution179 solution134 =new Solution179();

        System.out.println("123".compareTo("345"));
        System.out.println("123".compareTo("045"));

        String[] a1=new String[]{"10","0123","956","499"};
        Arrays.sort(a1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int result= o1.compareTo(o2);
                System.out.println("o1:"+o1+" o2:"+o2+". result:"+result);
                return result;
            }
        });

        System.out.println(Arrays.toString(a1));



        String[] array=new String[]{"543","345","876","32","23","9","11","98"};

        Arrays.sort(array,new MyComparator());

        System.out.println(Arrays.toString(array));


    }
}
