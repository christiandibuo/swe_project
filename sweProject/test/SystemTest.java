import static org.junit.Assert.*;

import javax.naming.ldap.ManageReferralControl;

import org.junit.Test;

import src.CatalogPackage.*;
import src.InvoicePackage.*;
import src.WarehousePackage.*;

public class SystemTest {

	@Test
	public void test() {
		
		User u1 = Manager.createUser("u1");
		Courier c1 = Manager.createCourier("c1", 200);
	    CatalogWorker cw = new CatalogWorker("cw");
	    
	    cw.createElementaryService("pianoCottura", 150, "GOOD", 70);
	    cw.createElementaryService("frigo", 200, "GOOD", 30);
	    
	    cw.createCompoundProduct("cucina");
	    try {
		    cw.addServiceToCompound("cucina", "pianoCottura", 1);
		    cw.addServiceToCompound("cucina", "frigo", 1);
	    }catch(Exception e) {
	    	System.out.print("the cart is empty");
	    }
	    cw.addToCatalog("cucina", 3);
	    
	    u1.addToCart("cucina", 1);
	    try {
	    	u1.makeOrder("CARD", "COURIER_SHIPMENT", "Via roma");
	    }catch(Exception e) {
	    	System.out.print("the cart is empty");
	    	
	    }
	    
	
	    Logistic l = new Logistic();
	    try {
	        l.makeShipment(Manager.getCouriers());
	    
	    }catch(Exception e) {
	    	System.out.print("no courier avaiable");
	    }
	    assertEquals(1, c1.getnProducts());
    
    
	}

}
