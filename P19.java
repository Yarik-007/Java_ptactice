//================================================================================//
//Перечисления
//================================================================================//
//Задача 1
//================================================================================//

// Пример 1: Перечисление DaysOfWeek с инициализацией через конструктор
enum DaysOfWeek {
    // Элементы перечисления с параметрами для конструктора
    MONDAY("Понедельник", 1),
    TUESDAY("Вторник", 2),
    WEDNESDAY("Среда", 3),
    THURSDAY("Четверг", 4),
    FRIDAY("Пятница", 5),
    SATURDAY("Суббота", 6),
    SUNDAY("Воскресенье", 7);

    // Поля класса
    private String russianName;
    private int number;

    // Конструктор перечисления (всегда private или package-private)
    DaysOfWeek(String russianName, int number) {
        this.russianName = russianName;
        this.number = number;
    }

    // Геттеры
    public String getRussianName() {
        return russianName;
    }

    public int getNumber() {
        return number;
    }

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

// Пример 2: Перечисление Planet с инициализацией сложных полей
enum Planet {
    // Элементы с массой (кг) и радиусом (м)
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    // Поля
    private final double mass;      // масса в кг
    private final double radius;    // радиус в м
    private final double surfaceGravity; // ускорение свободного падения

    // Универсальная гравитационная постоянная
    private static final double G = 6.67300E-11;

    // Конструктор
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.surfaceGravity = G * mass / (radius * radius);
    }

    // Методы
    public double getMass() { return mass; }
    public double getRadius() { return radius; }
    public double getSurfaceGravity() { return surfaceGravity; }

    public double getSurfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}

// Пример 3: Перечисление с инициализацией через блок
enum Color {
    RED, GREEN, BLUE, YELLOW, BLACK, WHITE;

    private String hexCode;
    private int rgb;

    // Блок инициализации (выполняется для каждого элемента)
    static {
        System.out.println("Статический блок перечисления");
    }

    // Нестатический блок инициализации (выполняется для каждого элемента)
    {
        // Можно выполнить сложную логику инициализации
        switch (this) {
            case RED:
                hexCode = "#FF0000";
                rgb = 0xFF0000;
                break;
            case GREEN:
                hexCode = "#00FF00";
                rgb = 0x00FF00;
                break;
            case BLUE:
                hexCode = "#0000FF";
                rgb = 0x0000FF;
                break;
            case YELLOW:
                hexCode = "#FFFF00";
                rgb = 0xFFFF00;
                break;
            case BLACK:
                hexCode = "#000000";
                rgb = 0x000000;
                break;
            case WHITE:
                hexCode = "#FFFFFF";
                rgb = 0xFFFFFF;
                break;
        }
    }

    public String getHexCode() { return hexCode; }
    public int getRgb() { return rgb; }
}

// Пример 4: Демонстрация работы
public class EnumInitializationDemo {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: DaysOfWeek ===");
        for (DaysOfWeek day : DaysOfWeek.values()) {
            System.out.printf("%s (%s) - номер %d, выходной: %b%n",
                day, day.getRussianName(), day.getNumber(), day.isWeekend());
        }

        System.out.println("\n=== Пример 2: Planet ===");
        double earthWeight = 70;
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();

        for (Planet planet : Planet.values()) {
            System.out.printf("Вес на %s: %.2f кг (гравитация: %.2f м/с²)%n",
                planet, planet.getSurfaceWeight(mass), planet.getSurfaceGravity());
        }

        System.out.println("\n=== Пример 3: Color ===");
        for (Color color : Color.values()) {
            System.out.printf("%s: HEX=%s, RGB=%d%n",
                color, color.getHexCode(), color.getRgb());
        }
    }
}
 

//================================================================================//
//Задача 2
//================================================================================//

// Пример 1: Перечисление операций калькулятора
enum Operation {
    // Элементы перечисления
    ADD {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }

        @Override
        public String getSymbol() {
            return "+";
        }
    },
    SUBTRACT {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }

        @Override
        public String getSymbol() {
            return "-";
        }
    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }

        @Override
        public String getSymbol() {
            return "*";
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("Деление на ноль!");
            }
            return x / y;
        }

        @Override
        public String getSymbol() {
            return "/";
        }
    },
    POWER {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }

        @Override
        public String getSymbol() {
            return "^";
        }
    };

    // Абстрактный метод (должен быть реализован каждым элементом)
    public abstract double apply(double x, double y);

    // Абстрактный метод для получения символа операции
    public abstract String getSymbol();

    // Конкретный метод
    public String getDescription() {
        return this.name() + " операция " + getSymbol();
    }

    // Статический метод поиска операции по символу
    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Неизвестная операция: " + symbol);
    }
}

// Пример 2: Перечисление уровней доступа с методами проверки
enum AccessLevel {
    GUEST(0) {
        @Override
        public boolean canRead() { return true; }

        @Override
        public boolean canWrite() { return false; }

        @Override
        public boolean canDelete() { return false; }

        @Override
        public boolean canAdmin() { return false; }
    },
    USER(1) {
        @Override
        public boolean canRead() { return true; }

        @Override
        public boolean canWrite() { return true; }

        @Override
        public boolean canDelete() { return false; }

        @Override
        public boolean canAdmin() { return false; }
    },
    MODERATOR(2) {
        @Override
        public boolean canRead() { return true; }

        @Override
        public boolean canWrite() { return true; }

        @Override
        public boolean canDelete() { return true; }

        @Override
        public boolean canAdmin() { return false; }
    },
    ADMIN(3) {
        @Override
        public boolean canRead() { return true; }

        @Override
        public boolean canWrite() { return true; }

        @Override
        public boolean canDelete() { return true; }

        @Override
        public boolean canAdmin() { return true; }
    };

    private final int level;

    AccessLevel(int level) {
        this.level = level;
    }

    // Абстрактные методы
    public abstract boolean canRead();
    public abstract boolean canWrite();
    public abstract boolean canDelete();
    public abstract boolean canAdmin();

    // Конкретные методы
    public int getLevel() { return level; }

    public boolean hasHigherLevelThan(AccessLevel other) {
        return this.level > other.level;
    }

    public boolean hasLowerLevelThan(AccessLevel other) {
        return this.level < other.level;
    }
}

// Пример 3: Перечисление статусов заказа с дополнительной логикой
enum OrderStatus {
    PENDING("Ожидает обработки") {
        @Override
        public boolean canCancel() { return true; }

        @Override
        public OrderStatus nextStatus() { return PROCESSING; }
    },
    PROCESSING("В обработке") {
        @Override
        public boolean canCancel() { return true; }

        @Override
        public OrderStatus nextStatus() { return SHIPPED; }
    },
    SHIPPED("Отправлен") {
        @Override
        public boolean canCancel() { return false; }

        @Override
        public OrderStatus nextStatus() { return DELIVERED; }
    },
    DELIVERED("Доставлен") {
        @Override
        public boolean canCancel() { return false; }

        @Override
        public OrderStatus nextStatus() { return COMPLETED; }
    },
    COMPLETED("Завершен") {
        @Override
        public boolean canCancel() { return false; }

        @Override
        public OrderStatus nextStatus() { return this; }
    },
    CANCELLED("Отменен") {
        @Override
        public boolean canCancel() { return false; }

        @Override
        public OrderStatus nextStatus() { return this; }
    };

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    // Абстрактные методы
    public abstract boolean canCancel();
    public abstract OrderStatus nextStatus();

    // Конкретные методы
    public String getDescription() { return description; }

    public boolean isFinal() {
        return this == COMPLETED || this == CANCELLED;
    }

    public boolean isActive() {
        return this == PENDING || this == PROCESSING;
    }
}

// Пример 4: Перечисление размеров одежды с методами конвертации
enum ClothingSize {
    XXS(42) {
        @Override
        public String getInternationalSize() { return "XS"; }

        @Override
        public String getDescription() { return "Очень маленький"; }
    },
    XS(44) {
        @Override
        public String getInternationalSize() { return "S"; }

        @Override
        public String getDescription() { return "Маленький"; }
    },
    S(46) {
        @Override
        public String getInternationalSize() { return "M"; }

        @Override
        public String getDescription() { return "Средний"; }
    },
    M(48) {
        @Override
        public String getInternationalSize() { return "L"; }

        @Override
        public String getDescription() { return "Большой"; }
    },
    L(50) {
        @Override
        public String getInternationalSize() { return "XL"; }

        @Override
        public String getDescription() { return "Очень большой"; }
    },
    XL(52) {
        @Override
        public String getInternationalSize() { return "XXL"; }

        @Override
        public String getDescription() { return "Экстра большой"; }
    };

    private final int russianSize;

    ClothingSize(int russianSize) {
        this.russianSize = russianSize;
    }

    // Абстрактные методы
    public abstract String getInternationalSize();
    public abstract String getDescription();

    // Конкретные методы
    public int getRussianSize() { return russianSize; }

    public boolean isLargerThan(ClothingSize other) {
        return this.russianSize > other.russianSize;
    }

    public static ClothingSize fromRussianSize(int size) {
        for (ClothingSize cs : values()) {
            if (cs.russianSize == size) {
                return cs;
            }
        }
        throw new IllegalArgumentException("Нет размера: " + size);
    }
}

// Демонстрация работы
public class EnumCustomDemo {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: Operation ===");
        double x = 10, y = 3;
        for (Operation op : Operation.values()) {
            System.out.printf("%.2f %s %.2f = %.2f%n",
                x, op.getSymbol(), y, op.apply(x, y));
        }

        Operation op = Operation.fromSymbol("*");
        System.out.println("Операция для '*': " + op.getDescription());

        System.out.println("\n=== Пример 2: AccessLevel ===");
        AccessLevel user = AccessLevel.USER;
        AccessLevel admin = AccessLevel.ADMIN;
        System.out.println("User может читать: " + user.canRead());
        System.out.println("User может администрировать: " + user.canAdmin());
        System.out.println("Admin выше User? " + admin.hasHigherLevelThan(user));

        System.out.println("\n=== Пример 3: OrderStatus ===");
        OrderStatus status = OrderStatus.PENDING;
        System.out.println("Статус: " + status.getDescription());
        System.out.println("Можно отменить: " + status.canCancel());
        System.out.println("Активен: " + status.isActive());
        System.out.println("Следующий статус: " + status.nextStatus().getDescription());

        System.out.println("\n=== Пример 4: ClothingSize ===");
        ClothingSize mySize = ClothingSize.M;
        System.out.println("Российский размер: " + mySize.getRussianSize());
        System.out.println("Международный размер: " + mySize.getInternationalSize());
        System.out.println("Описание: " + mySize.getDescription());

        System.out.println("Размер S больше XS? " +
            ClothingSize.S.isLargerThan(ClothingSize.XS));
    }
}
 
