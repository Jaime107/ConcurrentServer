package escuela.ing.edu.co.hilos;

/**
 * Hello world!
 *
 */
public class HelloRunnable implements Runnable
{
    int i;

    public HelloRunnable(int i){
        this.i = i;
    }
    public void run(){
        System.out.println("Hello from runnable Nª " + i + ". Object" + this);
    }
    public static void main( String... args )
    {

        int i = 0;
        while(i < 20){
            (new Thread(new HelloRunnable(i))).start();
            i++;
        }

    }
}
