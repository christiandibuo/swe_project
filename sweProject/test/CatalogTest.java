

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import javax.xml.catalog.CatalogException;

import org.junit.*;

import src.CatalogPackage.*;
import src.InvoicePackage.User;

public class CatalogTest {
	CatalogWorker cw;
	Catalog catalog = Catalog.getInstance();
	User u1;
	
	@Before
	public void setUp() {
		cw = new CatalogWorker("franco");
		u1 = new User("u1", "001");
		cw.createElementaryService("sedia", 10, "NEW", 7);
		cw.createElementaryService("tavolo", 20, "NEW", 33);
		cw.createCompoundProduct("tavolo_cucina");
		
		try {
			cw.addServiceToCompound("tavolo_cucina", "sedia", 4);
			cw.addServiceToCompound("tavolo_cucina", "tavolo", 1);
		} catch (ElementaryServiceException e) {
			e.printStackTrace();
		}
		cw.addToCatalog("sedia", 10);
	}
	
	@Test
	public void updateCatalogWorkerTest() {
		
		
		cw.addToCatalog("tavolo_cucina", 5);
		catalog.search("tavolo_cucina");
		
		assertThrows(NoSuchElementException.class, () -> {
            catalog.search("cucina");
        });
		cw.removeFromCatalog("sedia", 3);
		
		catalog.search("sedia");
		
		assertThrows(CatalogException.class, () -> {
			cw.removeFromCatalog("sedia", 100);
        });
		
	}

	@Test
	public void updateCartTest() {
		cw.createElementaryService("tavolo", 20, "NEW", 33);
		cw.addToCatalog("tavolo", 10);
		
		u1.searchProduct("tavolo");
		u1.addToCart("tavolo", 10);
		assertThrows(NoSuchElementException.class, () -> {
            catalog.search("tavolo");
        });
		
		u1.removeFromCart("tavolo", 3);
		assertEquals(3, u1.searchNumberProduct("tavolo"));
	}


}
