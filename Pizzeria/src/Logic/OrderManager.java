package Logic;

import java.util.*;

import static Logic.CityMap.getRoute;
import static Logic.Courier.couriersTable;


class OrderManager {

    private static int orderId = 1;
    private static Map<Integer, Integer> courierOrder = new HashMap<>();
    private static volatile Map<Integer, String> orderAddress = new HashMap<>();// temporary contains only order id and address
    static volatile Map<Integer, String> orderDone = new HashMap<>();


    void couriersHiring() {  // creates Courier instances
        for (int i = 1; i < 3; i++) {
            new Courier("Servant no." + Integer.toString(i)).start();
        }
    }

    void throwsOrder(List<String> order) throws Exception {
        for (String str : order) {
            orderAddress.put(orderId, str.substring(0, 2));
            orderId++;
        }
        System.err.println("orderAdresses:" + orderAddress);
        this.chooseCourier(orderAddress);
    }


    private void chooseCourier(Map<Integer, String> ordAddress) throws Exception {
        while (ordAddress.size() != orderDone.size()) {
            for (Integer ordId : ordAddress.keySet()) {
                if (ordAddress.get(ordId).equals("5")) {
                    System.err.println("now order list is :" + ordAddress);
                    continue;
                }
                for (Courier Courie : couriersTable.keySet()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        System.err.println(ie.getMessage());

                    }
                    System.err.println("trying to throw order no  " + ordId + " to " + Courie.name);
                    System.err.println(Courie.name + " is busy: " + Courie.busy);
                    if (!Courie.busy) {
                        Courie.busy = true;
                        courierOrder.put(Courie.itsID, ordId);
                        System.err.println(Courie.name + " takes " + courierOrder.get(Courie.itsID));
                        System.err.println("adress is" + ordAddress.get(ordId));
                        String temp = ordAddress.get(ordId);
                        ordAddress.put(ordId, "5"); // "5" means that now this order goes in work
                        this.sendCourier(Courie, temp);
                        break;
                    }
                }
            }
        }
        for (Courier C : couriersTable.keySet()) {
            C.executOrder = 9999;
        }
    }

    private void sendCourier(Courier Courie, String ordAdres) throws Exception {

        Courie.travelingLength = (getRoute("[5", ordAdres)); // calculating length of route
        Courie.executOrder = courierOrder.get(Courie.itsID);
        System.err.println("____________" + Courie.name + "goes for order nombre " + Courie.executOrder + " during "
                + Courie.travelingLength);

    }
}





