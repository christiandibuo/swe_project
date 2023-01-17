package src.WarehousePackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.CatalogPackage.AbstractProduct;
import src.ObserverPackage.Observable;
import src.WarehousePackage.ConcreteElementaryService;

public class WarehouseWorker extends Observable{

	private int ID;
	private int serialNumber;
	Warehouse warehouse;
	
    public WarehouseWorker(int ID) {
    	this.ID = ID;
    	serialNumber = 0;
		this.warehouse = Warehouse.getInstance();
    }
    
    
    
    private int setSerialNumber() {
    	return serialNumber++;
    }
    
    public void createElementaryService(AbstractProduct ap, int number) {
    	List<AbstractProduct> concreteElementaryProducts = new ArrayList<>();
    	concreteElementaryProducts = ap.getChild();
    	for(int i = 0; i < number; i++) {
			for (AbstractProduct j : concreteElementaryProducts) {
				ConcreteElementaryService cp = new ConcreteElementaryService(j, setSerialNumber());
				warehouse.addConcreteElementaryService(cp,1);
			}
		}
    }
    
    public void addElementarytoWarehouse(String name, int weight, String position, String condition, int serialNumber, int numberofelements){
    	ConcreteElementaryService cs= new ConcreteElementaryService(name, weight, position, condition, setSerialNumber());
    	warehouse.addConcreteElementaryService(cs, numberofelements);
    
    }
    
}
