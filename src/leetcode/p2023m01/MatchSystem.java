package leetcode.p2023m01;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/7
 * @time 4:36 PM
 */
public class MatchSystem {

    class Order {
        int  direction;
        int  quantity;
        int  price;
        long orderSequence;
    }

    class BuyOrder extends Order {
        public BuyOrder(int price) {
            this.price = price;
            this.direction = 1;
        }
    }

    class SellOrder extends Order {
        public SellOrder(int price) {
            this.price = price;
            this.direction = 0;
        }
    }


    class OrderQueue {
        private PriorityQueue<Order> pq;
        private Comparator<Order>    comparator;

        public OrderQueue(Comparator<Order> comparator) {
            this.comparator = comparator;
            pq = new PriorityQueue<>(this.comparator);
        }

        public void add(Order order) {
            pq.add(order);
        }

        public Order peek() {
            return pq.peek();
        }

        public Order poll() {
            return pq.poll();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }
    }

    class BuyOrderQueue extends OrderQueue {
        public BuyOrderQueue() {
            super(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o2.price - o1.price;
                }
            });
        }
    }

    class SellOrderQueue extends OrderQueue {
        public SellOrderQueue() {
            super(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    return o1.price - o2.price;
                }
            });
        }
    }


    public void match(List<Order> orders) {
        BuyOrderQueue  buyOrderQueue  = new BuyOrderQueue();
        SellOrderQueue sellOrderQueue = new SellOrderQueue();

        for (Order order : orders) {
            // buy
            if (order.direction == 1) {
                Order headOrder = sellOrderQueue.peek();
                while (!sellOrderQueue.isEmpty() && headOrder.price <= order.price
                        && headOrder.quantity > 0 && order.quantity > 0) {
                    Order temp       = sellOrderQueue.poll();
                    int   matchCount = Math.min(headOrder.quantity, order.quantity);
                    order.quantity -= matchCount;
                    temp.quantity -= matchCount;
                    System.out.println(String.format("Buy Match quantity:%d", matchCount));
                    if (temp.quantity > 0) {
                        sellOrderQueue.add(temp);
                    }
                }
                if (order.quantity > 0) {
                    buyOrderQueue.add(order);
                }
            } else {
                //sell
                Order headOrder = buyOrderQueue.peek();
                while (!buyOrderQueue.isEmpty() && headOrder.price >= order.price
                        && headOrder.quantity > 0 && order.quantity > 0) {
                    Order temp       = buyOrderQueue.poll();
                    int   matchCount = Math.min(headOrder.quantity, order.quantity);
                    order.quantity -= matchCount;
                    temp.quantity -= matchCount;
                    System.out.println(String.format("Sell Match quantity:%d", matchCount));
                    if (temp.quantity > 0) {
                        buyOrderQueue.add(temp);
                    }
                }
                if (order.quantity > 0) {
                    sellOrderQueue.add(order);
                }
            }
        }
    }
}
