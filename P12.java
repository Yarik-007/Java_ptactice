//================================================================================//
//Методы
//================================================================================//
 
 class calc{
    static public int a=10, b=20;
    int sum(int a, int b){
        return a+b;
    }
    int sum(int a, int b, int c){
        return a+b+c;
    }
}
class calc1 extends calc{
    int sum(int a, int b){
        return a*b;
    }
}
public class P12 {
    public static void main(String[] args){
        calc Calculator = new calc();
        System.out.println(Calculator.sum(Calculator.a, Calculator.b));
        calc1 Calc = new calc1();
        System.out.println(Calc.sum(Calc.a, Calc.b));
    }
}
