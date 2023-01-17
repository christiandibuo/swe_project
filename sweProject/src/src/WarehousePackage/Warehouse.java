package src.WarehousePackage;
import src.ObserverPackage.*;
import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.Catalog;
import src.CatalogPackage.ElementaryService;
import src.InvoicePackage.Invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Warehouse{
    private List <ConcreteElementaryService> concreteElementaries = new ArrayList<>();
    private List <ConcreteProduct> productsSold = new ArrayList<>();
    
    private static Warehouse instance = null;
    
    private Warehouse(){};
    
    public static Warehouse getInstance(){
        if(instance == null)
            instance = new Warehouse();
        return instance;
    }

    public void addConcreteElementaryService(ConcreteElementaryService cp, int number) {
    	for(int i = 0; i<number; i++) {
    		concreteElementaries.add(cp);
    	}
    }
    
    public void addproductsSold(ConcreteProduct cp) {
    	productsSold.add(cp);
    }
    
    public ConcreteElementaryService getConcreteElementaryService(AbstractProduct ap)throws NoSuchElementException {
    	for(ConcreteElementaryService i: concreteElementaries) {
    		if(i.getName() == ap.getName() && i.getCondition() == ap.getCondition()) {
    			concreteElementaries.remove(i);
    			return i;
    		}
    	}throw new NoSuchElementException(ap.getName() + "doesn't exist");
    }
}
