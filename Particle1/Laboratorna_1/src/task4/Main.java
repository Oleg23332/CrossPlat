package task4;

public class Main {
    public static void main(String[] args) {
        // Приклади використання

        Object intArray = ArrayManager.createArray(int.class, 2);
        System.out.println(ArrayManager.arrayToString(intArray));

        Object stringArray = ArrayManager.createArray(String.class, 3);
        System.out.println(ArrayManager.arrayToString(stringArray));

        Object doubleArray = ArrayManager.createArray(Double.class, 5);
        System.out.println(ArrayManager.arrayToString(doubleArray));

        Object intMatrix = ArrayManager.createMatrix(int.class, 3, 5);
        System.out.println(ArrayManager.matrixToString(intMatrix));

        Object resizedMatrix = ArrayManager.resizeMatrix(intMatrix, 4, 6);
        System.out.println(ArrayManager.matrixToString(resizedMatrix));

        Object resizedMatrix2 = ArrayManager.resizeMatrix(intMatrix, 3, 7);
        System.out.println(ArrayManager.matrixToString(resizedMatrix2));

        Object intMatrix2 = ArrayManager.createMatrix(int.class, 2, 2);
        System.out.println(ArrayManager.matrixToString(intMatrix2));
    }
}


