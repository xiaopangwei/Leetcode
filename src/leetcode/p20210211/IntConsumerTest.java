package leetcode.p20210211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class IntConsumerTest {




    public static void main(String[] args) throws Exception{
        IntConsumer intConsumer= new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };

        intConsumer.accept(3);

    }
}
