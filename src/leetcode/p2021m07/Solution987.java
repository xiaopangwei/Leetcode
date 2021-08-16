package leetcode.p2021m07;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 9:40 AM
 */
public class Solution987 {


    static class Coordinate{
        public int x;
        public int y;
        public int val;
        public Coordinate(int x,int y,int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (root==null){
            return ans;
        }
        List<Coordinate> coordinates=new ArrayList<>();
        dfs(root,0,0,coordinates);


        Collections.sort(coordinates, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                if (o1.y!=o2.y){
                    return o1.y-o2.y;
                }else if (o1.x!=o2.x){
                    return o1.x-o2.x;
                }else {
                    return o1.val-o2.val;
                }
            }
        });

        int prevY=coordinates.get(0).y;
        List<Integer> groupedList=new ArrayList<>();
        for (int i=0;i<coordinates.size();i++){
            Coordinate temp=coordinates.get(i);
            if (temp.y!=prevY){
                ans.add(groupedList);
                groupedList=new ArrayList<>();
                groupedList.add(temp.val);
                prevY=temp.y;
            }else{
                groupedList.add(temp.val);
            }
        }
        ans.add(groupedList);



        return ans;

    }

    private void dfs(TreeNode root, int verticalId,int horizontalId, final List<Coordinate> list){
        if (root==null){
            return;
        }
        list.add(new Coordinate(horizontalId,verticalId,root.val));
        dfs(root.left,verticalId-1,horizontalId+1,list);
        dfs(root.right,verticalId+1,horizontalId+1,list);
    }

    public static void main(String[] args){
        Solution987         solution987 =new Solution987();
        List<List<Integer>> ans         =solution987.verticalTraversal(TreeNode.ofArray("[3,1,4,0,2,2]"));
        System.out.println(ans);

    }
}
