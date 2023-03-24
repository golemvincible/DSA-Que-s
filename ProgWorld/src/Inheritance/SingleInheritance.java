package Inheritance;

class A{
    int a,b;
    void display(){
        System.out.println("value of a and b is : "+a+","+b);
    }
}
class B extends A{
    void sum(){
        System.out.println(a+b);
    }
}
public class SingleInheritance {
    public static void main(String args[]){
        A a1 = new A();
        B b1 = new B();
        a1.a=5;
        a1.b=10;
        System.out.println("display() method from a1");
        a1.display();
        b1.a=20;
        b1.b=25;
        System.out.println("display() method from b1");
        b1.display();
        b1.sum();
    }



}
