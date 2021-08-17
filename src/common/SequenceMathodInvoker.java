package common;

import java.lang.reflect.Method;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 5:19 PM
 */
public class SequenceMathodInvoker {

    private Object subject;

    public SequenceMathodInvoker(Object subject) {
        this.subject = subject;
    }

    private Method getMethod(String methodName, Class<?>... parameterTypes) throws Exception {
        Class<?> clz          = subject.getClass();
        Method   targetMethod = clz.getDeclaredMethod(methodName, parameterTypes);
        return targetMethod;
    }

    public Object exec(Method method, Object... args) throws Exception {
        return method.invoke(subject, args);
    }

}
