//================================================================================//
// StringBuilder и StringBuffer
//================================================================================//
// Задача 1
//================================================================================//

// Демонстрация 10 методов StringBuilder (аналогично работает для StringBuffer)

public class StringBuilderDemo {
    public static void main(String[] args) {

        System.out.println("=== 10 методов StringBuilder ===\n");

        // Создание StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append() - добавляет строку в конец
        System.out.println("1. append():");
        sb.append(" World");
        System.out.println("   После append: " + sb); // Hello World

        // 2. insert() - вставляет строку в указанную позицию
        System.out.println("\n2. insert():");
        sb.insert(5, " Beautiful");
        System.out.println("   После insert: " + sb); // Hello Beautiful World

        // 3. delete() - удаляет символы от start до end
        System.out.println("\n3. delete():");
        sb.delete(5, 15);
        System.out.println("   После delete: " + sb); // Hello World

        // 4. deleteCharAt() - удаляет символ по индексу
        System.out.println("\n4. deleteCharAt():");
        sb.deleteCharAt(5);
        System.out.println("   После deleteCharAt(5): " + sb); // HelloWorld

        // 5. replace() - заменяет часть строки
        System.out.println("\n5. replace():");
        sb.replace(5, 10, " Java");
        System.out.println("   После replace: " + sb); // Hello Java

        // 6. reverse() - переворачивает строку
        System.out.println("\n6. reverse():");
        sb.reverse();
        System.out.println("   После reverse: " + sb); // avaJ olleH
        sb.reverse(); // возвращаем обратно

        // 7. length() - возвращает длину
        System.out.println("\n7. length():");
        System.out.println("   Длина строки: " + sb.length()); // 10

        // 8. capacity() - возвращает текущую вместимость
        System.out.println("\n8. capacity():");
        System.out.println("   Вместимость: " + sb.capacity());

        // 9. charAt() / setCharAt() - получение и установка символа
        System.out.println("\n9. charAt() и setCharAt():");
        System.out.println("   Символ на позиции 1: " + sb.charAt(1)); // e
        sb.setCharAt(0, 'h');
        System.out.println("   После setCharAt(0, 'h'): " + sb); // hello Java

        // 10. substring() - извлекает подстроку
        System.out.println("\n10. substring():");
        String sub = sb.substring(6);
        System.out.println("   Подстрока с 6: " + sub); // Java

        // Дополнительные методы
        System.out.println("\n=== Дополнительные методы ===");

        // indexOf() - поиск подстроки
        System.out.println("indexOf('Java'): " + sb.indexOf("Java")); // 6

        // lastIndexOf() - поиск с конца
        System.out.println("lastIndexOf('l'): " + sb.lastIndexOf("l")); // 2

        // toString() - преобразование в String
        String result = sb.toString();
        System.out.println("toString(): " + result);

        // setLength() - установка длины
        sb.setLength(5);
        System.out.println("setLength(5): " + sb); // hello

        // ensureCapacity() - гарантирует вместимость
        sb.ensureCapacity(100);
        System.out.println("После ensureCapacity(100) вместимость: " + sb.capacity());

        // trimToSize() - уменьшает capacity до размера строки
        sb.trimToSize();
        System.out.println("После trimToSize() вместимость: " + sb.capacity());
    }
}
 
//================================================================================//
// Задача 2
//================================================================================//

// Преобразование StringBuilder и StringBuffer друг в друга

public class StringBuilderStringBufferConversionDemo {
    public static void main(String[] args) {

        System.out.println("=== Преобразование StringBuilder и StringBuffer ===\n");

        // Способ 1: Через конструктор
        System.out.println("1. Преобразование через конструктор:");

        // StringBuilder -> StringBuffer
        StringBuilder sb = new StringBuilder("Hello from StringBuilder");
        StringBuffer sbf = new StringBuffer(sb);
        System.out.println("StringBuffer из StringBuilder: " + sbf);

        // StringBuffer -> StringBuilder
        StringBuffer sbf2 = new StringBuffer("Hello from StringBuffer");
        StringBuilder sb2 = new StringBuilder(sbf2);
        System.out.println("StringBuilder из StringBuffer: " + sb2);

        // Способ 2: Через append()
        System.out.println("\n2. Преобразование через append():");

        // StringBuilder -> StringBuffer
        StringBuilder sb3 = new StringBuilder("Append way");
        StringBuffer sbf3 = new StringBuffer();
        sbf3.append(sb3);
        System.out.println("StringBuffer через append: " + sbf3);

        // StringBuffer -> StringBuilder
        StringBuffer sbf4 = new StringBuffer("Append way too");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(sbf4);
        System.out.println("StringBuilder через append: " + sb4);

        // Способ 3: Через toString() и конструктор
        System.out.println("\n3. Преобразование через toString():");

        // StringBuilder -> StringBuffer
        StringBuilder sb5 = new StringBuilder("Via toString");
        StringBuffer sbf5 = new StringBuffer(sb5.toString());
        System.out.println("StringBuffer через toString: " + sbf5);

        // StringBuffer -> StringBuilder
        StringBuffer sbf6 = new StringBuffer("Via toString too");
        StringBuilder sb6 = new StringBuilder(sbf6.toString());
        System.out.println("StringBuilder через toString: " + sb6);

        // Способ 4: Через toString() и append()
        System.out.println("\n4. Преобразование через toString() + append():");

        // StringBuilder -> StringBuffer
        StringBuilder sb7 = new StringBuilder("Combined");
        StringBuffer sbf7 = new StringBuffer().append(sb7.toString());
        System.out.println("StringBuffer комбинированный: " + sbf7);

        // Демонстрация с пустыми объектами
        System.out.println("\n5. Преобразование пустых объектов:");

        StringBuilder emptySb = new StringBuilder();
        StringBuffer emptySbf = new StringBuffer(emptySb);
        System.out.println("Пустой StringBuffer из пустого StringBuilder: '" + emptySbf + "'");

        System.out.println("\n=== Краткая таблица преобразований ===");
        System.out.println("StringBuilder -> StringBuffer:");
        System.out.println("  StringBuffer sbf = new StringBuffer(sb);");
        System.out.println("  StringBuffer sbf = new StringBuffer().append(sb);");
        System.out.println("  StringBuffer sbf = new StringBuffer(sb.toString());");

        System.out.println("\nStringBuffer -> StringBuilder:");
        System.out.println("  StringBuilder sb = new StringBuilder(sbf);");
        System.out.println("  StringBuilder sb = new StringBuilder().append(sbf);");
        System.out.println("  StringBuilder sb = new StringBuilder(sbf.toString());");

        System.out.println("\n=== Важное замечание ===");
        System.out.println("StringBuffer - потокобезопасный (синхронизированные методы)");
        System.out.println("StringBuilder - не потокобезопасный (быстрее)");
        System.out.println("При преобразовании потокобезопасность НЕ сохраняется!");
    }
}
