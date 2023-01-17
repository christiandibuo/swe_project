package src.WarehousePackage;

import java.util.List;

import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.Condition;
import src.CatalogPackage.ElementaryService;
import src.CatalogPackage.ElementaryServiceException;

public class ConcreteElementaryService implements ConcreteProduct{
    private int serialNumber;
    private String name;
    private int weight;
    private String position;
    private Condition condition;
   
    public ConcreteElementaryService(AbstractProduct ap, int serialNumber){
    	this.condition = ap.getCondition();
    	this.name = ap.getName();
        this.serialNumber = serialNumber;
    }
    
    public ConcreteElementaryService(String name, int weight, String position, String condition, int serialNumber){
    	super();
    	this.name = name;
    	this.weight = weight;
    	this.position = position;
    	this.condition = Condition.valueOf(condition);
    	this.serialNumber = serialNumber;
    }

    public int getSerialNumber(){
        return this.serialNumber;
    }

	@Override
	public int getWeight() {
		return weight;
	}

	public String getName() {
		return this.name;
	}

	public String getPosition() {
		return position;
	}

	public Condition getCondition() {
		return this.condition;
	}
    
	public void add(ConcreteElementaryService p){
	}
    
}
