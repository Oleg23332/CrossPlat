package task3;
import java.lang.reflect.*;
import java.util.Arrays;
public class MethodCaller {
    public static Object callMethod(Object obj, String methodName, Object... params) throws FunctionNotFoundException {
        Class<?>[] paramTypes = new Class<?>[params.length];
        for (int i = 0; i < params.length; i++) {
            paramTypes[i] = params[i].getClass(); // Отримуємо класи параметрів
        }

        try {
            Method method = obj.getClass().getMethod(methodName, paramTypes); // Отримуємо метод за ім'ям та типами параметрів
            return method.invoke(obj, params); // Викликаємо метод на об'єкті з вказаними параметрами
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new FunctionNotFoundException("Метод " + methodName + " з параметрами " + Arrays.toString(paramTypes) + " не знайдено.");
        }
    }

}
