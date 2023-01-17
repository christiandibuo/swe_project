package src.CatalogPackage;
import src.ObserverPackage.*;
import src.WarehousePackage.WarehouseWorker;
import src.WarehousePackage.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogWorker extends Observable{
	WarehouseWorker warehouseworker = new WarehouseWorker(001);
	Catalog catalog;
	Warehouse warehouse;
	private String username;
	Map<String, AbstractProduct> abstractProductMap;

	public CatalogWorker(String username) {
		abstractProductMap = new HashMap<>();
		this.catalog = Catalog.getInstance();
		this.addObserver(catalog);
		this.username = username;
	}

	public void addToCatalog(String ap, int number){
		this.notifyAdd(abstractProductMap.get(ap), number);
		warehouseworker.createElementaryService(abstractProductMap.get(ap), number);
	}

	public void removeFromCatalog(String ap, int number){
		this.notifyRemove(abstractProductMap.get(ap), number);
	}
	
    public void createElementaryService(String nameOfProduct, float price, String condition, int weight) {
    	AbstractProduct p = new ElementaryService(nameOfProduct, price, condition, weight);
    	abstractProductMap.put(nameOfProduct, p);
//		return p;
	}
    public void createCompoundProduct(String nameOfCompound) {
    	abstractProductMap.put(nameOfCompound, new CompoundProduct(nameOfCompound));
//    	return abstractProductMap.get(nameOfCompound);
	}
    public void addServiceToCompound(String compoundProduct, String elementaryService,int numberOfElementaryService) throws ElementaryServiceException {
    	abstractProductMap.get(compoundProduct).add(abstractProductMap.get(elementaryService), numberOfElementaryService);
	}
    
    public AbstractProduct getAbstractProduct(String productName) {
		return abstractProductMap.get(productName);
	}
}
