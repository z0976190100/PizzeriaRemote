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
        this.setName(nam);
        this.name = nam;
        couriersTable.put(this, this.itsID);
    }

    public void run() {
if(executOrder != 0) {
    this.executingOrder();
}

        return;

    }

    public void executingOrder() {
        System.err.println("order no " + this.executOrder);
        try {
            sleep(this.travelingLength * 2 * 1000);
        } catch (InterruptedException ie) {
        }
        orderDone.put(this.executOrder, "done");
        System.err.println("this order no. " + this.executOrder + " is  " + orderDone.get(this.executOrder));
        this.busy = false;
        return;

    }
}
