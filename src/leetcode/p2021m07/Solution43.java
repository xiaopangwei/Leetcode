package leetcode.p2021m07;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/26
 * @time 1:40 PM
 */
public class Solution43 {
    public String multiply(String num1, String num2) {

       char[] a1=num1.toCharArray();
       char[] a2=num2.toCharArray();
       LinkedList<Long> res=new LinkedList<>();

        long left=0;
        long base1=1;
        long temp=1;
       for (int i=a2.length-1;i>=0;i--){
           long last=a2[i]-'0';
           last=last*base1;
           base1*=10;
           long sum=0;
           sum+=left;

           long base2=1;
           for (int j=a1.length-1;j>=0;j--){
               sum+=(last*(a1[j]-'0')*base2);
               base2*=10;
           }

           long a=(sum/temp)%10;
           res.addFirst(a);
           temp*=10;
           left=(sum/temp)*temp;
       }

        long carry=left / temp;


       StringBuilder stringBuilder=new StringBuilder();

       if (carry!=0) {
           stringBuilder.append(String.valueOf(carry));
       }

       while (carry==0 && !res.isEmpty() && res.getFirst()==0){
           res.removeFirst();
       }

       if (carry==0 && res.isEmpty()){
           return "0";
       }
       while (!res.isEmpty())
       {
           long a=res.getFirst();
           System.out.println(a +" "+String.valueOf(a));
           stringBuilder.append(String.valueOf(a));

           res.removeFirst();
       }
       return stringBuilder.toString();
    }

    public static void main(String[] args){
//        "498828660196"
//        "840477629533"
        Solution43 solution43=new Solution43();
        String res=solution43.multiply("498828660196","840477629533");
        System.out.println(res);
    }
}
