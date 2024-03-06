package task4;
import java.lang.reflect.Array;
import java.util.Arrays;
public class ArrayManager {
    // Метод для створення одновимірного масиву заданого типу та розміру
    public static Object createArray(Class<?> type, int size) {
        return Array.newInstance(type, size);
    }

    // Метод для зміни розміру одновимірного масиву зі збереженням значень
    public static Object resizeArray(Object array, int newSize) {
        Class<?> type = array.getClass().getComponentType();
        Object newArray = Array.newInstance(type, newSize);
        int length = Math.min(Array.getLength(array), newSize);
        System.arraycopy(array, 0, newArray, 0, length);
        return newArray;
    }

    // Метод для конвертації одновимірного масиву в рядок
    public static String arrayToString(Object array) {
        return Arrays.deepToString(new Object[]{array});
    }

    // Метод для створення матриці заданого типу та розміру
    public static Object createMatrix(Class<?> type, int rows, int cols) {
        return Array.newInstance(type, rows, cols);
    }

    // Метод для зміни розміру матриці зі збереженням значень
    public static Object resizeMatrix(Object matrix, int newRows, int newCols) {
        Class<?> type = matrix.getClass().getComponentType().getComponentType();
        Object newMatrix = Array.newInstance(type, newRows, newCols);
        int rows = Math.min(Array.getLength(matrix), newRows);
        for (int i = 0; i < rows; i++) {
            Object row = Array.get(matrix, i);
            Object newRow = resizeArray(row, newCols);
            Array.set(newMatrix, i, newRow);
        }
        return newMatrix;
    }

    // Метод для конвертації матриці в рядок
    public static String matrixToString(Object matrix) {
        return Arrays.deepToString((Object[]) matrix);
    }
}
