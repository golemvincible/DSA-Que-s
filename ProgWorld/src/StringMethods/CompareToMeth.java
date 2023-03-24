package StringMethods;

public class CompareToMeth {
    public static void main(String args[]){
        String str1 = new String("Hello");
        String str2 = new String("hello");
        System.out.println(str1);
        int x = str1.compareTo(str2);
        System.out.println(x);
    }
}
