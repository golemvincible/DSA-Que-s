package Inheritance;
class M{
    int i,j;
    M(int a,int b){
        i=a;
        j=b;
    }
    void show(){
        System.out.println("From M\ni= "+i+"\nj= "+j);
    }
}
class N extends M{
    int i,j,k;
    N(int a,int b,int c){
        super(a,b); /* this is must otherwise we'll encounter compilation error as when we call N, default constructor
                        of M will be called automatically as there is an invisible super() inside constructor of N
                        but the constructor of M is not a default constructor, so we need to explicitly call super() and
                        pass arguments super(a,b)
                     */
        k=c;
    }
    void show(){
        System.out.println("From N\nk = "+k);
        super.show(); //if you want to access the superclass version of show()
    }
}
public class MethodOverloading1 {
    public static void main(String args[]){
        N nobj = new N(1,2,3);
        nobj.show();
    }
}
