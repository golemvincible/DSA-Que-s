package Inheritance;

class AA{
    AA(int x,int y){
        System.out.println("Hello from A "+x+" "+y);
    }
}
class BB extends AA{
    BB(int a,int b,int c){
        super(a,b);
        System.out.println("Hello from B "+a+" "+b+" "+c);
    }
}
public class SuperKeyword {
    public static void main(String args[]){
        AA a1 = new AA(10,20);
        BB b1 = new BB(100,200,300);
    }
}
