package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/24
 * @time 1:17 PM
 */
public class Solution1736 {
    public String maximumTime(String time) {


        String[] biArray=time.split(":");

        char[] hourArray=biArray[0].toCharArray();
        char[] minuteArray=biArray[1].toCharArray();


        if (hourArray[0]=='?' && hourArray[1]=='?' ){
            hourArray[0]='2';
            hourArray[1]='3';
        }else if (hourArray[0]=='?' ){
            if (hourArray[1]<='3'){
                hourArray[0]='2';
            }else{
                hourArray[0]='1';
            }
        }else if (hourArray[1]=='?'){
            if (hourArray[0]=='2'){
                hourArray[1]='3';
            }else{
                hourArray[1]='9';
            }
        }


        if (minuteArray[0]=='?' && minuteArray[1]=='?' ){
            minuteArray[0]='5';
            minuteArray[1]='9';
        }else if (minuteArray[0]=='?' ){
            minuteArray[0]='5';
        }else if (minuteArray[1]=='?'){
            minuteArray[1]='9';
        }

        StringBuilder builder=new StringBuilder();

        builder.append(hourArray[0]);
        builder.append(hourArray[1]);
        builder.append(":");
        builder.append(minuteArray[0]);
        builder.append(minuteArray[1]);

        return builder.toString();

    }

    public static void main(String[] args){
        Solution1736 solution1736=new Solution1736();
        System.out.println(solution1736.maximumTime("2?:?0"));
        System.out.println(solution1736.maximumTime("0?:3?"));
        System.out.println(solution1736.maximumTime("1?:22"));
    }
}
