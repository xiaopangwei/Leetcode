package leetcode.p20210708;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/6
 * @time 11:13 PM
 */
public class Solution1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans=new ArrayList<>();

        Set<String> foodSets=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Set<Integer> tableSets=new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        //tableID
        Map<String,Map<String,Integer>> tableIdAndFoodMap=new HashMap<>();
        for (List<String> temp:orders){
            foodSets.add(temp.get(2));
            tableSets.add(Integer.parseInt(temp.get(1)));
            if (!tableIdAndFoodMap.containsKey(temp.get(1)))
            {
                tableIdAndFoodMap.put(temp.get(1),new HashMap<>());
            }
            Map<String,Integer> foodItemAndCountMap=tableIdAndFoodMap.get(temp.get(1));
            foodItemAndCountMap.put(temp.get(2),foodItemAndCountMap.getOrDefault(temp.get(2),0)+1);
        }

        List<String> head=new ArrayList<>();
        head.add("Table");
        head.addAll(foodSets);
        ans.add(head);
        for (int tableId:tableSets){
            List<String> rows=new ArrayList<>();
            rows.add(String.valueOf(tableId));
            for (String foodName:foodSets){
                Map<String,Integer> tableMap=tableIdAndFoodMap.get(String.valueOf(tableId));
                if (!tableMap.containsKey(foodName)){
                    rows.add("0");
                }else {
                    rows.add(String.valueOf(tableMap.get(foodName)));
                }
            }
            ans.add(rows);
        }

        return ans;
    }

    public static void main(String[] args){
        Solution1418 solution1418=new Solution1418();
        List<List<String>> inAgs=new ArrayList<>();
        List<String> arg1=Arrays.asList("Laura","2","Bean Burrito");
        List<String> arg2=Arrays.asList("Jhon","2","Beef Burrito");
        List<String> arg3=Arrays.asList("Melissa","2","Soda");

        inAgs.add(arg1);
        inAgs.add(arg2);
        inAgs.add(arg3);
        List<List<String>> ans=solution1418.displayTable(inAgs);
        System.out.println(ans);
    }
}
