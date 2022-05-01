package common;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/4
 * @time 2:24 PM
 */
public class State {
    public String name;
    Map<Integer, State> transition;

    public State(String name) {
        this.name = name;
        this.transition = new HashMap<>();
    }

    public void add(int type, State next) {
        this.transition.put(type, next);
    }

    public State getNext(int type) {
        return this.transition.get(type);
    }
}
