package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 10:42 AM
 */
public class FileNode {
    // /
    // |__a
    // |__b
    //    |__c

    public boolean isDict = true;

    public String absPath;

    public String name;

    public Map<String, FileNode> subFiles;

    public String content;

    public FileNode(String path) {
        this.absPath = path;
        subFiles = new HashMap<>();
    }

    @Override
    public String toString() {
        return "[" + absPath + " " + " " + isDict + "]";
    }

    public static boolean containsSub(FileNode root, String subPath) {
        return root.subFiles.containsKey(subPath);
    }


    public static boolean contains(FileNode root, String subPath) {
        for (Map.Entry<String, FileNode> entry : root.subFiles.entrySet()) {
            if (entry.getValue().name.equals(subPath)) {
                return true;
            }
        }

        return false;
    }


    public static void insert(FileNode root, String path, boolean isDict) {
        FileNode p      = root;
        String[] prefix = path.split("/");
        int      i      = 1;
        while (i < prefix.length) {
            if (containsSub(p, prefix[i])) {
                p = p.subFiles.get(prefix[i]);
            } else {
                FileNode temp = new FileNode(p.absPath + prefix[i] + "/");
                temp.name = prefix[i];
                p.subFiles.put(prefix[i], temp);
                p = temp;
            }

            if (i == prefix.length - 1) {
                p.isDict = isDict;
            }
            i++;
        }
    }

    public static List<String> list(FileNode root, String prefix) {
        FileNode p = search(root, prefix);

        List<String> ans = new ArrayList<>();
        if (!p.isDict) {
            ans.add(p.name);
            return ans;
        } else if (p == null || p.subFiles.isEmpty()) {
            return ans;
        }

        Set<String> pathList = p.subFiles.keySet();
        for (String item : pathList) {
            ans.add(item);
        }

        Collections.sort(ans);
        return ans;
    }

    public static FileNode search(FileNode root, String prefix) {
        FileNode p     = root;
        String[] array = prefix.split("/");
        int      i     = 1;

        while (i < array.length) {
            if (contains(p, array[i])) {
                p = p.subFiles.get(array[i]);
            } else {
                return null;
            }
            i++;
        }
        return p;
    }



    public static void dfs(FileNode root) {

        System.out.println(root);

        for (Map.Entry<String, FileNode> entry : root.subFiles.entrySet()) {
            dfs(entry.getValue());
        }
    }

    public static void main(String[] args) {
        FileNode root = new FileNode("/");
        FileNode.insert(root, "/a/b", true);
        FileNode.insert(root, "/a/c", true);
        FileNode.insert(root, "/a/c/d", false);
        FileNode.insert(root, "/b/c", true);

        System.out.println(FileNode.list(root, "/b"));
    }
}
