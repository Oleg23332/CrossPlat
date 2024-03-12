package task2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TypeInfoAnalyzer {
    public static String getTypeInfo(String typeName) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(typeName);
        return getTypeInfo(clazz);
    }

    public static String getTypeInfo(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();

        // Назва пакету
        Package pkg = clazz.getPackage();
        if (pkg != null) {
            builder.append("пакети: ").append(pkg.getName()).append("\n");
        }

        // Модифікатори та назва класу
        int modifiers = clazz.getModifiers();
        builder.append("Модифікатори: ").append(Modifier.toString(modifiers)).append("\n");
        builder.append("назва класу: ").append(clazz.getSimpleName()).append("\n");

        // Суперкласи
        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {
            builder.append("Суперкласи: ").append(superClass.getSimpleName()).append("\n");
        }

        // Реалізовані інтерфейси
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            builder.append("Реалізовані інтерфейси: ");
            for (Class<?> iface : interfaces) {
                builder.append(iface.getSimpleName()).append(", ");
            }
            builder.delete(builder.length() - 2, builder.length()); // Remove trailing comma and space
            builder.append("\n");
        }

        // Поля
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0) {
            builder.append("Поля:\n");
            for (Field field : fields) {
                builder.append(Modifier.toString(field.getModifiers())).append(" ")
                        .append(field.getType().getSimpleName()).append(" ")
                        .append(field.getName()).append("\n");
            }
        }

        // Конструктори
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (constructors.length > 0) {
            builder.append("Конструктори:\n");
            for (Constructor<?> constructor : constructors) {
                builder.append(Modifier.toString(constructor.getModifiers())).append(" ")
                        .append(clazz.getSimpleName()).append("(");
                Class<?>[] paramTypes = constructor.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    builder.append(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) {
                        builder.append(", ");
                    }
                }
                builder.append(")\n");
            }
        }

        // Методи
        Method[] methods = clazz.getDeclaredMethods();
        if (methods.length > 0) {
            builder.append("Methods:\n");
            for (Method method : methods) {
                builder.append(Modifier.toString(method.getModifiers())).append(" ")
                        .append(method.getReturnType().getSimpleName()).append(" ")
                        .append(method.getName()).append("(");
                Class<?>[] paramTypes = method.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    builder.append(paramTypes[i].getSimpleName());
                    if (i < paramTypes.length - 1) {
                        builder.append(", ");
                    }
                }
                builder.append(")\n");
            }
        }

        return builder.toString();
    }
}
