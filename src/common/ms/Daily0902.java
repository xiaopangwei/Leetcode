package common.ms;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/9/2
 * @time 10:18 PM
 */
public class Daily0902 {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;

        int tIndex=0;
        while(i<name.length()){
            int j=i+1;
            while(j<name.length() && name.charAt(j)==name.charAt(i)){
                j++;
            }

            int len=j-i;
            if (tIndex>=typed.length()){
                return false;
            }
            char ch=typed.charAt(tIndex);

            int temp=tIndex+1;
            while(temp<typed.length() && typed.charAt(temp)==ch){
                temp++;
            }
            int len2=temp-tIndex;

            if(name.charAt(i)==typed.charAt(tIndex) && len2>=len){
                i=j;
                tIndex=temp;
            }else{
                return false;
            }
        }
        return i==name.length() && tIndex==typed.length();
    }

    public static void main(String[] args){
        Daily0902 daily0902=new Daily0902();
        boolean ans=daily0902.isLongPressedName("alexd","ale");
        System.out.println(ans);
    }
}
