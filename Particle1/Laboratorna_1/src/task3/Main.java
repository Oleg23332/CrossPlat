package task3;

public class Main {
    public static void main(String[] args) {
        try {
            // Створення об'єкта для виклику методу
            TestClass obj = new TestClass();

            // Виклик методу з різними параметрами
            System.out.println("Результати виклику методу:");
            System.out.println("Типи: [double], значення: [1]");
            System.out.println("Результат виклику: " + MethodCaller.callMethod(obj, "method", 1.0));

            System.out.println("Типи: [double, int], значення: [1, 1]");
            System.out.println("Результат виклику: " + MethodCaller.callMethod(obj, "method", 1.0, 1));
        } catch (FunctionNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
