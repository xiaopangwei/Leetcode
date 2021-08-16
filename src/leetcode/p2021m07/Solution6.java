package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 11:13 PM
 */
public class Solution6 {
    public String convert(String s, int numRows) {

        List<List<Character>> nestedList=new ArrayList<>();

        for (int i=0;i<numRows;i++){
            nestedList.add(new ArrayList<>());
        }

        if (numRows==1){
            return s;
        }
        int mod=(numRows-1)*2;
        for (int i=0;i<s.length();i++){

            int temp=i%mod;
            int listId=temp;
            if (temp>=mod/2){
                listId=mod-temp;
            }
            nestedList.get(listId).add(s.charAt(i));
        }

        StringBuilder stringBuilder=new StringBuilder();

        for (List<Character> item:nestedList){

            for (Character ch:item){

                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args){
        Solution6 solution6=new Solution6();
        String src=solution6.convert("PAYPALISHIRING",3);
        System.out.println(src);

    }

}
