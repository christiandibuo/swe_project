

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import javax.xml.catalog.CatalogException;

import org.junit.*;

import src.CatalogPackage.*;

public class CatalogTest {
	CatalogWorker cm;
	Catalog catalog = Catalog.getInstance();
	
	@Before
	public void setUp() {
		cm = new CatalogWorker("franco");
		
		cm.createElementaryService("sedia", 10, "NEW", 7);
		cm.createElementaryService("tavolo", 20, "NEW", 33);
		cm.createCompoundProduct("tavolo_cucina");
		
		try {
			cm.addServiceToCompound("tavolo_cucina", "sedia", 4);
			cm.addServiceToCompound("tavolo_cucina", "tavolo", 1);
		} catch (ElementaryServiceException e) {
			e.printStackTrace();
		}
		
		cm.addToCatalog("sedia", 10);
	}
	
	@Test
	public void testAdd() {
		
		
		cm.addToCatalog("tavolo_cucina", 5);
		
		catalog.search("tavolo_cucina");
		
		assertThrows(NoSuchElementException.class, () -> {
            catalog.search("cucina");
        });
		
	}

	@Test
	public void testRemove() {
		
		cm.removeFromCatalog("sedia", 3);
		
		assertThrows(CatalogException.class, () -> {
			cm.removeFromCatalog("sedia", 100);
        });
	}


}
