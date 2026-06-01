//Практика #1
/*
public class Main {
    void main() {
        int a = 10, b= 100, c = 20;
        //Истинные выражения
        boolean comparison_a_b = a < b; // true
        boolean comparison_a_c = c > a; //true
        boolean comparison_b_c = b > c; //true
        //Ложное выражение
        boolean comparison_a_b_false = a > b; // false

        System.out.println("comparison_a_b = "+ comparison_a_b +"\t" +
                "comparison_a_c = " + comparison_a_c + "\t"+
                 "comparison_b_c = " + comparison_b_c + "\t"+
                "comparison_a_b_false = " + comparison_a_b_false);

        //огическое умножение (Конъюнкция), выражение будет истинным
        boolean conjunction = comparison_a_b && comparison_a_c && comparison_b_c; // true
        System.out.println("conjunction = "+ conjunction);
        // следующее логическое умножение будет ложным из-за  выражения comparison_a_b_false
        boolean conjunction_false = comparison_a_b_false && comparison_a_c && comparison_b_c; // false
        System.out.println("conjunction_false = "+ conjunction_false);
        //логическое сложение(дизъюнкция)
        boolean disjunction = comparison_a_b || comparison_a_c || comparison_b_c || comparison_a_b_false;
        System.out.println("disjunction = "+ disjunction);

        //Логические выражения с операциями ?: и ^
        boolean a_true = (5 < 6) ^ (4 > 6); // 5 < 6 - true, поэтому возвращается true (4 > 6 - false)
        boolean b_false = (50 > 6) ^ (4 / 2 < 3); // 50 > 6 - true, 4/2 < 3 - true, поэтому возвращается false
        boolean z = a_true == !b_false? a_true && b_false: a_true || b_false;
        System.out.println("z = " +z);


        //Примеры префиксной и постфиксной форм записей ++
         a = 8;
         b = a++;

        System.out.println(a);  // 9
        System.out.println(b);  // 8
        c = ++a;
        System.out.println(c);  //10

        int value1 = 3;  // 0b0000_0011
        int value2 = 2;  // 0b0000_0010
        int value3 = 1;  // 0b0000_0001
        int result = 0b0000_0000;
        // сохраняем в result значения из value1
        result = result | value1; // 0b0000_0011
        // сдвигаем разряды в result на 2 разряда влево
        result = result << 2;   // 0b0000_1100
        // сохраняем в result значения из value2
        result = result | value2;  // 0b0000_1110
        // сдвигаем разряды в result на 2 разряда влево
        result = result << 2;   // 0b0011_1000
        // сохраняем в result значения из value3
        result = result | value3;  // 0b0011_1001

        System.out.println(result);  // 57
    }
}
 */

//Практика #2
/*
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();


        // Проверка принадлежности к классу Animal
        System.out.println(animal instanceof Animal); // true
        System.out.println(dog instanceof Animal);    // true (наследование)

        // Проверка принадлежности к конкретному классу
        System.out.println(dog instanceof Dog);       // true
        System.out.println(animal instanceof Dog);    // false

        // Случай, когда оператор применятся к null-объекту
        String text = null;

        // Все проверки с null возвращают false
        System.out.println(text instanceof String);   // false
        System.out.println(text instanceof Object);   // false

        // Прямая проверка null
        System.out.println(null instanceof String);   // false
    }
}
 */

