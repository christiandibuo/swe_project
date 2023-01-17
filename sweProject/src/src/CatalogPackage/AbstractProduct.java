package src.CatalogPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

public abstract class AbstractProduct{
	private String name;
	List <AbstractProduct > products ;
	Map <AbstractProduct, AbstractProduct> productsMap ;
	
	protected Discount discount;
	private Condition condition;

	public AbstractProduct(String name, String condition) {
		products = new ArrayList<>();
		productsMap = new HashMap<>();
		this.name = name;
		this.condition = Condition.valueOf(condition);
		discount = new Discount(Condition.valueOf(condition));
	}

	public abstract float getPrice();
	
	public abstract int getWeight();
	
	public String getName(){
		return this.name;
	}
	public Condition getCondition() {
		return this.condition;
	}
	abstract void describe(AbstractProduct ab);
	
	public void add(AbstractProduct p, int numberOfProduct) throws ElementaryServiceException {
	       if (this instanceof ElementaryService)
	    	   throw new ElementaryServiceException();
	}
	 
	void remove(AbstractProduct p, int numberOfProduct) throws ElementaryServiceException {
	       if (this instanceof ElementaryService)
	    	   throw new ElementaryServiceException();
	}

	public List <AbstractProduct>  getChild(){
		products.clear();
		this.describe(this);
		return products;
	}
	
	public abstract List <AbstractProduct>  justDescribe();
	
	int childrenNumber(){
		return 0;
	}

}	

