// Практика 4 документация

// Для генерации документации выполнить:
// javadoc -d docs -author -version Practice4.java

/**
 * Класс-калькулятор для демонстрации комментариев
 *
 * @author Ярослав
 * @version 1.0
 * @since 2026
 */
public class P4 {
    /**
     * Текущий результат вычислений
     */
    private double result;
    /**
     * Конструктор по умолчанию
     */
    public P4() {
        this.result = 0;
    }
    /**
     * Складывает два числа и возвращает сумму
     *
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма a + b
     */
    public double add(double a, double b) {
        return a + b;
    }
    /**
     * Делит первое число на второе
     *
     * @param a делимое
     * @param b делитель
     * @return результат деления
     * @throws ArithmeticException если b равно нулю
     * @see #add(double, double)
     */
    public double divide(double a, double b) {
        if (b == 0)
            throw new ArithmeticException("деление на ноль запрещено");
        return a / b;
    }
    /**
     * Демонстрация работы калькулятора
     */
    public static void main(String[] args) {
        P4 calc = new P4();
        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("10 / 2 = " + calc.divide(10, 2));
    }
}
