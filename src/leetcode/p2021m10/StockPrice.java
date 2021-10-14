package leetcode.p2021m10;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/12
 * @time 7:57 PM
 */
public class StockPrice {


    public TreeMap<Integer, Integer> timeStampAndPriceMap;
    public TreeMap<Integer, Integer> priceAndTimeMap;

    public StockPrice() {
        timeStampAndPriceMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        priceAndTimeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
    }

    public void update(int timestamp, int price) {

        if (!timeStampAndPriceMap.containsKey(timestamp)) {
            timeStampAndPriceMap.put(timestamp, price);
            priceAndTimeMap.put(price, priceAndTimeMap.getOrDefault(price, 0) + 1);
        } else {
            int prevVal = timeStampAndPriceMap.get(timestamp);
            if (prevVal != price) {
                timeStampAndPriceMap.put(timestamp, price);
                int temp = priceAndTimeMap.getOrDefault(prevVal, 0) - 1;
                if (temp <= 0) {
                    priceAndTimeMap.remove(prevVal);
                } else {
                    priceAndTimeMap.put(prevVal, temp);
                }
                priceAndTimeMap.put(price, priceAndTimeMap.getOrDefault(price, 0) + 1);
            }
        }

    }

    public int current() {
        int k = timeStampAndPriceMap.lastKey();
        return timeStampAndPriceMap.get(k);
    }

    public int maximum() {
        return priceAndTimeMap.lastKey().intValue();
    }

    public int minimum() {
        return priceAndTimeMap.firstKey().intValue();
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        stockPrice.update(3, 10);
        stockPrice.update(4, 5);
        System.out.println(stockPrice.current());
        System.out.println(stockPrice.maximum());
        stockPrice.update(1, 11);
        System.out.println(stockPrice.maximum());
        stockPrice.update(5, 2);
        System.out.println(stockPrice.minimum());
    }
}
