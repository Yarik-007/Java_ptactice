//================================================================================//
//Ошибки статической инициализации
//================================================================================//

public class App {
    final static int START_COUNTER;
    static {
        START_COUNTER = Integer.parseInt("Y-");
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

/*
Ответ:

Программа завершится с ошибкой NumberFormatException, "Hello" НЕ будет выведено.

Причина:
- Статический блок выполняется при загрузке класса ДО вызова main()
- Integer.parseInt("Y-") не может преобразовать "Y-" в число
- Возникает NumberFormatException → программа падает
- main() не запускается
*/
