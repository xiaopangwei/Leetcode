package leetcode.p20210218;

import java.util.*;
import java.util.stream.Stream;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:25 PM
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
       char[] charArray=s.toCharArray();
       int i=0;
       int j=s.length()-1;
       while (i<j){
           while (i<j && !isValid(charArray[i]) ) {i++;}
           while (i<j && !isValid(charArray[j])  ) {j--;}
           if (lower(charArray[i])!=lower(charArray[j])){
               return false;
           }else{
               i++;
               j--;
           }
       }
        return true;
    }

    private boolean isValid(char ch){
        if (ch>='0' && ch<='9')
            return true;
        if (ch>='a' && ch<='z')
            return true;
        if (ch>='A' && ch<='Z')
            return true;
        return false;
    }

    private int lower(char ch){
        if (ch>='A'&& ch<='Z'){
            return ch-'A';
        }
        else if (ch>='a'&& ch<='z'){
            return ch-'a';
        }else{
            return ch;
        }
    }
    public static void main(String[] args){
        Palindrome palindrome=new Palindrome();
        System.out.println(palindrome.isPalindrome("race a car"));
    }
}
