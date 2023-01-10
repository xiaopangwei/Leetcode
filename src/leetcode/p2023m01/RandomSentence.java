package leetcode.p2023m01;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/7
 * @time 11:02 PM
 */
public class RandomSentence {

    public void random1(String[] array, int m) {
        Map<String, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String item = array[i];
            if (!posMap.containsKey(item)) {
                posMap.put(item, new ArrayList<>());
            }
            posMap.get(item).add(i);
        }

        List<String> ans   = new ArrayList<>();
        int          index = new Random().nextInt(array.length);

        for (int i = 0; i < m; i++) {
            ans.add(array[index]);
            int           nextIndex = (index + 1) % array.length;
            List<Integer> list      = posMap.get(array[nextIndex]);
            index = list.get(new Random().nextInt(list.size()));
        }

        System.out.println(ans);

    }


    public void random2(String[] array, int m, int n) {
        List<List<String>> combinations = new ArrayList<>();
        LinkedList<String> temp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            temp.add(array[i]);
        }
        combinations.add(temp);
        for (int i = n; i < array.length; i++) {
            LinkedList<String> cloned = new LinkedList<>(temp);
            cloned.add(array[i]);
            cloned.removeFirst();
            combinations.add(cloned);
            temp = cloned;
        }

        String[] newArray=new String[combinations.size()];
        for (int i=0;i<combinations.size();i++){

            List<String> list=combinations.get(i);
            StringBuilder sb=new StringBuilder();
            for (String s:list){
                sb.append(s);
                sb.append(" ");
            }
            sb.setLength(sb.length()-1);
            newArray[i]=sb.toString();
        }


        System.out.println(Arrays.toString(newArray));

        random1(newArray,m);



    }


    public static void main(String[] args) {
        RandomSentence randomSentence = new RandomSentence();
        randomSentence.random2("this is a sentence it is a good one and it is also bad".split(" "), 4, 2);
    }

}
