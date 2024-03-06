package task2;
import java.lang.reflect.*;
import java.util.Scanner;

public class ObjectInspector {
    public static void inspectObject(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("Реальний тип об'єкта: " + clazz.getName());

        // Вивід стану об'єкта (поля та їх значення)
        System.out.println("Стан об'єкта:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Дозволяємо отримати доступ до приватних полів
            try {
                System.out.println(field.getType().getSimpleName() + " " + field.getName() + " = " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Вивід відкритих методів
        System.out.println("Список відкритих методів:");
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println((i + 1) + "). " + methods[i]);
        }

        // Вибір методу для виклику
        System.out.print("Введіть порядковий номер методу [1 ," + methods.length + "]: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= methods.length) {
            try {
                Method method = methods[choice - 1];
                if (method.getParameterCount() == 0) { // Перевіряємо, чи метод не має параметрів
                    Object result = method.invoke(obj); // Викликаємо метод на об'єкті
                    System.out.println("Результат виклику методу: " + result);
                } else {
                    System.out.println("Обраний метод має параметри. Введіть інший метод.");
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Введено невірний номер методу.");
        }
    }
}

