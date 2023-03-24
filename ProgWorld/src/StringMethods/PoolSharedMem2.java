package StringMethods;

public class PoolSharedMem2 {
    public static void main(String args[]){
        //pool memory
        //here str4 is simply pointing to str3 which is pointing to "Hello" object so it will not be considered an object but only a reference
        String str1 = new String("Hello");
        String str2 = new String("World");
        String str3 = "Hello";
        String str4 = str3;
        System.out.println(str1+" "+ str2+" "+str3+" "+str4);
        System.out.println("str1 hashCode is : "+str1.hashCode());
        System.out.println("str2 hashCode is : "+str2.hashCode());
        System.out.println("str3 hashCode is : "+str3.hashCode());
        System.out.println("str4 hashCode is : "+str4.hashCode());
        System.out.println("Hello hashCode is : "+"Hello".hashCode());
        System.out.println("World hashCode is : "+"World".hashCode());
    }
}
