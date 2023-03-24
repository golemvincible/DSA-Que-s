package ExceptionHandling;
//multiple try and multiple catch
public class Ex1 {
    public static void main(String args[]){
        int a=10,b=0,c,d[]={1,2,3};
        String s = "sourabh";
        String x=null;
        try{
            try{
                c=a/b;
                System.out.println(c);
            }
            catch(ArithmeticException e){
                System.out.println(e);
            }
            try{
                System.out.println(d[3]);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(e);
            }
            try{
                int y = Integer.parseInt(s);
            }
            catch (NumberFormatException e){
                System.out.println(e);
            }
            try{
                System.out.println(x.length());
            }
            catch(NullPointerException e){
                System.out.println(e);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Bye");
    }
}
