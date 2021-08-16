package leetcode.p2021m02.p20210214;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution28 {

    public int[] getPrefixTable(char[] pattern){
        int len=pattern.length;
        int[] table=new int[len];
        table[0]=0;
        int lastPrefixLength=0;

        for (int i=1;i<len;i++){
            lastPrefixLength=table[i-1];
            if (pattern[lastPrefixLength]==pattern[i]){
                table[i]=lastPrefixLength+1;
            }
            else{

                int idx=i-1;
                while (true)
                {

                     int endIndex=table[idx];
                     if (endIndex==0){
                         if (pattern[endIndex]==pattern[i]) {
                             table[i] = table[endIndex] + 1;
                             break;
                         }
                         else{
                             table[i]=0;
                             break;
                         }
                     }
                     else {
                         if (pattern[endIndex] == pattern[i]) {
                             table[i] = table[endIndex] + 1;
                             break;
                         } else {
                             idx = table[endIndex - 1];
                         }
                     }
                }
            }
        }

        for (int i=0;i<table.length;i++){
            System.out.println("("+i+":"+table[i]+")");
        }


        System.out.println("---------------------after");
        for (int i=table.length-1;i>0;i--){
            table[i]=table[i-1];
        }

        table[0]=-1;

        return table;

    }

    public boolean searchByKmp(char[] txt,char[] pattern,int[] table){
        int i=0;int j=0;
        boolean flag=false;
        while (true){
            if (i>=txt.length){
                if (!flag)
                {
                    System.out.println("Not Found");
                    break;
                }

            }

            if (j==pattern.length-1 && txt[i]==pattern[j])
            {
                System.out.println("Found,start at index:"+i);
                flag=true;
            }


            if (txt[i]==pattern[j]){
                i++;
                j++;
            }
            //txt[i]!=pattern[j]
            else{
                    System.out.println(" j miss " + j + "-->" +txt[i]+" "+pattern[i]+" "+table[j]);
                    if (table[j]<0)
                    {
                        j=0;
                        i++;
                    }
                    else {
                        j = table[j];
                    }
                }

            }
        return true;
        }




    public static void main(String[] args){

        String txtStr="acbaabacbaa";

        String patternStr="aabcaabcaac";

        Solution28 solution28=new Solution28();
        int[] array=solution28.getPrefixTable(patternStr.toCharArray());
        for (int i=0;i<array.length;i++){
            System.out.println("("+i+":"+array[i]+")");
        }

//        solution28.searchByKmp(txtStr.toCharArray(),patternStr.toCharArray(),array);
    }
}
