package leetcode.p20210214;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class KmpSolution {

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


                int j=i-1;
                while (true)
                {
                    if (j<0){
                        break;
                    }
                    int k=table[j];

                    //
                    if (pattern[k]==pattern[i]){
                        table[i]=table[k]+1;
                        break;
                    }
                    else{
                        j=k-1;
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



    public boolean search(char[] txt,char[] pattern,int[] next){
        int i=0;
        int j=0;
        boolean find=false;
        while (true){
            if (i>=txt.length){
                return find;
            }
            if (j==pattern.length-1 && pattern[j]==txt[i]){
                find=true;
                System.out.println(i);
                j=next[j];
            }
            if (txt[i]==pattern[j]){
                i++;
                j++;
            }
            else{
                System.out.println("UnMatch "+i+" "+txt[i]+" "+j+" "+pattern[j]);
                int nextJ=next[j];
                if (nextJ<0){
                    i++;
                    j=0;
                }
                else{
                    j=nextJ;
                }
            }
        }

    }




    public static void main(String[] args){

        String txtStr="BBC ABCDAB ABCDABCDABDABCDABD";
//        String txtStr="BBC ABCDAB ABCDABCDABDE";

        String patternStr="ABCDABD";

        KmpSolution solution28 =new KmpSolution();
        int[]       array      =solution28.getPrefixTable(patternStr.toCharArray());
        for (int i=0;i<array.length;i++){
            System.out.println("("+i+":"+array[i]+")");
        }

        solution28.search(txtStr.toCharArray(),patternStr.toCharArray(),array);
    }
}
