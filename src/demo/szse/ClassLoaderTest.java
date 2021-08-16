package demo.szse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class ClassLoaderTest {


    static class MyClassLoader extends ClassLoader {
        String className="demo.szse.Example1";
        int length=692;
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            if (className.equalsIgnoreCase(name)) {
                String path="/Users/weihuang/Desktop/classes/Example1.class";
                try {
                    InputStream inputStream=new FileInputStream(path);
                    byte[] bytes=new byte[length];
                    inputStream.read(bytes,0,length);
                    return this.defineClass(className,bytes,0,length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("xxx");
            }

            return null;

        }


        public static void main(String[] args) throws Exception{
            MyClassLoader myClassLoader=new MyClassLoader();
            Class<?>      clz=myClassLoader.loadClass("demo.szse.Example1");
            Object        instance=clz.newInstance();
            Method method=clz.getDeclaredMethod("say",String.class);
            method.invoke(instance,"huangwei");
            System.out.println(clz.getClassLoader());
            System.out.println(clz.getClassLoader().getParent());


            MyClassLoader myClassLoader2=new MyClassLoader();
            Class<?>      clz2=myClassLoader2.loadClass("demo.szse.Example1");
            Object        instance2=clz2.newInstance();
            Method method2=clz2.getDeclaredMethod("say",String.class);
            method2.invoke(instance2,"huangwei123");





        }
    }
}

