package escuela.ing.edu.co.hilos.deadlock;

public class Friend {


    private final String name;
    private Boolean bowing;

    public Friend(String name, Boolean joy) {
        this.name = name;
        this.bowing = joy;
    }
    public String getName() {
        return this.name;
    }

    public synchronized void bow(Friend bower){
        System.out.format("%s: %s has bowed me! %n", name, bower.getName());
        while(!bowing) {
            try {
                wait(4000);
            } catch (InterruptedException e) {

            }
        }
        notifyJoy();

        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower){
        System.out.format("%s: %s has bowed back to me! %n", name, bower.getName());
    }

    public synchronized void notifyJoy() {
        bowing = true;
        notifyAll();
    }

    public static void main(String...args){
        Friend alphonse = new Friend("Alphonse", false);
        Friend gastone = new Friend("Gaston", false);
        (new Thread(() -> alphonse.bow(gastone))).start();
        (new Thread(() -> gastone.bow(alphonse))).start();
    }
}
