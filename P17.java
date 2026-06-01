//================================================================================//
//Параметризованные классы
//================================================================================//
 //Задача 1
//================================================================================//

import java.util.*;

public class InstanceOfGenericExample {
    public static void main(String[] args) {

        // - Так нельзя - ошибка компиляции!
        // List<String> list = new ArrayList<>();
        // if (list instanceof List<String>) { } // Ошибка!

        // + Правильные способы использования instanceof с generics:

        // 1. Проверка с raw type (сырым типом)
        List<String> stringList = new ArrayList<>();
        if (stringList instanceof List) {
            System.out.println("stringList является List (raw type)");
        }

        // 2. Проверка с wildcard (знаком подстановки)
        if (stringList instanceof List<?>) {
            System.out.println("stringList является List<?>");
        }

        // 3. Проверка параметризованного класса с конкретным типом через промежуточную переменную
        ArrayList<Integer> intList = new ArrayList<>();
        if (intList instanceof ArrayList) {
            System.out.println("intList является ArrayList");
            // После проверки можем безопасно работать, но с предупреждениями
            ArrayList raw = intList; // приведение к raw типу
        }

        // 4. Практический пример - обходной путь
        processGenericObject(new ArrayList<String>());
        processGenericObject(new ArrayList<Integer>());
        processGenericObject(new HashSet<String>());
    }

    public static void processGenericObject(Object obj) {
        // Проверяем, является ли объект List (без указания типа)
        if (obj instanceof List<?>) {
            List<?> list = (List<?>) obj;
            System.out.println("Объект является List, размер: " + list.size());

            // Не можем добавить элементы, но можем читать
            // list.add("new"); // Ошибка! Нельзя добавить из-за wildcard
            Object first = list.get(0); // Читать можно как Object
        }

        // Проверка с raw type (с предупреждением)
        if (obj instanceof List) {
            List rawList = (List) obj;
            // Можно добавить что угодно, но не типобезопасно
            rawList.add("unsafe operation"); // Может вызвать проблемы
        }
    }
}

// Пример с собственным параметризованным классом
class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

class GenericInstanceOfDemo {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(123);

        // Проверка с Box (raw type)
        if (stringBox instanceof Box) {
            System.out.println("stringBox является Box (raw type)");
        }

        // Проверка с Box<?>
        if (stringBox instanceof Box<?>) {
            System.out.println("stringBox является Box<?>");
        }

        // Тип стирается, поэтому stringBox и intBox одного типа во время выполнения
        System.out.println("Оба объекта одного класса: " +
            stringBox.getClass().equals(intBox.getClass())); // true
    }
}
 

//================================================================================//
//Задача 2
//================================================================================//

import java.util.*;

class Animal {
    String name;
    Animal(String name) { this.name = name; }
    public String toString() { return "Animal: " + name; }
}

class Dog extends Animal {
    String breed;
    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    public String toString() { return "Dog: " + name + " (" + breed + ")"; }
}

class Cat extends Animal {
    Cat(String name) { super(name); }
    public String toString() { return "Cat: " + name; }
}

class Puppy extends Dog {
    Puppy(String name) { super(name, "Unknown"); }
    public String toString() { return "Puppy: " + name; }
}

public class WildcardExample {
    public static void main(String[] args) {

        // === <? extends T> - Producer Extends ===
        // Используется, когда нужно ЧИТАТЬ элементы (производитель)

        List<Dog> dogs = Arrays.asList(
            new Dog("Rex", "German Shepherd"),
            new Dog("Buddy", "Golden Retriever")
        );

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Generic Animal"));

        System.out.println("=== Примеры <? extends T> ===");
        printAnimals(dogs);     // Можно передать List<Dog>
        printAnimals(animals);  // Можно передать List<Animal>

        // НО нельзя добавлять элементы в коллекцию с extends
        List<? extends Animal> animalList = dogs;
        // animalList.add(new Dog("New Dog", "Labrador")); // Ошибка!
        // animalList.add(new Animal("New Animal"));      // Ошибка!

        Animal firstAnimal = animalList.get(0); // Можем читать
        System.out.println("Прочитали: " + firstAnimal);

        // === <? super T> - Consumer Super ===
        // Используется, когда нужно ДОБАВЛЯТЬ элементы (потребитель)

        System.out.println("\n=== Примеры <? super T> ===");
        List<Animal> animalContainer = new ArrayList<>();
        List<Object> objectContainer = new ArrayList<>();

        addDogs(animalContainer);   // Можно передать List<Animal>
        addDogs(objectContainer);   // Можно передать List<Object>
        // addDogs(dogs);           // Нельзя передать List<Dog> (слишком специфично)

        System.out.println("Animal container: " + animalContainer);
        System.out.println("Object container: " + objectContainer);

        // Чтение из коллекции с super дает только Object
        List<? super Dog> superDogList = animalContainer;
        Object obj = superDogList.get(0); // Можно прочитать только как Object

        // === Принцип PECS (Producer Extends, Consumer Super) ===
        System.out.println("\n=== Принцип PECS ===");
        List<Puppy> puppies = Arrays.asList(
            new Puppy("Max"),
            new Puppy("Charlie")
        );

        copyCollection(puppies, animalContainer);
        System.out.println("После копирования: " + animalContainer);
    }

    // Метод с <? extends T> - читаем элементы
    public static void printAnimals(List<? extends Animal> animals) {
        // Можем только читать, но не модифицировать
        for (Animal animal : animals) {
            System.out.println("  " + animal);
        }
        // animals.add(new Dog("New", "Mix")); // Нельзя добавить!
    }

    // Метод с <? super T> - добавляем элементы
    public static void addDogs(List<? super Dog> superDogList) {
        // Можем добавлять Dog и его подклассы
        superDogList.add(new Dog("Spike", "Bulldog"));
        superDogList.add(new Puppy("Lucky"));
        // superDogList.add(new Animal("Unknown")); // Нельзя добавить Animal (родитель)

        System.out.println("Добавили собак в коллекцию");
    }

    // Пример использования обоих wildcard'ов (PECS)
    public static <T> void copyCollection(List<? extends T> source, List<? super T> dest) {
        // source - producer (отдаем элементы)
        // dest - consumer (принимает элементы)
        for (T item : source) {
            dest.add(item);
        }
    }
}
 */
