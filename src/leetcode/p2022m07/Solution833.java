package leetcode.p2022m07;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 9:28 PM
 */
public class Solution833 {


    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        StringBuilder          sb  = new StringBuilder();
        int                    n   = indices.length;
        Map<Integer, String[]> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(indices[i], new String[]{sources[i], targets[i]});
        }


        int[]    newIndices = new int[n];
        String[] newSource  = new String[n];
        String[] newTargets = new String[n];
        int      ii         = 0;
        for (Map.Entry<Integer, String[]> entry : map.entrySet()) {
            newIndices[ii] = entry.getKey();
            newSource[ii] = entry.getValue()[0];
            newTargets[ii] = entry.getValue()[1];
            ii++;
        }

        indices = newIndices;
        sources = newSource;
        targets = newTargets;


        int index = 0;
        int i     = 0;
        while (i < s.length()) {
            if (i > indices[indices.length-1] || i != indices[index]) {
                sb.append(s.charAt(i));
                i++;
            } else {
                int    len = sources[index].length();
                String t   = s.substring(indices[index], indices[index] + len);
                if (t.equals(sources[index])) {
                    sb.append(targets[index]);
                } else {
                    sb.append(t);
                }
                i = i + len;
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution833 solution833 = new Solution833();
        //"abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]


//        "vmokgggqzp"
//                [3,5,1]
//        ["kg","ggq","mo"]
//        ["s","so","bfr"]
        String t = solution833.findReplaceString("vmokgggqzp", new int[]{3, 5, 1}, new String[]{"kg", "ggq", "mo"},
                new String[]{"s", "so", "bfr"});
        System.out.println(t);
    }

}
