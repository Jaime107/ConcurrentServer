package escuela.ing.edu.co.hilos.executors;


import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {

    public static void main(String...args){
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        int i = 0;
        while (i < 100){
            threadPool.submit(() ->System.out.println("Hellow from thread" + LocalDateTime.now()));
            i++;
        }
        threadPool.shutdown();

    }
}
