package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/26
 * @time 4:03 PM
 */
public class Solution557 {
    public String reverseWords(String s) {
        char[] newArray=s.toCharArray();
        int start=0;
        int end=0;
        int i=0;
        while (i<s.length()){
            if (s.charAt(i)==' '){
                end=i-1;
                //[start-end]
                while (start<=end){
                    char temp=newArray[start];
                    newArray[start]=newArray[end];
                    newArray[end]=temp;
                    start++;
                    end--;
                }
                start=i+1;
            }
            i++;
        }

        end=s.length()-1;
        while (start<=end){
            char temp=newArray[start];
            newArray[start]=newArray[end];
            newArray[end]=temp;
            start++;
            end--;
        }
        return new String(newArray);
    }

    public static void main(String[] args){
        Solution557 solution557=new Solution557();
        String ret=solution557.reverseWords("Ab bB Ccc ");
        System.out.println(ret);
    }
}
