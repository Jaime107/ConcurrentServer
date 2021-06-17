package escuela.ing.edu.co.hilos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Hello world!
 *
 */
public class HelloRunnableWithJoin implements Runnable
{

    public void run(){
        try{
            Thread.sleep(4000);
            System.out.println("Time from thread:  " + LocalDateTime.now());
        }catch (InterruptedException ex){
            Logger.getLogger(HelloRunnableWithJoin.class.getName()).log(Level.SEVERE, null, ex);

        }


    }
    public static void main( String... args )
    {
        int i = 0;
        Thread t = null;
        List<Thread> myThreads= new ArrayList<Thread>();
        while (i <4){
            t = new Thread(new HelloRunnableWithJoin());
            t.start();
            System.out.println("Time from main thread before join:  " + LocalDateTime.now());
            i++;
            myThreads.add(t);
        }
        for(Thread currentThread: myThreads){
            try {
                currentThread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloRunnableWithJoin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("Time from main thread after join:  " + LocalDateTime.now());
    }
}
