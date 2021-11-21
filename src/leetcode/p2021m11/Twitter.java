package leetcode.p2021m11;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 2:18 PM
 */
public class Twitter {
    int offset = 0;
    public Map<Integer, LinkedList<Integer>> userAndTweetRefMap     = new HashMap<>();
    public Map<Integer, List<Integer>>       userAndFolloweeRefMap  = new HashMap<>();
    public Map<Integer, Integer>             tweetIdAndOffsetRefMap = new HashMap<>();


    static final int MAX_SIZE = 10;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {

        tweetIdAndOffsetRefMap.put(tweetId, offset++);
        if (!userAndTweetRefMap.containsKey(userId)) {
            userAndTweetRefMap.put(userId, new LinkedList<>());
        }
        LinkedList<Integer> temp = userAndTweetRefMap.get(userId);

        if (temp.size() >= 10) {
            temp.removeLast();
            temp.addFirst(tweetId);
        } else {
            temp.addFirst(tweetId);
        }
    }

    class Node {
        int rowId;
        int colId;
        int value;
        int offset;

        public Node(int rowId, int colId, int value, int offset) {
            this.rowId = rowId;
            this.colId = colId;
            this.value = value;
            this.offset = offset;
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> fList = userAndFolloweeRefMap.get(userId);
        if (fList == null) {
            fList = new ArrayList<>();
        }
        if (!fList.contains(userId)) {
            fList.add(userId);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.offset - o1.offset;
            }
        });

        for (int i = 0; i < fList.size(); i++) {
            int fItem = fList.get(i);
            if (userAndTweetRefMap.containsKey(fItem)) {
                int temp = userAndTweetRefMap.get(fItem).get(0);
                pq.add(new Node(fItem, 0, temp, tweetIdAndOffsetRefMap.get(temp)));
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            if (pq.isEmpty()){
                break;
            }
            Node t = pq.poll();
            if (!ans.contains(t.value)) {
                ans.add(t.value);
            }


            LinkedList<Integer> list = userAndTweetRefMap.get(t.rowId);

            if (t.colId + 1 < list.size()) {
                int val = list.get(t.colId + 1);
                pq.add(new Node(t.rowId, t.colId + 1, val, tweetIdAndOffsetRefMap.get(val)));
            }
        }

        return ans;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!userAndFolloweeRefMap.containsKey(followerId)) {
            userAndFolloweeRefMap.put(followerId, new ArrayList<>());
        }

        userAndFolloweeRefMap.get(followerId).add(followeeId);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> list=userAndFolloweeRefMap.get(followerId);
        if (list!=null && list.contains((Integer) followeeId)){
            userAndFolloweeRefMap.get(followerId).remove((Integer) followeeId);
        }

    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
    }
}
