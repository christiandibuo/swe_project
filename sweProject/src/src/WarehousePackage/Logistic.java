package src.WarehousePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.ElementaryServiceException;
import src.InvoicePackage.Invoice;
import src.InvoicePackage.ShipmentOption;
import src.*;

public class Logistic {
	private static List <Invoice> invoices = new ArrayList<>();
	private Warehouse warehouse;
	private List<Courier> courierList = new ArrayList<>();
	
	
	public Logistic() {
		this.warehouse = Warehouse.getInstance();
		
	}
	
	public static void receiveInvoice(Invoice invoice) {
		invoices.add(invoice);
	}
	
	public boolean chooseCourier(ConcreteProduct cp, List<Courier> courierList) {
		int i = 0;
		int weight = cp.getWeight();
		while(i < courierList.size()) {
			if(courierList.get(i).getStatus() == CourierStatus.AVAIABLE) { 
				weight = courierList.get(i).addProducts(cp, weight);
				if(weight <= 0)
					return true;
			}
			i++;
		}return false;
	}
	
	
	public void makeShipment(List<Courier> courierList) throws NoSuchElementException, ElementaryServiceException{
		Invoice invoice = invoices.get(0);
		for (Map.Entry<AbstractProduct, Integer> set :invoice.getProductMap().entrySet()) {
			for(int j = 0; j < set.getValue(); j++) {
				ConcreteProduct cp = makeConcreteProduct(set.getKey(), invoice.getAddress());
				
				if(invoice.getShipmentOption() == ShipmentOption.COURIER_SHIPMENT) {
					if(!chooseCourier(cp, courierList))
						throw new RuntimeException("All Courier are busy");
				}else {
					warehouse.addproductsSold(cp);
				}
			}
		}
	}
	
	public ConcreteProduct makeConcreteProduct(AbstractProduct ap, String shippingAddress) throws NoSuchElementException, ElementaryServiceException {
		ConcreteProduct cp;
		if(ap.getChild().size() == 1) {
    		cp = warehouse.getConcreteElementaryService(ap);
    	}
		else {
			cp = new ConcreteCompoundProduct(ap, shippingAddress);
			for (AbstractProduct i : ap.getChild()) {
				cp.add(warehouse.getConcreteElementaryService(i));
			}
    	}
		return cp;
	}
}
