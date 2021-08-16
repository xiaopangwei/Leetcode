package demo.lcs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/23
 * @time 4:56 PM
 */
public class SolutionLCS02 {
    public int halfQuestions(int[] questions) {

        Map<Integer,Integer> typeAndFreqMap=new HashMap<>();
        for (int i=0;i<questions.length;i++){
            if (!typeAndFreqMap.containsKey(questions[i])){
                typeAndFreqMap.put(questions[i],1);
            }else{
                typeAndFreqMap.put(questions[i],typeAndFreqMap.get(questions[i])+1);
            }
        }

        List<Map.Entry<Integer,Integer>> sortedList=typeAndFreqMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        }).collect(Collectors.toList());

        int n=questions.length/2;
        int index=0;
        while (true){
            if (n==0){
                break;
            }
            int temp=sortedList.get(index).getValue();
            if (n>=temp){
                index++;
                n-=temp;
            }else{
                index++;
                break;
            }

        }
        return index;
    }


    public static void main(String[] args){
        SolutionLCS02 solutionLCS02=new SolutionLCS02();
        int count=solutionLCS02.halfQuestions(new int[]{2,1,6,2});
        System.out.println(count);
    }

}
