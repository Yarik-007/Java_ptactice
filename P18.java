//================================================================================//
//Методы с переменным числом параметров
//================================================================================//

public class VarargsOverloadExample {

    // Метод с одним int параметром
    public void print(int a) {
        System.out.println("Один int: " + a);
    }

    // Метод с переменным числом int параметров
    public void print(int... numbers) {
        System.out.print("Массив int: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Метод с переменным числом String параметров
    public void print(String... strings) {
        System.out.print("Массив String: ");
        for (String str : strings) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    // Метод с переменным числом Object параметров
    public void print(Object... objects) {
        System.out.print("Массив Object: ");
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        VarargsOverloadExample obj = new VarargsOverloadExample();

        obj.print(10);           // Вызов метода с одним int
        obj.print(1, 2, 3);      // Вызов метода с varargs int
        obj.print("A", "B", "C"); // Вызов метода с varargs String
        obj.print(1, "hello", 3.14); // Вызов метода с varargs Object
        obj.print();              // Вызов метода с varargs (пустой массив)
    }
}
