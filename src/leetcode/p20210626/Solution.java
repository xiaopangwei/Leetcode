package leetcode.p20210626;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/27
 * @time 10:08 AM
 */
class Solution {
    public boolean isMatch(String s, String p) {
        TestPattern pattern = new TestPattern();
        pattern.compile(p);
        return pattern.matches(s);
    }
    class TestPattern {
        //状态机节点
        private PartternNode rootPartternNode;

        private void compile(String reg) {
            rootPartternNode = new PartternNode();
            if (reg.equals("")) {
                rootPartternNode.setEnd(true);
                return;
            }
            Map<Integer, PartternNode> indexPartternNodeMap = new HashMap<>();
            indexPartternNodeMap.put(-1, rootPartternNode);
            for (int i = 0; i < reg.length(); i++) {
                char regChar = reg.charAt(i);
                PartternNode node = null;
                if (indexPartternNodeMap.get(i) == null) {
                    node = new PartternNode();
                    indexPartternNodeMap.put(i, node);
                }
                node.setNextnodeFunc(new ArrayList<>());
                node.setValue(regChar);
                PartternNode parent = indexPartternNodeMap.get(i - 1);
                if (parent.getValue() == '*') {
                    //设置上上个节点、 上上上个节点，到这个节点的连线
                    int j = 1;
                    while (true) {
                        PartternNode tempParent = indexPartternNodeMap.get(i - j * 2);
                        if (tempParent != null) {
                            setLines(regChar, node, tempParent);
                        }
                        PartternNode grandParent = indexPartternNodeMap.get(i - 1 - j * 2);
                        if (grandParent != null) {
                            setLines(regChar, node, grandParent);
                            if (grandParent.getValue() == '*') {
                                j++;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                //设置上一节点到这个节点的连线。
                if (i == reg.length() - 1) {
                    node.setEnd(true);
                }
                setLines(regChar, node, parent);
                if (regChar == '*') {
                    // 设置上一个/上上个 节点为终点
                    // "**" 这种是非法表达式
                    if (i == reg.length() - 1) {
                        int j = 1;
                        while (j != 0) {
                            PartternNode tempParent = indexPartternNodeMap.get(i + 1 - j * 2);
                            if (tempParent != null) {
                                tempParent.setEnd(true);
                            }
                            PartternNode grandParent = indexPartternNodeMap.get(i - j * 2);
                            if (grandParent != null) {
                                grandParent.setEnd(true);
                                if (grandParent.getValue() == '*') {
                                    j++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    //设置上一个 节点自旋 连线
                    setLines(parent.getValue(), parent, parent);
                }
            }
            System.out.println("END");
        }

        private void setLines(char regChar, PartternNode node, PartternNode parent) {
            List<BiFunction<String, Integer, PartternNode>> nextnodeFunc = parent.getNextnodeFunc();
            PartternNode finalNode = node;
            System.out.println("assert"+regChar+" "+node.value);
            System.out.println("setLines node:"+node.value+" parent:"+parent.value);
            if (regChar != '.' && regChar != '*') {
                //设置一般字符匹配连线
                nextnodeFunc.add(new BiFunction<String, Integer, PartternNode>() {
                    @Override
                    public PartternNode apply(String s, Integer integer) {
                        if (s.charAt(integer) != regChar) {
                            return null;
                        }
                        return finalNode;
                    }
                });
            } else if (regChar == '.') {
                //设置"."号的连线
                nextnodeFunc.add(new BiFunction<String, Integer, PartternNode>() {
                    @Override
                    public PartternNode apply(String s, Integer integer) {
                        return finalNode;
                    }
                });
            }
            else{
                System.out.println("Skip regChar:"+regChar+" node:"+node.value+" parent:"+parent.value);
            }
        }

        private boolean matches(String input) {
            return rootPartternNode.matches(input, 0);
        }

    }

    class PartternNode {
        private char value;
        private boolean isEnd = false;
        private List<BiFunction<String, Integer, PartternNode>> nextnodeFunc = new ArrayList<>();

        public boolean matches(String input, Integer index) {
            if (index == input.length()) {
                return isEnd;
            }
            if (!nextnodeFunc.isEmpty()) {
                for (BiFunction<String, Integer, PartternNode> nextFunc : nextnodeFunc) {
                    PartternNode nextnode = nextFunc.apply(input, index);
                    if (nextnode != null) {
                        boolean result = nextnode.matches(input, index + 1);
                        if (result) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }


        public List<BiFunction<String, Integer, PartternNode>> getNextnodeFunc() {
            return nextnodeFunc;
        }

        public void setNextnodeFunc(List<BiFunction<String, Integer, PartternNode>> nextnodeFunc) {
            this.nextnodeFunc = nextnodeFunc;
        }


    }

    public static void main(String[] args){
        Solution solution=new Solution();
        boolean ans=solution.isMatch("dab","c*a*b");
        System.out.println(ans);
    }
}
