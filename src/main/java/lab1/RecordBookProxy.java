package lab1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RecordBookProxy implements InvocationHandler {
    private Object ref;

    private RecordBookProxy(Object ref) {
        this.ref = ref;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        if (method.getName().startsWith("set")) {
            throw new IllegalAccessError("Not allowed");
        }
        return method.invoke(ref, args);
    }

    public static Object newProxyInstance(Object obj) {
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new RecordBookProxy(obj));
    }
}

