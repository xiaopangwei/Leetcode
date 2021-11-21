package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 10:14 AM
 */
public class Solution917 {
    public String reverseOnlyLetters(String s) {


        char[] array=s.toCharArray();
        int i=0;
        int j=s.length()-1;

        while (i<j){
            while (i<j && !isValid(array[i])){
                i++;
            }

            while (i<j && !isValid(array[j])){
                j--;
            }

            char temp=array[i];
            array[i]=array[j];
            array[j]=temp;

            i++;
            j--;
        }
        return new String(array);
    }

    private boolean isValid(char c){
        if (c>='a' && c<='z'){
            return true;
        }
        if (c>='A' && c<='Z'){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution917 solution917=new Solution917();
        String ans=solution917.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(ans);
    }
}
