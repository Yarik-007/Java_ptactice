//================================================================================//
//Собственные исключения
//================================================================================//

//Проверяемое исключение (extends Exception)
class InvalidAgeException extends Exception {

    // Конструктор без параметров
    public InvalidAgeException() {
        super("Некорректный возраст");
    }

    // Конструктор с сообщением
    public InvalidAgeException(String message) {
        super(message);
    }

    // Конструктор с сообщением и причиной
    public InvalidAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
