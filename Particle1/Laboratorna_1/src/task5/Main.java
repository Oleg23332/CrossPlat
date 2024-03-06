package task5;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Evaluatable f1 = new Function1();
        Evaluatable f2 = new Function2();

        Evaluatable profiledF1 = (Evaluatable) Proxy.newProxyInstance(
                Evaluatable.class.getClassLoader(),
                new Class<?>[]{Evaluatable.class},
                new ProfilingHandler(f1));

        System.out.println("F1: " + profiledF1.eval(0.5));

        Evaluatable tracedF2 = (Evaluatable) Proxy.newProxyInstance(
                Evaluatable.class.getClassLoader(),
                new Class<?>[]{Evaluatable.class},
                new TracingHandler(f2));

        System.out.println("F2: " + tracedF2.eval(1.0));
    }
}
