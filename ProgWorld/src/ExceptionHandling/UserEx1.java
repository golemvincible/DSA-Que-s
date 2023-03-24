package ExceptionHandling;
class SourabhException extends Exception{
    String mssg;
    SourabhException(String str){
        mssg=str;
    }
    public String toString(){
        return "java.lang.SourabhException: "+mssg;
    }
}
public class UserEx1 {
    public static void main(String args[]){
        int a=10 , b=1, c;
        try{
            if(b==1){
                throw new SourabhException("/ by one");
            }
            else{
                c = a/b;
                System.out.println(c);
            }
        }
        catch(SourabhException s){
            System.out.println(s);
        }
        System.out.println("bye");
    }
}
