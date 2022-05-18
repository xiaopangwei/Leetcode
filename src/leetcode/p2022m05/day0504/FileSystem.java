package leetcode.p2022m05.day0504;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 7:19 PM
 */
public class FileSystem {

    class FileNode {
        String                name;
        Map<String, FileNode> nextLevels;
        boolean isDict          = true;
        String  originalContent = "";

        public FileNode(String name) {
            nextLevels = new HashMap<>();
            this.name = name;
        }
    }

    FileNode root;

    public FileSystem() {
        root = new FileNode("/");
    }

    public List<String> ls(String path) {
        FileNode     p     = root;
        List<String> ans   = new ArrayList<>();
        String[]     array = path.split("/");
        for (String item : array) {
            if (item.isEmpty()) {
                continue;
            }
            if (p.nextLevels.containsKey(item)) {
                p = p.nextLevels.get(item);
            }
        }

        if (!p.isDict) {
            return Arrays.asList(p.name);
        }
        for (String item : p.nextLevels.keySet()) {
            ans.add(item);
        }
        Collections.sort(ans);
        return ans;
    }

    public void mkdir(String path) {
        FileNode p     = root;
        String[] array = path.split("/");
        for (String item : array) {
            if (item.isEmpty()) {
                continue;
            }
            if (p.nextLevels.containsKey(item)) {
                p = p.nextLevels.get(item);
            } else {
                FileNode newNode = new FileNode(item);
                p.nextLevels.put(item, newNode);
                p = newNode;
            }
        }
    }

    public void addContentToFile(String filePath, String content) {
        FileNode p     = root;
        String[] array = filePath.split("/");
        for (String item : array) {
            if (item.isEmpty()) {
                continue;
            }
            if (p.nextLevels.containsKey(item)) {
                p = p.nextLevels.get(item);
            } else {
                FileNode newNode = new FileNode(item);
                p.nextLevels.put(item, newNode);
                p = newNode;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.originalContent);
        stringBuilder.append(content);
        p.isDict = false;
        p.originalContent = stringBuilder.toString();
    }

    public String readContentFromFile(String filePath) {
        FileNode p     = root;
        String[] array = filePath.split("/");
        for (String item : array) {
            if (item.isEmpty()) {
                continue;
            }
            if (p.nextLevels.containsKey(item)) {
                p = p.nextLevels.get(item);
            }
        }
        return p.originalContent;
    }

    public static void main(String[] args) {
        FileSystem   fileSystem = new FileSystem();
        List<String> ans        = fileSystem.ls("/");                         // 返回 []
        System.out.println(ans);
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        fileSystem.ls("/");                         // 返回 ["a"]
        fileSystem.readContentFromFile("/a/b/c/d");


        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));


    }
}
