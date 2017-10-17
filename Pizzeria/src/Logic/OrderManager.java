package Logic;

import java.util.*;

import static Logic.CityMap.getRoute;
import static Logic.Courier.couriersTable;

public class OrderManager {

    static int orderId = 1;
    static Map<Integer, Integer> courierOrder = new HashMap<>();
    Map<Integer, String> orderAddress = new HashMap<>();// temporary contains only order id and address
    static Map<Integer, String> orderDone = new HashMap<>();
    Map<Integer, Boolean> couriersBusy = new HashMap<>(); // includes couriersBusy id and if he is avaliable for order


    void couriersHiring() {  // creates Courier instances
        for (int i = 1; i < 5; i++) {
            new Courier("Servant no." + Integer.toString(i));
        }
    }

    public String throwsOrder(List<String> order) throws Exception {

        for (String str : order) {

            this.orderAddress.put(orderId, str.substring(0, 2));
            orderId++;
        }

        System.err.println("orderAdresses:" + this.orderAddress);

        this.chooseCourier(this.orderAddress);

        String done = "done";
        return done;

    }


    public void chooseCourier(Map<Integer, String> ordAddress) throws Exception {
        for (Integer ordId : ordAddress.keySet()) {
            for (Courier Courie : couriersTable.keySet()) {
                if (!Courie.busy) {
                    courierOrder.put(Courie.itsID, ordId);
                    System.err.println("adress is" + ordAddress.get(ordId));
                    this.sendCourier(Courie, ordAddress.get(ordId));
break;
                }
            }
        }
    }

    public String sendCourier(Courier Courie, String ordAdres) throws Exception {

        Courie.travelingLength = (getRoute("[5", ordAdres)); // calculating length of route
       // Courie.busy = true;
        Courie.executOrder = courierOrder.get(Courie.itsID);
        System.err.println("____________" + Courie.name + "goes for order nombre "+ Courie.executOrder + " during "
                + Courie.travelingLength);
        return ordAdres;
        //Courie.start();
        // Courie.sleep(Courie.travelingLength * 2 * 1000); // duration of executing of order
       // Courie.busy = false;
    }
}




