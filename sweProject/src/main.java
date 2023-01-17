import src.CatalogPackage.*;

import java.util.ArrayList;
import java.util.List;

import src.*;
import src.InvoicePackage.*;
import src.WarehousePackage.Logistic;
import src.WarehousePackage.Warehouse;

public class main {
    public static void main(String args[]) throws Exception {
        String name = "franco";
        
        User u = Manager.createUser(name);
        CatalogWorker cm = new CatalogWorker("franco");
        Manager.createCourier(name, 100);
//        cm.createElementaryService("sedia", 10, "GOOD", 10);
//        a.createElementaryService("tavolo", 20, "NEW");
//
//        a.createCompoundProduct("tavolo da cucina");
//        a.addServiceToCompound("tavolo da cucina", "sedia", 4);
//        a.addServiceToCompound("tavolo da cucina", "tavolo", 0);

        cm.createCompoundProduct("cucina");
        cm.createElementaryService("frigo", 200, "GOOD", 40);
        //a.addServiceToCompound("cucina", "tavolo da cucina", 1);
        cm.addServiceToCompound("cucina", "frigo", 2);
        cm.addToCatalog("cucina", 3);
//        cm.addToCatalog("sedia", 1);
        
        Warehouse w = Warehouse.getInstance();


        u.searchProduct("cucina");
        
//        u.addToCart("sedia", 1);
        u.addToCart("cucina", 1);
        System. out.print(u.getCartTotalPrice());
//        
//        
//        
//        Logistic l = new Logistic();
//        try {
//        	String onm = (u.makeOrder("CARD", "COURIER_SHIPMENT", "via verdi, 27, ROMA")).getOrderNumber();
//        	
//            l.makeShipment(onm, Manager.getCouriers());
//        
//        }catch(Exception e) {
//        	System.out.print("the cart is empty");
//        }
//        
    }

}
