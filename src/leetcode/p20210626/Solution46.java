package leetcode.p20210626;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 2:52 PM
 */
public class Solution46 {
    public int translateNum(int num) {
        String strVal=String.valueOf(num);

        return getTotalKinds(strVal);
    }

    //12258
    public int getTotalKinds(String str){
        char[] charArray=str.toCharArray();
        if (str.length()<=1){
            return 1;
        }
        if (!isValid(charArray[0],charArray[1])){
            return getTotalKinds(str.substring(1));
        }else {
            return getTotalKinds(str.substring(1))+getTotalKinds(str.substring(2));
        }
    }

    private boolean isValid(char ch1,char ch2){
        if (ch1=='0'){
            return false;
        }
        else if (ch1>='3'){
            return false;
        }else if (ch1=='2'){
            if (ch2<='5') {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution46 solution46=new Solution46();
        System.out.println(solution46.getTotalKinds("506"));
//        System.out.println(Solution46.convert(100));
//        System.out.println(Solution46.convert(0));
//        System.out.println(Solution46.convert(5));
//        System.out.println(Solution46.convert(25));
    }
}
