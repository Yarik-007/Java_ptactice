//================================================================================//
//Ограничение доступа
//================================================================================//

class Airplane{
    int abobusov = 200;
    public String name = "plane";
    protected int speed = 1000;
    private int height = 10000;
    public int getHeight(){
        return height;
    }
}
public class P11 {
    public static void main(String[] args){
        Airplane plane = new Airplane();
        System.out.println(plane.abobusov);
        System.out.println(plane.name);
        System.out.println(plane.speed);
        System.out.println(plane.getHeight());
    }
}
