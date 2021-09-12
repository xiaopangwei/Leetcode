package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 4:34 PM
 */
public class Solution1236 {
    interface HtmlParser {
        // 返回给定 url 对应的页面中的全部 url 。
        public List<String> getUrls(String url);
    }

    List<String> res = new ArrayList<>();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {


        String domain = getDomain(startUrl);

        dfs(startUrl, htmlParser, domain);

        return res;


    }

    private void dfs(String startUrl, HtmlParser htmlParser, final String domain) {

        if (res.contains(startUrl)) {
            return;
        }

        res.add(startUrl);
        List<String> urls = htmlParser.getUrls(startUrl);
        if (!urls.isEmpty()) {
            for (String url : urls) {
                if (domain.equals(getDomain(url))) {
                    dfs(url, htmlParser, domain);
                }
            }
        }
    }

    private String getDomain(String url) {
        // http://
        if (url.length() < 7) {
            return null;
        }
        int index = url.indexOf("/", 7);
        if (index == -1) {
            return url.substring(7);
        } else {
            return url.substring(7, index);
        }
    }

    public static void main(String[] args) {
        Solution1236 solution1236 = new Solution1236();
        String       domain       = solution1236.getDomain("http://www.baidu.com/tieba/huang/123");
        System.out.println(domain);
    }
}
