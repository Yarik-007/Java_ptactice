//================================================================================//
//Статические методы и поля
//================================================================================//

 class A1 {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}
public class P13 {
    public static void main(String[] args){
        A1.printVars();

        A1 a = new A1();
        a.printVars();

        A1 b = null;
        b.printVars();
    }
}
