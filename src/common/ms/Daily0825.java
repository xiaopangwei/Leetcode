package common.ms;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/25
 * @time 10:35 PM
 */
public class Daily0825 {
    static final long MAX_V = (long) Math.pow(10, 9) + 7L;

    public int slidingPuzzle(int[][] board) {
        return bfs(board);
    }

    private int bfs(int[][] board) {

        List<List<Integer>> directions = new ArrayList<>();
        directions.add(Arrays.asList(1, 3));
        directions.add(Arrays.asList(0, 2, 4));
        directions.add(Arrays.asList(1, 5));
        directions.add(Arrays.asList(0, 4));
        directions.add(Arrays.asList(1, 3, 5));
        directions.add(Arrays.asList(2, 4));
        Queue<String> queue = new LinkedList<>();
        StringBuilder sb    = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(String.valueOf(board[i][j]));
            }
        }
        String initial = sb.toString();
        queue.add(initial);
        int         level   = 0;
        Set<String> visited = new HashSet<>();
        visited.add(initial);
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                String temp = queue.poll();
                if (temp.equals("123450")) {
                    return level;
                }

                for (int j = 0; j < 6; j++) {
                    if (temp.charAt(j) == '0') {
                        List<Integer> directList = directions.get(j);
                        for (int d : directList) {
                            String res = swap(temp, d, j);
                            if (visited.contains(res)) {
                                continue;
                            }
                            queue.add(res);
                            visited.add(res);
                        }
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char          ci = s.charAt(i);
        char          cj = s.charAt(j);
        sb.setCharAt(i, cj);
        sb.setCharAt(j, ci);
        return sb.toString();
    }

    int MAX = 1000000007;

    public int concatenatedBinary(int n) {
        return (int) concatenatedBinary1(n);
    }

    public long concatenatedBinary1(int n) {

        long res = 0;
        for (int i = 1; i <= n; i++) {
            int d = getDigits(i);
            res = ((res << d) % MAX + i % MAX) % MAX;
        }
        return res;
    }

    private int getDigits(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n >>= 1;
        }
        return cnt;
    }

    private String convert(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 0) {
                sb.append('0');
            } else {
                sb.append('1');
            }
            n /= 2;
        }
        if (sb.length() == 0) {
            return "";
        }
        if (sb.length() == 1 && sb.charAt(0) == '0') {
            return "";
        }
        return sb.reverse().toString();
    }


    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String, Set<String>> nextMap     = new HashMap<>();
        List<String>             visited     = new ArrayList<>();
        Map<String, Integer>     indegreeMap = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String r = recipes[i];
            for (String item : ingredients.get(i)) {
                indegreeMap.put(r, indegreeMap.getOrDefault(r, 0) + 1);
                if (!nextMap.containsKey(item)) {
                    nextMap.put(item, new HashSet<>());
                }
                nextMap.get(item).add(r);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String s : supplies) {
            queue.add(s);
        }
        while (!queue.isEmpty()) {
            String      item = queue.poll();
            Set<String> sets = nextMap.get(item);
            if (sets != null) {
                for (String s : sets) {
                    int d = indegreeMap.getOrDefault(s, 0) - 1;
                    if (d <= 0) {
                        queue.add(s);
                        visited.add(s);
                    }
                    indegreeMap.put(s, d);
                }
            }
        }
        return visited;
    }

    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;

        int index1 = m;
        int index2 = n;

        int           carry = 0;
        StringBuilder sb    = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int t = a.charAt(index1) - '0' + b.charAt(index2) - '0' + carry;
            if ((t & 1) == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            carry = t / 2;

            index1--;
            index2--;
        }

        while (index1 >= 0) {
            int t = a.charAt(index1) - '0' + carry;
            if ((t & 1) == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            carry = t / 2;
            index1--;
        }

        while (index2 >= 0) {
            int t = b.charAt(index2) - '0' + carry;
            if ((t & 1) == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            carry = t / 2;
            index2--;
        }

        if (carry != 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }


    static class NumArray {

        int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }


//    Map<String, Integer> cached = new HashMap<>();

    public int maxUniqueSplit(String s) {
        return dfs(s, 0, new HashSet<>());
    }

    private int dfs(final String s, int startIndex, Set<String> visited) {
        StringBuilder sb = new StringBuilder();
        sb.append(startIndex);
        sb.append("%");
        for (String item : visited) {
            sb.append(item);
            sb.append("#");
        }
        String biKey = sb.toString();
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (startIndex >= s.length()) {
            return 0;
        }

        int maxVal = 0;
        for (int i = 1; i <= s.length(); i++) {
            int endIndex = startIndex + i - 1;
            if (endIndex >= s.length()) {
                break;
            }
            String temp = s.substring(startIndex, endIndex + 1);
            if (visited.contains(temp)) {
                continue;
            }
            visited.add(temp);
            maxVal = Math.max(maxVal, dfs(s, endIndex + 1, visited) + 1);
            visited.remove(temp);
        }

        cached.put(biKey, maxVal);
        return maxVal;
    }


    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int ans = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }

        ans += sumOfLeftLeaves(root.left);
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }


    Map<String, Integer> cached = new HashMap<>();

    public int lastStoneWeightII(int[] stones) {
        int s = 0;
        for (int item : stones) {
            s += item;
        }
        int temp = dfs(stones, 0, 0, s);
        return Math.abs(s - temp - temp);
    }


    private int dfs(int[] stone, int startIndex, int currentSum, int sum) {
        String biKey = startIndex + "#" + currentSum;
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (startIndex >= stone.length) {
            return currentSum;
        }
        int t1   = currentSum + stone[startIndex];
        int s1   = dfs(stone, startIndex + 1, t1, sum);
        int gap1 = Math.abs(sum - s1 - s1);

        int s2   = dfs(stone, startIndex + 1, currentSum, sum);
        int gap2 = Math.abs(sum - s2 - s2);

        if (gap1 < gap2) {
            cached.put(biKey, s1);
            return s1;
        } else {
            cached.put(biKey, s2);
            return s2;
        }

    }

    public static void main(String[] args) {
        Daily0825 daily0825 = new Daily0825();
//        int       ans       = daily0825.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}});
//        System.out.println(ans);
//        String[] recipes = new String[]{"bread", "sandwich", "burger"};
//        List<List<String>> ingredients = Arrays.asList(Arrays.asList("yeast", "flour"),
//                Arrays.asList("bread", "meat"), Arrays.asList("sandwich", "meat", "bread"));
//        String[] supplies = new String[]{"yeast", "flour", "meat"};
//        System.out.println(daily0825.findAllRecipes(recipes, ingredients, supplies));
//        System.out.println(daily0825.addBinary("1010", "1011"));
//        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
//        System.out.println(numArray.sumRange(0, 2));
//        System.out.println(numArray.sumRange(2, 5));
//        int ans = daily0825.maxUniqueSplit("wwwzfvedwfvhsww");
        int ans = daily0825.lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
        System.out.println(ans);
    }
}
