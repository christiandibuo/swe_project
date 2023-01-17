package src.CatalogPackage;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import src.WarehousePackage.ConcreteProduct;

public class CompoundProduct extends AbstractProduct {

	private Vector<AbstractProduct> children;
	private int numberOfProduct;
	
	public CompoundProduct(String name) {
		super(name, "NULL");
		children = new Vector();
	}

	public void add(AbstractProduct p, int numberOfProduct) throws ElementaryServiceException {
		for(int i=0; i<numberOfProduct; i++){
			children.addElement(p);
		}
	}
	

	public void describe(AbstractProduct ab) {
		int vLength = children.size();
		for (int i = 0; i < vLength; i++) {
			AbstractProduct p = children.get(i); 
			if (p.childrenNumber() == 0) {
				ab.products.add(p);
				
			}
			else {
			p.describe(ab);
			}
		}
	}
	
	public List <AbstractProduct>  justDescribe() {
		int vLength = children.size();
		List <AbstractProduct> products = new ArrayList<>();
		for (int i = 0; i < vLength; i++) {
			AbstractProduct p = children.get(i);
			products.add(p);
		}
		return 	products;
	
	}

	public void remove(AbstractProduct p, int numberOfProduct) throws ElementaryServiceException {
		for(int i=0; i<numberOfProduct; i++){
			children.removeElement(p);
		}
	}

	public float priceCalculator(){
		float totalPrice=0;
		for(int i=0; i<children.size(); i++){
			AbstractProduct p = children.get(i);
			totalPrice += p.getPrice();
		}
		
		return totalPrice;
	}


	@Override
	public float getPrice(){
		return priceCalculator();
	}

	public int childrenNumber(){
		return children.size();
	}

	private int weightCalculator(){
		int totalWeight=0;
		for(int i=0; i<children.size(); i++){
			AbstractProduct ap = (AbstractProduct) children.get(i);
			totalWeight += ap.getWeight();
		}
		return totalWeight;
	}

	@Override
	public int getWeight() {
		return weightCalculator();
	}
}
