import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.CatalogPackage.Catalog;
import src.CatalogPackage.CatalogWorker;
import src.InvoicePackage.*;

public class UserTest {
	Catalog catalog = Catalog.getInstance();
	CatalogWorker cm;
	User u;
	@Before
	public void setUp() {
		cm = new CatalogWorker("cw");
		u = new User("u001", "u1");
	 	cm.createElementaryService("sedia", 10, "NEW", 7);
	 	cm.addToCatalog("sedia", 30);
	 	
	 	int max = 29;
        int min = 1;
        int range = max - min + 1;
	 	int rand = (int)(Math.random() * range) + min;
	 	u.addToCart("sedia", rand);
	}
	@Test
	public void updateCartTest() {
		int beforeRemove = u.getCartProductNumber();
		u.removeFromCart("sedia", 2);
		assertEquals(beforeRemove - 2, u.getCartProductNumber());
		
		int beforeAdd = u.getCartProductNumber();
		u.addToCart("sedia", 3);
		assertEquals(beforeAdd + 3, u.getCartProductNumber());
	}
	
	@Test
	public void makeOrderTest() {
		int norder = u.getOrderCounter();
		try {
			u.makeOrder("CASH", "PICKUP_IN_STORE ", "via roma");
		}catch(Exception e) {}
		
		assertEquals(norder + 1, u.getOrderCounter());
		
	}

}
