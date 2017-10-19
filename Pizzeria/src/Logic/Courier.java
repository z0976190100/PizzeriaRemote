package Logic;

import java.util.HashMap;
import java.util.Map;

import static Logic.OrderManager.orderDone;
import static java.lang.Thread.sleep;

public class Courier extends Thread {

    private static int id = 1;
    static Map<Courier, Integer> couriersTable = new HashMap<>();

    volatile int executOrder = 0;
    String name;
    boolean busy;
    int travelingLength;
    int itsID;


    Courier(String nam) {
        this.itsID = id++;
        this.busy = false;
        this.setName(nam);
        this.name = nam;
        couriersTable.put(this, this.itsID);
    }

    public void run() {
        try {
            sleep(2000);
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }
        while (this.executOrder != 9999) {
            if (this.executOrder != 0) {

                this.executingOrder();

            }
        }
    }


    private void executingOrder() {
        if (this.executOrder != 9999) {
            System.err.println("order no " + this.executOrder);
            try {
                sleep(this.travelingLength * 2 * 1000);
            } catch (InterruptedException ie) {
            }
            orderDone.put(this.executOrder, "done");
            System.err.println("this order no. " + this.executOrder + " is  " + orderDone.get(this.executOrder));
            this.busy = false;
        }
    }
}
