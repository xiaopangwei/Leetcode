package leetcode.p2021m08;

import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 10:41 AM
 */
public class FileSystem {

    FileNode root;

    public FileSystem() {
        root = new FileNode("/");
    }

    public List<String> ls(String path) {
        return FileNode.list(root, path);
    }

    public void mkdir(String path) {
        FileNode.insert(root, path, true);
    }

    public void addContentToFile(String filePath, String content) {
        FileNode temp = FileNode.search(root, filePath);
        if (temp == null) {
            FileNode.insert(root, filePath, false);
            FileNode current = FileNode.search(root, filePath);
            current.content = content;
        } else {
            temp.content = temp.content + content;
        }
    }

    public String readContentFromFile(String filePath) {
        FileNode current = FileNode.search(root, filePath);
        if (current == null) {
            return null;
        }
        return current.content;
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
//        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/cc", "test");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
//        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));

        fileSystem.addContentToFile("/a/b/c/d", " world");
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d"));

        System.out.println(fileSystem.ls("/a/b/c/d"));

    }
}
