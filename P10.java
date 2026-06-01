//Массив
//Практика #1

import java.util.Arrays;
import java.util.Comparator;

public class ArraysExample {
    public static void main(String[] args) {

        // 1. Пример использования toString()
        // Преобразует массив в строковое представление
        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        // 2. Пример использования sort()
        // Сортирует массив в порядке возрастания
        Arrays.sort(numbers);
        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));

        // 3. Пример использования binarySearch()
        // Ищет элемент в отсортированном массиве (возвращает индекс)
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Индекс элемента 8: " + index);

        // Попытка поиска в несортированном массиве (непредсказуемый результат)
        int[] unsorted = {3, 1, 4, 2};
        int badIndex = Arrays.binarySearch(unsorted, 4);
        System.out.println("Поиск в несортированном массиве: " + badIndex);

        // 4. Пример использования equals()
        // Сравнивает два массива на равенство
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5};
        int[] array3 = {1, 2, 3, 4, 6};

        System.out.println("\narray1 == array2? " + Arrays.equals(array1, array2)); // true
        System.out.println("array1 == array3? " + Arrays.equals(array1, array3)); // false

        // 5. Пример использования compare() (Java 9+)
        // Сравнивает два массива лексикографически
        // Возвращает:
        // 0 - если массивы равны
        // отрицательное число - если первый массив меньше второго
        // положительное число - если первый массив больше второго
        int[] arrA = {1, 2, 3};
        int[] arrB = {1, 2, 4};
        int[] arrC = {1, 2, 3};

        int compareResult1 = Arrays.compare(arrA, arrB);
        int compareResult2 = Arrays.compare(arrA, arrC);

        System.out.println("\nСравнение {1,2,3} и {1,2,4}: " + compareResult1); // -1
        System.out.println("Сравнение {1,2,3} и {1,2,3}: " + compareResult2); // 0

        // Дополнительные полезные методы Arrays

        // fill() - заполнение массива
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("\nЗаполненный массив: " + Arrays.toString(filledArray));

        // copyOf() - копирование массива
        int[] copiedArray = Arrays.copyOf(numbers, 3);
        System.out.println("Копия первых 3 элементов: " + Arrays.toString(copiedArray));

        // copyOfRange() - копирование диапазона
        int[] rangeCopy = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("Копия элементов с индекса 1 по 3: " + Arrays.toString(rangeCopy));

        // Пример с многомерным массивом
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};

        // deepEquals() для глубокого сравнения многомерных массивов
        System.out.println("\nМногомерные массивы равны? " + Arrays.deepEquals(matrix1, matrix2));

        // deepToString() для строкового представления многомерных массивов
        System.out.println("Многомерный массив: " + Arrays.deepToString(matrix1));

        // Пример сортировки объектов с компаратором
        String[] words = {"banana", "apple", "cherry", "date"};
        Arrays.sort(words, Comparator.comparing(String::length));
        System.out.println("\nСортировка строк по длине: " + Arrays.toString(words));

        // Пример параллельной сортировки (для больших массивов)
        int[] largeArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.parallelSort(largeArray);
        System.out.println("Параллельная сортировка: " + Arrays.toString(largeArray));
    }
}
