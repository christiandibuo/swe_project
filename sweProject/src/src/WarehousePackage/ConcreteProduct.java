package src.WarehousePackage;

import java.util.ArrayList;
import java.util.List;

import src.CatalogPackage.AbstractProduct;
import src.CatalogPackage.ElementaryService;
import src.CatalogPackage.ElementaryServiceException;



public interface ConcreteProduct {
	
	
	public src.CatalogPackage.Condition getCondition();
	public String getName();
	
	public void add(ConcreteElementaryService p);
	
	public abstract int getWeight();


}	

