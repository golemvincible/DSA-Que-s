package Nested_Class;
class OuterClass{
    static int a=10;

    int b=20;

    private static int c=30;

    static class StaticNestedClass{
        void display(){
            System.out.println("value of a is: "+a);
            System.out.println("value of c is: "+c);
        }
    }
}
public class StaticNestedClass {
    public static void main(String args[]){
        OuterClass.StaticNestedClass obj = new OuterClass.StaticNestedClass();
        obj.display();
    }
}
