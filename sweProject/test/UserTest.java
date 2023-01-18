import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import src.CatalogPackage.Catalog;
import src.CatalogPackage.CatalogWorker;
import src.InvoicePackage.*;

public class UserTest {
	static CatalogWorker cw = new CatalogWorker("cw");
	static User u = new User("u001", "u1");
	
	@BeforeClass
	public static void initialSetUp() {
		cw.createElementaryService("sedia", 10, "NEW", 7);
		cw.addToCatalog("sedia", 30);
	 	int max = 29;
        int min = 3;
        int range = max - min + 1;
	 	int rand = (int)(Math.random() * range) + min;
	 	u.addToCart("sedia", rand);
	}
	

	
	@Test
	public void updateCartTest() {
		int n = u.searchNumberProduct("sedia");
		int beforeRemove = u.getCartProductNumber();
		u.removeFromCart("sedia", 3);
		assertEquals(beforeRemove - 3, u.getCartProductNumber());
		
		int beforeAdd = u.getCartProductNumber();
		u.addToCart("sedia", 3);
		assertEquals(beforeAdd + 3, u.getCartProductNumber());

		assertEquals(n, u.searchNumberProduct("sedia"));
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
