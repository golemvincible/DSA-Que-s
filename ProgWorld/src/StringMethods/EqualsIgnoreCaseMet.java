package StringMethods;

public class EqualsIgnoreCaseMet {
    public static void main(String args[]){
        String str1 = new String("hello");
        String str2 = new String("HELLO");
        if(str1.equalsIgnoreCase(str2)){
            System.out.println("Equals");
        }else{
            System.out.println("Not equal");
        }
    }
}
