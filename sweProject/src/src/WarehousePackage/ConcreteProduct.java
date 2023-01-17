package src.WarehousePackage;

import java.util.ArrayList;
import java.util.List;

import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.ElementaryService;
import src.CatalogPackage.ElementaryServiceException;



public abstract class ConcreteProduct {
	private String name;
	private src.CatalogPackage.Condition condition;
	private List <ConcreteProduct> products = new ArrayList<>();
	protected int weight;


	public ConcreteProduct(AbstractProduct ap) {
		this.name = ap.getName();
		this.condition = ap.getCondition();
		this.weight = ap.getWeight();
	}
	
	public ConcreteProduct() {}
	
	
	public src.CatalogPackage.Condition getCondition(){
		return condition;
	}
	public String getName(){
		return name;
	}
	
	public void add(ConcreteProduct p)throws ElementaryServiceException {
	       if (this instanceof ConcreteElementaryService)
	    	   throw new ElementaryServiceException();
	}
	
	public abstract int getWeight();


}	

