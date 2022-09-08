package common.simu;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/8
 * @time 11:02 PM
 */
public class Amazon0708 {
    public static int maxSetSize(List<Integer> riceBags) {
        // Write your code here
        Collections.sort(riceBags);
        int[] dp = new int[riceBags.size()];
        Arrays.fill(dp, -1);
        for (int i = 1; i < dp.length; i++) {
            int s = (int) Math.sqrt(riceBags.get(i));
            if (s * s == riceBags.get(i)) {
                for (int j = 0; j < i; j++) {
                    int t = riceBags.get(j);
                    if (t * t == riceBags.get(i)) {
                        dp[i] = Math.max(1, dp[j]) + 1;
                    }
                }
            }
        }

        int maxLen = -1;
        for (int i = 0; i < dp.length; i++) {
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;

    }


    public static long findMaxProducts(List<Integer> products) {
        // Write your code here

        int n = products.size();

//        //左边第一个比高
//        int[] left = new int[n];
//        Arrays.fill(left, -1);
//
//        int[] right = new int[n];
//        Arrays.fill(right, n);
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = n - 1; i >= 0; i--) {
//            if (stack.isEmpty()) {
//                stack.push(i);
//            } else {
//                while (!stack.isEmpty() && products.get(i) > products.get(stack.peek())) {
//                    left[stack.pop()] = i;
//                }
//                stack.push(i);
//            }
//        }
//        //右边第一个比低
//
//        stack.clear();
//        for (int i = 0; i < n; i++) {
//            if (stack.isEmpty()) {
//                stack.push(i);
//            } else {
//                while (!stack.isEmpty() && products.get(i) < products.get(stack.peek())) {
//                    right[stack.pop()] = i;
//                }
//                stack.push(i);
//            }
//        }
//
//
//        for (int i=0;i<n;i++){
//            int l=left[i];
//            int r=right[i];
//
//            int s=0;
//            for (int j=l+1;j<r;i++){
//                s+=products.get(j);
//            }
//
//
//            while (l>=0){
//                if (products.get())
//            }
//        }
//
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));


        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = i; j < n; j++) {
                arr.add(products.get(j));
            }

            List<Integer> sorted = new ArrayList<>();
            sorted.addAll(arr);
            Collections.sort(sorted);
            int ans = 0;
            for (int t = 0; t < sorted.size(); t++) {
                if (sorted.get(t) == arr.get(t)) {
                    ans += sorted.get(t);
                } else if (arr.get(t) > sorted.get(t)) {
                    ans += sorted.get(t) - 1;
                } else {
                    ans += sorted.get(t);
                }
            }

        }


        return 0;
    }


    int ans = 0;

    public int sumNumbers(TreeNode root, int s) {
        dfs(root, 0);
        return ans;
    }


    private void dfs(TreeNode root, int s) {
        if (root == null) {
            return;
        }
        int temp = s * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += temp;
            return;
        }

        dfs(root.left, temp);
        dfs(root.right, temp);
    }


    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> freq = new HashMap<>();
        for (String item : cpdomains) {
            int i = 0;
            int t = 0;
            while (i < item.length() && item.charAt(i) != ' ') {
                t = t * 10 + item.charAt(i) - '0';
                i++;
            }

            String   domain = item.substring(i + 1);
            String[] array  = domain.split("\\.");
            String   key    = "";
            for (int j = array.length - 1; j >= 0; j--) {
                if (array[j].length() > 0 && key.length() > 0) {
                    key = array[j] + "." + key;
                } else {
                    key = array[j];
                }
                freq.put(key, freq.getOrDefault(key, 0) + t);
            }
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }


    public int widthOfBinaryTree(TreeNode root) {

        int maxWidth = 0;
        root.val = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            int s = queue.size();
            maxWidth = Math.max(queue.getLast().val - queue.getFirst().val + 1, maxWidth);
            for (int i = 0; i < s; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    queue.add(node.right);
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        Amazon0708 solution0708 = new Amazon0708();
        //3
//        long ans = Amazon0708.findMaxProducts(Arrays.asList(2, 9, 4, 7, 5, 2));
        List<String> ans = solution0708.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
        System.out.println(ans);

    }
}
