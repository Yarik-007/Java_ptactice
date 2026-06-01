// Практика 1 принцип подстановки Лисков

// наследник должен дополнять, а не ломать поведение родителя
// базовый класс птица умеет есть
class Bird {
    void eat() {
        System.out.println("Птица ест");
    }
}

// наследник для летающих птиц, только расширяет поведение
class FlyingBird extends Bird {
    void fly() {
        System.out.println("Птица летит");
    }
}

// воробей летает
class Sparrow extends FlyingBird { }

// пингвин не летающая птица
class Penguin extends Bird { }

public class P1 {
    // метод работает с любой птицей
    static void makeEat(Bird bird) {
        bird.eat();
    }

    // метод работает только с летающими птицами
    static void makeFly(FlyingBird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        makeEat(new Sparrow());
        makeEat(new Penguin());
        makeFly(new Sparrow());

        // makeFly(new Penguin()); // err
    }
}
