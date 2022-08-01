package common.ms;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/9/6
 * @time 10:31 PM
 */
public class BrowserHistory {


    LinkedList<String> pageList;
    int curr   = 0;
    int maxLen = 0;

    public BrowserHistory(String homepage) {
        pageList = new LinkedList<>();
        pageList.add(homepage);
        maxLen = 1;
    }

    public void visit(String url) {
        pageList.add(++curr, url);
        maxLen = curr + 1;
    }

    public String back(int steps) {
        if (curr <= steps) {
            curr = 0;
            return pageList.get(0);
        } else {
            curr -= steps;
            return pageList.get(curr);
        }
    }

    public String forward(int steps) {
        if (curr + steps >= maxLen) {
            curr = maxLen - 1;
            return pageList.get(maxLen - 1);
        } else {
            curr += steps;
            return pageList.get(curr);
        }
    }
}
