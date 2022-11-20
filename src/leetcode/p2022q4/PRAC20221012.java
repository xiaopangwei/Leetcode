package leetcode.p2022q4;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/10/9
 * @time 8:36 PM
 */
public class PRAC20221012 {


    public String toGoatLatin(String sentence) {

        String[]      array = sentence.split(" ");
        StringBuilder sb    = new StringBuilder();
        int           count = 1;
        for (String item : array) {
            if (item.isEmpty()) {
                continue;
            }
            if (isHit(item.charAt(0))) {
                sb.append(item);
            } else {
                sb.append(item.substring(1));
                sb.append(item.charAt(0));

            }
            sb.append("ma");
            for (int i = 0; i < count; i++) {
                sb.append("a");
            }
            sb.append(" ");
            count++;
        }
        String t = sb.toString();
        return t.substring(0, t.length() - 1);
    }


    private boolean isHit(char ch) {
        char t = ch;
        if (t >= 'A' && t <= 'Z') {
            t = (char) (t + 'a' - 'A');
        }
        if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
            return true;
        }
        return false;
    }


    private int minPayment = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<Integer> buyed = new ArrayList<>();
        minPayment = payForSingle(needs, price);
        for (int i = 0; i < needs.size(); i++) {
            buyed.add(0);
        }
        dfs(buyed, price, special, needs, 0, 0);
        return minPayment;
    }


    private int payForSingle(List<Integer> needs, final List<Integer> price) {
        int s = 0;
        for (int i = 0; i < needs.size(); i++) {
            s += (needs.get(i) * price.get(i));
        }
        return s;
    }

    private void dfs(List<Integer> buyed,
                     final List<Integer> price,
                     final List<List<Integer>> special,
                     final List<Integer> needs,
                     int index,
                     int payment) {
        if (payment >= minPayment) {
            return;
        }
        System.out.println(payment + " " + buyed);
        if (index >= special.size()) {
            List<Integer> remained = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                remained.add(needs.get(i) - buyed.get(i));
            }
            minPayment = Math.min(minPayment, payment + payForSingle(remained, price));
            return;
        }


        dfs(buyed, price, special, needs, index + 1, payment);
        boolean isOk = true;

        List<Integer> newBuyed = new ArrayList<>();
        newBuyed.addAll(buyed);
        for (int i = 0; i < needs.size(); i++) {
            int tt = buyed.get(i) + special.get(index).get(i);
            newBuyed.set(i, tt);
            if (tt > needs.get(i)) {
                isOk = false;
                break;
            }
        }

        if (isOk) {
            int total = special.get(index).get(special.get(0).size() - 1);
            dfs(newBuyed, price, special, needs, index, payment + total);
        }
    }


    List<Integer> minAnsList;


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        Set<String> requiredSkills = new HashSet<>();
        for (String s : req_skills) {
            requiredSkills.add(s);
        }
        int ans = dfs(requiredSkills, people, new HashSet<>(), 0, new ArrayList<>());
        System.out.println("ans:" + ans);
        int[] array = new int[minAnsList.size()];
        for (int i = 0; i < minAnsList.size(); i++) {
            array[i] = minAnsList.get(i);
        }
        return array;
    }


    private int dfs(Set<String> requiredSkills, List<List<String>> people, Set<String> selected, int index, List<Integer> listOfMinLen) {
        if (selected.size() >= requiredSkills.size()) {
            if (contains(selected, requiredSkills)) {
                return 0;
            }
            return -1;
        }

        if (index >= people.size()) {
            return -1;
        }


        Set<String> newSet = new HashSet<>();
        newSet.addAll(selected);
        newSet.addAll(people.get(index));

        int min = requiredSkills.size();

        List<Integer> selectedIndex = new ArrayList<>();
        selectedIndex.addAll(listOfMinLen);
        selectedIndex.add(index);

        int t1 = dfs(requiredSkills, people, newSet, index + 1, selectedIndex);
        int t2 = dfs(requiredSkills, people, selected, index + 1, listOfMinLen);
        if (t1 != -1) {
            min = Math.min(t1 + 1, min);
        }
        if (t2 != -1) {
            min = Math.min(t2, min);
        }


        if (min!=-1) {
            System.out.println(selectedIndex+" "+minAnsList);
            if (min == t1 + 1) {
                minAnsList = selectedIndex;
            } else if (min == t2) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(listOfMinLen);
                minAnsList = temp;
            }
        }
        return min;
    }


    private boolean contains(Set<String> s1, Set<String> s2) {
        for (String s : s1) {
            if (!s2.contains(s)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        PRAC20221012 prac20221012 = new PRAC20221012();
        int[] array = prac20221012.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                Arrays.asList(Arrays.asList("java"),
                        Arrays.asList("nodejs"),
                        Arrays.asList("nodejs", "reactjs")));
//        int ans = prac20221012.shoppingOffers(Arrays.asList(2, 3, 4), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 2, 1));

        System.out.println(Arrays.toString(array));
    }

}
