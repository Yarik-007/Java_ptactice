class A3 {
    {
        System.out.println("logic (1) id= " + this.id);  // logic (1) id= 0
    }
    static {
        System.out.println("static logic");  // static logic
    }
    private int id = 1;
    public A3(int id) {
        this.id = id;
        System.out.println("ctor id= " + id);  // ctor id= 100
    }
    {
        System.out.println("logic (2) id= " + id);  // logic (2) id= 1
    }
}
public class P15 {
    public static void main(String[] args) {
        new A3(100);
    }
}
// static logic
// logic (1) id= 0
// logic (2) id= 1
// ctor id= 100
