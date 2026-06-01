//================================================================================//
//Класс Object
//================================================================================//

import java.util.Objects;

// Класс с переопределенным методом equals()
class Person {
    private String name;
    private int age;
    private String passportId;

    public Person(String name, int age, String passportId) {
        this.name = name;
        this.age = age;
        this.passportId = passportId;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на тот же объект
        if (this == obj) return true;

        // 2. Проверка на null
        if (obj == null) return false;

        // 3. Проверка типа
        if (getClass() != obj.getClass()) return false;

        // 4. Приведение типа
        Person other = (Person) obj;

        // 5. Сравнение полей
        return age == other.age &&
               Objects.equals(name, other.name) &&
               Objects.equals(passportId, other.passportId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, passportId);
    }
}

public class EqualsDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Иван", 25, "AB123");
        Person p2 = new Person("Иван", 25, "AB123");
        Person p3 = new Person("Мария", 30, "CD456");

        System.out.println("p1.equals(p2): " + p1.equals(p2));  // true
        System.out.println("p1.equals(p3): " + p1.equals(p3));  // false
        System.out.println("p1.equals(null): " + p1.equals(null));  // false
        System.out.println("p1.equals(p1): " + p1.equals(p1));  // true

        System.out.println("\n=== Соглашения для equals() ===");
        System.out.println("1. Рефлексивность: x.equals(x) == true");
        System.out.println("2. Симметричность: если x.equals(y), то y.equals(x)");
        System.out.println("3. Транзитивность: если x.equals(y) и y.equals(z), то x.equals(z)");
        System.out.println("4. Постоянство: результат не должен меняться");
        System.out.println("5. Сравнение с null: x.equals(null) == false");

        System.out.println("\n=== Рекомендации ===");
        System.out.println("- Всегда переопределяйте hashCode() вместе с equals()");
        System.out.println("- Используйте Objects.equals() для полей-объектов");
        System.out.println("- Для примитивов используйте ==");
        System.out.println("- Сначала проверяйте this == obj");
        System.out.println("- Проверяйте obj == null");
    }
}
