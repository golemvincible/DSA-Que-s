package StringMethods;

public class EqualsMeth {
    public static void main(String args[]){
        //operator will compare reference not value
//        String str1 = new String("Hello");
//        String str2 = new String("Hello");
//        String str3 = new String("World");
//        //not equal will be the output because operators work on physical address and methods work on logical address
//        System.out.println("Hashcode of str1: "+str1.hashCode());
//        System.out.println("Hashcode of str2: "+str2.hashCode());
//        if(str1 == str2){
//            System.out.print("Equals");
//        }else {
//            System.out.print("Not equal");
//        }
        //method will work on logical address i.e. it will compare values
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = new String("World");
        if(str1.equals(str2)){
            System.out.println("Same");
        }else{
            System.out.print("Different");
        }
    }
}

