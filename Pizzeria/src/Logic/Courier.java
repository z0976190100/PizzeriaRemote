package Logic;

import java.util.HashMap;
import java.util.Map;

import static Logic.Manager.orderDoneString;
import static Logic.Manager.orderString;

public class Courier extends Thread {

    static int id = 1;

    int itsID;
    int executOrder = 0;
    String name;
    boolean busy;
    int travelingLength;
    public static Map<Courier, Integer> couriersTable = new HashMap<>();

    Courier(String nam) {
        this.itsID = id++;
        this.busy = false;
        this.name = nam;
        couriersTable.put(this, this.itsID);
    }

    public void run() {
        System.err.println("order no "+this.executOrder);
        this.executingOrder(executOrder);

    }
// removes order id entrie from orderString map;
    private void executingOrder(int ordId) {
        System.err.println(orderDoneString.put(ordId, "done"));

    }

}
