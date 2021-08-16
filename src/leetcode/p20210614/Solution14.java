package leetcode.p20210614;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/17
 * @time 10:01 AM
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int len=strs.length;
        if (strs.length==1){
            return strs[0];
        }
        if (strs.length==2){
            return getSimpleCommon(strs[0],strs[1]);
        }
        String[] prevArray=new String[len/2];
        String[] nextArray=null;
        if (len%2!=0) {
            nextArray=new String[len / 2 + 1];
        }else{
            nextArray=new String[len / 2];
        }
        int j=0;
        for (int i=0;i<len/2;i++){
            prevArray[j++]=strs[i];
        }
        j=0;
        for (int i=len/2;i<len;i++){
            nextArray[j++]=strs[i];
        }

        String prevCommon=this.longestCommonPrefix(prevArray);
        String nextCommon=this.longestCommonPrefix(nextArray);
        return getSimpleCommon(prevCommon,nextCommon);

    }


    private String getSimpleCommon(String source,String target){
        if (source.length()==0 || target.length()==0){
            return "";
        }
        else{
            int count=0;
            char[] sourceCharArray=source.toCharArray();
            int len=sourceCharArray.length;
            for (int i=0;i<len;i++){
                if (i>=target.length()){
                    break;
                }
                if (sourceCharArray[i]==target.charAt(i)){
                    count++;
                }else{
                    break;
                }
            }
            if (count!=0) {
                return source.substring(0, count);
            }else{
                return "";
            }
        }
    }

    public static void main(String[] args){
        Solution14 solution14=new Solution14();
        String result=solution14.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(result);


    }
}
