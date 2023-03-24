package StringMethods;

import java.util.Locale;

public class PoolSharedMem {
    public static void main(String args[]){
        //shared memory
        //here str3,str4 is simply pointing to "Hello" obj which is already created
        //str3 and str4 is are not object and so is str1,str2
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = "Hello";
        String str4 = "Hello";
        System.out.println(str1+" "+ str2+" "+str3+" "+str4);
        System.out.println("str1 hashCode is : "+str1.hashCode());
        System.out.println("str2 hashCode is : "+str2.hashCode());
        System.out.println("str3 hashCode is : "+str3.hashCode());
        System.out.println("str4 hashCode is : "+str4.hashCode());
    }
}
