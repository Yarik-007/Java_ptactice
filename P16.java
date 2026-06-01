//================================================================================//
//Перегрузка методов
//================================================================================//

class A4 {
    public void printNum(Integer i) {
        System.out.println("Integer = " + i);
    }
    public void printNum(int i) {
        System.out.println("int = " + i);
    }
    public void printNum(Float f) {
        System.out.println("Float = " + f);
    }
    public void printNum(Number n) {
        System.out.println("Number = " + n);
    }
}

public class P16 {
    public static void main(String[] args) {
        A4 a = new A4();
        Number[] num = {
                Integer.valueOf(1),
                11,
                1.11f,
                11.11
        };
        // цикл for
        for (Number n : num)
            a.printNum(n);
        System.out.println();
        // прямые вызовы
        a.printNum(Integer.valueOf(1));
        a.printNum(11);
        a.printNum(1.11f);
        a.printNum(11.11);
        /*результат отличается потому что:
        в цикле n имеет тип Number
        поэтому вызывается printNum(Number)
        при прямых вызовах компилятор
        выбирает наиболее подходящий метод*/
