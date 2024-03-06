package task5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TracingHandler implements InvocationHandler {
    private final Object target;

    public TracingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("[" + target.getClass().getSimpleName() + "." + method.getName() + "]");
        if (args != null && args.length > 0) {
            System.out.print("(");
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        } else {
            System.out.println();
        }
        return method.invoke(target, args);
    }
}
