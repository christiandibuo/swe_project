import static org.junit.Assert.*;
import org.junit.*;
import src.CatalogPackage.*;
import src.InvoicePackage.Cart;
import src.InvoicePackage.User;


public class CartTest {
	Cart cart;
	float totPriceExpected = 0;
	CatalogWorker cm;
	
	@Before
	public void setUp() {
		cart = new Cart();

		
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
		cm.addToCatalog("tavolo_cucina", 5);
		
	
		AbstractProduct ap = cm.getAbstractProduct("tavolo_cucina");
		cart.addProduct(ap, 1);
		cart.addProduct(cm.getAbstractProduct("sedia"), 2);
		totPriceExpected += 80;
	}
	
	@Test
	public void calculatePriceTest() {
		assertEquals(totPriceExpected, cart.priceCalculator(), 0);
	}
	
	@Test
    public void updateProductTest() {
		
        int oldNProducts = cart.getProductList().size();
        double oldTotPrice = cart.priceCalculator();
        double newProductPrice = 20;
        
        cm.createElementaryService("tavolo", 20, "NEW", 33);
        cm.addToCatalog("tavolo", 1);
        AbstractProduct ap = cm.getAbstractProduct("tavolo");
        cart.addProduct(ap, 1);
        assertEquals(oldNProducts + 1, (cart.getProductList()).size());
        assertEquals(oldTotPrice + newProductPrice, cart.priceCalculator(), 0);
        
        cart.removeProduct("tavolo", 1);
        assertEquals(oldNProducts, (cart.getProductList()).size());
    }
	


    @Test
    public void clearTest() {
        cart.clear();
        assertEquals(0, cart.getProductList().size());
    }

}
