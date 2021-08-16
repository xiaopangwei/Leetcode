package demo.completition;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/24
 * @time 9:30 AM
 */
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {

        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();

        char a='0';
        char b='0';

        int count=0;

        boolean flag=false;
        for (int i=0;i<arr1.length;i++){
            if (arr1[i]!=arr2[i]){
                count++;
                if (a=='0' && b=='0'){
                    a=arr1[i];
                    b=arr2[i];
                }else{
                    if (a==arr2[i] && b==arr1[i]){
                        flag=true;
                    }
                }
            }
        }

        return (count==2 && flag) || count==0;
    }

    public static void main(String[] args){
        Solution1790 solution1790=new Solution1790();
        System.out.println(solution1790.areAlmostEqual("caa","aaz"));
    }

}
