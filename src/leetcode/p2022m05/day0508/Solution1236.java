package leetcode.p2022m05.day0508;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 8:44 PM
 */
public class Solution1236 {
    List<String> ans = new ArrayList<>();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        ans.add(startUrl);
        dfs(getHost(startUrl), startUrl, htmlParser);
        return ans;
    }

    private void dfs(String host, String url, HtmlParser htmlParser) {

        List<String> temp = htmlParser.getUrls(url);
        for (String item : temp) {
            if (!getHost(item).equals(host) || ans.contains(item)) {
                continue;
            }
            ans.add(item);
            dfs(host, item, htmlParser);
        }
    }

    public String getHost(String url) {

        int index=url.indexOf('/', 7);
        if (index<0){
            index=url.length();
        }
        return url.substring(7,index);
    }

    public static void main(String[] args){
        Solution1236 solution1236=new Solution1236();
        String ans=solution1236.getHost("");
        System.out.println(ans);
    }
}
