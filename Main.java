import java.util.Scanner;

class Program {
    void main() {
        Scanner in = new Scanner(System.in);
        System.out.printf("Введите Ваше имя:\n");
        String name = in.next();
        System.out.printf("Привет, %s", name);
    }
}