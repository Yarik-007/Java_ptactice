//================================================================================//
//Внутренние (inner) классы
//================================================================================//
//Задача 1
//================================================================================//

class OuterClass {
    private int privateField = 10;
    public int publicField = 20;
    protected int protectedField = 30;
    int defaultField = 40;

    // 1. public внутренний класс
    public class PublicInner {
        public void display() {
            System.out.println("PublicInner - доступен всем");
        }
    }

    // 2. private внутренний класс
    private class PrivateInner {
        public void display() {
            System.out.println("PrivateInner - доступен только внутри OuterClass");
            System.out.println("  Доступ к privateField: " + privateField);
        }
    }

    // 3. protected внутренний класс
    protected class ProtectedInner {
        public void display() {
            System.out.println("ProtectedInner - доступен в пакете и подклассах");
        }
    }

    // 4. default (package-private) внутренний класс
    class DefaultInner {
        public void display() {
            System.out.println("DefaultInner - доступен только в пакете");
        }
    }

    public void createInnerClasses() {
        // Внутри внешнего класса доступны все внутренние классы
        PublicInner pi = new PublicInner();
        PrivateInner pri = new PrivateInner();  // Доступен
        ProtectedInner proi = new ProtectedInner();
        DefaultInner di = new DefaultInner();

        pri.display();  // PrivateInner доступен только здесь
    }
}

// Класс в том же пакете
class SamePackageClass {
    public void test() {
        OuterClass outer = new OuterClass();

        // Доступен public внутренний класс
        OuterClass.PublicInner publicInner = outer.new PublicInner();
        publicInner.display();

        // Доступен protected внутренний класс (в том же пакете)
        OuterClass.ProtectedInner protectedInner = outer.new ProtectedInner();
        protectedInner.display();

        // Доступен default внутренний класс (в том же пакете)
        OuterClass.DefaultInner defaultInner = outer.new DefaultInner();
        defaultInner.display();

        // private внутренний класс НЕ доступен
        // OuterClass.PrivateInner privateInner = outer.new PrivateInner(); // Ошибка!
    }
}

// Подкласс в другом пакете
// package anotherpackage;
// class SubClassInAnotherPackage extends OuterClass {
//     public void test() {
//         // public - доступен
//         PublicInner publicInner = new PublicInner();
//
//         // protected - доступен в подклассе (даже в другом пакете)
//         ProtectedInner protectedInner = new ProtectedInner();
//
//         // default - НЕ доступен (другой пакет)
//         // DefaultInner defaultInner = new DefaultInner(); // Ошибка!
//
//         // private - НЕ доступен
//     }
// }
 



//================================================================================//
//Задача 2
//================================================================================//

class Outer {
    private String privateField = "Приватное поле";
    public String publicField = "Публичное поле";
    protected String protectedField = "Защищенное поле";
    String defaultField = "Поле по умолчанию";

    private void privateMethod() {
        System.out.println("Приватный метод внешнего класса");
    }

    public void publicMethod() {
        System.out.println("Публичный метод внешнего класса");
    }

    // Внутренний класс
    class Inner {
        private String innerPrivateField = "Поле внутреннего класса";

        public void accessOuterFields() {
            // Внутренний класс имеет доступ ко ВСЕМ полям внешнего класса
            System.out.println("Доступ к privateField: " + privateField);
            System.out.println("Доступ к publicField: " + publicField);
            System.out.println("Доступ к protectedField: " + protectedField);
            System.out.println("Доступ к defaultField: " + defaultField);

            // Доступ к методам внешнего класса
            privateMethod();
            publicMethod();
        }

        public void modifyOuterFields() {
            // Внутренний класс может изменять поля внешнего класса
            privateField = "Изменено из внутреннего класса";
        }
    }

    public void demonstrateInnerAccess() {
        Inner inner = new Inner();
        inner.accessOuterFields();

        // Внутренний класс также имеет доступ к private полям внешнего
        System.out.println("После изменения: " + privateField);
    }
}

 

//================================================================================//
//Задача 3
//================================================================================//

class OuterWithInner {

    // Внутренний класс с разными спецификаторами
    public class PublicInner {
        public String publicInnerField = "public поле";
        private String privateInnerField = "private поле";
        protected String protectedInnerField = "protected поле";
        String defaultInnerField = "default поле";

        public void publicInnerMethod() {
            System.out.println("public метод внутреннего класса");
        }

        private void privateInnerMethod() {
            System.out.println("private метод внутреннего класса");
        }

        protected void protectedInnerMethod() {
            System.out.println("protected метод внутреннего класса");
        }

        void defaultInnerMethod() {
            System.out.println("default метод внутреннего класса");
        }
    }

    private class PrivateInner {
        public String field = "Поле приватного внутреннего класса";

        public void method() {
            System.out.println("Метод приватного внутреннего класса");
        }
    }

    protected class ProtectedInner {
        public String field = "Поле защищенного внутреннего класса";
    }

    class DefaultInner {
        public String field = "Поле внутреннего класса по умолчанию";
    }

    // Внешний класс имеет доступ ко ВСЕМ членам внутреннего класса
    // независимо от их спецификаторов
    public void accessInnerMembers() {
        // Создание экземпляра внутреннего класса
        PublicInner publicInner = new PublicInner();

        // Доступ ко всем полям (даже private)
        System.out.println(publicInner.publicInnerField);      // Доступен
        System.out.println(publicInner.privateInnerField);     // Доступен! (private не мешает)
        System.out.println(publicInner.protectedInnerField);   // Доступен
        System.out.println(publicInner.defaultInnerField);     // Доступен

        // Доступ ко всем методам (даже private)
        publicInner.publicInnerMethod();    // Доступен
        publicInner.privateInnerMethod();   // Доступен! (private не мешает)
        publicInner.protectedInnerMethod(); // Доступен
        publicInner.defaultInnerMethod();   // Доступен
    }

    public void accessPrivateInner() {
        // Доступ к private внутреннему классу возможен только внутри внешнего класса
        PrivateInner privateInner = new PrivateInner();
        System.out.println(privateInner.field);  // Доступен
        privateInner.method();                    // Доступен
    }
}
 
