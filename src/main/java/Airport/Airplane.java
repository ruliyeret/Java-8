package Airport;

public class Airplane  extends Thread implements IAirPlane {
    private int systemId;
    private static Object flight = new Object();

    public Airplane(int systemId){
        this.systemId = systemId;
    }

    @Override
    public void TakeOff() {

    }

    @Override
    public void landing() {

    }

    @Override
    public void flight() {

    }

    @Override
    public void TakeOffSync() {
        System.out.println("Airplane number " + this.systemId + " wants to take of");
        synchronized (flight) {
            System.out.println("Airplane number " + this.systemId + " takes off");
        }
        System.out.println("Airplane number " + this.systemId + " finished to taking of");
    }

    @Override
    public void landingSync() {
        System.out.println("Airplane number " + this.systemId + " wants to landing");
        synchronized (flight) {
            System.out.println("Airplane number " + this.systemId + " landing");
        }

        System.out.println("Airplane number " + this.systemId + " finished landing");
    }

    @Override
    public void flightSync() {
        int time = (int) (Math.random() * 1000);
        System.out.println("Airplane number " + this.systemId + " start flying for: " + time + " ms");

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run(){
        System.out.println("Airplane number " + this.systemId + " in the Airport");

        this.TakeOffSync();
        this.flightSync();
        this.landingSync();
    }
}
