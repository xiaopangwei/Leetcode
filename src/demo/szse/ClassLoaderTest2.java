package demo.szse;


import java.lang.reflect.Method;

public class ClassLoaderTest2 {




        public static void main(String[] args) throws Exception{

            Class<?>      clz=Class.forName("demo.szse.Example2");
            Object        instance=clz.newInstance();
            Method method=clz.getDeclaredMethod("say",String.class);
            method.invoke(instance,"huangwei huanxx");







    }
}

