package MultiThreading;

public class Thread1 implements Runnable{
    public void run(){
        System.out.println("Hello");
    }
    public static void main(String args[]){
        Thread1 t1 = new Thread1();
        Thread t = new Thread(t1,"myThread");
        t.start();
        System.out.println("bye");
        int i =java.lang.Thread.activeCount();
        System.out.println(i);
        System.out.println(t1);
        System.out.println(t);
        System.out.println(t.getName());
        Thread t2 = Thread.currentThread();
        System.out.println(t.getName());
    }
}
