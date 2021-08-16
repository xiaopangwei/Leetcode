package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 3:09 PM
 */
public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int                accountLength       = accounts.size();
        int[]              parents             = new int[accountLength];
        String[]           accountName         = new String[accountLength];
        List<List<String>> accountPossibleList = new ArrayList<>();
        for (int i = 0; i < accountLength; i++) {
            accountName[i] = accounts.get(i).get(0);
            parents[i] = i;
            List<String> items = new ArrayList<>();
            for (int j = 1; j < accounts.get(i).size(); j++) {
                items.add(accounts.get(i).get(j));
            }
            accountPossibleList.add(items);
        }

        for (int i = 0; i < accountLength; i++) {
            List<String> prevList = accountPossibleList.get(i);
            for (int j = i + 1; j < accountLength; j++) {

                List<String> nextList = accountPossibleList.get(j);

                for (String acc : nextList) {
                    if (prevList.contains(acc)) {
//                        System.out.println("parent => " + j + " " + i);
                        if (parents[j] == j) {
                            parents[j] = i;
//                            System.out.println(j + " ==> " + i);
                        } else {
                            int temp1 = i;
                            int temp2 = j;

                            while (parents[temp1] != temp1) {
                                temp1=parents[temp1];
                            }

                            while (parents[temp2] != temp2) {
                                temp2=parents[temp2];
                            }

                            int maxVal = Math.max(temp1, temp2);
                            int minVal = Math.min(temp1, temp2);

//                            System.out.println(maxVal + " ==> " + minVal);
                            parents[maxVal] = minVal;
                        }
                    }
                }

            }
        }
        System.out.println(Arrays.toString(parents));
        Map<Integer, Set<String>> ans = new HashMap<>();
        for (int i = 0; i < accountLength; i++) {
            if (parents[i] == i) {
                Set<String> temp = new TreeSet<>();
                temp.addAll(accountPossibleList.get(i));
                ans.put(i, temp);
            } else {
                int j = parents[i];
                while (parents[j] != j) {
                    j = parents[j];
                }
                if (!ans.containsKey(j)) {
                    ans.put(j, new HashSet<>());
                }
                ans.get(j).addAll(accountPossibleList.get(i));
            }
        }

        List<List<String>> res  = new ArrayList<>();
        Set<Integer>       keys = ans.keySet();
        for (int key : keys) {
            List<String> temp = new ArrayList<>();
            temp.add(accountName[key]);
            temp.addAll(ans.get(key));
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution721 solution721 = new Solution721();
//                "Lily","Lily3@m.co","Lily4@m.co","Lily17@m.co",
//                "Lily","Lily5@m.co","Lily3@m.co","Lily23@m.co",
//                "Lily","Lily0@m.co","Lily1@m.co","Lily8@m.co",
//                "Lily","Lily14@m.co","Lily23@m.co",
//                "Lily","Lily4@m.co","Lily5@m.co","Lily20@m.co",
//                "Lily","Lily1@m.co","Lily2@m.co","Lily11@m.co",
//                "Lily","Lily2@m.co","Lily0@m.co","Lily14@m.co"
        List<List<String>> input = Arrays.asList(
                Arrays.asList("Lily", "Lily3@m.co", "Lily4@m.co", "Lily17@m.co"),
                Arrays.asList("Lily", "Lily5@m.co", "Lily3@m.co", "Lily23@m.co"),
                Arrays.asList("Lily", "Lily0@m.co", "Lily1@m.co", "Lily8@m.co"),
                Arrays.asList("Lily", "Lily14@m.co", "Lily23@m.co"),
                Arrays.asList("Lily", "Lily4@m.co", "Lily5@m.co", "Lily20@m.co"),
                Arrays.asList("Lily", "Lily1@m.co", "Lily2@m.co", "Lily11@m.co"),
                Arrays.asList("Lily", "Lily2@m.co", "Lily0@m.co", "Lily14@m.co")
        );
        System.out.println(solution721.accountsMerge(input));

    }
}
