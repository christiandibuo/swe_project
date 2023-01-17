import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.*;

import src.CatalogPackage.*;
import src.InvoicePackage.*;
import src.WarehousePackage.ConcreteElementaryService;
import src.WarehousePackage.Courier;
import src.WarehousePackage.CourierStatus;
import src.WarehousePackage.Logistic;

public class LogisticTest {
	Logistic l;
	List<Courier> courierList;
	
	@Before
	public void setup() {
		l = new Logistic();
		courierList = new ArrayList<>();
		Courier c1 = new Courier("c1", 80);
		Courier c2 = new Courier("c2", 80);
		Courier c3 = new Courier("c3", 80);
		courierList.add(c1);
		courierList.add(c2);
		courierList.add(c3);
	}
	
	@Test
	public void chooseCouriertest(){
		ConcreteElementaryService cp1 = new ConcreteElementaryService("cp1", 240, "scaffale1", "NEW", 001);
		l.chooseCourier(cp1, courierList);
		for(int i = 0; i <  courierList.size(); i++) {
			assertEquals(CourierStatus.BUSY, courierList.get(i).getStatus());
		}
		courierList.get(0).shipmentCompleted();
		assertEquals(CourierStatus.AVAIABLE, courierList.get(0).getStatus());
	}

}
