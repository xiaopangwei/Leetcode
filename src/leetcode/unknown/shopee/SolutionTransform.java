package leetcode.unknown.shopee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/14
 * @time 10:49 AM
 */
public class SolutionTransform {

    public String caseTransform(String src){

        return String.join(" ",getList(src));
    }

    private List<String> getList(String src){
        List<String> ans=new ArrayList<>();
        ans.add(src);

        char[] charArray=src.toCharArray();

        LinkedList<Integer> upperIndex =new LinkedList<>();

        for (int i=0;i<charArray.length;i++){
            if (charArray[i]>='A' && charArray[i]<='Z' && i!=0){
                upperIndex.add(i);
            }
        }

        //1 case
        char[] firstCase =charArray.clone();
        firstCase[0]=(char)('a'+charArray[0]-'A');
        ans.add(new String(firstCase));


        //2&3 case

        List<String> part=new ArrayList<>();

        String loweredSrc=src.toLowerCase();
        upperIndex.addFirst(0);
        upperIndex.addLast(charArray.length);
        for (int i=0;i<upperIndex.size()-1;i++){
            part.add(loweredSrc.substring(upperIndex.get(i),upperIndex.get(i+1)));
        }

        ans.add(String.join("_",part));
        ans.add(String.join("-",part));
        return ans;
    }

    public static void main(String[] args){
        SolutionTransform solutionTransform=new SolutionTransform();
        System.out.println(solutionTransform.caseTransform("PascalCaseTest"));
    }
}
