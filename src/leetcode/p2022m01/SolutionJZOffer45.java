package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 11:37 PM
 */
public class SolutionJZOffer45 {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int item : nums) {
            list.add(String.valueOf(item));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        System.out.println(list);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        SolutionJZOffer45 solutionJZOffer45 = new SolutionJZOffer45();
        String            ans               = solutionJZOffer45.minNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(ans);
    }
}
