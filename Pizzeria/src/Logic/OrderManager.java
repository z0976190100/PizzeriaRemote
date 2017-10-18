package Logic;

import java.util.*;

import static Logic.CityMap.getRoute;
import static Logic.Courier.couriersTable;
import static java.lang.Thread.sleep;

public class OrderManager {

    static int orderId = 1;
    static Map<Integer, Integer> courierOrder = new HashMap<>();
    static volatile Map<Integer, String> orderAddress = new HashMap<>();// temporary contains only order id and address
    static Map<Integer, String> orderDone = new HashMap<>();
    Map<Integer, Boolean> couriersBusy = new HashMap<>(); // includes couriersBusy id and if he is avaliable for order


    void couriersHiring() {  // creates Courier instances
        for (int i = 1; i < 3; i++) {
            new Courier("Servant no." + Integer.toString(i));
        }
        for (Courier C: couriersTable.keySet()) {
            C.start();
        }
    }

    public String throwsOrder(List<String> order) throws Exception {

        for (String str : order) {

            orderAddress.put(orderId, str.substring(0, 2));
            orderId++;
        }

        System.err.println("orderAdresses:" + orderAddress);

        this.chooseCourier(orderAddress);

        String done = "done";
        return done;

    }


    public void chooseCourier(Map<Integer, String> ordAddress) throws Exception {
        while (true){
            for (Integer ordId : ordAddress.keySet()) {
                if(ordAddress.get(ordId).equals("5")){
                    System.err.println("now order list is :" + ordAddress);
                    continue;
                }
                for (Courier Courie : couriersTable.keySet()) {
                    System.err.println("trying to throw order no  " + ordId+ " to " + Courie.name);
                    if (!Courie.busy) {
                        Courie.busy = true;
                        courierOrder.put(Courie.itsID, ordId);
                        System.err.println(Courie.name+ " takes " + courierOrder.get(Courie.itsID));
                        System.err.println("adress is" + ordAddress.get(ordId));
                        String temp = ordAddress.get(ordId);
                        ordAddress.put(ordId, "5"); // "5" means that now this order is in work
                        this.sendCourier(Courie, temp);
                        break;
                    }
                }
                //  System.err.println("All couriers are busy now!"); // ????????????
                //this.chooseCourier(this.orderAddress);
            }
        }
    }

    public void sendCourier(Courier Courie, String ordAdres) throws Exception {

        Courie.travelingLength = (getRoute("[5", ordAdres)); // calculating length of route

        Courie.executOrder = courierOrder.get(Courie.itsID);
        System.err.println("____________" + Courie.name + "goes for order nombre " + Courie.executOrder + " during "
                + Courie.travelingLength);

       /* while (!Courie.isInterrupted()) {
            try {
                sleep(1000);
            }catch (InterruptedException ie) {}
        }*/
        //if(Courie.isAlive()) {
            Courie.executingOrder();
        }
    }





