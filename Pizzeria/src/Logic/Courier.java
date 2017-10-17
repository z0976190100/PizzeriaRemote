package Logic;

import java.util.HashMap;
import java.util.Map;

import static Logic.OrderManager.orderDone;
import static java.lang.Thread.sleep;

public class Courier extends Thread {

    static int id = 1;
    public static Map<Courier, Integer> couriersTable = new HashMap<>();


    int itsID;
    int executOrder = 0;
    String name;
    boolean busy;
    int travelingLength;


    Courier(String nam) {
        this.itsID = id++;
        this.busy = false;
        this.name = nam;
        couriersTable.put(this, this.itsID);
    }

    public void run() {
        System.err.println("order no "+this.executOrder);
       try {
            sleep(this.travelingLength * 2 * 100);
        }catch (InterruptedException ie) {}
        this.executingOrder(executOrder);


    }
// removes order id entry from orderAddress map;
    private void executingOrder(int ordId) {
        System.err.println(orderDone.put(ordId, "done"));
        this.busy = false;
    }

}
